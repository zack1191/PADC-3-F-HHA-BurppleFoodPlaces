package com.hha.heinhtetaung.burpplefoodplaces.activities.network;

import com.hha.heinhtetaung.burpplefoodplaces.activities.network.responses.GetLoginResponses;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by E5 on 1/27/2018.
 */

public interface LoginApi {

    @FormUrlEncoded
    @POST("login.php")
    Call<GetLoginResponses> loginUser(@Field("phoneNo") String phoneNo, @Field("password") String password);


}
