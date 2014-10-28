package com.example.chatapplicationdagger.Modules;

import android.util.Log;

import com.example.chatapplicationdagger.App;
import com.example.chatapplicationdagger.BussinessControllers.FriendChatBussinessController;
import com.example.chatapplicationdagger.BussinessControllers.IChatRepresentationDelegate;
import com.example.chatapplicationdagger.ViewControllers.ChatActivityViewController;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Amaury Esparza on 02/10/2014.
 */
@Module(
        injects = ChatActivityViewController.class
)
public class ChatActivityModule {

    App application;
    public ChatActivityModule(App application){
        this.application = application;
    }
    @Provides @Singleton
    IChatRepresentationDelegate provideFriendChat(){
        return new FriendChatBussinessController(application);
    }
}
