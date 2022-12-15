package com.example.alfabankfoodcourt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Locale;

public class FoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        FoodItem foodItem = (FoodItem) getIntent().getSerializableExtra("food");
        String restaurantName = getIntent().getStringExtra("restaurantName");

        ImageView imageView = findViewById(R.id.food_image_view);
        ImageView backButton = findViewById(R.id.food_back_button);
        TextView restaurantNameView = findViewById(R.id.restaurant_name_text_view);
        TextView nameView = findViewById(R.id.food_name_text_view);
        TextView descriptionView = findViewById(R.id.food_description_text_view);
        TextView priceView = findViewById(R.id.food_price_text_view);
        TextView typeView = findViewById(R.id.food_type_text_view);
        TextView compositionView = findViewById(R.id.food_composition_text_view);
        TextView eatingTimeView = findViewById(R.id.food_eating_time_text_view);

        Picasso.get().load(foodItem.getImageURL()).into(imageView);
        restaurantNameView.setText(restaurantName);
        nameView.setText(foodItem.getName());
        descriptionView.setText(foodItem.getDescription());
        priceView.setText(String.format(Locale.getDefault(), "%.1f р.", foodItem.getPrice()));
        typeView.setText("Тип:");
        compositionView.setText("Состав:");
        eatingTimeView.setText("Прием пищи:");

        backButton.setOnClickListener(view -> finish());
    }
}