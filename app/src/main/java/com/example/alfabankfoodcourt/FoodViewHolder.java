package com.example.alfabankfoodcourt;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FoodViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView, descriptionView, priceView;
    Button dishAddButton;

    public FoodViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
        super(itemView);

        imageView = itemView.findViewById(R.id.dish_image_view);
        nameView = itemView.findViewById(R.id.dish_name);
        descriptionView = itemView.findViewById(R.id.dish_description);
        priceView = itemView.findViewById(R.id.dish_price);
        dishAddButton = itemView.findViewById(R.id.dish_add_button);

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
