package lsinf1225.uclove;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Write a description of class Friends here.
 *
 * @author Groupe P
 * @version 25.04.2016
 */
public class Friends
{
    // instance variables
    private String listOwnerStr;
    private ArrayList<String> friendsListStr;
    private ArrayList<String> recFriendsRequestsStr;
    private ArrayList<String> sentFriendsRequestsStr;
    //private User[] friendsListUsr;  //on veut qu'il se delete des qu'on l'utilise plus, car des users ca prend de la mémoire
    /*private Chat friendChat;*/

    /**
     * Constructor for objects of class Friends
     */

    public Friends(String listOwnerStr, boolean alreadyCreated, Context context){
        if(alreadyCreated){
            this.listOwnerStr = listOwnerStr;
            this.friendsListStr = null;
            this.recFriendsRequestsStr = null;
            this.recFriendsRequestsStr = null;
        }
        else{
            FriendshipManager fM = new FriendshipManager(context);
            fM.open();
            this.listOwnerStr = listOwnerStr;
            this.friendsListStr= fM.getFriendsStr(listOwnerStr);
            this.recFriendsRequestsStr= new ArrayList<String>(Arrays.asList(DatabaseHandler.getRecFriendsRequests(listOwnerStr)));
            this.sentFriendsRequestsStr = new ArrayList<String>(Arrays.asList(DatabaseHandler.getRecFriendsRequests(listOwnerStr)));
            fM.close();
        }

    }
    public Friends(){}

    public boolean sendFriendRequest(String target, Context context){ //sends true if worked, sends false if it was already a friend
        if(sentFriendsRequestsStr.contains(target)){
            return false;
        }
        sentFriendsRequestsStr.add(target);
        FriendshipManager fM = new FriendshipManager(context);
        fM.open();
        fM.addFriendship(new Friendship(listOwnerStr, target, null));
        fM.close();
        return true;
    }
    public void acceptFriendRequest(String target, Context context){
        recFriendsRequestsStr.remove(target);
        friendsListStr.add(target);
        FriendshipManager fM = new FriendshipManager(context);
        fM.open();
        fM.modFriendship(new Friendship(listOwnerStr, target, "b;" + listOwnerStr + "c;" + "Ur my niuuu frieeeeeeend, lets fuck" + "d;"));
        fM.close();

    }
    public void refuseFriendRequest(String target, Context context){
        recFriendsRequestsStr.remove(target);
        FriendshipManager fM = new FriendshipManager(context);
        fM.open();
        if(fM.supFriendship(new Friendship(listOwnerStr, target, "")) == 0){
            System.err.println("error sql delete request");
        }
        fM.close();
    }
    public void deleteFriend(String target, Context context){
        friendsListStr.remove(target);
        FriendshipManager fM = new FriendshipManager(context);
        fM.open();
        if(fM.supFriendship(new Friendship(listOwnerStr, target, "")) == 0){
            fM.supFriendship(new Friendship(target, listOwnerStr, ""));
        }
        fM.close();
    }
    public String getListOwnerStr() {
        return listOwnerStr;
    }

    public String[] getFriendsListStr() {
        return (String[])friendsListStr.toArray();
    }

    public String[] getRecFriendsRequestsStr() {
        return (String[])recFriendsRequestsStr.toArray();
    }

    public String[] getSentFriendsRequestsStr() {
        return (String[])sentFriendsRequestsStr.toArray();
    }

    public User[] getFriendsListUsr() { //on load les users
        User []friendsListUsr = new User[friendsListStr.size()];
        for(int i = 0;i < friendsListStr.size();i++){
            friendsListUsr[i] = new User(friendsListStr.get(i));
        }
        return friendsListUsr;
    }

    public ArrayList<User> getFriendsUsr(Context context) {
        UserManager uM = new UserManager(context);
        ArrayList<User> FrUsr = new ArrayList();
        for(int i = 0;i<friendsListStr.size();i++) {
            FrUsr.add(i,uM.getUserStr(friendsListStr.get(i)));
        }
        return FrUsr;
    }

    public ArrayList<User> getSentFriendsRequestsUsr(Context context) {
        UserManager uM = new UserManager(context);
        ArrayList<User> sentFrReqUsr = new ArrayList();
        for(int i = 0;i<sentFriendsRequestsStr.size();i++) {
            sentFrReqUsr.add(i,uM.getUserStr(sentFriendsRequestsStr.get(i)));
        }
        return sentFrReqUsr;
    }

    public ArrayList<User> getRecFriendsRequestsUsr(Context context) {
        UserManager uM = new UserManager(context);
        ArrayList<User> recFrReqUsr = new ArrayList();
        for(int i = 0;i<recFriendsRequestsStr.size();i++) {
            recFrReqUsr.add(i,uM.getUserStr(recFriendsRequestsStr.get(i)));
        }
        return recFrReqUsr;
    }

}

    
