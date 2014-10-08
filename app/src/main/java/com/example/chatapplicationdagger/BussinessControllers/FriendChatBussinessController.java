package com.example.chatapplicationdagger.BussinessControllers;

import android.util.Log;

/**
 * Created by Amaury Esparza on 02/10/2014.
 */
public class FriendChatBussinessController implements IChatRepresentationDelegate{

    //ParseRequestBussinessController request;
    //Request to sendMessage
    @Override
    public void sendMessage(String message){
        Log.d("FriendChatBussinessController", message);
    }

    //Request to get all the previous messages
    @Override
    public String [] getPreviousMessages(){
        //Make the request to ParseRequestBusinessController
        //I need to difference the messages (Receiver and Receptor)
        //It's just to prove the DI
        return new String[] {"Ey!", "Hi!", "How are u", "I'm ok, you?"};
    }



}
