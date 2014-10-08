package com.example.chatapplicationdagger.BussinessControllers;

/**
 * Created by Amaury Esparza on 02/10/2014.
 */

//Get the list of the friends connected from the server
public class ListFriendsBussinessController implements IListFriendsRepresentationDelegate{

    //This value it's gonna be injected
    //ParseRequestBusinessController parserRequest;

    @Override
    public String[] listConnectedFriends(){
        String [] names = new String[] {"Amaury Esparza", "Luis Rangel", "Hugo Medina", "Cesar Ureno"};
        return names;
        //Return parserRequest.getListFriends
    }

}
