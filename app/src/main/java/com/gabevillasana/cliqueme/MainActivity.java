package com.gabevillasana.cliqueme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.AccessToken;
import android.content.Intent;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    private TextView info;
    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // INITIALIZE FACEBOOK SDK
        FacebookSdk.sdkInitialize(getApplicationContext());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // DECLARE CALLBACK METHOD
        callbackManager = CallbackManager.Factory.create();

        // LINK TEXTVIEW
        info = (TextView) findViewById(R.id.info);

        // LINK LOGIN BUTTON
        loginButton = (LoginButton) findViewById(R.id.login_button);
        /*
        List<String> permissionNeeds = Arrays.asList("user_photos", "email", "user_birthday", "public_profile");
        loginButton.setReadPermissions(permissionNeeds);
        */

        /** Callback to handle the results of the login attempts.
         *  onSuccess = login successful
         *  onCancel = Canceled login
         *  onError = Failed Login
         */
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                launchEvents();
                // CALL SEARCH
                Events query = new Events(loginResult.getAccessToken());
                query.getEventsNearMe();
            }

            @Override
            public void onCancel() {
                info.setText("Login attempt canceled.");
            }

            @Override
            public void onError(FacebookException e) {
                info.setText("Login attempt failed.");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void launchEvents() {
        Intent launchEvents = new Intent(this, EventsPage.class);
        startActivity(launchEvents);
    }

}
