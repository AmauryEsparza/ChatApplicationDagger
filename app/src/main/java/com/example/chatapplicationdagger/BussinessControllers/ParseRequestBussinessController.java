package com.example.chatapplicationdagger.BussinessControllers;

import android.app.Application;
import android.text.format.Time;
import android.util.JsonReader;
import android.util.Log;
import android.widget.Toast;

import com.example.chatapplicationdagger.App;
import com.example.chatapplicationdagger.InformationHandlers.IClientChat;
import com.example.chatapplicationdagger.Modules.ClientChatInformationModule;

import org.json.JSONException;
import org.json.JSONObject;


import java.util.Calendar;
import java.util.Iterator;

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
    //Store the users public keys
    private static String [] publicKeys;

    @Inject IClientChat chatHandler;

    //Pass through the classes App maybe isn´t good
    public ParseRequestBussinessController(App app){
        objectGraph = app.getObjectGraph().plus(new ClientChatInformationModule());
        objectGraph.inject(this);
    }

    @Override
    public void updateUser(String username, String ip, int port, String status) throws JSONException{
        //Prepare JSONObject Request
        jsonRequest = new JSONObject();
        jsonRequest.put("accion", "actualizar");
        jsonRequest.put("identificador", 0);
        JSONObject jsonInformation = new JSONObject();
        jsonInformation.put("status", status);
        jsonInformation.put("usuario", username);
        jsonInformation.put("IP", ip);
        jsonInformation.put("puerto", port);
        jsonRequest.accumulate("informacion", jsonInformation);
        chatHandler.getResponseString(jsonRequest);
    }

    @Override
    public String[] getConnectedUsers() throws JSONException {
        String [] names;
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
        //Public Keys Array
        publicKeys = new String[jsonContacts.length()];
        Iterator iterator = jsonContacts.keys();
        int index = 0;
        //Iterator JSONObject element
        while(iterator.hasNext()) {
            String key = (String) iterator.next();
            JSONObject jsonInformation = jsonContacts.getJSONObject(key);
            publicKeys[index] = key;
            names[index] = jsonInformation.getString("usuario");
            index++;
        }
        return names;
    }

    @Override
    public void listMessages(int publicId) throws JSONException{
        jsonRequest = new JSONObject();
        jsonRequest.put("accion", "listarMensajes");
        jsonResponse = new JSONObject(chatHandler.getResponseString(jsonRequest));
        Log.d("ParseRequestBusinessController$listMessages", jsonResponse.toString());
    }

    @Override
    public void sendMessage(int index, String message) throws JSONException{
        //Get the current time
        Log.d("ParseRequestBusinessController$sendMessage", message);
        Time now = new Time(Time.getCurrentTimezone());
        now.setToNow();
        jsonRequest = new JSONObject();
        jsonRequest.put("accion", "enviar");
        jsonRequest.put("identificador", publicKeys[index]);
        JSONObject messageInformation = new JSONObject();
        //messageInformation.put("horaFecha", now.format("YYYY-mm-dd HH:MM:SS"));
        messageInformation.put("horaFecha", now.format("%Y-%m-%d %H:%M:%S.000000"));
        messageInformation.put("mensaje", message);
        jsonRequest.accumulate("informacionMsj", messageInformation);
        jsonResponse = new JSONObject(chatHandler.getResponseString(jsonRequest));
        Log.d("ParseRequestBusinessController$sendMessage", jsonResponse.toString());
    }
}

