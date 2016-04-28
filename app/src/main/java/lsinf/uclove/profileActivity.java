package lsinf1225.uclove;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class profileActivity extends AppCompatActivity {

    TextView firstNameView, nameView, placeView, birthdayView, descriptionView, orientationView;
    User user;
    private ImageButton yesOrNoButton, friendsRequestButton, friendsButton, profileButton, settingsButton;

    String firstNameStr, nameStr, placeStr, birthdayStr, descriptionStr, orientationStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firstNameView = (TextView) findViewById(R.id.firstName);
        nameView = (TextView) findViewById(R.id.name);
        placeView = (TextView) findViewById(R.id.place);
        birthdayView = (TextView) findViewById(R.id.birthday);
        descriptionView = (TextView) findViewById(R.id.description);
        orientationView = (TextView) findViewById(R.id.orientation);

        MyApplication mApplication = (MyApplication)getApplicationContext();
        user = mApplication.getUser();
        firstNameView.setText(user.getFirstNameStr());
        nameView.setText(user.getNameStr());
        placeView.setText(user.getPlaceStr());
        birthdayView.setText(user.getBirthdayStr());
        descriptionView.setText(user.getDescriptionStr());
        orientationView.setText(user.getOrientationStr());

        yesOrNoButton = (ImageButton) findViewById(R.id.YesOrNo);
        friendsRequestButton = (ImageButton) findViewById(R.id.FriendsRequests);
        friendsButton = (ImageButton) findViewById(R.id.Friends);
        profileButton = (ImageButton) findViewById(R.id.Profile);
        settingsButton = (ImageButton) findViewById(R.id.Settings);

        /*
        yesOrNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { }
        });
        */

        /*
        friendsRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { }
        });
        */

        /*
        friendsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { }
        });
        */


        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(profileActivity.this, "Refreshing...", Toast.LENGTH_SHORT).show();
            }
        });


        /*
        yesOrNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { }
        });
        */


    }
}
