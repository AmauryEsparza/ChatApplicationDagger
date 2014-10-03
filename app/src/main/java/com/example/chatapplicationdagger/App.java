package com.example.chatapplicationdagger;

import android.app.Application;

import dagger.ObjectGraph;

/**
 * Created by Amaury Esparza on 03/10/2014.
 */
public class App extends Application{
    private ObjectGraph objectGraph;

    @Override
    public void onCreate(){
        super.onCreate();
        objectGraph.create(AppModule.class);
    }

    public ObjectGraph getObjectGraph(){
        return objectGraph;
    }


}
