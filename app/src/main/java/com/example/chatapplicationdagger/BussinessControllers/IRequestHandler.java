package com.example.chatapplicationdagger.BussinessControllers;

import org.json.JSONException;

/**
 * Created by Amaury Esparza on 02/10/2014.
 */

//All the methods for prepare the JSON Objects to send to ClientChatInformationHandler
public interface IRequestHandler {
    public String[] getConnectedUsers() throws JSONException;
    public void updateUser(String username, String ip, int port, String status)throws JSONException;
    public void sendMessage(int index, String message) throws JSONException;
    public void listMessages(int publicId) throws JSONException;

}
