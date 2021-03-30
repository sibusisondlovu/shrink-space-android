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

import za.co.shrinkspace.mvp.R;

public class RegisterActivity extends AppCompatActivity {

    private Button btnRegister;
    private EditText etEmail, etPassword;
    private TextView tvAlreadyHaveAnAccountLink;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();

        initWidgets();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(etEmail.getText())) {
                    etEmail.setError("Email is Required!");
                    return;
                }

                if (TextUtils.isEmpty(etPassword.getText())) {
                    etPassword.setError("Password is Required!");
                    return;
                }
                createNewAccount();
            }
        });

        tvAlreadyHaveAnAccountLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });
    }

    private void createNewAccount() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        progressDialog.setTitle("Creating New Account");
        progressDialog.setMessage("PLease wait while we are creating your account");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this, "Account creation successful",
                                Toast.LENGTH_SHORT).show();

                        Intent login = new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(login);
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this,
                                e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void initWidgets() {
        etEmail = findViewById(R.id.register_activity_etEmail);
        etPassword = findViewById(R.id.register_activity_etPassword);

        btnRegister = findViewById(R.id.register_activity_btnRegister);
        tvAlreadyHaveAnAccountLink = findViewById(R.id.register_activity_tvAlreadyHaveAnAccount);

        progressDialog = new ProgressDialog(this);

    }
}