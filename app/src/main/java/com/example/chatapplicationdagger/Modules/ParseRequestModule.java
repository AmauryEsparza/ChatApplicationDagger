package com.example.chatapplicationdagger.Modules;

import android.app.Application;

import com.example.chatapplicationdagger.App;
import com.example.chatapplicationdagger.BussinessControllers.IRequestHandler;
import com.example.chatapplicationdagger.BussinessControllers.ListFriendsBussinessController;
import com.example.chatapplicationdagger.BussinessControllers.LoginBussinessController;
import com.example.chatapplicationdagger.BussinessControllers.ParseRequestBussinessController;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Amaury Esparza on 08/10/2014.
 */
@Module(
        injects = {
                ListFriendsBussinessController.class,
                LoginBussinessController.class
        }
)
public class ParseRequestModule {

    App app;
    public ParseRequestModule(Application app){
        this.app = (App) app;
    }
    @Provides @Singleton
    IRequestHandler provideIRequestHandler(){
        return new ParseRequestBussinessController(app);
    }
}
