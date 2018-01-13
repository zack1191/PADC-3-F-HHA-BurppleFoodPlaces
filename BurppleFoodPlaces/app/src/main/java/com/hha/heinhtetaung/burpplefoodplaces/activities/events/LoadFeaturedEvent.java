package com.hha.heinhtetaung.burpplefoodplaces.activities.events;

import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo.FeaturesVO;

import java.util.List;

/**
 * Created by E5 on 1/12/2018.
 */

public class LoadFeaturedEvent {
    private List<FeaturesVO> featuredList;

    public LoadFeaturedEvent(List<FeaturesVO> featuredList) {
        this.featuredList = featuredList;
    }

    public List<FeaturesVO> getFeaturedList() {
        return featuredList;
    }
}
