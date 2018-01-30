package com.hha.heinhtetaung.burpplefoodplaces.activities.network;

/**
 * Created by E5 on 1/27/2018.
 */

public interface LoginDataAgent {

    /**
     * login user
     * @param phoneNo
     * @param password
     */
    void loginUser(String phoneNo, String password);

    void registerUser(String phoneNo, String password, String name);
}
