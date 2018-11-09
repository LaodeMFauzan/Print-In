package papb.learn.fauzan.printin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_register;
    private Button btn_login;
    private EditText et_email_login,et_password_login;
    int reqCode = 99;

    private FirebaseAuth mAuth;

    private String name,email,password;

    final String TAG_LOGIN_SUCCESS = "SUCCESS";
    final String TAG_LOGIN_FAILED= "ERROR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv_register = findViewById(R.id.tv_register);
        btn_login = findViewById(R.id.btn_login);
        et_email_login = findViewById(R.id.et_email_login);
        et_password_login = findViewById(R.id.et_password_login);

        tv_register.setOnClickListener(this);
        btn_login.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
        if (currentUser != null){
            Intent toHomeActivity = new Intent(this,OrderCriteriaActivity.class);
            startActivity(toHomeActivity);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_register :
                Intent toRegister = new Intent(this,RegisterActivity.class);
                this.startActivityForResult(toRegister,reqCode);
                break;

            case R.id.btn_login:
//                Intent toOrderCriteriaTemp = new Intent(this,OrderCriteriaActivity.class);
//                startActivity(toOrderCriteriaTemp);
                email = et_email_login.getText().toString();
                password = et_password_login.getText().toString();

                mAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Log.d(TAG_LOGIN_SUCCESS,"createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    updateUI(user);
                                } else {
                                    Log.w(TAG_LOGIN_FAILED,"createUserWithEmail:failure",task.getException());
                                    Toast.makeText(LoginActivity.this,"Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }
                            }
                        });
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == reqCode){
            if (resultCode == RESULT_OK){
                name = data.getStringExtra("username");
                email = data.getStringExtra("email");
                password = data.getStringExtra("password");
            }
        }
    }
}
