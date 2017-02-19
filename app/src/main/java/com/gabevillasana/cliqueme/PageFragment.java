package com.gabevillasana.cliqueme;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.pdf.PdfDocument;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import static com.facebook.FacebookSdk.getApplicationContext;
import static com.gabevillasana.cliqueme.Events.getNearbyEvents;
import static com.gabevillasana.cliqueme.R.layout.events;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends android.support.v4.app.Fragment {
    TextView name;
    TextView date;
    TextView times;
    TextView description;
    TextView place;


    public PageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Fetch events
        LocationManager manager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        Location location = manager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        // Obtain event list
        ArrayList<Event> events = Events.getNearbyEvents(location.getLatitude(), location.getLongitude());
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.page_fragment_layout, container, false);
        Bundle bundle = getArguments();
        String message = Integer.toString(bundle.getInt("eventNum"));
        name = (TextView)view.findViewById(R.id.name);
        name.setText("Name " + events.get(Integer.valueOf(message)).getName());
        date = (TextView)view.findViewById(R.id.date);
        date.setText("Date " + events.get(Integer.valueOf(message)).getDate());
        times = (TextView)view.findViewById(R.id.times);
        times.setText(events.get(Integer.valueOf(message)).getStartTime() + " - " + events.get(Integer.valueOf(message)).getEndTime());
        description = (TextView)view.findViewById(R.id.description);
        description.setText("Description " + events.get(Integer.valueOf(message)).getDescription());
        place = (TextView)view.findViewById(R.id.place);
        place.setText("Place " + events.get(Integer.valueOf(message)).getPlace());
        return  view;
    }

}
