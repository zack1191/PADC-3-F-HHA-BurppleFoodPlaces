package com.hha.heinhtetaung.burpplefoodplaces.activities.data.models;

import com.hha.heinhtetaung.burpplefoodplaces.activities.network.FeaturedOkHttpDataAgent;
import com.hha.heinhtetaung.burpplefoodplaces.activities.network.FeaturedRetrofitDataAgent;
import com.hha.heinhtetaung.burpplefoodplaces.activities.network.FeaturesDataAgent;

/**
 * Created by E5 on 1/12/2018.
 */

public class FeaturesModel {
    private static FeaturesModel sObjInstance;
    private FeaturesDataAgent mFeaturesDataAgent;


    private FeaturesModel() {

//        mFeaturesDataAgent = FeaturedOkHttpDataAgent.getsObjInstance();
        mFeaturesDataAgent = FeaturedRetrofitDataAgent.getsObjInstance();
    }

    public static FeaturesModel getSobjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new FeaturesModel();
        }
        return sObjInstance;
    }

    public void loadFeatured() {
        mFeaturesDataAgent.loadFeatures();
    }
}
