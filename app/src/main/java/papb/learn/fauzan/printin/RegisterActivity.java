package papb.learn.fauzan.printin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_username,et_email,et_password;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_username = findViewById(R.id.et_username);
        et_email = findViewById(R.id.et_email_register);
        et_password = findViewById(R.id.et_password_register);

        btn_register = findViewById(R.id.btn_register);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                Intent backToLogin = getIntent();
                backToLogin.putExtra("email",et_email.getText().toString());
                backToLogin.putExtra("username",et_username.getText().toString());
                backToLogin.putExtra("password",et_password.getText().toString());

                setResult(RESULT_OK,backToLogin);
                finish();
        }
    }
}
