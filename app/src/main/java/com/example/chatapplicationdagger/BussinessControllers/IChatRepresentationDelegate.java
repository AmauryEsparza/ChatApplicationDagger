package com.example.chatapplicationdagger.BussinessControllers;

/**
 * Created by Amaury Esparza on 02/10/2014.
 */
public interface IChatRepresentationDelegate {
    public void sendMessage(String message);
    public String [] getPreviousMessages();
}
