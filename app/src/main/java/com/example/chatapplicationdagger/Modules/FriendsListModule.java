package com.example.chatapplicationdagger.Modules;

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

    @Provides @Singleton IListFriendsRepresentationDelegate providesListFriendsRepresentationDelegateProvides(){
        return new ListFriendsBussinessController();
    }
}
