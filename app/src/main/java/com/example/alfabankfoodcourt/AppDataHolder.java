package com.example.alfabankfoodcourt;

import android.content.Context;
import android.location.Address;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AppDataHolder {
    public boolean isUserAuthorized;
    public boolean isUserGPSOn;

    public Address getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(Address userAddress) {
        this.userAddress = userAddress;
    }

    public void printUserAddress(Context context) {
//        String message = userAddress.getLatitude() + ", " + userAddress.getLongitude();
        String message = userAddress.getAddressLine(0);
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    private Address userAddress;

    private final Map<FoodItem, Integer> foodCounts = new HashMap<FoodItem, Integer>();

    private static final AppDataHolder holder = new AppDataHolder();
    public static AppDataHolder getInstance() { return holder; }

    public Map<FoodItem, Integer> getFoodCounts() { return foodCounts; }

    private FoodItem getFoodItemByType (FoodItem foodType) {
        for (FoodItem foodItem : foodCounts.keySet()) {
            if (Objects.equals(foodType.name, foodItem.name)) {
                return foodItem;
            }
        }
        return foodType;
    }

    public void AddFood (FoodItem foodType) {
        Integer foodTypeAmountOrNull = foodCounts.get(foodType);
        int foodTypeAmount = foodTypeAmountOrNull == null ? 0 : foodTypeAmountOrNull;

        for (FoodItem foodItem : foodCounts.keySet()) {
            if (Objects.equals(foodType.name, foodItem.name)) {
                foodCounts.put(foodType, foodTypeAmount + 1);
                return;
            }
        }

        foodCounts.put(foodType, 1);
    }

    public void RemoveFood (FoodItem foodType) {
        Integer foodTypeAmountOrNull = foodCounts.get(foodType);
        int foodTypeAmount = foodTypeAmountOrNull == null ? 0 : foodTypeAmountOrNull;

        if (foodTypeAmount <= 1) {
            foodCounts.remove(foodType);
        } else {
            foodCounts.put(foodType, foodTypeAmount - 1);
        }
    }
}
