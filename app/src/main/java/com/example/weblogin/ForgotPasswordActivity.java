package com.example.weblogin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText etForgotEmail;
    Button btnContinue, btnBackLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        etForgotEmail = findViewById(R.id.etForgotEmail);
        btnContinue = findViewById(R.id.btnContinue);
        btnBackLogin = findViewById(R.id.btnBackLogin);

        btnContinue.setOnClickListener(v -> {

            String email = etForgotEmail.getText()
                    .toString().trim();

            if (email.isEmpty()) {
                etForgotEmail.setError("Enter your email");
            }
            else if (!Patterns.EMAIL_ADDRESS
                    .matcher(email).matches()) {
                etForgotEmail.setError("Invalid email");
            }
            else {
                Intent intent = new Intent(
                        ForgotPasswordActivity.this,
                        ResetPasswordActivity.class
                );

                intent.putExtra("email", email);
                startActivity(intent);
            }
        });

        btnBackLogin.setOnClickListener(v -> finish());
    }
}
