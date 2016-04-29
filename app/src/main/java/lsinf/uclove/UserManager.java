package lsinf1225.uclove;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


/**
 * Created by cariamole on 29.04.16.
 */
public class UserManager {
    //Nom Table Person
    public static final String TABLE_PERSON = "person";
    //Key Person
    public static final String PERSON_FIRST_NAME = "firstName";
    public static final String PERSON_NAME = "name";
    public static final String PERSON_LOGIN = "login";
    public static final String PERSON_PLACE = "place";
    public static final String PERSON_BIRTHDAY = "birthday";
    public static final String PERSON_LANGUAGE = "language";
    public static final String PERSON_HAIR = "hair";
    public static final String PERSON_EYES = "eyes";
    public static final String PERSON_PASSWORD = "password";
    public static final String PERSON_DESCRIPTION = "description";
    public static final String PERSON_GENDER = "gender";
    public static final String PERSON_ORIENTATION = "orientation";
    //Create
    public static final String PERSON_TABLE_CREATE =
            "CREATE TABLE " + TABLE_PERSON + " (" +
                    PERSON_LOGIN + " TEXT PRIMARY KEY, " +
                    PERSON_PLACE + " TEXT not nul, " +
                    PERSON_FIRST_NAME + " TEXT not null, " +
                    PERSON_NAME + " TEXT not null, " +
                    PERSON_BIRTHDAY + " TEXT not null, " +
                    PERSON_LANGUAGE + " TEXT not null, " +
                    PERSON_HAIR + " TEXT not null, " +
                    PERSON_EYES + " TEXT not null, " +
                    PERSON_PASSWORD + " TEXT not null, " +
                    PERSON_DESCRIPTION + " TEXT not null, " +
                    PERSON_GENDER + " TEXT not null, " +
                    PERSON_ORIENTATION + " TEXT not null);";

    private DatabaseHandler maBaseSQLite;
    private SQLiteDatabase db;

    public UserManager(Context context) {
        maBaseSQLite = DatabaseHandler.getInstance(context);
    }

    public void open() {
        db = maBaseSQLite.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public long addUser(User user) {
        ContentValues values = new ContentValues();

        values.put(PERSON_LOGIN, user.getLoginStr());
        values.put(PERSON_PLACE, user.getPlaceStr());
        values.put(PERSON_FIRST_NAME, user.getFirstNameStr());
        values.put(PERSON_NAME, user.getNameStr());
        values.put(PERSON_BIRTHDAY, user.getBirthdayStr());
        values.put(PERSON_LANGUAGE, user.getLanguageStr());
        values.put(PERSON_HAIR, user.getHairStr());
        values.put(PERSON_EYES, user.getEyesStr());
        values.put(PERSON_PASSWORD, user.getPasswordStr());
        values.put(PERSON_DESCRIPTION, user.getDescriptionStr());
        values.put(PERSON_GENDER, user.getGenderStr());
        values.put(PERSON_ORIENTATION, user.getOrientationStr());

        return db.insert(TABLE_PERSON, null, values);
    }

    public int modUser(User user) {
        ContentValues values = new ContentValues();

        values.put(PERSON_LOGIN, user.getLoginStr());
        values.put(PERSON_PLACE, user.getPlaceStr());
        values.put(PERSON_FIRST_NAME, user.getFirstNameStr());
        values.put(PERSON_NAME, user.getNameStr());
        values.put(PERSON_BIRTHDAY, user.getBirthdayStr());
        values.put(PERSON_LANGUAGE, user.getLanguageStr());
        values.put(PERSON_HAIR, user.getHairStr());
        values.put(PERSON_EYES, user.getEyesStr());
        values.put(PERSON_PASSWORD, user.getPasswordStr());
        values.put(PERSON_DESCRIPTION, user.getDescriptionStr());
        values.put(PERSON_GENDER, user.getGenderStr());
        values.put(PERSON_ORIENTATION, user.getOrientationStr());

        String where = PERSON_LOGIN + " = ?";
        String[] whereArgs = {user.getLoginStr() + ""};

        return db.update(TABLE_PERSON, values, where, whereArgs);
    }

    public int supUser(User user) {
        String where = PERSON_LOGIN + " = ?";
        String[] whereArgs = {user.getLoginStr()+""};

        return db.delete(TABLE_PERSON, where, whereArgs);
    }

    public User getUserStr(String login) {
        User u = new User();
        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_PERSON+" WHERE "+PERSON_LOGIN+" = "+login,null);
        if(c.moveToFirst()){
            u.setLoginStr(c.getString(c.getColumnIndex(PERSON_LOGIN)));
            u.setLoginStr(c.getString(c.getColumnIndex(PERSON_PLACE)));
            u.setFirstNameStr(c.getString(c.getColumnIndex(PERSON_FIRST_NAME)));
            u.setNameStr(c.getString(c.getColumnIndex(PERSON_NAME)));
            u.setBirthdayStr(c.getString(c.getColumnIndex(PERSON_BIRTHDAY)));
            u.setLanguageStr(c.getString(c.getColumnIndex(PERSON_LANGUAGE)));
            u.setHairStr(c.getString(c.getColumnIndex(PERSON_HAIR)));
            u.setEyesStr(c.getString(c.getColumnIndex(PERSON_EYES)));
            u.setPasswordStr(c.getString(c.getColumnIndex(PERSON_PASSWORD)));
            u.setDescriptionStr(c.getString(c.getColumnIndex(PERSON_DESCRIPTION)));
            u.setGenderStr(c.getString(c.getColumnIndex(PERSON_GENDER)));
            u.setOrientationStr(c.getString(c.getColumnIndex(PERSON_ORIENTATION)));
            c.close();
        }
        return u;
    }
}