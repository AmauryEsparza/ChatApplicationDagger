package com.example.chatapplicationdagger.BussinessControllers;

import android.app.Application;
import android.util.JsonReader;
import android.util.Log;
import android.widget.Toast;

import com.example.chatapplicationdagger.App;
import com.example.chatapplicationdagger.InformationHandlers.IClientChat;
import com.example.chatapplicationdagger.Modules.ClientChatInformationModule;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;

import dagger.ObjectGraph;

/**
 * Created by Amaury Esparza on 02/10/2014.
 */

//Prepare de JSON request before send it through the server
public class ParseRequestBussinessController implements IRequestHandler {
    private ObjectGraph objectGraph;
    //Maybe this value must be injected;
    private JSONObject jsonRequest;
    private JSONObject jsonResponse;

    @Inject IClientChat chatHandler;

    //Pass through the classes App maybe isn´t good
    public ParseRequestBussinessController(App app){
        objectGraph = app.getObjectGraph().plus(new ClientChatInformationModule());
        objectGraph.inject(this);
    }

    @Override
    public String[] getConnectedUsers() throws JSONException {
        String [] names;

        String value = "";

        jsonRequest = new JSONObject();
        jsonRequest.put("accion", "listar");
        jsonResponse = new JSONObject(chatHandler.getResponseString(jsonRequest));
        if(jsonResponse.getString("status").equals("error")){
            return null;
        }
        //Parse JSONObject Response
        JSONObject jsonContacts = new JSONObject(jsonResponse.get("informacion").toString());
        //Usernames String Array
        names = new String [jsonContacts.length()] ;
        Iterator iterator = jsonContacts.keys();
        int index = 0;
        //Iterator JSONObject element
        while(iterator.hasNext()) {
            String key = (String) iterator.next();
            JSONObject jsonInformation = jsonContacts.getJSONObject(key);
            names[index] = jsonInformation.getString("usuario");
            Log.d("ParseRequestBusinessController$jsonInformation", names[index]);
            index++;
        }
        return names;
    }

    @Override
    public void updateUser(String username, String ip, int port, String status) throws JSONException{
        //Prepare JSONObject Request
        jsonRequest = new JSONObject();
        jsonRequest.put("accion", "actualizar");
        jsonRequest.put("identificador", 1);
        JSONObject jsonInformation = new JSONObject();
        jsonInformation.put("status", status);
        jsonInformation.put("usuario", username);
        jsonInformation.put("IP", ip);
        jsonInformation.put("puerto", port);
        jsonRequest.accumulate("informacion", jsonInformation);
        Log.d("ParseRequestBusinessController$updateUser()", chatHandler.getResponseString(jsonRequest));



    }
}

