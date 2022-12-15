package com.example.alfabankfoodcourt;

import java.io.Serializable;

public class FoodItem implements Serializable {

    String name;
    String description;
    String imageURL;

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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getCalories() {
        return calories;
    }

    public void setCalories(Float calories) {
        this.calories = calories;
    }

    public Float getProteins() {
        return proteins;
    }

    public void setProteins(Float proteins) {
        this.proteins = proteins;
    }

    public Float getFats() {
        return fats;
    }

    public void setFats(Float fats) {
        this.fats = fats;
    }

    public Float getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Float carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Float getCooking_time() {
        return cooking_time;
    }

    public void setCooking_time(Float cooking_time) {
        this.cooking_time = cooking_time;
    }

    public FoodItem(String name, String description, String imageURL, float price, float weight, float calories, float proteins, float fats, float carbohydrates, float cooking_time) {
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.price = price;
        this.weight = weight;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
        this.cooking_time = cooking_time;
    }

    float price;
    float weight;
    float calories;
    float proteins;
    float fats;
    float carbohydrates;
    float cooking_time;

}
