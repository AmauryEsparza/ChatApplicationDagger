package com.example.chatapplicationdagger.ViewControllers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.chatapplicationdagger.App;
import com.example.chatapplicationdagger.BussinessControllers.ILoginRepresentationDelegate;
import com.example.chatapplicationdagger.Modules.LoginActivityModule;
import com.example.chatapplicationdagger.R;
import javax.inject.Inject;
import dagger.ObjectGraph;

public class LoginActivityViewController extends Activity {

    //Call to login on LoginBusinessController
    @Inject ILoginRepresentationDelegate loginRepresentationDelegate;
    private ObjectGraph loginGraph;
    private Button buttonLogin;
    private EditText editTextUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonLogin = (Button) findViewById(R.id.button);
        editTextUser = (EditText) findViewById(R.id.username);

        //Adds new dependencies to the Graph
        loginGraph = ((App) getApplication()).getObjectGraph().plus(new LoginActivityModule());
        loginGraph.inject(this);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Verify the user exists
                loginRepresentationDelegate.login(editTextUser.getText().toString());
                Intent intent = new Intent(getApplicationContext(), FriendsListViewController.class);
                startActivity(intent);
            }
        });
    }
}
