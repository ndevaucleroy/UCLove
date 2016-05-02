package lsinf1225.uclove;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StartupActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Button proceedButton;
    private EditText nameView, firstNameView, placeView;
    private String day, month, year;
    private String strName, strFirstName, strPlace, strOrientation, strHair, strEyes,
            strGender;
    private static final String VALID_NAME = "[a-zA-Z0-9_-]{3,15}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
        day= "1";
        month = "January";
        year="1998";
        proceedButton =(Button) findViewById(R.id.proceed);
        nameView = (EditText) findViewById(R.id.seditName);
        firstNameView = (EditText) findViewById(R.id.seditFirstName);
        placeView = (EditText) findViewById(R.id.seditPlace);

        //Spinners
        Spinner ospinner = (Spinner) findViewById(R.id.setOrientation);
        ospinner.setOnItemSelectedListener(this);
        List<String> ocategories = new ArrayList<String>();
        ocategories.add("Men");
        ocategories.add("Women");
        ocategories.add("Men and women");
        ArrayAdapter<String> odataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ocategories);
        odataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ospinner.setAdapter(odataAdapter);

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

        Spinner espinner = (Spinner) findViewById(R.id.setEyes);
        espinner.setOnItemSelectedListener(this);
        List<String> ecategories = new ArrayList<String>();
        ecategories.add("Black");
        ecategories.add("Blue");
        ecategories.add("Brown");
        ecategories.add("Green");
        ArrayAdapter<String> edataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ecategories);
        edataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        espinner.setAdapter(edataAdapter);

        Spinner gspinner = (Spinner) findViewById(R.id.setGender);
        gspinner.setOnItemSelectedListener(this);
        List<String> gcategories = new ArrayList<String>();
        gcategories.add("M");
        gcategories.add("F");
        ArrayAdapter<String> gdataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gcategories);
        gdataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gspinner.setAdapter(gdataAdapter);

        Spinner bdspinner = (Spinner) findViewById(R.id.bday);
        bdspinner.setOnItemSelectedListener(this);
        Spinner bmspinner = (Spinner) findViewById(R.id.bmonth);
        bmspinner.setOnItemSelectedListener(this);
        Spinner byspinner = (Spinner) findViewById(R.id.byear);
        byspinner.setOnItemSelectedListener(this);

        //end spinners

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trySave();
            }
        });
    }

    public void trySave(){
        strName = nameView.getText().toString();
        strFirstName = firstNameView.getText().toString();
        strPlace = placeView.getText().toString();
        if (TextUtils.isEmpty(strName)) {
            sendError(nameView, "Error field required: please fill all the fields");
            return;
        }
        if (TextUtils.isEmpty(strFirstName)) {
            sendError(firstNameView, "Error field required: please fill all the fields");
            return;
        }
        if (TextUtils.isEmpty(strPlace)) {
            sendError(placeView, "Error field required: please fill all the fields");
            return;
        }
        save();
    }

    public void save(){
        MyApplication.getUser().setNameStr(strName);
        MyApplication.getUser().setFirstNameStr(strFirstName);
        MyApplication.getUser().setPlaceStr(strPlace);
        MyApplication.getUser().setOrientationStr(strOrientation);
        MyApplication.getUser().setEyesStr(strEyes);
        MyApplication.getUser().setHairStr(strHair);
        MyApplication.getUser().setGenderStr(strGender);
        MyApplication.getUser().setBirthdayStr(year + "-" + User.monthToInt(month) + "-" + day);
        Intent intent = new Intent(this, ResearchSettingsActivity.class);
        Toast.makeText(StartupActivity.this, "Redirection...", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // On selecting a spinner item
        switch(parent.getId()){
            case R.id.setOrientation :
                setOrientation(parent, view, pos, id);
                break;
            case R.id.setHair :
                setHair(parent, view, pos, id);
                break;
            case R.id.setEyes :
                setEyes(parent, view, pos, id);
                break;
            case R.id.setGender :
                setGender(parent, view, pos, id);
                break;
            case R.id.bday:
                day = parent.getSelectedItem().toString();;
                break;
            case R.id.bmonth:
                month=parent.getSelectedItem().toString();;
                break;
            case R.id.byear:
                year= parent.getSelectedItem().toString();;
                break;
        }
    }
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
    public void setOrientation(AdapterView<?> parent, View view, int pos, long id){
        switch(pos){
            case 1 :
                strOrientation = "M";
                break;
            case 2 :
                strOrientation = "F";
                break;
            case 3 :
                strOrientation = "B";
                break;
        }
    }
    public void setHair(AdapterView<?> parent, View view, int pos, long id){
        switch(pos){
            case 1 :
                strHair = "black";
                break;
            case 2 :
                strHair = "blond";
                break;
            case 3 :
                strHair = "brown";
                break;
            case 4 :
                strHair = "red";
                break;
            case 5 :
                strHair = "other";
                break;
        }
    }
    public void setEyes(AdapterView<?> parent, View view, int pos, long id){
        switch (pos){
            case 1 :
                strEyes = "black";
                break;
            case 2 :
                strEyes = "blue";
                break;
            case 3 :
                strEyes = "brown";
                break;
            case 4 :
                strEyes = "green";
                break;
        }
    }
    public void setGender(AdapterView<?> parent, View view, int pos, long id){
        switch(pos){
            case 1 :
                strGender = "M";
                break;
            case 2 :
                strGender = "M";
                break;
        }
    }

    private boolean isValid(String username) {
        return Pattern.compile("^" + VALID_NAME + "{3,20}$").matcher(username).matches();
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
}
