package com.hha.heinhtetaung.burpplefoodplaces.activities.network.responses;

import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo.PromotionVO;

import java.util.List;

/**
 * Created by E5 on 1/13/2018.
 */

public class GetPromotionResponses {
    private int code;
    private String message;
    private String apiVersion;
    private String page;
    private List<PromotionVO> promotions;

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

    public List<PromotionVO> getPromotions() {
        return promotions;
    }
}
