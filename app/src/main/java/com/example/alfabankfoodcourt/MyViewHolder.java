package com.example.alfabankfoodcourt;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView, descriptionView, floorView, averageCheckView, ratingView, mallView;

    public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
        super(itemView);

        imageView = itemView.findViewById(R.id.image_view);
        nameView = itemView.findViewById(R.id.name);
        descriptionView = itemView.findViewById(R.id.restaurant_description);
        floorView = itemView.findViewById(R.id.restaurant_floor);
        averageCheckView = itemView.findViewById(R.id.restaurant_average_check);
        ratingView = itemView.findViewById(R.id.restaurant_rating);
        mallView = itemView.findViewById(R.id.mall);

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

