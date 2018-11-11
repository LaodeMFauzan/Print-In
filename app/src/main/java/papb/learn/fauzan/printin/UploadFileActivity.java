package papb.learn.fauzan.printin;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class UploadFileActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_upload_file,btn_select_file;
    private ProgressBar pb_upload_file;
    private StorageReference mStorageReference;


    private Uri pdfUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_file);

        btn_upload_file = findViewById(R.id.btn_upload_file);
        btn_select_file = findViewById(R.id.btn_select_file);
        btn_upload_file.setOnClickListener(this);
        btn_select_file.setOnClickListener(this);

        pb_upload_file = findViewById(R.id.pb_upload_file);
        pb_upload_file.setVisibility(View.INVISIBLE);

        mStorageReference = FirebaseStorage.getInstance().getReference();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_select_file:
                if (ContextCompat.checkSelfPermission(UploadFileActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED) {
                    selectPDF();
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        ActivityCompat.requestPermissions(UploadFileActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},9);
                    }
                }
                break;
            case R.id.btn_upload_file:
                if (pdfUri != null){
                    uploadFile(pdfUri);
                } else {
                    Toast.makeText(UploadFileActivity.this,"please select a file...",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void selectPDF(){
        Intent getPdf = new Intent();
        getPdf.setType("application/pdf");
        getPdf.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(getPdf,86);
    }

    private void uploadFile(Uri pdfUri){
        pb_upload_file.setVisibility(View.VISIBLE);

        final String filename = System.currentTimeMillis()+"";
        mStorageReference.child("Uploads").child(filename).putFile(pdfUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(UploadFileActivity.this,"Upload file success...!",Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UploadFileActivity.this,"Failed to upload file...",Toast.LENGTH_SHORT).show();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                int currentProgress = (int) (100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                pb_upload_file.setProgress(currentProgress);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 86 && resultCode == RESULT_OK && data != null){
            pdfUri = data.getData();
        } else {
            Toast.makeText(UploadFileActivity.this,"please select a file...",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 9 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            selectPDF();
        } else {
            Toast.makeText(UploadFileActivity.this,"please provide information...",Toast.LENGTH_SHORT).show();
        }
    }
}
