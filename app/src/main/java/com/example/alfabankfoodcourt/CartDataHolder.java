package com.example.alfabankfoodcourt;

import java.io.FileDescriptor;
import java.util.HashMap;
import java.util.Map;

public class CartDataHolder {
    private boolean isUserAuthorized;
    private final Map<Class<FoodItem>, Integer> foodCounts = new HashMap<Class<FoodItem>, Integer>();

    private static final CartDataHolder holder = new CartDataHolder();
    public static CartDataHolder getInstance() { return holder; }

    public Map<Class<FoodItem>, Integer> getFoodCounts() { return foodCounts; }

    public void AddFood (Class<FoodItem> foodType) {
        Integer foodTypeAmountOrNull = foodCounts.get(foodType);
        int foodTypeAmount = foodTypeAmountOrNull == null ? 0 : foodTypeAmountOrNull;

        foodCounts.put(foodType, foodTypeAmount);
    }

    public void RemoveFood (Class<FoodItem> foodType) {
        Integer foodTypeAmountOrNull = foodCounts.get(foodType);
        int foodTypeAmount = foodTypeAmountOrNull == null ? 0 : foodTypeAmountOrNull;

        if (foodTypeAmount <= 1) {
            foodCounts.remove(foodType);
        } else {
            foodCounts.put(foodType, foodTypeAmount - 1);
        }
    }
}
