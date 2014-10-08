package com.example.chatapplicationdagger.BussinessControllers;

import android.util.Log;

/**
 * Created by Amaury Esparza on 02/10/2014.
 */

public class LoginBussinessController implements ILoginRepresentationDelegate {
    //The data it's send to ParseRequestBusinessController for the server request

    @Override
    public void login(String username){
        Log.d("LoginBusinessController", username);
    }
}
