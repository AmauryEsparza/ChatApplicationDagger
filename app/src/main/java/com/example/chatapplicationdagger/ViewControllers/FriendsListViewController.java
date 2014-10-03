package com.example.chatapplicationdagger.ViewControllers;

import android.app.ListActivity;
import android.os.Bundle;

import com.example.chatapplicationdagger.R;

/**
 * Created by Amaury Esparza on 02/10/2014.
 */

//Shows the list of the friends implements for ListFriendsBussinessController
public class FriendsListViewController extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends_list_activity);

    }

}
