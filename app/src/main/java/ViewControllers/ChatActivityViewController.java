package ViewControllers;

import android.app.Activity;
import android.os.Bundle;

import com.example.chatapplicationdagger.R;

import BussinessControllers.FriendChatBussinessController;
import BussinessControllers.IChatRepresentationDelegate;

/**
 * Created by Amaury Esparza on 02/10/2014.
 */

//Contains the reference to chat_activity.xml relation with FriendsChatBussinesController to send the messages
public class ChatActivityViewController extends Activity{

    //this fields is gonna be injected
    IChatRepresentationDelegate chatBussiness;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity);
        chatBussiness = new FriendChatBussinessController();
        chatBussiness.sendMessage("Hola");
    }



}
