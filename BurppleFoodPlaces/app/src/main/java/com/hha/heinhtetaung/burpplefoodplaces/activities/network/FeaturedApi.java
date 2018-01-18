package com.hha.heinhtetaung.burpplefoodplaces.activities.network;

import android.telecom.Call;

import com.hha.heinhtetaung.burpplefoodplaces.activities.network.responses.GetFeaturedResponses;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by E5 on 1/16/2018.
 */

public interface FeaturedApi {

    @FormUrlEncoded
    @POST("getFeatured.php")

    retrofit2.Call<GetFeaturedResponses> getFeatured(@Field("page") int page,
                                                     @Field("access_token") String accessToken);
}
