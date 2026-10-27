package com.example.weblogin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResetPasswordActivity extends AppCompatActivity {

    EditText etNewPassword, etConfirmNewPassword;
    Button btnResetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        etNewPassword = findViewById(R.id.etNewPassword);
        etConfirmNewPassword = findViewById(
                R.id.etConfirmNewPassword);
        btnResetPassword = findViewById(R.id.btnResetPassword);

        btnResetPassword.setOnClickListener(v -> {

            String password = etNewPassword
                    .getText().toString();

            String confirm = etConfirmNewPassword
                    .getText().toString();

            if (password.length() < 6) {
                etNewPassword.setError(
                        "Minimum 6 characters");
            }
            else if (!password.equals(confirm)) {
                etConfirmNewPassword.setError(
                        "Passwords do not match");
            }
            else {
                Toast.makeText(this,
                        "Demo reset validation successful",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(
                        ResetPasswordActivity.this,
                        LoginActivity.class
                );

                intent.addFlags(
                        Intent.FLAG_ACTIVITY_CLEAR_TOP |
                                Intent.FLAG_ACTIVITY_SINGLE_TOP
                );

                startActivity(intent);
                finish();
            }
        });
    }
}
