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
import java.util.Arrays;
import java.util.List;

public class ProfileSettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private ImageButton yesOrNoButton, friendsRequestButton, friendsButton, profileButton, settingsButton;
    private ImageButton saveNameButton, saveFirstNameButton, savePlaceButton,
        saveBirthButton;
    private EditText nameView, firstNameView, placeView;
    private String day, month, year;

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

        day= "1";
        month = "January";
        year="1998";

        saveNameButton = (ImageButton) findViewById(R.id.confirm1);
        saveFirstNameButton = (ImageButton) findViewById(R.id.confirm2);
        savePlaceButton = (ImageButton) findViewById(R.id.confirm4);
        saveBirthButton = (ImageButton) findViewById(R.id.confirm5);

        nameView = (EditText) findViewById(R.id.editName);
        firstNameView = (EditText) findViewById(R.id.editFirstName);
        placeView = (EditText) findViewById(R.id.editPlace);

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


        Spinner spinner = (Spinner) findViewById(R.id.editOrientation);
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

        Spinner hspinner = (Spinner) findViewById(R.id.setHair);
        hspinner.setOnItemSelectedListener(this);
        List<String> hcategories = new ArrayList<String>();
        hcategories.add("Black");
        hcategories.add("Blond");
        hcategories.add("Brown");
        hcategories.add("Red");
        hcategories.add("Other");
        ArrayAdapter<String> hdataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, hcategories);
        hdataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hspinner.setAdapter(hdataAdapter);
        if(MyApplication.getUser().getHairStr().equals("blond"))
            hspinner.setSelection(2);
        if(MyApplication.getUser().getHairStr().equals("brown"))
            hspinner.setSelection(3);
        if(MyApplication.getUser().getHairStr().equals("red"))
            hspinner.setSelection(4);
        if(MyApplication.getUser().getHairStr().equals("red"))
            hspinner.setSelection(5);

        Spinner espinner = (Spinner) findViewById(R.id.editEyes);
        espinner.setOnItemSelectedListener(this);
        List<String> ecategories = new ArrayList<String>();
        ecategories.add("Black");
        ecategories.add("Blue");
        ecategories.add("Brown");
        ecategories.add("Green");
        ArrayAdapter<String> edataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ecategories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        espinner.setAdapter(edataAdapter);
        if(MyApplication.getUser().getHairStr().equals("blue"))
            espinner.setSelection(2);
        if(MyApplication.getUser().getHairStr().equals("brown"))
            espinner.setSelection(3);
        if(MyApplication.getUser().getHairStr().equals("green"))
            espinner.setSelection(4);

        Spinner bdspinner = (Spinner) findViewById(R.id.xday);
        bdspinner.setOnItemSelectedListener(this);
        for(int i=1; i<10;i++){
            if(MyApplication.getUser().birthDay().equals("0"+Integer.toString(i)))
                bdspinner.setSelection(i);
        }
        for(int i=10; i<=31;i++){
            if(MyApplication.getUser().birthDay().equals(Integer.toString(i)))
                bdspinner.setSelection(i);
        }


        Spinner bmspinner = (Spinner) findViewById(R.id.xmonth);
        bmspinner.setOnItemSelectedListener(this);
        for(int i=1; i<10;i++){
            if(MyApplication.getUser().birthMonth().equals("0"+Integer.toString(i)))
                bmspinner.setSelection(i);
        }
        for(int i=10; i<=12;i++){
            if(MyApplication.getUser().birthMonth().equals(Integer.toString(i)))
                bmspinner.setSelection(i);
        }

        Spinner byspinner = (Spinner) findViewById(R.id.xyear);
        byspinner.setOnItemSelectedListener(this);
        for(int i=0; i<=68;i++){
            if(MyApplication.getUser().birthYear().equals(Integer.toString(1930 + i)))
                byspinner.setSelection(i+1);
        }

        saveBirthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyApplication.getUser().setBirthdayStr(year+"-"+User.monthToInt(month)+"-"+day);
            }
        });
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

    private void changeName(String change){
        MyApplication.getUser().setNameStr(change);
    }
    private void changeFirstName(String change){
        MyApplication.getUser().setFirstNameStr(change);
    }
    private void changePlace(String change){
        MyApplication.getUser().setPlaceStr(change);
    }

    private void sendError(EditText field, String message) {
        field.setError(message);
        field.requestFocus();
    }
    private void setErrorsToNull() {
        nameView.setError(null);
        firstNameView.setError(null);
        placeView.setError(null);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // On selecting a spinner item
        switch(parent.getId()){
            case R.id.editOrientation :
                setOrientation(parent, view, pos, id);
                break;
            case R.id.editHair :
                setHair(parent, view, pos, id);
                break;
            case R.id.editEyes :
                setEyes(parent, view, pos, id);
                break;
            case R.id.xday:
                day = parent.getSelectedItem().toString();
                break;
            case R.id.xmonth:
                month=parent.getSelectedItem().toString();
                break;
            case R.id.xyear:
                year= parent.getSelectedItem().toString();
                break;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
    public void setOrientation(AdapterView<?> parent, View view, int pos, long id){
        switch(pos){
            case 1 :
                MyApplication.getUser().setOrientationStr("M");
                break;
            case 2 :
                MyApplication.getUser().setOrientationStr("F");
                break;
            case 3 :
                MyApplication.getUser().setOrientationStr("B");
                break;
        }
    }
    public void setHair(AdapterView<?> parent, View view, int pos, long id){
        switch(pos){
            case 1 :
                MyApplication.getUser().setHairStr("black");
                break;
            case 2 :
                MyApplication.getUser().setHairStr("blond");
                break;
            case 3 :
                MyApplication.getUser().setHairStr("brown");
                break;
            case 4 :
                MyApplication.getUser().setHairStr("red");
                break;
            case 5 :
                MyApplication.getUser().setHairStr("other");
                break;
        }
    }
    public void setEyes(AdapterView<?> parent, View view, int pos, long id){
        switch (pos){
            case 1 :
                MyApplication.getUser().setEyesStr("black");
                break;
            case 2 :
                MyApplication.getUser().setEyesStr("blue");
                break;
            case 3 :
                MyApplication.getUser().setEyesStr("brown");
                break;
            case 4 :
                MyApplication.getUser().setEyesStr("green");
                break;
        }
    }

}
