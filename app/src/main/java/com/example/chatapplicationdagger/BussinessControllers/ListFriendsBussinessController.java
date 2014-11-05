package com.example.chatapplicationdagger.BussinessControllers;

import com.example.chatapplicationdagger.App;
import com.example.chatapplicationdagger.Modules.ParseRequestModule;

import org.json.JSONException;

import javax.inject.Inject;

import dagger.ObjectGraph;

/**
 * Created by Amaury Esparza on 02/10/2014.
 */

//Get the list of the friends connected from the server
public class ListFriendsBussinessController implements IListFriendsRepresentationDelegate{

    private ObjectGraph graphListFriends;
    //This value it's gonna be injected
    @Inject IRequestHandler requestHandler;

    //Pass App reference through the classes don't like me
    public ListFriendsBussinessController(App app){
        graphListFriends = app.getObjectGraph().plus(new ParseRequestModule(app));
        graphListFriends.inject(this);
    }
    @Override
    public String[] listConnectedFriends(){
        String[] names = {""};
        try {
            names = requestHandler.getConnectedUsers();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return names;
    }
}
