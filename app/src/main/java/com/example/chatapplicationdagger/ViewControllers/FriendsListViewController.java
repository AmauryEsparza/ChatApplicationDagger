package com.example.chatapplicationdagger.ViewControllers;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.chatapplicationdagger.App;
import com.example.chatapplicationdagger.BussinessControllers.IListFriendsRepresentationDelegate;
import com.example.chatapplicationdagger.Modules.FriendsListModule;
import com.example.chatapplicationdagger.R;

import javax.inject.Inject;

import dagger.ObjectGraph;

/**
 * Created by Amaury Esparza on 02/10/2014.
 */

//Shows the list of the friends implements for ListFriendsBussinessController
public class FriendsListViewController extends ListActivity {

    //This object it's gonna be injected
    @Inject IListFriendsRepresentationDelegate friendsRepresentationDelegate;
    private String [] names;
    private ObjectGraph graphFriendsList;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Injecting Dependencies
        graphFriendsList = ((App) getApplication()).getObjectGraph().plus(new FriendsListModule((App)getApplication()));
        graphFriendsList.inject(this);
        //Create the adapter and add the friends to the ListView
        names = friendsRepresentationDelegate.listConnectedFriends();
        if(names != null) {
            ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, names);
            setListAdapter(listAdapter);
        }
        else{
            Toast.makeText(getApplicationContext(), "Error receiving data", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Intent intentChat = new Intent(getApplicationContext(), ChatActivityViewController.class);
        Log.d("FiendListViewController$onListItemClick", position+"");
        intentChat.putExtra("INDEX", position);
        startActivity(intentChat);
    }

    @Override
    protected void onDestroy(){
        graphFriendsList = null;
        super.onDestroy();
    }

}
