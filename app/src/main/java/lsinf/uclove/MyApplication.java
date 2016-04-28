package lsinf1225.uclove;

import android.app.Application;
import android.content.res.Configuration;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by Maxence on 28-04-16.
 */
public class MyApplication extends Application {

    private static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        MyApplication.user = user;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        Toast.makeText(MyApplication.this, "Goodbye", Toast.LENGTH_SHORT).show();
        super.onTerminate();
    }

}
