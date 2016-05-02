package lsinf1225.uclove;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

//TODO: image
//TODO: bouton vers modification du profil?

public class profileActivity extends AppCompatActivity {

    TextView firstNameView, nameView, placeView, birthdayView, descriptionView, orientationView;
    User user;
    private ImageButton yesOrNoButton, friendsRequestButton, friendsButton, profileButton, settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //////////////////BOUTONS DE MENU///////////////////////
        yesOrNoButton = (ImageButton) findViewById(R.id.YesOrNo);
        friendsRequestButton = (ImageButton) findViewById(R.id.FriendsRequests);
        friendsButton = (ImageButton) findViewById(R.id.Friends);
        profileButton = (ImageButton) findViewById(R.id.Profile);
        settingsButton = (ImageButton) findViewById(R.id.Settings);

        yesOrNoButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), YesOrNoActivity.class);
                startActivity(intent);}});
        friendsRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FriendsRequestActivity.class);
                startActivity(intent); } });
        friendsButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ListOfChatsActivity.class);
                startActivity(intent); } });
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Toast.makeText(profileActivity.this, "Refreshing...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), profileActivity.class);
                startActivity(intent); } });
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SettingsActivity.class);
                startActivity(intent); } });
        ////////////////////FIN BOUTONS DE MENU///////////////////////

        firstNameView = (TextView) findViewById(R.id.firstName);
        nameView = (TextView) findViewById(R.id.name);
        placeView = (TextView) findViewById(R.id.place);
        birthdayView = (TextView) findViewById(R.id.birthday);
        descriptionView = (TextView) findViewById(R.id.description);
        orientationView = (TextView) findViewById(R.id.orientation);

        user = MyApplication.getUser();
        firstNameView.setText(user.getFirstNameStr());
        nameView.setText(user.getNameStr());
        placeView.setText(user.getPlaceStr());
        birthdayView.setText(user.getBirthdayStr());
        descriptionView.setText(user.getDescriptionStr());
        orientationView.setText(user.getOrientationStr());

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton("No way!", null)
                .setPositiveButton("Yes...", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        finish();
                    }
                }).create().show();
    }
}
