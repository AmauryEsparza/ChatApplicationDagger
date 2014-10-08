package com.example.chatapplicationdagger.ViewControllers;

import com.example.chatapplicationdagger.BussinessControllers.ILoginRepresentationDelegate;
import com.example.chatapplicationdagger.BussinessControllers.LoginBussinessController;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Amaury Esparza on 06/10/2014.
 */
@Module(
        injects = LoginActivityViewController.class
)
public class LoginActivityModule {

    @Provides @Singleton
    ILoginRepresentationDelegate provideLoginRepresentationDelegate(){
        return new LoginBussinessController();
    }


}
