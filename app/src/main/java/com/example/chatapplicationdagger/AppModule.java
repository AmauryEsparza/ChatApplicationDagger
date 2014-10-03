package com.example.chatapplicationdagger;

import com.example.chatapplicationdagger.ViewControllers.ChatActivityModule;
import com.example.chatapplicationdagger.ViewControllers.ChatActivityViewController;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Amaury Esparza on 02/10/2014.
 */

@Module(
        injects = {
                ChatActivityViewController.class
        },
        complete = false
)
public class AppModule {

}
