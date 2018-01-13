package com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by E5 on 1/12/2018.
 */

public class PromotionShopsVO {
    @SerializedName("burpple-shop-id")
    private String promotionShopId;

    @SerializedName("burpple-shop-name")
    private String promotionShopName;

    @SerializedName("burpple-shop-area")
    private String promotionShopArea;

    public String getPromotionShopId() {
        return promotionShopId;
    }

    public String getPromotionShopName() {
        return promotionShopName;
    }

    public String getPromotionShopArea() {
        return promotionShopArea;
    }
}
