package za.co.shrinkspace.mvp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import de.hdodenhof.circleimageview.CircleImageView;
import za.co.shrinkspace.mvp.R;

public class SettingsActivity extends AppCompatActivity {

    private EditText etNames, etEmail, etPhone, etProfession, etSector, etAbout;
    private CircleImageView civAvatar;
    private Button btnDeleteAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initWidgets();

        btnDeleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingsActivity.this, "Functionality not implemented yet",
                        Toast.LENGTH_SHORT).show();
            }
        });

        civAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingsActivity.this, "Functionality not implemented yet",
                        Toast.LENGTH_SHORT).show();
            }
        });

        getUserProfileInformation();
    }

    private void getUserProfileInformation() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("users")
                .document(firebaseAuth.getUid())
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        etNames.setText(documentSnapshot.getString("names"));
                        etEmail.setText(documentSnapshot.getString("email"));
                        etPhone.setText(documentSnapshot.getString("phone"));
                        etProfession.setText(documentSnapshot.getString("profession"));
                        etSector.setText(documentSnapshot.getString("sector"));
                        etAbout.setText(documentSnapshot.getString("about"));
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SettingsActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void initWidgets() {
        etNames = findViewById(R.id.settings_activity_etName);
        etPhone = findViewById(R.id.settings_activity_etEmail);
        etPhone = findViewById(R.id.settings_activity_etPhone);
        etProfession = findViewById(R.id.settings_activity_etProfession);
        etSector = findViewById(R.id.settings_activity_etSector);
        etAbout = findViewById(R.id.settings_activity_etAbout);

        etNames.setEnabled(false);
        etPhone.setEnabled(false);
        etPhone.setEnabled(false);
        etProfession.setEnabled(false);
        etSector.setEnabled(false);
        etAbout.setEnabled(false);

        civAvatar = findViewById(R.id.settings_activity_civAvatar);
        btnDeleteAccount = findViewById(R.id.settings_activity_btnDelete);
    }

    public void closeActivity(View view) {
        finish();
    }
}