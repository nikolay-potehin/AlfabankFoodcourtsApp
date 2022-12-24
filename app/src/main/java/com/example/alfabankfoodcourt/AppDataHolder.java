package com.example.alfabankfoodcourt;

import android.content.Context;
import android.location.Address;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
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

    private List<CartItem> cartItems = new ArrayList<>();

    private static final AppDataHolder holder = new AppDataHolder();
    public static AppDataHolder getInstance() { return holder; }

    public List<CartItem> getCartItems() { return cartItems; }

    public CartItem searchCartItemByName (String cartItemName) {
        for (CartItem cartItem : cartItems) {
            if (Objects.equals(cartItemName, cartItem.foodItem.name)) {
                return cartItem;
            }
        }
        return null;
    }

    public void increaseFoodAmount (String cartItemName) {
        searchCartItemByName(cartItemName).amount++;
    }

    public void decreaseFoodAmount (String cartItemName) {
        searchCartItemByName(cartItemName).amount--;

        if (searchCartItemByName(cartItemName).amount == 0) {
            cartItems.remove(searchCartItemByName(cartItemName));
        }
    }

    public void addFood (FoodItem foodItem) {
        CartItem cartItem = searchCartItemByName(foodItem.getName());

        if (cartItem == null) {
            cartItems.add(new CartItem(foodItem, 1));
        } else {
            increaseFoodAmount(foodItem.getName());
        }
    }

    public float countTotalPrice() {
        float sum = 0;

        for (CartItem cartItem : cartItems) {
            sum += cartItem.foodItem.price * cartItem.amount;
        }
        return sum;
    }
}
