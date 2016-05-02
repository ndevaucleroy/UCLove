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
    private Favorite favoriteStr;
    /**
     * Constructor for objects of class User
     */
    public User(String passwordStr, String loginStr, String  firstNameStr,
                String  nameStr, String  placeStr, String birthdayStr, String languageStr,
                String hairStr, String  eyesStr, String descriptionStr, String genderStr, String  orientationStr, Favorite favoriteStr, Context context)//constructeur pour un tout nouvel utilisateur
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
        this.favorite=favorite;
        this.friends = new Friends(this.loginStr, true, context);
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
    

    public void setFriends(Friends friends) {
        this.friends = friends;
    }
    
    public void setFavorite(Favorite fav){
        this.favorite=fav;
    }

    public Favorite getFavorite(){
        return this.favorite;
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

    /**
     * Cree le string de la requete XML d'un user pour sa recherche par rapport a ses preferences.
     * @return string pour la requete XML par rapport a ses preferences
     */
    public String makePersonalRequest() {
        boolean[] hair=this.favorite.getHair();
        boolean[] eyes=.this.favorite.getEyes();
        boolean samePlace=this.favorite.getPlace();
        int ageMin=this.favorite.getMin();
        int ageMax=this.favorite.getMax();
        String request = "SELECT login FROM person WHERE " ;
        // Test de la couleur des cheveux.
        if(hair[0]) {
            request += "hair = 'black' and ";
        }
        if(hair[1]) {
            request += "hair = 'blond' and ";
        }
        if(hair[2]) {
            request += "hair = 'brown' and ";
        }
        if(hair[3]) {
            request += "hair = 'other' and ";
        }
        if(hair[4]) {
            request += "hair = 'red' and ";
        }
        // Test de la couleur des yeux.
        if(eyes[0]) {
            request += "eyes = 'black' and ";
        }
        if(eyes[1]) {
            request += "eyes = 'blue' and ";
        }
        if(eyes[2]) {
            request += "eyes = 'brown' and ";
        }
        if(eyes[3]) {
            request += "eyes = 'green' and ";
        }
        // Test de la même localite
        if(samePlace) {
            request = request + "place = " + this.placeStr + " and ";
        }

        // Test de l'age
        request = request + "" + this.ageMin + " < ((JulianDay('now')) - (julianday(birthday))/365,25) < " + this.ageMax;
        // Test du genre et de la sexualite
        char sexe = (this.genderStr).charAt(0);
        char pref = (this.orientationStr).charAt(0);//Homme, Femme ou Bi
        if(pref != 'B') {
            request += "gender = '" + pref + "' and ";
        }
        request += "(orientation = 'B' or orientation = '" + sexe + "')";

        return request;
    }

}
