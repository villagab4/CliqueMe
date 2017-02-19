package com.gabevillasana.cliqueme;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.google.firebase.storage.FirebaseStorage;

/**
 * Created by Gabe Villasana on 2/18/2017.
 */

public class EventsPage extends FragmentActivity {
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager());
        viewPager.setAdapter(swipeAdapter);
    }
    FirebaseStorage storage = FirebaseStorage.getInstance();
}
