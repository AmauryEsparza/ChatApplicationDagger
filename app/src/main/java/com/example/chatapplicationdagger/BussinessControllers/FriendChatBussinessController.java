package com.example.chatapplicationdagger.BussinessControllers;

import android.util.Log;

/**
 * Created by Amaury Esparza on 02/10/2014.
 */
public class FriendChatBussinessController implements IChatRepresentationDelegate{

    //ParseRequestBussinessController request;
    @Override
    public void sendMessage(String message){
        Log.d("FriendChatBussinessController", message);
    }

}