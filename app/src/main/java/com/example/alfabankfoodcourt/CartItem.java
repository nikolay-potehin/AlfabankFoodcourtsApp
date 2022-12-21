package com.example.alfabankfoodcourt;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CartItem {

    String imageURL, title, description, price, amount;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public CartItem(String imageURL, String title, String description, String price, String amount) {
        this.imageURL = imageURL;
        this.title = title;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }
}
