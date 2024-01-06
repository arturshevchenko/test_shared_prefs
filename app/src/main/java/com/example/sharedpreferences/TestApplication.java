package com.example.sharedpreferences;


import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.appspector.sdk.AppSpector;
import com.appspector.sdk.monitors.commands.CommandCallback;
import com.appspector.sdk.monitors.commands.Responder;


public class TestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AppSpector.build(this)
                .withDefaultMonitors()
                .run("android_YWI5ZTM1OWQtZDYyYi00MTgyLTgwYzEtODEwOWZiNDlkYWY3");

    }



}
