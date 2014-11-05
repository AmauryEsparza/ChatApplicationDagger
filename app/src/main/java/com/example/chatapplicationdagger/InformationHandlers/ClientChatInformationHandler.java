package com.example.chatapplicationdagger.InformationHandlers;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.concurrent.ExecutionException;

/**
 * Created by Amaury Esparza on 02/10/2014.
 */

//This class send the request and receive the response from the server
public class ClientChatInformationHandler extends AsyncTask<JSONObject, Void , Void> implements IClientChat{
    //Server IP address
    private final String serverAddress = "192.168.1.79";
    private final int serverPort = 13373;
    private String response;

    @Override
    protected Void doInBackground(JSONObject... action) {
        Socket socket = null;
        response = "";
        try {
            socket = new Socket(serverAddress, serverPort);
            Log.d("JSONObject ClientTask", "" + action[0] + '\0');
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Log.d("JSONObject ClientTask", "" + action[0] + '\0');
            out.write(action[0].toString()+'\0');
            out.flush();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            response = in.readLine();
            Log.d("RESPONSE", response);
            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public String getResponseString(JSONObject jsonObject){
        //Start the Thread
        try {
            execute(jsonObject);
            get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d("ClientChatInformationHandler", response);
        return response;
    }

}
