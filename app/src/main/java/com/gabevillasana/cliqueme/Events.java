package com.gabevillasana.cliqueme;

/**
 * Created by gbotev on 2/18/17.
 */

import android.app.Activity;
import android.os.Bundle;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONObject;

import java.util.ArrayList;

public class Events extends Activity {

    private AccessToken token;

    // Initialize a new event with current user's access token
    public Events(AccessToken token) {
        this.token = token;
    }

    /**
     * Produces an ArrayList of events that are nearby the current user.
     */
    public ArrayList<Event> getEventsNearMe() {
        GraphRequest request = GraphRequest.newMeRequest(token, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                // Application code
                System.out.println(object.toString());
                System.out.println("HELLOOOOOOOOOOOOOOOOO");
            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,link");
        request.setParameters(parameters);
        request.executeAsync();
        // FIX
        return null;
    }


}
