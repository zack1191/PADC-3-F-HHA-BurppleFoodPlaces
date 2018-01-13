package com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by E5 on 1/13/2018.
 */

public class GuidesVO {
    @SerializedName("burpple-guide-id")
    private String guidesId;

    @SerializedName("burpple-guide-image")
    private String guidesImage;

    @SerializedName("burpple-guide-title")
    private String guidesTitle;

    @SerializedName("burpple-guide-desc")
    private String guidesDesc;

    public String getGuidesId() {
        return guidesId;
    }

    public String getGuidesImage() {
        return guidesImage;
    }

    public String getGuidesTitle() {
        return guidesTitle;
    }

    public String getGuidesDesc() {
        return guidesDesc;
    }
}
