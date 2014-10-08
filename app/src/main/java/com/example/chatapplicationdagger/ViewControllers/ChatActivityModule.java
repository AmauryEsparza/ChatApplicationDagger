package com.example.chatapplicationdagger.ViewControllers;

import android.util.Log;

import com.example.chatapplicationdagger.BussinessControllers.FriendChatBussinessController;
import com.example.chatapplicationdagger.BussinessControllers.IChatRepresentationDelegate;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Amaury Esparza on 02/10/2014.
 */
@Module(
        injects = ChatActivityViewController.class,
        complete = false
)
public class ChatActivityModule {

    @Provides @Singleton
    IChatRepresentationDelegate provideFriendChat(){
        return new FriendChatBussinessController();
    }
}
