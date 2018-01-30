package com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by E5 on 1/27/2018.
 */

public class FavFoodPlacesVO {
    @SerializedName("favorite_food_place_id")
    private int id;
    private String title;
    private String address;
    private String photoUrl;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
