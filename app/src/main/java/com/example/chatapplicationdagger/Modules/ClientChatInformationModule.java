package com.example.chatapplicationdagger.Modules;

import com.example.chatapplicationdagger.BussinessControllers.ParseRequestBussinessController;
import com.example.chatapplicationdagger.InformationHandlers.ClientChatInformationHandler;
import com.example.chatapplicationdagger.InformationHandlers.IClientChat;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Amaury Esparza on 08/10/2014.
 */
@Module(
    injects = ParseRequestBussinessController.class
)
public class ClientChatInformationModule {
    @Provides @Singleton
    IClientChat provideIClientChat(){
        return new ClientChatInformationHandler();
    }
}
