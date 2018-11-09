package papb.learn.fauzan.printin;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_username,et_email,et_password;
    private Button btn_register;
    private ProgressBar pb_register;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_username = findViewById(R.id.et_username);
        et_email = findViewById(R.id.et_email_register);
        et_password = findViewById(R.id.et_password_register);

        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);

        pb_register = findViewById(R.id.pb_register);
        pb_register.setVisibility(View.INVISIBLE);
        pb_register.setIndeterminate(true);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        FirebaseAuth.getInstance().signOut();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
        if (currentUser != null){
            Intent toLoginActivity = getIntent();
            setResult(RESULT_OK,toLoginActivity);
            finish();
        }
    }

    private void createUser(){
        pb_register.setVisibility(View.VISIBLE);
        String email_register = et_email.getText().toString();
        String password_register = et_password.getText().toString();

        final String TAG_SUCCESS_CREATE = "SUCCESS";
        final String TAG_FAILED_CREATE = "ERROR";

        mAuth.createUserWithEmailAndPassword(email_register,password_register)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            pb_register.setVisibility(View.GONE);
                            Log.d(TAG_SUCCESS_CREATE,"createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            pb_register.setVisibility(View.GONE);
                            Log.w(TAG_FAILED_CREATE,"createUserWithEmail:failure",task.getException());
                            Toast.makeText(RegisterActivity.this,"Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                createUser();
        }
    }
}
