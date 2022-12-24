package com.example.alfabankfoodcourt;

import java.io.Serializable;

public class FoodItem implements Serializable {

    String name, description, imageURL;
    float price, weight, calories, proteins, fats, carbohydrates, cookingTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public Float getPrice() {
        return price;
    }


    public FoodItem(String name, String description, String imageURL, float price, float weight, float calories, float proteins, float fats, float carbohydrates, float cookingTime) {
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.price = price;
        this.weight = weight;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
        this.cookingTime = cookingTime;
    }
}
