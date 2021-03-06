package com.example.chatapplicationdagger;

import android.app.Application;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by Amaury Esparza on 03/10/2014.
 */
public class App extends Application{
    private ObjectGraph objectGraph;

    @Override
    public void onCreate(){
        super.onCreate();
        Log.d("App", "onCreate");
        objectGraph = ObjectGraph.create(getModules().toArray());
    }

    public ObjectGraph getObjectGraph(){
        return objectGraph;
    }

    private List<Object> getModules(){
        return Arrays.<Object> asList(new AppModule());
    }
}
