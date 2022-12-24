package com.example.alfabankfoodcourt;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

public class RestaurantItem implements Serializable {

    private static final DecimalFormat df = new DecimalFormat("0.00");
    List<FoodItem> foodItems;

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getFloor() {
        return Integer.toString(floor) + " этаж";
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    String name, description, mall, imageURL;
    int minAverageCheck, maxAverageCheck, image_default, floor;
    float rating;
    float lat;
    float lon;

    public float getDistanceFromUser() {
        return distanceFromUser;
    }

    public void setDistanceFromUser(float distanceFromUser) {
        this.distanceFromUser = distanceFromUser;
    }

    float distanceFromUser;

    public String getMall() {
        return mall;
    }

    public String getMallAndDistance() {
        if (getDistanceFromUser() == 0.0) {
            return getMall() + ", ? км";
        }
        return getMall() + ", " + df.format(getDistanceFromUser()) + " км";
    }

    public void setMall(String mall) {
        this.mall = mall;
    }

    public String getAverageCheck() {
        return minAverageCheck + "-" + maxAverageCheck + " ₽";
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

    public RestaurantItem(List<FoodItem> foodItems, String name, String email, int floor,
                          int minAverageCheck, int maxAverageCheck, float rating, String imageURL,
                          String mall, float lat, float lon) {
        this.foodItems = foodItems;
        this.name = name;
        this.description = email;
        this.floor = floor;
        this.minAverageCheck = minAverageCheck;
        this.maxAverageCheck = maxAverageCheck;
        this.rating = rating;
        this.image_default = R.drawable.ic_outline_image_24;
        this.imageURL = imageURL;
        this.mall = mall;
        this.lat = lat;
        this.lon = lon;
        this.distanceFromUser = 0;
    }

    public float calculateDistanceFromUser (float longitude, float latitude) {
        double d2r = Math.PI / 180;

        try {
            double dlong = (Math.abs(longitude - lon)) * d2r;
            double dlat = (Math.abs(latitude - lat)) * d2r;
            double a =
                    Math.pow(Math.sin(dlat / 2.0), 2)
                            + Math.cos(latitude * d2r)
                            * Math.cos(lat * d2r)
                            * Math.pow(Math.sin(dlong / 2.0), 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

            return (float) (6367 * c);

        } catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static int compareTo(long a, long b) {
        return Long.compare(a, b);
    }
}
