package com.hha.heinhtetaung.burpplefoodplaces.activities.network;

import com.hha.heinhtetaung.burpplefoodplaces.activities.network.responses.GetPromotionResponses;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by E5 on 1/18/2018.
 */

public interface PromotionApi {

    @FormUrlEncoded
    @POST("getPromotions.php")
    Call<GetPromotionResponses> getPromotions(@Field("page") int page,
                                              @Field("access_token") String accessToken);

}
