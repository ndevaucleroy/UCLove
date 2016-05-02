package lsinf1225.uclove;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.SharedPreferences;
import android.database.Cursor;

public class DatabaseHandler extends SQLiteOpenHelper {

    //SQLite Name, Version, instance
    private static final String DATABASE_NAME = "db.sqlite";
    private static final int DATABASE_VERSION = 1;
    private static DatabaseHandler sInstance;
   
   //Drop Table
    public static final String PERSON_TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_PERSON + ";";
    public static final String SCORE_TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_SCORE + ";";
    public static final String ALBUM_TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_ALBUM + ";";
    public static final String FRIENDSHIP_TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_FRIENDSHIP + ";";
    public static final String RENDEZVOUS_TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_RENDEZVOUS + ";";
    public static final String AVAILABILITY_TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_AVAILABILITY + ";";

    public static synchronized DatabaseHandler getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DatabaseHandler(context); }
        return sInstance;
    }

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserManager.PERSON_TABLE_CREATE);
        db.execSQL(ScoreManager.SCORE_TABLE_CREATE);
        db.execSQL(AlbumManager.ALBUM_TABLE_CREATE);
        db.execSQL(FriendshipManager.FRIENDSHIP_TABLE_CREATE);
        db.execSQL(RendezVousManager.RENDEZVOUS_TABLE_CREATE);
        db.execSQL(AvailabiltyManager.AVAILABILITY_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(PERSON_TABLE_DROP);
        db.execSQL(SCORE_TABLE_DROP);
        db.execSQL(ALBUM_TABLE_DROP);
        db.execSQL(FRIENDSHIP_TABLE_DROP);
        db.execSQL(RENDEZVOUS_TABLE_DROP);
        db.execSQL(AVAILABILITY_TABLE_DROP);
        onCreate(db);
    }

}
