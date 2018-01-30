package com.hha.heinhtetaung.burpplefoodplaces.activities.network.responses;

import com.google.gson.annotations.SerializedName;
import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo.FavFoodPlacesVO;
import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo.FavFoodVO;
import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo.LoginUserVO;

import java.util.List;

/**
 * Created by E5 on 1/27/2018.
 */

public class GetLoginResponses {

    private int code;
    private String message;

    @SerializedName("login_user")
    private LoginUserVO loginUserVO;

    @SerializedName("fav_foods")
    private List<FavFoodVO> favFoodVO;

    @SerializedName("fav_food_places")
    private List<FavFoodPlacesVO> favFoodPlacesVO;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public LoginUserVO getLoginUserVO() {
        return loginUserVO;
    }

    public List<FavFoodVO> getFavFoodVO() {
        return favFoodVO;
    }

    public List<FavFoodPlacesVO> getFavFoodPlacesVO() {
        return favFoodPlacesVO;
    }
}
