package lsinf1225.uclove;

import android.content.Context;

import java.util.ArrayList;
/**
 *
 *
 * @author: Groupe P
 * @version: 25.04.2016
 */
public class User
{
    private String passwordStr;
    private String loginStr, firstNameStr, nameStr, placeStr, birthdayStr, languageStr,
            hairStr, eyesStr, descriptionStr, genderStr, orientationStr;
    private Friends friends;

    boolean[] hair;
    boolean[] eyes;
    boolean samePlace;
    int ageMin, ageMax;
    /**
     * Constructor for objects of class User
     */
    public User(String passwordStr, String loginStr, String  firstNameStr,
                String  nameStr, String  placeStr, String birthdayStr, String languageStr,
                String hairStr, String  eyesStr, String descriptionStr, String genderStr, String  orientationStr, boolean[] hair, boolean[] eyes, boolean samePlace,
                int ageMin, int ageMax, Context context)//constructeur pour un tout nouvel utilisateur
    {
        this.passwordStr = passwordStr;
        this.loginStr = loginStr;
        this.firstNameStr = firstNameStr;
        this.nameStr = nameStr;
        this.placeStr = placeStr;
        this.birthdayStr = birthdayStr;
        this.languageStr = languageStr;
        this.hairStr = hairStr;
        this.eyesStr = eyesStr;
        this.descriptionStr = descriptionStr;
        this.genderStr = genderStr;
        this.orientationStr = orientationStr;
        this.friends = new Friends(this.loginStr, true, context);
        this.hair = hair;
        this.eyes = eyes;
        this.samePlace = samePlace;
        this.ageMin = ageMin;
        this.ageMax = ageMax;
        UserManager uM = new UserManager(context);
        uM.open();
        uM.addUser(this);
        uM.close();
    }

    public User(){
    }
    public User(String loginStr, Context context) { //in order to load an User from the database
        this.loginStr = loginStr;
        UserManager uM = new UserManager(context);
        uM.open();
        if(uM.loadUserStr(this));
        else{System.err.println("coundnt laod a user");}
        uM.close();
        this.friends = new Friends(this.loginStr, false, context);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User))
        {return false;}
        User user = (User) o;
        if (user.loginStr == this.loginStr){
        return true;}
        return false;
    }
    public void updateDatabase(Context context){
        UserManager uM = new UserManager(context);
        uM.open();
        uM.modUser(this);
        uM.close();
    }
    public void setHair(boolean[] hair) {
        this.hair = hair;
    }

    public void setEyes(boolean[] eyes) {
        this.eyes = eyes;
    }

    public void setSamePlace(boolean samePlace) {
        this.samePlace = samePlace;
    }

    public void setAgeMin(int ageMin) {
        this.ageMin = ageMin;
    }

    public void setAgeMax(int ageMax) {
        this.ageMax = ageMax;
    }

    public void setFriends(Friends friends) {
        this.friends = friends;
    }

    public boolean[] getHair() {
        return hair;
    }

    public boolean[] getEyes() {
        return eyes;
    }

    public boolean getSamePlace() {
        return samePlace;
    }

    public int getAgeMin() {
        return ageMin;
    }

    public int getAgeMax() {
        return ageMax;
    }

    public static boolean isLoginAvailable(String username){
        return true;
    }

    public String getLoginStr(){
        return loginStr;
    }

    public void setLoginStr(String loginStr){
        this.loginStr = loginStr;
    }
    public String getPasswordStr(){
        return passwordStr;
    }

    public void setPasswordStr(String passwordStr){
        this.passwordStr = passwordStr;
    }

    public String getFirstNameStr() {
        return firstNameStr;
    }

    public void setFirstNameStr(String firstNameStr) {
        this.firstNameStr = firstNameStr;
    }

    public String getNameStr() {
        return nameStr;
    }

    public void setNameStr(String nameStr) {
        this.nameStr = nameStr;
    }

    public String getPlaceStr() {
        return placeStr;
    }

    public void setPlaceStr(String placeStr) {
        this.placeStr = placeStr;
    }

    public String getBirthdayStr() {
        return birthdayStr;
    }

    public void setBirthdayStr(String birthdayStr) {
        this.birthdayStr = birthdayStr;
    }

    public String getLanguageStr() {
        return languageStr;
    }

    public void setLanguageStr(String languageStr) {
        this.languageStr = languageStr;
    }

    public String getHairStr() {
        return hairStr;
    }

    public void setHairStr(String hairStr) {
        this.hairStr = hairStr;
    }

    public String getEyesStr() {
        return eyesStr;
    }

    public void setEyesStr(String eyesStr) {
        this.eyesStr = eyesStr;
    }

    public String getDescriptionStr() {
        return descriptionStr;
    }

    public void setDescriptionStr(String descriptionStr) {
        this.descriptionStr = descriptionStr;

    }

    public String getGenderStr() {
        return genderStr;
    }

    public void setGenderStr(String genderStr) {
        this.genderStr = genderStr;

    }

    public String getOrientationStr() {
        return orientationStr;
    }

    public void setOrientationStr(String orientationStr) {
        this.orientationStr = orientationStr;

    }

    public Friends getFriends() {
        return friends;
    }

}
