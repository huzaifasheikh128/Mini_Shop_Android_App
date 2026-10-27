package com.example.weblogin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText etName, etEmail, etPhone;
    EditText etPassword, etConfirmPassword;
    Button btnRegister;
    TextView tvBackToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etRegisterEmail);
        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etRegisterPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        tvBackToLogin = findViewById(R.id.tvBackToLogin);

        btnRegister.setOnClickListener(v -> {

            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();
            String password = etPassword.getText().toString();
            String confirm = etConfirmPassword.getText().toString();

            if (name.isEmpty()) {
                etName.setError("Enter your name");
                etName.requestFocus();
            }
            else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.setError("Enter a valid email");
                etEmail.requestFocus();
            }
            else if (phone.isEmpty()) {
                etPhone.setError("Enter your phone number");
                etPhone.requestFocus();
            }
            else if (password.length() < 6) {
                etPassword.setError("Minimum 6 characters");
                etPassword.requestFocus();
            }
            else if (!password.equals(confirm)) {
                etConfirmPassword.setError("Passwords do not match");
                etConfirmPassword.requestFocus();
            }
            else {
                // Classroom demo only:
                // No real account is created or stored.
                Toast.makeText(this,
                        "Form validated successfully",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(
                        RegisterActivity.this,
                        LoginActivity.class
                );

                intent.putExtra("email", email);
                startActivity(intent);
                finish();
            }
        });

        tvBackToLogin.setOnClickListener(v -> finish());
    }
}
