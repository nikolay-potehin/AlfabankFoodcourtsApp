package com.example.alfabankfoodcourt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;

    Context context;
    List<RestaurantItem> items;

    public MyAdapter(Context context, List<RestaurantItem> items,
                     RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.items = items;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.restaurant_item_view, parent, false),
                recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nameView.setText(items.get(position).getName());
        holder.descriptionView.setText(items.get(position).getDescription());
        holder.imageView.setImageResource(items.get(position).getImage_default());
        holder.deliveryView.setText(items.get(position).getDeliveryTime());
        holder.averageCheckView.setText(items.get(position).getAverageCheck());
        holder.ratingView.setText(String.format(Locale.getDefault(), "%.1f", items.get(position).getRating()));
        holder.mall.setText(items.get(position).getMall());

        Picasso.get().load(items.get(position).getImageURL()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

