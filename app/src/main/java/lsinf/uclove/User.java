package lsinf1225.uclove;

import java.util.ArrayList;
/**
 *
 *
 * @author: Groupe P 
 * @version: 25.04.2016
 */
public class User
{
    private String password;
    private String loginStr, firstNameStr, nameStr, placeStr, birthdayStr, languageStr,
            hairStr, eyesStr, descriptionStr, genderStr, orientationStr;
    private Friends friends;

    /**
     * Constructor for objects of class User
     */
    public User(String password, String loginStr, String  firstNameStr,
                String  nameStr, String  placeStr, String birthdayStr, String languageStr,
                String hairStr, String  eyesStr, String descriptionStr, String genderStr, String  orientationStr)
    {
        this.password = password;
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
        this.friends = new Friends(this.loginStr, true);
        DatabaseHandler.createUser(this);
    }

    public User(){
    }
    public User(String loginStr) {
        this.loginStr = loginStr;
        this.password = DatabaseHandler.getPassword(loginStr);
        this.firstNameStr = DatabaseHandler.getFisrtNameStr(loginStr);
        this.nameStr = DatabaseHandler.getNameStr(loginStr);
        this.placeStr = DatabaseHandler.getPlaceStr(loginStr);
        this.birthdayStr = DatabaseHandler.getBirthdayStr(loginStr);
        this.languageStr = DatabaseHandler.getLanguageStr(loginStr);
        this.hairStr = DatabaseHandler.getHairStr(loginStr);
        this.eyesStr = DatabaseHandler.getEyesStr(loginStr);
        this.descriptionStr = DatabaseHandler.getDescriptionStr(loginStr);
        this.genderStr = DatabaseHandler.getGenderStr(loginStr);
        this.orientationStr = DatabaseHandler.getOrientation(loginStr);
        this.friends = new Friends(loginStr, false);
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
    
    public void setPasswordStr(String password){
        this.password = password;
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
