package com.example.alfabankfoodcourt;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView, descriptionView, deliveryView, averageCheckView, ratingView, mall;

    public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
        super(itemView);

        imageView = itemView.findViewById(R.id.image_view);
        nameView = itemView.findViewById(R.id.name);
        descriptionView = itemView.findViewById(R.id.restaurant_description);
        deliveryView = itemView.findViewById(R.id.restaurant_average_delivery_time);
        averageCheckView = itemView.findViewById(R.id.restaurant_average_check);
        ratingView = itemView.findViewById(R.id.restaurant_rating);
        mall = itemView.findViewById(R.id.mall);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (recyclerViewInterface != null) {
                    int position = getBindingAdapterPosition();

                    if (position != RecyclerView.NO_POSITION) {
                        recyclerViewInterface.onItemClick(position);
                    }
                }
            }
        });
    }
}

