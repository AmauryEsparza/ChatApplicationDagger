package com.example.chatapplicationdagger.BussinessControllers;

import android.util.Log;

import com.example.chatapplicationdagger.App;
import com.example.chatapplicationdagger.Modules.ParseRequestModule;

import org.json.JSONException;

import javax.inject.Inject;

import dagger.ObjectGraph;

/**
 * Created by Amaury Esparza on 02/10/2014.
 */

public class LoginBussinessController implements ILoginRepresentationDelegate {
    //The data it's send to ParseRequestBusinessController for the server request
    @Inject
    IRequestHandler requestHandler;
    private ObjectGraph loginGraph;
    public LoginBussinessController(App app){
        loginGraph = app.getObjectGraph().plus(new ParseRequestModule(app));
        loginGraph.inject(this);
    }

    @Override
    public void login(String username, String ip, int port, String status){
        try {
            requestHandler.updateUser(username, ip, port, status);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
