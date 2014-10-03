package com.example.chatapplicationdagger.ViewControllers;

import com.example.chatapplicationdagger.BussinessControllers.FriendChatBussinessController;
import com.example.chatapplicationdagger.BussinessControllers.IChatRepresentationDelegate;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Amaury Esparza on 02/10/2014.
 */
@Module
public class ChatActivityModule {

    @Provides public IChatRepresentationDelegate provideFriendChat(){
        return new FriendChatBussinessController();
    }
}
