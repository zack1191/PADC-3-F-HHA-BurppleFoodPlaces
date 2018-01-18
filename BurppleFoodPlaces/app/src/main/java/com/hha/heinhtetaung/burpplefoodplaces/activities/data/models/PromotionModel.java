package com.hha.heinhtetaung.burpplefoodplaces.activities.data.models;

import com.hha.heinhtetaung.burpplefoodplaces.activities.network.PromotionDataAgent;
import com.hha.heinhtetaung.burpplefoodplaces.activities.network.PromotionOkHttpDataAgent;
import com.hha.heinhtetaung.burpplefoodplaces.activities.network.PromotionRetrofitDataAgent;

/**
 * Created by E5 on 1/12/2018.
 */

public class PromotionModel {

    private static PromotionModel sObjInstance;
    private PromotionDataAgent mPromotionDataAgent;

    private PromotionModel() {

//        mPromotionDataAgent = PromotionOkHttpDataAgent.getsObjInstance();
        mPromotionDataAgent = PromotionRetrofitDataAgent.getsObjInstance();
    }

    public static PromotionModel getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new PromotionModel();
        }
        return sObjInstance;
    }

    public void loadPromotion() {
        mPromotionDataAgent.loadPromotion();
    }
}
