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
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class ListOfChatsActivity extends AppCompatActivity {

    private static int i;
    private static ArrayList<User> listOfFriends;
    private ImageButton yesOrNoButton, friendsRequestButton, friendsButton, profileButton, settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_chats);

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
                Toast.makeText(ListOfChatsActivity.this, "Refreshing...", Toast.LENGTH_SHORT).show();
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
        ///////////////////FIN BOUTONS DE MENU//////////////////////

        listOfFriends = MyApplication.getUser().getFriends().getFriendsUsr(this);

        final LinearLayout ll = (LinearLayout) findViewById(R.id.listoffriends);

        for(i = 0 ; i<listOfFriends.size(); i++){
            try{
                LinearLayout wid = new LinearLayout(ListOfChatsActivity.this);
                wid.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

                Button btn = new Button(ListOfChatsActivity.this);
                LinearLayout.LayoutParams layoutparam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                layoutparam.setMargins(10, 5, 10, 5);
                btn.setLayoutParams(layoutparam);
                btn.setText("Chat with " + listOfFriends.get(i).getFirstNameStr() + listOfFriends.get(i).getNameStr() + "!");
                btn.setBackgroundColor(0xffe36899);
                btn.setId(i);

                wid.addView(btn);
                ll.addView(wid);

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MyApplication.setUserToDisplay(listOfFriends.get(v.getId()));
                        Intent intent = new Intent(v.getContext(), DiscussionActivity.class);
                        startActivity(intent);
                    }
                });
            }
            catch(IndexOutOfBoundsException e){
                break;
            }
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
