package lsinf1225.uclove;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.SharedPreferences;
import android.database.Cursor;

public class DatabaseHandler extends SQLiteOpenHelper {

    //DataBase name
    public static final String TABLE_PERSON = "person";
    public static final String TABLE_SCORE="score";
    public static final String TABLE_ALBUM="album";
    public static final String TABLE_FRIENDSHIP="friendship";
    public static final String TABLE_RENDEZVOUS="rendezvous";
    public static final String TABLE_AVAILABILITY="availability";

    //Key name
        //Key Person Name
    public static final String PERSON_FIRST_NAME = "firstName";
    public static final String PERSON_NAME = "name";
    public static final String PERSON_LOGIN="login";
    public static final String PERSON_PLACE="place";
    public static final String PERSON_BIRTHDAY="birthday";
    public static final String PERSON_LANGUAGE="language";
    public static final String PERSON_HAIR="hair";
    public static final String PERSON_EYES="eyes";
    public static final String PERSON_PASSWORD="password";
    public static final String PERSON_DESCRIPTION="description";
    public static final String PERSON_GENDER="gender";
    public static final String PERSON_ORIENTATION="orientation";
    public static final String PERSON_TABLE_NAME = "person";
        //Key Score Name
    public static final String SCORE_LOGINGET="loginGet";
    public static final String SCORE_LOGINGIVE="loginGive";
    public static final String SCORE_QUOTATION="quotation";
        //Key Album Name
    public static final String ALBUM_LOGIN="login";
    public static final String ALBUM_PICTURE="picture";
        //Key Friendship Name
    public static final String FRIENDSHIP_LOGIN1="login1";
    public static final String FRIENDSHIP_LOGIN2="login2";
    public static final String FRIENDSHIP_CHAT="chat";
        //Key RendezVous Name
    public static final String RENDEZVOUS_LOGIN1="login1";
    public static final String RENDEZVOUS_LOGIN2="login2";
    public static final String RENDEZVOUS_MEETING="meeting";
        //Key Availability Name
    public static final String AVAILABILITY_LOGIN="login";
    public static final String AVAILABILITY_DATE="date";

    //Drop Table
    public static final String PERSON_TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_PERSON + ";";
    public static final String SCORE_TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_SCORE + ";";
    public static final String ALBUM_TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_ALBUM + ";";
    public static final String FRIENDSHIP_TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_FRIENDSHIP + ";";
    public static final String RENDEZVOUS_TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_RENDEZVOUS+ ";";
    public static final String AVAILABILITY_TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_AVAILABILITY + ";";

    //Create Table
        //Person
    public static final String PERSON_TABLE_CREATE =
            "CREATE TABLE " + TABLE_PERSON + " ("+
                    PERSON_LOGIN+" TEXT PRIMARY KEY, " +
                    PERSON_PLACE+" TEXT not nul, "+
                    PERSON_FIRST_NAME +" TEXT not null, " +
                    PERSON_NAME+" TEXT not null, "+
                    PERSON_BIRTHDAY+" TEXT not null, "+
                    PERSON_LANGUAGE+" TEXT not null, "+
                    PERSON_HAIR+" TEXT not null, "+
                    PERSON_EYES+" TEXT not null, "+
                    PERSON_PASSWORD+" TEXT not null, "+
                    PERSON_DESCRIPTION+" TEXT not null, "+
                    PERSON_GENDER+" TEXT not null, "+
                    PERSON_ORIENTATION+" TEXT not null);";
        //Score
    public static final String SCORE_TABLE_CREATE =
            "CREATE TABLE "+ TABLE_SCORE+" ("+
                    SCORE_LOGINGIVE+" TEXT not null references "+TABLE_PERSON+", "+
                    SCORE_LOGINGET+" TEXT not null references "+TABLE_PERSON+", "+
                    SCORE_QUOTATION+" INTEGER not null, PRIMARY KEY ("+
                    SCORE_LOGINGIVE+", "+SCORE_LOGINGET+"));";
            //Album
    public static final String ALBUM_TABLE_CREATE =
            "CREATE TABLE "+TABLE_ALBUM+" ("+
                    ALBUM_LOGIN+" TEXT not null references "+TABLE_PERSON+", "+
                    ALBUM_PICTURE+" TEXT not null, PRIMARY KEY("+
                    ALBUM_LOGIN+", "+ALBUM_PICTURE+"));";
            //Friendship
    public static final String FRIENDSHIP_TABLE_CREATE=
                "CREATE TABLE "+TABLE_FRIENDSHIP+" ("+
                        FRIENDSHIP_LOGIN1+" TEXT not null references "+TABLE_PERSON+", "+
                        FRIENDSHIP_LOGIN2+" TEXT not null references "+TABLE_PERSON+", "+
                        FRIENDSHIP_CHAT+" TEXT, PRIMARY KEY ("+
                        FRIENDSHIP_LOGIN1+", "+FRIENDSHIP_LOGIN2+"));";
            //Rendezvous
    public static final String RENDEZVOUS_TABLE_CREATE=
                    "CREATE TABLE "+TABLE_RENDEZVOUS+" ("+
                            RENDEZVOUS_LOGIN1+" TEXT not null references"+TABLE_PERSON+", "+
                            RENDEZVOUS_LOGIN2+" TEXT not null references"+TABLE_PERSON+", "+
                            RENDEZVOUS_MEETING+" TEXT not null, PRIMARY KEY"+
                            RENDEZVOUS_LOGIN1+", "+RENDEZVOUS_LOGIN2+"), FOREIGN KEY("+
                            RENDEZVOUS_LOGIN1+", "+RENDEZVOUS_MEETING+") references "+TABLE_AVAILABILITY+", FOREIGN KEY("+
                            RENDEZVOUS_LOGIN2+", "+RENDEZVOUS_MEETING+") references "+TABLE_AVAILABILITY+");";
            //Availability
    public static final String AVAILABILITY_TABLE_CREATE=
                    "CREATE TABLE "+TABLE_AVAILABILITY+" ("+
                            AVAILABILITY_LOGIN+" TEXT not null references"+TABLE_PERSON+", "+
                            AVAILABILITY_DATE+" TEXT not null, PRIMARY KEY ("+
                            AVAILABILITY_LOGIN+", "+AVAILABILITY_DATE+"));";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PERSON_TABLE_CREATE);
        db.execSQL(SCORE_TABLE_CREATE);
        db.execSQL(ALBUM_TABLE_CREATE);
        db.execSQL(FRIENDSHIP_TABLE_CREATE);
        db.execSQL(RENDEZVOUS_TABLE_CREATE);
        db.execSQL(AVAILABILITY_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(PERSON_TABLE_DROP);
        db.execSQL(SCORE_TABLE_DROP);
        db.execSQL(AVAILABILITY_TABLE_DROP);
        db.execSQL(FRIENDSHIP_TABLE_DROP);
        db.execSQL(RENDEZVOUS_TABLE_DROP);
        db.execSQL(AVAILABILITY_TABLE_DROP);
        onCreate(db);
    }

    /*public static void createUser(User user){
        
    }*/

}
