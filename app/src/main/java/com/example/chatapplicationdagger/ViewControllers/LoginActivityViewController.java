package com.example.chatapplicationdagger.ViewControllers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chatapplicationdagger.App;
import com.example.chatapplicationdagger.BussinessControllers.ILoginRepresentationDelegate;
import com.example.chatapplicationdagger.Modules.LoginActivityModule;
import com.example.chatapplicationdagger.R;

import java.net.InetAddress;

import javax.inject.Inject;
import dagger.ObjectGraph;

public class LoginActivityViewController extends Activity {

    //Call to login on LoginBusinessController
    @Inject ILoginRepresentationDelegate loginRepresentationDelegate;
    private ObjectGraph loginGraph;
    private Button buttonLogin;
    private EditText editTextUser;
    private String ip;
    private String port;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonLogin = (Button) findViewById(R.id.button);
        editTextUser = (EditText) findViewById(R.id.username);

        //Adds new dependencies to the Graph
        loginGraph = ((App) getApplication()).getObjectGraph().plus(new LoginActivityModule((App) getApplication()));
        loginGraph.inject(this);



        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if(connectionInfo != null){
                    //ip = Integer.toString(connectionInfo.getIpAddress());
                    ip = "192.168.1.79";
                    if(ip != null) {
                        Log.d("LoginActivity", ip + "");
                        loginRepresentationDelegate.login(editTextUser.getText().toString(), ip, 13375, "online");
                        Intent intent = new Intent(getApplicationContext(), FriendsListViewController.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "There's not internet connection, Try Again Later", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "There's not internet connection, Try Again Later", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    @Override
    protected void onDestroy(){
        Log.d("LoginActivityViewController", "onDestroy()");
        //Status change to offline
        loginGraph = null;
        super.onDestroy();
    }
}
