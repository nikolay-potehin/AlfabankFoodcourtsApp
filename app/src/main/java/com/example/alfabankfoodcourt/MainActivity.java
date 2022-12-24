package com.example.alfabankfoodcourt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    private static final String JSON_URL = "https://collapse.pythonanywhere.com/api/v1/food/?format=json";

    RecyclerView recyclerView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.restaurant_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadJSONFromURL();
    }

    private List<FoodItem> FoodDataFromJSON (ArrayList<JSONObject> jsonItems) {
        List<FoodItem> foodItems = new ArrayList<>();

        for (int i = 0; i < jsonItems.size(); i++) {
            try {
                JSONObject jsonItem = jsonItems.get(i);

                foodItems.add(new FoodItem(
                        jsonItem.getString("name"),
                        jsonItem.getString("description"),
                        jsonItem.getString("food_pic"),
                        (float) jsonItem.getDouble("price"),
                        (float) jsonItem.getDouble("weight"),
                        (float) jsonItem.getDouble("calories"),
                        0f, 0f, 0f, 0f
                ));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return foodItems;
    }

    private List<RestaurantItem> RestaurantDataFromJSON (ArrayList<JSONObject> listItems) {
        List<RestaurantItem> restaurantItems = new ArrayList<>();

        for (int i = 0; i < listItems.size(); i++) {
            try {
                // get restaurant json item
                JSONObject jsonItem = listItems.get(i);

                // Parse restaurant food list
                JSONArray jsonArrayFood = jsonItem.getJSONArray("food");
                ArrayList<JSONObject> jsonFoodItems = getArrayListFromJSONArray(jsonArrayFood);
                List<FoodItem> foodItems = FoodDataFromJSON(jsonFoodItems);

                // Add restaurant class item
                restaurantItems.add(new RestaurantItem(
                        foodItems,
                        jsonItem.getString("name"),
                        jsonItem.getString("description"),
                        jsonItem.getInt("floor"),
                        (int) jsonItem.getDouble("min_price"),
                        (int) jsonItem.getDouble("max_price"),
                        (float) jsonItem.getDouble("rating"),
                        (String) jsonItem.get("rest_pic"),
                        (String) jsonItem.get("mall"),
                        (float) jsonItem.getDouble("lat"),
                        (float) jsonItem.getDouble("lon")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        // If GPS is on, sort restaurants depending on a user geolocation
        try {
            Address userAddress = AppDataHolder.getInstance().getUserAddress();
            float userLatitude = (float) userAddress.getLatitude();
            float userLongitude = (float) userAddress.getLongitude();

            for (RestaurantItem restaurantItem : restaurantItems) {
                restaurantItem.distanceFromUser = restaurantItem.calculateDistanceFromUser(userLongitude, userLatitude);
            }

            Collections.sort(restaurantItems, (item1, item2) -> Float.compare(item1.getDistanceFromUser(), item2.getDistanceFromUser()));
        } catch (NullPointerException e) {
            Toast.makeText(MainActivity.this, "Не удалось получить ваше местоположение", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        return restaurantItems;
    }

    private void loadJSONFromURL() {
        final ProgressBar progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(RecyclerView.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, MainActivity.JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(RecyclerView.INVISIBLE);
                        try {
                            JSONArray jsonArray = new JSONArray(EncodingToUTF8(response));
                            ArrayList<JSONObject> listItems = getArrayListFromJSONArray(jsonArray);
                            adapter = new MyAdapter(getApplicationContext(), RestaurantDataFromJSON(listItems), MainActivity.this);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @NonNull
    private ArrayList<JSONObject> getArrayListFromJSONArray(JSONArray jsonArray) {
        ArrayList<JSONObject> arrayList = new ArrayList<JSONObject>();
        try {
            if (jsonArray != null) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    arrayList.add(jsonArray.getJSONObject(i));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static String EncodingToUTF8(String response) {
        byte[] code = response.toString().getBytes(StandardCharsets.ISO_8859_1);
        response = new String(code, StandardCharsets.UTF_8);
        return response;
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, RestaurantActivity.class);

        intent.putExtra("restaurant", adapter.items.get(position));

        startActivity(intent);
    }
}