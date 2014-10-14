package com.example.chatapplicationdagger.Modules;

import android.app.Application;

import com.example.chatapplicationdagger.App;
import com.example.chatapplicationdagger.BussinessControllers.IListFriendsRepresentationDelegate;
import com.example.chatapplicationdagger.BussinessControllers.ListFriendsBussinessController;
import com.example.chatapplicationdagger.ViewControllers.FriendsListViewController;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Amaury Esparza on 07/10/2014.
 */
@Module(
    injects = FriendsListViewController.class
)
public class FriendsListModule {

    private App application;
    public FriendsListModule(App application){
        this.application = application;
    }
    @Provides @Singleton IListFriendsRepresentationDelegate providesListFriendsRepresentationDelegateProvides(){
        return new ListFriendsBussinessController(application);
    }
}
