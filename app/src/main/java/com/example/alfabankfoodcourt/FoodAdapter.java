package com.example.alfabankfoodcourt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

public class FoodAdapter extends RecyclerView.Adapter<FoodViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;

    Context context;
    List<FoodItem> foodItems;

    public FoodAdapter(Context context, List<FoodItem> foodItems,
                       RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.foodItems = foodItems;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FoodViewHolder(LayoutInflater.from(context).inflate(R.layout.food_item_view, parent, false),
                recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.nameView.setText(foodItems.get(position).getName());
        holder.descriptionView.setText(foodItems.get(position).getDescription());
        holder.priceView.setText(String.format(Locale.getDefault(), "%.1f р.", foodItems.get(position).getPrice()));

        Picasso.get().load(foodItems.get(position).getImageURL()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return foodItems.size();
    }
}
