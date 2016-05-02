package lsinf1225.uclove;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ProfileSettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private ImageButton yesOrNoButton, friendsRequestButton, friendsButton, profileButton, settingsButton;
    private ImageButton saveNameButton, saveFirstNameButton, savePlaceButton,
        saveBirthButton, saveEyesButton, saveHairButton;
    private EditText nameView, firstNameView, orientationView, placeView, birthdayView, eyesView, hairView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_settings);


        //////////////////BOUTONS DE MENU///////////////////////

        yesOrNoButton = (ImageButton) findViewById(R.id.YesOrNo);
        friendsRequestButton = (ImageButton) findViewById(R.id.FriendsRequests);
        friendsButton = (ImageButton) findViewById(R.id.Friends);
        profileButton = (ImageButton) findViewById(R.id.Profile);
        settingsButton = (ImageButton) findViewById(R.id.Settings);

        yesOrNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), YesOrNoActivity.class);
                startActivity(intent);
            }
        });
        friendsRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FriendsRequestActivity.class);
                startActivity(intent);
            }
        });
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

        /////////////////FIN BOUTONS DE MENU//////////////////////

        saveNameButton = (ImageButton) findViewById(R.id.confirm1);
        saveFirstNameButton = (ImageButton) findViewById(R.id.confirm2);
        savePlaceButton = (ImageButton) findViewById(R.id.confirm4);
        saveBirthButton = (ImageButton) findViewById(R.id.confirm5);
        saveEyesButton = (ImageButton) findViewById(R.id.confirm6);
        saveHairButton = (ImageButton) findViewById(R.id.confirm7);

        nameView = (EditText) findViewById(R.id.editName);
        firstNameView = (EditText) findViewById(R.id.editName);
        placeView = (EditText) findViewById(R.id.editName);
        hairView = (EditText) findViewById(R.id.editName);
        eyesView = (EditText) findViewById(R.id.editName);
        birthdayView = (EditText) findViewById(R.id.editName);

        saveNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryChangeName(nameView.getText().toString());
            }
        });
        saveFirstNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryChangeFirstName(firstNameView.getText().toString());
            }
        });
        savePlaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryChangePlace(placeView.getText().toString());
            }
        });
        saveBirthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryChangeBirth(birthdayView.getText().toString());
            }
        });
        saveEyesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryChangeEyes(eyesView.getText().toString());
            }
        });
        saveHairButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryChangeHair(hairView.getText().toString());
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.languageSpinner);
        spinner.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("Hetero");
        categories.add("Homo");
        categories.add("Bi");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        if(MyApplication.getUser().getOrientationStr().equals("Homo"))
            spinner.setSelection(2);
        if(MyApplication.getUser().getOrientationStr().equals("Bi"))
            spinner.setSelection(3);


    }

    private void tryChangeName(String change){
        setErrorsToNull();
        if(change.equals(null)){
            sendError(nameView, "Error: no input");
            return;
        }
        changeName(change);
    }
    private void tryChangeFirstName(String change){
        setErrorsToNull();
        if(change.equals(null)){
            sendError(firstNameView, "Error: no input");
            return;
        }
        changeFirstName(change);
    }
    private void tryChangePlace(String change){
        setErrorsToNull();
        if(change.equals(null)){
            sendError(placeView, "Error: no input");
            return;
        }
        changePlace(change);
    }
    private void tryChangeHair(String change){
        setErrorsToNull();
        if(change.equals(null)){
            sendError(hairView, "Error: no input");
            return;
        }
        changeHair(change);
    }
    private void tryChangeEyes(String change){
        setErrorsToNull();
        if(change.equals(null)){
            sendError(eyesView, "Error: no input");
            return;
        }
        changeEyes(change);
    }
    private void tryChangeBirth(String change){
        setErrorsToNull();
        if(change.equals(null)){
            sendError(eyesView, "Error: no input");
            return;
        }
        changeBirth(change);
    }

    private void changeName(String change){
        MyApplication.getUser().setNameStr(change);
    }
    private void changeFirstName(String change){
        MyApplication.getUser().setFirstNameStr(change);
    }
    private void changePlace(String change){
        MyApplication.getUser().setPlaceStr(change);
    }
    private void changeHair(String change){
        MyApplication.getUser().setHairStr(change);
    }
    private void changeEyes(String change){
        MyApplication.getUser().setEyesStr(change);
    }
    private void changeBirth(String change){
        MyApplication.getUser().setBirthdayStr(change);
    }

    private void sendError(EditText field, String message) {
        field.setError(message);
        field.requestFocus();
    }
    private void setErrorsToNull() {
        nameView.setError(null);
        firstNameView.setError(null);
        placeView.setError(null);
        orientationView.setError(null);
        hairView.setError(null);
        eyesView.setError(null);
        birthdayView.setError(null);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(pos).toString();
        MyApplication.getUser().setOrientationStr(item);
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
