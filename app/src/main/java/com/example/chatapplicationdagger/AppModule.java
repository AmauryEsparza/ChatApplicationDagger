package com.example.chatapplicationdagger;

import android.app.Application;

import com.example.chatapplicationdagger.BussinessControllers.FriendChatBussinessController;
import com.example.chatapplicationdagger.ViewControllers.ChatActivityModule;
import com.example.chatapplicationdagger.ViewControllers.ChatActivityViewController;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Amaury Esparza on 02/10/2014.
 */

@Module(
        injects = App.class
)
public class AppModule {

}
