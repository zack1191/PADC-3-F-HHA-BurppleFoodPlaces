package com.hha.heinhtetaung.burpplefoodplaces.activities.network.responses;

import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo.FeaturesVO;
import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo.GuidesVO;

import java.util.List;

/**
 * Created by E5 on 1/13/2018.
 */

public class GetGuidesResponses {
    private int code;
    private String message;
    private String apiVersion;
    private int page;
    private List<GuidesVO> featured;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public int getPage() {
        return page;
    }

    public List<GuidesVO> getFeatured() {
        return featured;
    }
}
