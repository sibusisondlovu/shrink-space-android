package za.co.shrinkspace.mvp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;

import za.co.shrinkspace.mvp.R;

public class LoginActivity extends AppCompatActivity {

    private FirebaseUser firebaseUser;
    private Button btnLogin, btnPhoneLogin;
    private EditText etEmail, etPassword;
    private TextView tvNeedNewAccount, tvForgotPassword;

    @Override
    protected void onStart() {
        super.onStart();

        if (firebaseUser != null) {
            sendToMainActivity();
        }
    }

    private  void initWidgets() {

        etEmail = findViewById(R.id.login_activity_etEmail);
        etPassword = findViewById(R.id.login_activity_etPassword);

        btnLogin = findViewById(R.id.login_activity_btnLogin);
        btnPhoneLogin = findViewById(R.id.login_activity_btnPhoneLogin);
        tvNeedNewAccount = findViewById(R.id.login_activity_tvNewAccountLink);
        tvForgotPassword = findViewById(R.id.login_activity_tvForgotPasswordLink);
    }

    private void sendToMainActivity() {
        Intent mainIntent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(mainIntent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initWidgets();

        tvNeedNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendToRegisterActivity();
            }
        });
    }

    private void sendToRegisterActivity() {
        Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(registerIntent);
    }
}