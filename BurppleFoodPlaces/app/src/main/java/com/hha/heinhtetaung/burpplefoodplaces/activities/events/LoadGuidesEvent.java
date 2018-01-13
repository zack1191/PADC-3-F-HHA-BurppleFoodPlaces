package com.hha.heinhtetaung.burpplefoodplaces.activities.events;

import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo.FeaturesVO;
import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo.GuidesVO;

import java.util.List;

/**
 * Created by E5 on 1/13/2018.
 */

public class LoadGuidesEvent {
    private List<GuidesVO> guideList;

    public LoadGuidesEvent(List<GuidesVO> guideList) {
        this.guideList = guideList;
    }

    public List<GuidesVO> getGuideList() {
        return guideList;
    }
}
