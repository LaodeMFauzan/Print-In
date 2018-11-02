package papb.learn.fauzan.printin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_register;
    int reqCode = 99;

    private String name,email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv_register = findViewById(R.id.tv_register);
        tv_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_register :
                Intent toRegister = new Intent(this,RegisterActivity.class);
                this.startActivityForResult(toRegister,reqCode);
                break;

            case R.id.btn_login:
                Intent toOrderCriteriaTemp = new Intent(this,OrderCriteriaActivity.class);
                startActivity(toOrderCriteriaTemp);
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
