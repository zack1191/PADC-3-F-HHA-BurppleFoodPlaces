package com.hha.heinhtetaung.burpplefoodplaces.activities.data.models;

import com.hha.heinhtetaung.burpplefoodplaces.activities.network.GuideOkHttpDataAgent;
import com.hha.heinhtetaung.burpplefoodplaces.activities.network.GuidesDataAgent;
import com.hha.heinhtetaung.burpplefoodplaces.activities.network.PromotionDataAgent;

/**
 * Created by E5 on 1/12/2018.
 */

public class GuidesModel {
    private GuidesDataAgent mGuidesDataAgent;

    private static GuidesModel sObjInstance;

    private GuidesModel() {

        mGuidesDataAgent = GuideOkHttpDataAgent.getsObjInstance();
    }

    public static GuidesModel getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new GuidesModel();
        }
        return sObjInstance;
    }

    public void loadGuides() {
        mGuidesDataAgent.loadGuides();
    }
}
