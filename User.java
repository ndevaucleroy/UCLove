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
    public String userID;
    protected String password;
    private ArrayList friendsList;
    private Profile profile;

    /**
     * Constructor for objects of class User
     */
    public User(String userID, String password, ArrayList friendsList, Profile profile)
    {
        this.userID=userID;
        this.password = password;
        this.friendsList = friendsList;
        this.profile = profile;
    }

    public User(){
    }

    public static boolean isLoginAvailable(String username){
        return true;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public ArrayList getFriendsList() { return friendsList;}

    public void setFriendList(ArrayList friendsList) {
        this.friendsList = friendsList;
    }
}
