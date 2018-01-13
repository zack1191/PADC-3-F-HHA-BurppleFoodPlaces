package com.hha.heinhtetaung.burpplefoodplaces.activities.events;

import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo.PromotionVO;

import java.util.List;

/**
 * Created by E5 on 1/13/2018.
 */

public class LoadPromotionEvent {
    private List<PromotionVO> promotionVOList;

    public LoadPromotionEvent(List<PromotionVO> promotionVOList) {
        this.promotionVOList = promotionVOList;
    }

    public List<PromotionVO> getPromotionVOList() {
        return promotionVOList;
    }
}
