package com.iteso.tarea4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.iteso.tarea4.beans.User;
import com.iteso.tarea4.tools.Constants;

import java.util.Timer;
import java.util.TimerTask;

public class ActivitySplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                User user = loadSharedPreferences();
                if(!user.isLogged()){
                    Intent intent = new Intent(ActivitySplashScreen.this,ActivityLogin.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(ActivitySplashScreen.this,ActivityMain.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, Constants.SPLASH_SCREEN_DELAY);
    }

    private User loadSharedPreferences(){
        User user = new User();
        SharedPreferences sharedPreferences = getSharedPreferences(Constants.PACKAGE_PREFERENCES,MODE_PRIVATE);
        user.setName(sharedPreferences.getString(Constants.SHARED_PREFERENCES_USERNAME, null));
        user.setPassword(sharedPreferences.getString(Constants.SHARED_PREFERENCES_PASSWORD, null));
        user.setLogged(sharedPreferences.getBoolean(Constants.SHARED_PREFERENCES_LOGGED,false));
        return user;
    }
}
