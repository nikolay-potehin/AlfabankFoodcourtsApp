package com.example.alfabankfoodcourt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RestaurantItem implements Serializable {

    List<FoodItem> foodItems;

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    String name;
    String description;
    String mall;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    String imageURL;

    int minDeliveryTime, maxDeliveryTime, minAverageCheck, maxAverageCheck;
    float rating;
    int image_default;

    public String getMall() {
        return mall;
    }

    public void setMall(String mall) {
        this.mall = mall;
    }

    public String getDeliveryTime() {
        return minDeliveryTime + "-" + maxDeliveryTime + " мин";
    }

    public String getAverageCheck() {
        return minAverageCheck + "-" + maxAverageCheck + " ₽";
    }

    public int getMinDeliveryTime() {
        return minDeliveryTime;
    }

    public void setMinDeliveryTime(int minDeliveryTime) {
        this.minDeliveryTime = minDeliveryTime;
    }

    public int getMaxDeliveryTime() {
        return maxDeliveryTime;
    }

    public void setMaxDeliveryTime(int maxDeliveryTime) {
        this.maxDeliveryTime = maxDeliveryTime;
    }

    public int getMinAverageCheck() {
        return minAverageCheck;
    }

    public void setMinAverageCheck(int minAverageCheck) {
        this.minAverageCheck = minAverageCheck;
    }

    public int getMaxAverageCheck() {
        return maxAverageCheck;
    }

    public void setMaxAverageCheck(int maxAverageCheck) {
        this.maxAverageCheck = maxAverageCheck;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage_default() {
        return image_default;
    }

    public void setImage_default(int image_default) {
        this.image_default = image_default;
    }

    public RestaurantItem(List<FoodItem> foodItems, String name, String email, int minDeliveryTime, int maxDeliveryTime, int minAverageCheck, int maxAverageCheck, float rating, String imageURL, String mall) {
        this.foodItems = foodItems;
        this.name = name;
        this.description = email;
        this.minDeliveryTime = minDeliveryTime;
        this.maxDeliveryTime = maxDeliveryTime;
        this.minAverageCheck = minAverageCheck;
        this.maxAverageCheck = maxAverageCheck;
        this.rating = rating;
        this.image_default = R.drawable.ic_outline_image_24;
        this.imageURL = imageURL;
        this.mall = mall;
    }
}
