package lsinf1225.uclove;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
//TODO image
public class YoNProfileActivity extends AppCompatActivity {

    private ImageButton yesOrNoButton, friendsRequestButton, friendsButton, profileButton,
            settingsButton, yesButton, noButton;
    private TextView firstNameView, nameView, placeView, birthdayView, descriptionView,
            orientationView, headTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yon_profile);

        //////////////////BOUTONS DE MENU///////////////////////
        yesOrNoButton = (ImageButton) findViewById(R.id.YesOrNo);
        friendsRequestButton = (ImageButton) findViewById(R.id.FriendsRequests);
        friendsButton = (ImageButton) findViewById(R.id.Friends);
        profileButton = (ImageButton) findViewById(R.id.Profile);
        settingsButton = (ImageButton) findViewById(R.id.Settings);
        yesButton = (ImageButton) findViewById(R.id.yes);
        noButton = (ImageButton) findViewById(R.id.no);

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
                Intent intent = new Intent(v.getContext(), profileActivity.class);
                startActivity(intent); } });
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SettingsActivity.class);
                startActivity(intent); } });
        ///////////////////FIN DE BOUTONS DE MENU//////////////////////

        firstNameView = (TextView) findViewById(R.id.firstName);
        nameView = (TextView) findViewById(R.id.name);
        placeView = (TextView) findViewById(R.id.place);
        birthdayView = (TextView) findViewById(R.id.birthday);
        descriptionView = (TextView) findViewById(R.id.description);
        orientationView = (TextView) findViewById(R.id.orientation);
        headTextView = (TextView) findViewById(R.id.headText);

        firstNameView.setText(MyApplication.getUserToDisplay().getFirstNameStr());
        nameView.setText(MyApplication.getUserToDisplay().getNameStr());
        placeView.setText(MyApplication.getUserToDisplay().getPlaceStr());
        birthdayView.setText(MyApplication.getUserToDisplay().getBirthdayStr());
        descriptionView.setText(MyApplication.getUserToDisplay().getDescriptionStr());
        orientationView.setText(MyApplication.getUserToDisplay().getOrientationStr());
        headTextView.setText(MyApplication.getUserToDisplay().getFirstNameStr() + " "
            + MyApplication.getUserToDisplay().getNameStr() + "'s profile");

        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sendFriendRequest
                MyApplication.setPositionInMatchingUsers(MyApplication.getPositionInMatchingUsers() + 1);
                Intent intent = new Intent(v.getContext(), YesOrNoActivity.class);
                startActivity(intent);
            }
        });
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                MyApplication.setPositionInMatchingUsers(MyApplication.getPositionInMatchingUsers() + 1);
                Intent intent = new Intent(v.getContext(), YesOrNoActivity.class);
                startActivity(intent);}});
    }
}
