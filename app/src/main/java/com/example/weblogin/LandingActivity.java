package com.example.weblogin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class LandingActivity extends AppCompatActivity {

    LinearLayout cardProducts, cardCategories;
    LinearLayout cardCart, cardProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        cardProducts = findViewById(R.id.cardProducts);
        cardCategories = findViewById(R.id.cardCategories);
        cardCart = findViewById(R.id.cardCart);
        cardProfile = findViewById(R.id.cardProfile);

        cardProducts.setOnClickListener(v -> {
            Intent intent = new Intent(
                    LandingActivity.this,
                    MainActivity.class
            );
            startActivity(intent);
        });

        // Categories uses the existing products screen.
        cardCategories.setOnClickListener(v -> {
            Intent intent = new Intent(
                    LandingActivity.this,
                    MainActivity.class
            );
            startActivity(intent);
        });

        cardCart.setOnClickListener(v -> {
            Intent intent = new Intent(
                    LandingActivity.this,
                    CartActivity.class
            );
            startActivity(intent);
        });

        cardProfile.setOnClickListener(v -> {
            Intent intent = new Intent(
                    LandingActivity.this,
                    ProfileActivity.class
            );
            startActivity(intent);
        });
    }
}
