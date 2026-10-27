package com.example.weblogin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnHeadphones, btnWatch, btnShoes, btnBag, btnCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHeadphones = findViewById(R.id.btnHeadphones);
        btnWatch = findViewById(R.id.btnWatch);
        btnShoes = findViewById(R.id.btnShoes);
        btnBag = findViewById(R.id.btnBag);
        btnCart = findViewById(R.id.btnCart);

        btnHeadphones.setOnClickListener(v -> addToCart(0));
        btnWatch.setOnClickListener(v -> addToCart(1));
        btnShoes.setOnClickListener(v -> addToCart(2));
        btnBag.setOnClickListener(v -> addToCart(3));

        btnCart.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CartActivity.class);
            startActivity(intent);
        });
    }

    void addToCart(int productIndex) {
        CartActivity.quantities[productIndex]++;

        Toast.makeText(this, "Product added to cart!",
                Toast.LENGTH_SHORT).show();
    }
}
