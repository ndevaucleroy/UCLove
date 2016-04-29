package lsinf1225.uclove;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 *
 * Created by Guillaume on 29/04/16.
 */
public class AvailabilityManager {
    //Key Album Name
    public static final String TABLE_PERSON = "person";
    public static final String TABLE_AVAILABILITY = "availability";
    public static final String AVAILABILITY_LOGIN = "login";
    public static final String AVAILABILITY_DATE = "date";
    //Availability
    public static final String AVAILABILITY_TABLE_CREATE =
            "CREATE TABLE " + TABLE_AVAILABILITY + " (" +
                    AVAILABILITY_LOGIN + " TEXT not null references" + TABLE_PERSON + ", " +
                    AVAILABILITY_DATE + " TEXT not null, PRIMARY KEY (" +
                    AVAILABILITY_LOGIN + ", " + AVAILABILITY_DATE + "));";

    private DatabaseHandler maBaseSQLite; // notre gestionnaire du fichier SQLite
    private SQLiteDatabase db;


    public AvailabilityManager(Context context) {
        maBaseSQLite = DatabaseHandler.getInstance(context);
    }

    public void open()
    {
        //on ouvre la table en lecture/écriture
        db = maBaseSQLite.getWritableDatabase();
    }

    public void close()
    {
        //on ferme l'accès à la BDD
        db.close();
    }

    public long addAlbum(Availability availability) {
        // Ajout d'un enregistrement dans la table
        ContentValues values = new ContentValues();
        values.put(AVAILABILITY_LOGIN, availability.getLogin());
        values.put(AVAILABILITY_DATE, availability.getDate());

        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insert(TABLE_AVAILABILITY, null, values);
    }

    public int supAvailability(Availability availability) {
        // suppression d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = AVAILABILITY_LOGIN+" = ? and "+AVAILABILITY_DATE+" = ?" ;
        String[] whereArgs = {availability.getLogin()+"", availability.getDate()+""};

        return db.delete(TABLE_AVAILABILITY, where, whereArgs);
    }

    public Availability getAvailabilityStr(String login, String date) {
        // Retourne l'availability de login et de date.

        Availability a=new Availability();

        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_AVAILABILITY+" WHERE "+AVAILABILITY_LOGIN+"="+login+" and "+AVAILABILITY_DATE+"="+date, null);
        if (c.moveToFirst()) {
            a.setLogin(c.getString(c.getColumnIndex(AVAILABILITY_LOGIN)));
            a.setDate(c.getString(c.getColumnIndex(AVAILABILITY_DATE)));
            c.close();
        }

        return a;
    }

    public Cursor getAvailabilitySLogin(String login) {
        // Retourne les available de login
        return db.rawQuery("SELECT * FROM "+TABLE_AVAILABILITY+" WHERE "+AVAILABILITY_LOGIN+"="+login, null);
    }

    public Cursor getAvailabilityStr() {
        // sélection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM "+TABLE_AVAILABILITY, null);
    }
}
