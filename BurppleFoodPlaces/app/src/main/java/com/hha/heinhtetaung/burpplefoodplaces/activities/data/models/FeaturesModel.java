package com.hha.heinhtetaung.burpplefoodplaces.activities.data.models;

import com.hha.heinhtetaung.burpplefoodplaces.activities.network.FeaturedOkHttpDataAgent;
import com.hha.heinhtetaung.burpplefoodplaces.activities.network.FeaturesDataAgent;

/**
 * Created by E5 on 1/12/2018.
 */

public class FeaturesModel {
    private static FeaturesModel sobjInstance;
    private FeaturesDataAgent mFeaturesDataAgent;


    private FeaturesModel() {
        mFeaturesDataAgent = FeaturedOkHttpDataAgent.getsObjInstance();
    }

    public static FeaturesModel getSobjInstance() {
        if (sobjInstance == null) {
            sobjInstance = new FeaturesModel();
        }
        return sobjInstance;
    }

    public void loadFeatured() {
        mFeaturesDataAgent.loadFeatures();
    }
}
