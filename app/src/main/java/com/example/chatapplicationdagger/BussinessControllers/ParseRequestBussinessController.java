package com.example.chatapplicationdagger.BussinessControllers;

import android.app.Application;
import android.util.Log;

import com.example.chatapplicationdagger.App;
import com.example.chatapplicationdagger.InformationHandlers.IClientChat;
import com.example.chatapplicationdagger.Modules.ClientChatInformationModule;

import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;

import dagger.ObjectGraph;

/**
 * Created by Amaury Esparza on 02/10/2014.
 */

//Prepare de JSON request before send it through the server
public class ParseRequestBussinessController implements IRequestHandler {
    private ObjectGraph objectGraph;
    //Maybe this value must be injected;
    private JSONObject jsonObject;
    @Inject IClientChat chatHandler;

    //Pass through the classes App maybe isn´t good
    public ParseRequestBussinessController(App app){
        objectGraph = app.getObjectGraph().plus(new ClientChatInformationModule());
        objectGraph.inject(this);
    }

    @Override
    public String[] getConnectedUsers() throws JSONException {
        jsonObject = new JSONObject();
        jsonObject.put("accion", "listar");
        Log.d("ParseRequestBussinessController", chatHandler.getResponseString(jsonObject));
        return new String[] {"Amaury Esparza", "Luis Rangel", "Hugo Medina"};
    }

    @Override
    public void updateUser(String username, String ip, int port) throws JSONException{
        contador++;
        //Prepare JSONObject
        jsonObject = new JSONObject();
        jsonObject.put("accion", "actualizar");
        jsonObject.put("identificador", 3);
        JSONObject jsonInformation = new JSONObject();
        jsonInformation.put("status", "online");
        jsonInformation.put("usuario", username);
        jsonInformation.put("IP", ip);
        jsonInformation.put("puerto", port);
        jsonObject.accumulate("informacion", jsonInformation);
        Log.d("ParseRequestBusinessController$updateUser()", chatHandler.getResponseString(jsonObject));
    }


    @Override
    public void imprimir(){
        Log.d("ParseRequestBusinessController", "imprimir()");
    }
}

