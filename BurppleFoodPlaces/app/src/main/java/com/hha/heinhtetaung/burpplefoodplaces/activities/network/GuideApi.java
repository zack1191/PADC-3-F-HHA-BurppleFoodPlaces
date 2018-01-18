package com.hha.heinhtetaung.burpplefoodplaces.activities.network;

import com.hha.heinhtetaung.burpplefoodplaces.activities.network.responses.GetGuidesResponses;
import com.hha.heinhtetaung.burpplefoodplaces.activities.network.responses.GetPromotionResponses;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by E5 on 1/18/2018.
 */

public interface GuideApi {

    @FormUrlEncoded
    @POST("getGuides.php")
    Call<GetGuidesResponses> getGuides(@Field("page") int page,
                                       @Field("access_token") String accessToken);


}
