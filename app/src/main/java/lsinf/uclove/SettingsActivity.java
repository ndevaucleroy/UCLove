package lsinf1225.uclove;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    private ImageButton yesOrNoButton, friendsRequestButton, friendsButton, profileButton, settingsButton;
    private Button profileSettingsButton, researchSettingsButton, appSettingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        profileSettingsButton = (Button) findViewById(R.id.profileSettings);
        researchSettingsButton = (Button) findViewById(R.id.researchSettings);
        appSettingsButton = (Button) findViewById(R.id.appSettings);
        yesOrNoButton = (ImageButton) findViewById(R.id.YesOrNo);
        friendsRequestButton = (ImageButton) findViewById(R.id.FriendsRequests);
        friendsButton = (ImageButton) findViewById(R.id.Friends);
        profileButton = (ImageButton) findViewById(R.id.Profile);
        settingsButton = (ImageButton) findViewById(R.id.Settings);

        //////////////////BOUTONS DE MENU///////////////////////

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
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), profileActivity.class);
                startActivity(intent);} });
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SettingsActivity.this, "Refreshing...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), SettingsActivity.class);
                startActivity(intent); } });

        ///////////////FIN BOUTONS DE MENU////////////////////////

        //Autres Boutons
        profileSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProfileSettingsActivity.class);
                startActivity(intent);}});
        researchSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ResearchSettingsActivity.class);
                startActivity(intent);}});
        appSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AppSettingsActivity.class);
                startActivity(intent);}});

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
