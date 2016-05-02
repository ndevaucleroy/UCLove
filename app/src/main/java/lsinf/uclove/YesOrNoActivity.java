package lsinf1225.uclove;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

//TODO: image
public class YesOrNoActivity extends AppCompatActivity {

    private ImageButton yesOrNoButton, friendsRequestButton, friendsButton, profileButton,
            settingsButton, otherProfileButton, yesButton, noButton;
    private TextView notFound, nameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yesorno);

        notFound= (TextView) findViewById(R.id.noFound);
        notFound.setVisibility(View.GONE);
        nameView = (TextView) findViewById(R.id.firstName);
        yesButton = (ImageButton) findViewById(R.id.yes);
        noButton = (ImageButton) findViewById(R.id.no);
        otherProfileButton = (ImageButton) findViewById(R.id.otherProfile);

        //////////////////BOUTONS DE MENU///////////////////////
        yesOrNoButton = (ImageButton) findViewById(R.id.YesOrNo);
        friendsRequestButton = (ImageButton) findViewById(R.id.FriendsRequests);
        friendsButton = (ImageButton) findViewById(R.id.Friends);
        profileButton = (ImageButton) findViewById(R.id.Profile);
        settingsButton = (ImageButton) findViewById(R.id.Settings);

        yesOrNoButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Toast.makeText(YesOrNoActivity.this, "Refreshing...", Toast.LENGTH_SHORT).show();
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
                startActivity(intent);
            }
        });
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });
        /////////////////FIN BOUTONS DE MENU///////////////////////

        //Trouver un user correspondant aux demandes
        MyApplication.setOtherUserYon(MyApplication.getMatchingUsers().get(MyApplication.getPositionInMatchingUsers()));
        nameView.setText(MyApplication.getOtherUserYon().getFirstNameStr());

        if(MyApplication.getOtherUserYon()==null){
            //display message saying "No more matches :("
            notFound.setVisibility(View.VISIBLE);
            //hide other buttons and textviews
            yesOrNoButton.setVisibility(View.GONE);
            friendsRequestButton.setVisibility(View.GONE);
            friendsButton.setVisibility(View.GONE);
            profileButton.setVisibility(View.GONE);
            settingsButton.setVisibility(View.GONE);
            otherProfileButton.setVisibility(View.GONE);
            yesButton.setVisibility(View.GONE);
            noButton.setVisibility(View.GONE);
        }
        else {
            MyApplication.setUserToDisplay(MyApplication.getOtherUserYon());
            //TODO: display photo and name of otherUserYon
            nameView.setText(MyApplication.getOtherUserYon().getFirstNameStr());

            otherProfileButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), YoNProfileActivity.class);
                    startActivity(intent);
                }
            });
            yesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO: sendFriendRequest
                    MyApplication.setPositionInMatchingUsers(MyApplication.getPositionInMatchingUsers() + 1);
                    Intent intent = new Intent(v.getContext(), YesOrNoActivity.class);
                    startActivity(intent);    }
            });
            noButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MyApplication.setPositionInMatchingUsers(MyApplication.getPositionInMatchingUsers() + 1);
                    Intent intent = new Intent(v.getContext(), YesOrNoActivity.class);
                    startActivity(intent);
                }
            });
        }

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
