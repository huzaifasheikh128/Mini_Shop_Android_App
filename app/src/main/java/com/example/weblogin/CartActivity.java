package com.example.weblogin;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends AppCompatActivity {

    // Sample products
    static String[] names = {
            "Headphones", "Smart Watch", "Sneakers", "Backpack"
    };

    static int[] prices = {2500, 4500, 3500, 1800};

    // Quantity of each product
    static int[] quantities = {0, 0, 0, 0};

    TextView txtItems, txtTotal;
    Button btnClearCart, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        txtItems = findViewById(R.id.txtItems);
        txtTotal = findViewById(R.id.txtTotal);
        btnClearCart = findViewById(R.id.btnClearCart);
        btnBack = findViewById(R.id.btnBack);

        showCart();

        btnClearCart.setOnClickListener(v -> {
            for (int i = 0; i < quantities.length; i++) {
                quantities[i] = 0;
            }

            showCart();
        });

        btnBack.setOnClickListener(v -> finish());
    }

    void showCart() {

        String items = "";
        int total = 0;

        for (int i = 0; i < names.length; i++) {

            if (quantities[i] > 0) {

                int amount = prices[i] * quantities[i];

                items += names[i] + "\n";
                items += "Quantity: " + quantities[i] + "\n";
                items += "Price: Rs. " + amount + "\n\n";

                total += amount;
            }
        }

        if (items.isEmpty()) {
            items = "Your cart is empty";
        }

        txtItems.setText(items);
        txtTotal.setText("Total: Rs. " + total);
    }
}
