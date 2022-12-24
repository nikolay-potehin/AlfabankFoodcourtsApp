package com.example.alfabankfoodcourt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CartActivity extends AppCompatActivity implements RecyclerViewInterface {

    RecyclerView recyclerView;
    CartAdapter adapter;
    Button checkoutButton;
    ImageView backButton;
    TextView totalPriceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.cart_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<CartItem> cartItems = AppDataHolder.getInstance().getCartItems();

        adapter = new CartAdapter(getApplicationContext(), cartItems, CartActivity.this);
        recyclerView.setAdapter(adapter);

        totalPriceView = findViewById(R.id.total_price);
        updateTotalPriceView(AppDataHolder.getInstance().countTotalPrice());

        checkoutButton = findViewById(R.id.checkout_button);
        checkoutButton.setEnabled(false);
        checkoutButton.setOnClickListener(view -> {
            Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);

            startActivity(intent);
        });

        backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(view -> finish());
    }

    public void updateTotalPriceView (float totalPrice) {
        String text = totalPrice + " р.";
        totalPriceView.setText(text);
    }

    @Override
    public void onItemClick(int position) {
        updateTotalPriceView(AppDataHolder.getInstance().countTotalPrice());
    }
}