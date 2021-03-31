package za.co.shrinkspace.mvp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import za.co.shrinkspace.mvp.R;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin, btnPhoneLogin;
    private EditText etEmail, etPassword;
    private TextView tvNeedNewAccount, tvForgotPassword;

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
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainIntent);
        finish();
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

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(etEmail.getText())){
                    etEmail.setError("Email is required!");
                    etEmail.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(etPassword.getText())){
                    etPassword.setError("Password is required!");
                    etPassword.requestFocus();
                    return;
                }

                authenticateUser();
            }
        });
    }

    private void authenticateUser() {
        ProgressDialog progressDialog = new ProgressDialog(this);

        progressDialog.setTitle("Authenticating");
        progressDialog.setMessage("Please wait while we sign you in....");
        progressDialog.setCanceledOnTouchOutside(false);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        progressDialog.dismiss();
                        sendToMainActivity();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void sendToRegisterActivity() {
        Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(registerIntent);
    }
}