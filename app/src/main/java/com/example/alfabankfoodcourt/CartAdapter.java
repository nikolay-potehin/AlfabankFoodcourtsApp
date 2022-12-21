package com.example.alfabankfoodcourt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;

    Context context;
    List<CartItem> items;

    public CartAdapter(RecyclerViewInterface recyclerViewInterface, Context context, List<CartItem> items) {
        this.recyclerViewInterface = recyclerViewInterface;
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CartViewHolder(LayoutInflater.from(context).inflate(R.layout.cart_item_view, parent, false),
                recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.titleView.setText(items.get(position).getTitle());
        holder.descriptionView.setText(items.get(position).getDescription());
        holder.priceView.setText(items.get(position).getPrice());
        holder.amountView.setText(items.get(position).getAmount());

        Picasso.get().load(items.get(position).getImageURL()).into(holder.imageView);
    }

    @Override
    public int getItemCount() { return items.size(); }
}
