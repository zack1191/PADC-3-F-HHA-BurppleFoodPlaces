package com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by E5 on 1/27/2018.
 */

public class FavFoodVO {
    @SerializedName("favorite_food_id")
    private int id;
    private String title;
    private String photoUrl;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
