package com.example.alfabankfoodcourt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;

    Context context;
    List<CartItem> items;

    public CartAdapter(Context context, List<CartItem> items, RecyclerViewInterface recyclerViewInterface) {
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
        holder.titleView.setText(items.get(position).getFoodItem().getName());
        holder.descriptionView.setText(items.get(position).getFoodItem().getDescription());
        holder.priceView.setText(items.get(position).getTotalPrice());
        holder.amountView.setText(items.get(position).getAmount());

        Picasso.get().load(items.get(position).getFoodItem().getImageURL()).into(holder.imageView);

        holder.moreButton.setOnClickListener(view -> {
            AppDataHolder.getInstance().increaseFoodAmount(items.get(position).getFoodItem().getName());
            notifyItemChanged(position);
        });

        holder.lessButton.setOnClickListener(view -> {
            int currentAmount = items.get(position).amount;

            // Decreasing amount and deleting item if the amount is 1
            AppDataHolder.getInstance().decreaseFoodAmount(items.get(position).getFoodItem().getName());

            // If currentAmount == 1 then by decreasing amount we also deleted that cart item
            if (currentAmount == 1) {
                notifyDataSetChanged();
            } else {
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() { return items.size(); }
}
