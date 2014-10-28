package com.example.chatapplicationdagger.ViewControllers;

import android.app.ListActivity;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.chatapplicationdagger.App;
import com.example.chatapplicationdagger.Modules.ChatActivityModule;
import com.example.chatapplicationdagger.R;
import javax.inject.Inject;
import com.example.chatapplicationdagger.BussinessControllers.IChatRepresentationDelegate;

import dagger.ObjectGraph;

/**
 * Created by Amaury Esparza on 02/10/2014.
 */

//Contains the reference to chat_activity.xml relation with FriendsChatBusinessController to send the messages
public class ChatActivityViewController extends ListActivity {

    private ObjectGraph activityGraph;
    private ImageButton buttonSend;
    private EditText editMessage;
    private int publicId;
    @Inject IChatRepresentationDelegate chatBusiness;

    @Override
    public void onCreate(Bundle savedInstanceState){
        publicId = getIntent().getExtras().getInt("INDEX");
        super.onCreate(savedInstanceState);

        //The index of the user to send message
        setContentView(R.layout.chat_activity);
        activityGraph = ((App) getApplication()).getObjectGraph().plus(new ChatActivityModule((App) getApplication()));
        activityGraph.inject(this);
        ArrayAdapter<String> adapterMessages = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chatBusiness.getPreviousMessages(publicId));
        setListAdapter(adapterMessages);
        buttonSend = (ImageButton) findViewById(R.id.button_message_send);
        editMessage = (EditText) findViewById(R.id.edit_new_message);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Parameters string message and user id for send message
                chatBusiness.sendMessage(editMessage.getText().toString(), publicId);
            }
        });
    }

    @Override
    protected void onDestroy(){
        activityGraph = null;
        super.onDestroy();
    }
}
