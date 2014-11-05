package com.example.chatapplicationdagger.BussinessControllers;

import android.util.Log;

import com.example.chatapplicationdagger.App;
import com.example.chatapplicationdagger.Modules.ParseRequestModule;

import org.json.JSONException;

import javax.inject.Inject;

import dagger.ObjectGraph;

/**
 * Created by Amaury Esparza on 02/10/2014.
 */
public class FriendChatBussinessController implements IChatRepresentationDelegate{

    private ObjectGraph graphSendMessage;
    //ParseRequestBussinessController request;
    @Inject IRequestHandler requestHandler;
    //Request to sendMessage
    public FriendChatBussinessController(App app){
        graphSendMessage = app.getObjectGraph().plus(new ParseRequestModule(app));
        graphSendMessage.inject(this);
    }

    @Override
    public void sendMessage(String message, int userID){
        try {
            requestHandler.sendMessage(userID, message);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //Request to get all the previous messages
    @Override
    public String [] getPreviousMessages(int publicId){
        //Make the request to ParseRequestBusinessController
        try {
            requestHandler.listMessages(publicId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new String[] {"Ey!", "Hi!", "How are u", "I'm ok, you?"};
    }
}
