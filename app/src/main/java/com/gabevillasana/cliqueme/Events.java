package com.gabevillasana.cliqueme;

/**
 * Created by gbotev on 2/18/17.
 */

import android.os.Bundle;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Events {

    private static User user;
    private static ArrayList<Event> events;
    private static boolean hasError = false;

    /**
     * Produces a User object with relevant info.
     */
    public static User getUserInfo() {
        GraphRequest request = GraphRequest.newMeRequest(
            AccessToken.getCurrentAccessToken(),
            new GraphRequest.GraphJSONObjectCallback() {
                @Override
                public void onCompleted(JSONObject object, GraphResponse response) {
                    try {
                        user = new User(object.getString("name"), object.getString("email"),
                                object.getString("locale"), object.getString("gender"));
                    } catch (Exception e) {
                        hasError = true;
                    }
                }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "name,gender,email,locale");
        request.setParameters(parameters);
        request.executeAsync();
        if (hasError) {
            // Reset error flag
            hasError = false;
            return null;
        } else {
            // Reset error flag
            hasError = false;
            return user;
        }
    }

    /**
     * Produces a ArrayList of events that are nearby the current user or null if an error occurred.
     */
    public static ArrayList<Event> getNearbyEvents(double latitude, double longitude) {
        events = new ArrayList<Event>();
        GraphRequest request = GraphRequest.newGraphPathRequest(AccessToken.getCurrentAccessToken(),
                "/search",
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse response) {
                        try {
                            JSONArray events = response.getJSONObject().getJSONArray("data");
                            for (int i = 0; i < events.length(); i++) {
                                JSONObject currEvent = (JSONObject) events.get(i);
                                Events.events.add(new Event(currEvent.getString("name"),
                                        currEvent.getString("description"),
                                        currEvent.getString("place"),
                                        currEvent.getString("date"),
                                        currEvent.getString("start_time"),
                                        currEvent.getString("end_time")));
                            }
                        } catch (Exception e) {
                            hasError = true;
                        }
                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("q", "*");
        parameters.putString("type", "event");
        parameters.putString("center", Double.toString(latitude) + ", " + Double.toString(longitude));
        parameters.putString("distance", "100");
        request.setParameters(parameters);
        request.executeAsync();
        if (hasError) {
            // Reset error flag
            hasError = false;
            return null;
        } else {
            // Reset error flag
            hasError = false;
            return events;
        }
    }

}
