package com.hha.heinhtetaung.burpplefoodplaces.activities.network.responses;

import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo.FeaturesVO;

import java.util.List;

/**
 * Created by E5 on 1/12/2018.
 */

public class GetFeaturedResponses {
    private int code;
    private String message;
    private String apiVersion;
    private String page;
    private List<FeaturesVO> featured;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<FeaturesVO> getFeatured() {
        return featured;
    }
}
