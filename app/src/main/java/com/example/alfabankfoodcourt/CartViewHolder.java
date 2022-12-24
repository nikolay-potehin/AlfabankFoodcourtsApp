package com.example.alfabankfoodcourt;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView titleView, descriptionView, priceView, amountView, lessButton, moreButton;

    public CartViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
        super(itemView);

        imageView = itemView.findViewById(R.id.cart_item_image);
        titleView = itemView.findViewById(R.id.cart_item_title);
        descriptionView = itemView.findViewById(R.id.cart_item_description);
        priceView = itemView.findViewById(R.id.cart_item_price);
        amountView = itemView.findViewById(R.id.cart_item_amount);
        lessButton = itemView.findViewById(R.id.cart_item_less_button);
        moreButton = itemView.findViewById(R.id.cart_item_more_button);
    }
}
