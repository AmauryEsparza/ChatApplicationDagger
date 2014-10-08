package com.example.chatapplicationdagger.ViewControllers;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.chatapplicationdagger.App;
import com.example.chatapplicationdagger.BussinessControllers.FriendChatBussinessController;
import com.example.chatapplicationdagger.R;
import javax.inject.Inject;
import com.example.chatapplicationdagger.BussinessControllers.IChatRepresentationDelegate;

import dagger.ObjectGraph;

/**
 * Created by Amaury Esparza on 02/10/2014.
 */

//Contains the reference to chat_activity.xml relation with FriendsChatBusinessController to send the messages
public class ChatActivityViewController extends Activity{

    //This fields is gonna be injected
    ObjectGraph activityGraph;
    @Inject IChatRepresentationDelegate chatBusiness;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity);
        activityGraph = ((App) getApplication()).getObjectGraph().plus(new ChatActivityModule());
        activityGraph.inject(this);
    }
}
