package com.example.alfabankfoodcourt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class RestaurantActivity extends AppCompatActivity implements RecyclerViewInterface {

    RecyclerView recyclerView;
    FoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        recyclerView = findViewById(R.id.restaurant_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RestaurantItem restaurant = (RestaurantItem) getIntent().getSerializableExtra("restaurant");

        adapter = new FoodAdapter(getApplicationContext(), restaurant.foodItems, RestaurantActivity.this);
        recyclerView.setAdapter(adapter);

        TextView restaurantNameView = findViewById(R.id.restaurant_name);
        restaurantNameView.setText(restaurant.getName());

        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(view -> finish());

        ImageView restaurantImage = findViewById(R.id.imageView);
        Picasso.get().load(restaurant.getImageURL()).into(restaurantImage);

        EditText dishSearchEditText = findViewById(R.id.dish_search_edittext);
        Button dishSearchButton = findViewById(R.id.dish_search_button);
        dishSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RestaurantActivity.this, dishSearchEditText.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        ImageView cartButton = findViewById(R.id.shopping_cart_image);
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RestaurantActivity.this, CartActivity.class);

                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(RestaurantActivity.this, FoodActivity.class);

        RestaurantItem restaurant = (RestaurantItem) getIntent().getSerializableExtra("restaurant");

        intent.putExtra("food", adapter.foodItems.get(position));
        intent.putExtra("restaurantName", restaurant.getName());

        startActivity(intent);
    }
}
