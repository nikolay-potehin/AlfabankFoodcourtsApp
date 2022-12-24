package com.example.alfabankfoodcourt;

public class CartItem {

    FoodItem foodItem;
    int amount;

    public FoodItem getFoodItem() { return foodItem; }

    public String getTotalPrice() {
        return Float.toString(foodItem.price * amount);
    }

    public String getAmount() {
        return Integer.toString(amount);
    }

    public CartItem(FoodItem foodItem, int amount) {
        this.foodItem = foodItem;
        this.amount = amount;
    }
}
