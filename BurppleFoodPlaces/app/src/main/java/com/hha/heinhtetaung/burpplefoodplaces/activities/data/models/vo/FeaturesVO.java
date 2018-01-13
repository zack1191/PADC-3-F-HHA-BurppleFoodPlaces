package com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by E5 on 1/12/2018.
 */

public class FeaturesVO extends GuidesVO {

    @SerializedName("burpple-featured-id")
    private String featureId;


    @SerializedName("burpple-featured-image")
    private String featureImage;

    @SerializedName( "burpple-featured-title")
    private String featureTitle;

    @SerializedName("burpple-featured-desc")
    private String featureDescription;

    @SerializedName( "burpple-featured-tag")
    private String featureTag;

    public String getFeatureId() {
        return featureId;
    }

    public String getFeatureImage() {
        return featureImage;
    }

    public String getFeatureTitle() {
        return featureTitle;
    }

    public String getFeatureDescription() {
        return featureDescription;
    }

    public String getFeatureTag() {
        return featureTag;
    }
}
