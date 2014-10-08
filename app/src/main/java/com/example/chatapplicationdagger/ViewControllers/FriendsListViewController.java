package com.example.chatapplicationdagger.ViewControllers;

import android.app.ListActivity;
import android.os.Bundle;
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
    String [] names;
    private ObjectGraph graphFriendsList;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Injecting Dependencies
        graphFriendsList = ((App) getApplication()).getObjectGraph().plus(new FriendsListModule());
        graphFriendsList.inject(this);
        //Get the names of the connected users
        names = friendsRepresentationDelegate.listConnectedFriends();

        //Create the adapter and add the friends to the ListView
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, names);
        setListAdapter(listAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Toast.makeText(this, "What's up", Toast.LENGTH_SHORT).show();

    }

}
