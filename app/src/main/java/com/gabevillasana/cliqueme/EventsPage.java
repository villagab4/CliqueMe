package com.gabevillasana.cliqueme;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;

import static com.facebook.FacebookSdk.getApplicationContext;

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

    public ArrayList<Event> getEventList() {
        try {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            // Fetch events
            LocationManager manager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);

            Location location = manager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            // Obtain event list
            ArrayList<Event> events = Events.getNearbyEvents(location.getLatitude(), location.getLongitude());
            return events;
        } catch (SecurityException | NullPointerException e) {
            double latitude = 39.29738;
            double longitude = (-76.59239);
            ArrayList<Event> events = Events.getNearbyEvents(latitude, longitude);
            return events;
        }
    }

    FirebaseStorage storage = FirebaseStorage.getInstance();
}
