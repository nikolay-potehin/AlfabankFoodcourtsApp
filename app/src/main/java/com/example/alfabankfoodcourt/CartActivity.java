package com.example.alfabankfoodcourt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CartActivity extends AppCompatActivity implements RecyclerViewInterface {

    RecyclerView recyclerView;
    CartAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.cart_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Map<FoodItem, Integer> foodCounts = AppDataHolder.getInstance().getFoodCounts();
        List<CartItem> cartItems = new ArrayList<>();

        for (int i = 0; i < foodCounts.size(); i++) {

        }

//        adapter = new FoodAdapter(getApplicationContext(), restaurant.foodItems, RestaurantActivity.this);
//        recyclerView.setAdapter(adapter);

        Button checkoutButton = findViewById(R.id.checkout_button);
        checkoutButton.setOnClickListener(view -> {
            Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);

            startActivity(intent);
        });
    }

    @Override
    public void onItemClick(int position) {

    }
}