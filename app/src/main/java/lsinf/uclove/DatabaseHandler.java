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
    public static final String PERSON_TABLE_DROP = "DROP TABLE IF EXISTS " + UserManager.TABLE_PERSON + ";";
    public static final String SCORE_TABLE_DROP = "DROP TABLE IF EXISTS " + ScoreManager.TABLE_SCORE + ";";
    public static final String ALBUM_TABLE_DROP = "DROP TABLE IF EXISTS " + AlbumManager.TABLE_ALBUM + ";";
    public static final String FRIENDSHIP_TABLE_DROP = "DROP TABLE IF EXISTS " + FriendshipManager.TABLE_FRIENDSHIP + ";";
    public static final String RENDEZVOUS_TABLE_DROP = "DROP TABLE IF EXISTS " + RendezVousManager.TABLE_RENDEZVOUS + ";";
    public static final String AVAILABILITY_TABLE_DROP = "DROP TABLE IF EXISTS " + AvailabilityManager.TABLE_AVAILABILITY + ";";

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
        db.execSQL(AvailabilityManager.AVAILABILITY_TABLE_CREATE);
        
        db.execSQL("INSERT INTO person VALUES(\"Maasym\",\"Charleroi\",\"Gabeline\",\"Hadagonde\",\"1915-6-20\",\"Français\",\"other\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",48656900)");
        db.execSQL("INSERT INTO person VALUES(\"Mabsuthat\",\"Charleroi\",\"Gabrienne\",\"Haddée\",\"1951-10-22\",\"Français\",\"other\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",30011947)");
        db.execSQL("INSERT INTO person VALUES(\"Maïa\",\"Liege\",\"Gacienne\",\"Haddie\",\"1917-9-6\",\"English\",\"blond\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",186285744)");
        db.execSQL("INSERT INTO person VALUES(\"Majya\",\"Liege\",\"Gadaline\",\"Hadeltrude\",\"1936-3-15\",\"Français\",\"black\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",67898410)");
        db.execSQL("INSERT INTO person VALUES(\"Manubrij\",\"Anvers\",\"Gadélie\",\"Hailemine\",\"1961-8-24\",\"Français\",\"other\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",186814916)");
        db.execSQL("INSERT INTO person VALUES(\"Marchab\",\"Bruxelles\",\"Gadélienne\",\"Hailemise\",\"1967-4-5\",\"Français\",\"blond\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",51505075)");
        db.execSQL("INSERT INTO person VALUES(\"Marfak\",\"Liege\",\"Gaëlle\",\"Haïssa\",\"1994-5-25\",\"English\",\"blond\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",120739713)");
        db.execSQL("INSERT INTO person VALUES(\"Marfic\",\"Bruxelles\",\"Gaëtina\",\"Halaïde\",\"1953-0-2\",\"Français\",\"other\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",171867)");
        db.execSQL("INSERT INTO person VALUES(\"Marfik\",\"Anvers\",\"Galamine\",\"Halbondie\",\"1952-9-6\",\"English\",\"other\",\"brown\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",253085730)");
        db.execSQL("INSERT INTO person VALUES(\"Marj\",\"Anvers\",\"Galarmine\",\"Haldina\",\"1920-7-20\",\"English\",\"blond\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",67505597)");
        db.execSQL("INSERT INTO person VALUES(\"Markab\",\"Mons\",\"Galianne\",\"Haliande\",\"1998-0-13\",\"English\",\"other\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",252505503)");
        db.execSQL("INSERT INTO person VALUES(\"Markeb\",\"Mons\",\"Galice\",\"Haliesca\",\"1915-4-25\",\"English\",\"black\",\"brown\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",176614666)");
        db.execSQL("INSERT INTO person VALUES(\"Marrha\",\"Mons\",\"Galienne\",\"Halima\",\"1909-8-4\",\"Français\",\"black\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",220562044)");
        db.execSQL("INSERT INTO person VALUES(\"Marsik\",\"Liege\",\"Galina\",\"Halpéria\",\"1946-9-25\",\"Français\",\"black\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",177506416)");
        db.execSQL("INSERT INTO person VALUES(\"Masym\",\"Gand\",\"Gallienne\",\"Halvina\",\"1965-0-19\",\"English\",\"blond\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",142379881)");
        db.execSQL("INSERT INTO person VALUES(\"Matar\",\"Bruxelles\",\"Gamélienne\",\"Halvine\",\"1928-6-17\",\"English\",\"red\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",35289871)");
        db.execSQL("INSERT INTO person VALUES(\"Meboula\",\"Louvain-La-Neuve\",\"Gameline\",\"Hameline\",\"1929-1-10\",\"Français\",\"other\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",198627856)");
        db.execSQL("INSERT INTO person VALUES(\"Mebsuta\",\"Mons\",\"Gamelire\",\"Hamida\",\"1900-5-12\",\"English\",\"blond\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",259268411)");
        db.execSQL("INSERT INTO person VALUES(\"Media\",\"Liege\",\"Gamelise\",\"Hamilda\",\"1945-0-19\",\"Français\",\"blond\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",104466436)");
        db.execSQL("INSERT INTO person VALUES(\"Megrets\",\"Mons\",\"Ganaïsse\",\"Hamildée\",\"1919-8-22\",\"Français\",\"blond\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",162110593)");
        db.execSQL("INSERT INTO person VALUES(\"Megrez\",\"Louvain-La-Neuve\",\"Gardélia\",\"Handrianne\",\"1921-5-21\",\"Français\",\"black\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",113765612)");
        db.execSQL("INSERT INTO person VALUES(\"Meïssa\",\"Gand\",\"Gardéva\",\"Handrienne\",\"1974-0-5\",\"Français\",\"other\",\"brown\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",84524509)");
        db.execSQL("INSERT INTO person VALUES(\"Mejssa\",\"Liege\",\"Gardina\",\"Hantippe\",\"1945-6-13\",\"English\",\"black\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",17290574)");
        db.execSQL("INSERT INTO person VALUES(\"Mekbuda\",\"Liege\",\"Gargonie\",\"Harégonde\",\"1946-2-20\",\"English\",\"other\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",10495012)");
        db.execSQL("INSERT INTO person VALUES(\"Melucta\",\"Liege\",\"Gargottine\",\"Harianne\",\"1972-4-24\",\"Français\",\"black\",\"brown\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",113498336)");
        db.execSQL("INSERT INTO person VALUES(\"Men\",\"Namur\",\"Garnoise\",\"Harielle\",\"1980-1-17\",\"Français\",\"red\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",45971094)");
        db.execSQL("INSERT INTO person VALUES(\"Menchi\",\"Namur\",\"Garsende\",\"Harienne\",\"1975-11-22\",\"English\",\"red\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",161883439)");
        db.execSQL("INSERT INTO person VALUES(\"Menka\",\"Gand\",\"Gasparde\",\"Hariette\",\"1900-2-25\",\"English\",\"black\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",162346776)");
        db.execSQL("INSERT INTO person VALUES(\"Menkab\",\"Liege\",\"Gasparina\",\"Harilda\",\"1969-3-10\",\"English\",\"black\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",164159862)");
        db.execSQL("INSERT INTO person VALUES(\"Menkalina\",\"Liege\",\"Gasparine\",\"Harildée\",\"1982-1-11\",\"English\",\"black\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",50089481)");
        db.execSQL("INSERT INTO person VALUES(\"Menkalinan\",\"Charleroi\",\"Gaspérina\",\"Harlina\",\"1919-5-5\",\"Français\",\"brown\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",37787554)");
        db.execSQL("INSERT INTO person VALUES(\"Menkar\",\"Anvers\",\"Gassienne\",\"Harline\",\"1970-11-25\",\"English\",\"other\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",15163046)");
        db.execSQL("INSERT INTO person VALUES(\"Menkent\",\"Bruxelles\",\"Gastelle\",\"Harlinia\",\"1998-4-24\",\"English\",\"black\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",10632749)");
        db.execSQL("INSERT INTO person VALUES(\"Menkhib\",\"Gand\",\"Gastonia\",\"Harlinie\",\"1938-8-0\",\"English\",\"red\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",33383967)");
        db.execSQL("INSERT INTO person VALUES(\"Menkib\",\"Anvers\",\"Gastonne\",\"Harmaïde\",\"1966-7-11\",\"Français\",\"red\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",206995203)");
        db.execSQL("INSERT INTO person VALUES(\"Mentar\",\"Charleroi\",\"Gatienne\",\"Harmaïsse\",\"1932-6-3\",\"Français\",\"brown\",\"brown\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",224973344)");
        db.execSQL("INSERT INTO person VALUES(\"Merach\",\"Charleroi\",\"Gauberte\",\"Harmance\",\"1968-4-9\",\"English\",\"black\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",29749163)");
        db.execSQL("INSERT INTO person VALUES(\"Merak\",\"Charleroi\",\"Gauchère\",\"Harmédia\",\"1982-11-19\",\"English\",\"brown\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",18432509)");
        db.execSQL("INSERT INTO person VALUES(\"Merakh\",\"Bruxelles\",\"Gauchette\",\"Harmélia\",\"1936-10-12\",\"English\",\"black\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",121929192)");
        db.execSQL("INSERT INTO person VALUES(\"Meres\",\"Louvain-La-Neuve\",\"Gaudélia\",\"Harmélie\",\"1950-7-24\",\"Français\",\"other\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",216967638)");
        db.execSQL("INSERT INTO person VALUES(\"Merets\",\"Bruxelles\",\"Gaudélie\",\"Harmélina\",\"1980-5-22\",\"Français\",\"red\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",184809649)");
        db.execSQL("INSERT INTO person VALUES(\"Merez\",\"Charleroi\",\"Gaudélina\",\"Harméline\",\"1915-11-9\",\"English\",\"other\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",54750980)");
        db.execSQL("INSERT INTO person VALUES(\"Merga\",\"Namur\",\"Gaudéline\",\"Harmélinia\",\"1988-1-15\",\"Français\",\"brown\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",72191027)");
        db.execSQL("INSERT INTO person VALUES(\"Merkab\",\"Anvers\",\"Gaudélinia\",\"Harmélinie\",\"1982-7-2\",\"Français\",\"other\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",623416)");
        db.execSQL("INSERT INTO person VALUES(\"Meropa\",\"Charleroi\",\"Gaudélise\",\"Harmélisa\",\"1926-11-7\",\"Français\",\"black\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",186652072)");
        db.execSQL("INSERT INTO person VALUES(\"Mérope\",\"Namur\",\"Gaudia\",\"Harmélise\",\"1958-9-19\",\"Français\",\"brown\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",150565284)");
        db.execSQL("INSERT INTO person VALUES(\"Mesarthim\",\"Mons\",\"Gaudianna\",\"Harmelle\",\"1900-0-11\",\"Français\",\"blond\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",51980759)");
        db.execSQL("INSERT INTO person VALUES(\"Mesartkhim\",\"Bruxelles\",\"Gaudianne\",\"Harménie\",\"1941-2-13\",\"Français\",\"brown\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",55663425)");
        db.execSQL("INSERT INTO person VALUES(\"Mesartim\",\"Charleroi\",\"Gaudienne\",\"Harménise\",\"1947-10-2\",\"English\",\"brown\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",52291244)");
        db.execSQL("INSERT INTO person VALUES(\"Metallah\",\"Bruxelles\",\"Gaudiosa\",\"Harmicia\",\"1995-1-4\",\"Français\",\"brown\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",211551094)");
        db.execSQL("INSERT INTO person VALUES(\"Metallakh\",\"Gand\",\"Gaudrière\",\"Harmina\",\"1977-5-7\",\"English\",\"other\",\"brown\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",117330280)");
        db.execSQL("INSERT INTO person VALUES(\"Mezartim\",\"Charleroi\",\"Gauthilda\",\"Harmonia\",\"1918-7-12\",\"Français\",\"brown\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",14800117)");
        db.execSQL("INSERT INTO person VALUES(\"Miaplacidus\",\"Louvain-La-Neuve\",\"Gauthilde\",\"Harmonie\",\"1960-11-3\",\"Français\",\"blond\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",76282260)");
        db.execSQL("INSERT INTO person VALUES(\"Miaplatsidus\",\"Bruxelles\",\"Gauvine\",\"Harmoza\",\"1968-11-12\",\"English\",\"brown\",\"brown\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",129905006)");
        db.execSQL("INSERT INTO person VALUES(\"Mifrid\",\"Louvain-La-Neuve\",\"Gaviria\",\"Harolda\",\"1915-7-7\",\"English\",\"brown\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",34508682)");
        db.execSQL("INSERT INTO person VALUES(\"Mimosa\",\"Namur\",\"Gazalie\",\"Haroldine\",\"1971-1-15\",\"English\",\"red\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",168904153)");
        db.execSQL("INSERT INTO person VALUES(\"Mimoza\",\"Charleroi\",\"Gazéla\",\"Harriette\",\"1908-2-6\",\"English\",\"black\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",83045609)");
        db.execSQL("INSERT INTO person VALUES(\"Minchir\",\"Gand\",\"Gazélia\",\"Hartémise\",\"1987-7-5\",\"English\",\"black\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",147500039)");
        db.execSQL("INSERT INTO person VALUES(\"Minelaua\",\"Namur\",\"Gazélie\",\"Hattie\",\"1941-4-13\",\"English\",\"other\",\"brown\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",105078025)");
        db.execSQL("INSERT INTO person VALUES(\"Minkar\",\"Anvers\",\"Gazella\",\"Hauviette\",\"1938-4-11\",\"English\",\"black\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",126691761)");
        db.execSQL("INSERT INTO person VALUES(\"Mintaka\",\"Namur\",\"Gaziéléa\",\"Hayda\",\"1980-2-9\",\"English\",\"brown\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",110139463)");
        db.execSQL("INSERT INTO person VALUES(\"Mintika\",\"Mons\",\"Gaziella\",\"Hazilda\",\"1985-10-0\",\"Français\",\"black\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",168355396)");
        db.execSQL("INSERT INTO person VALUES(\"Mira\",\"Bruxelles\",\"Gazielle\",\"Hazildée\",\"1930-11-12\",\"English\",\"other\",\"brown\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",120834984)");
        db.execSQL("INSERT INTO person VALUES(\"Miram\",\"Gand\",\"Gazilda\",\"Hébée\",\"1926-9-14\",\"English\",\"other\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",19976424)");
        db.execSQL("INSERT INTO person VALUES(\"Mirac\",\"Charleroi\",\"Gazildée\",\"Hébernia\",\"1956-7-8\",\"English\",\"black\",\"brown\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",68183022)");
        db.execSQL("INSERT INTO person VALUES(\"Mirach\",\"Anvers\",\"Gédalia\",\"Hectérine\",\"1979-1-16\",\"Français\",\"blond\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",160874809)");
        db.execSQL("INSERT INTO person VALUES(\"Mirak\",\"Gand\",\"Gédalie\",\"Hectorette\",\"1969-11-9\",\"Français\",\"black\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",209534433)");
        db.execSQL("INSERT INTO person VALUES(\"Mirakh\",\"Charleroi\",\"Gédégonde\",\"Hectoria\",\"1952-6-4\",\"Français\",\"black\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",39831918)");
        db.execSQL("INSERT INTO person VALUES(\"Mirfak\",\"Bruxelles\",\"Gédélia\",\"Hectorienne\",\"1992-9-15\",\"English\",\"brown\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",163625753)");
        db.execSQL("INSERT INTO person VALUES(\"Mirphak\",\"Mons\",\"Gédéline\",\"Hectoriette\",\"1934-0-13\",\"Français\",\"other\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",196417464)");
        db.execSQL("INSERT INTO person VALUES(\"Mirtsam\",\"Anvers\",\"Gédélise\",\"Hectorina\",\"1922-0-24\",\"Français\",\"other\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",237280596)");
        db.execSQL("INSERT INTO person VALUES(\"Mirza\",\"Charleroi\",\"Gédéonne\",\"Hectorine\",\"1987-10-15\",\"English\",\"black\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",218695095)");
        db.execSQL("INSERT INTO person VALUES(\"Mirzam\",\"Louvain-La-Neuve\",\"Gédina\",\"Hectorise\",\"1904-7-14\",\"English\",\"red\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",222480625)");
        db.execSQL("INSERT INTO person VALUES(\"Mismar\",\"Bruxelles\",\"Gédinia\",\"Hectovie\",\"1939-5-11\",\"English\",\"other\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",97954084)");
        db.execSQL("INSERT INTO person VALUES(\"Misam\",\"Mons\",\"Geffrine\",\"Hédélianne\",\"1989-7-6\",\"Français\",\"red\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",240201923)");
        db.execSQL("INSERT INTO person VALUES(\"Mitsar\",\"Charleroi\",\"Gélénora\",\"Hédélienne\",\"1912-3-2\",\"English\",\"other\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",46616533)");
        db.execSQL("INSERT INTO person VALUES(\"Mizar\",\"Gand\",\"Gélinda\",\"Hédémora\",\"1908-6-17\",\"English\",\"red\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",21636389)");
        db.execSQL("INSERT INTO person VALUES(\"Mizat\",\"Gand\",\"Géline\",\"Hédia\",\"1921-5-24\",\"English\",\"blond\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",9424732)");
        db.execSQL("INSERT INTO person VALUES(\"Monkar\",\"Mons\",\"Gélisée\",\"Hédine\",\"1903-2-3\",\"English\",\"other\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",257713086)");
        db.execSQL("INSERT INTO person VALUES(\"Motallakh\",\"Charleroi\",\"Gélisette\",\"Hédivilda\",\"1961-10-0\",\"Français\",\"brown\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",236088510)");
        db.execSQL("INSERT INTO person VALUES(\"Mothallah\",\"Charleroi\",\"Gelmira\",\"Hédola\",\"1923-6-22\",\"Français\",\"blond\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",40125984)");
        db.execSQL("INSERT INTO person VALUES(\"Mufrid\",\"Namur\",\"Gelna\",\"Hédonine\",\"1955-9-4\",\"Français\",\"brown\",\"blue\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",70079174)");
        db.execSQL("INSERT INTO person VALUES(\"Mufride\",\"Bruxelles\",\"Gelsémina\",\"Hédonise\",\"1983-9-21\",\"Français\",\"blond\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",37102057)");
        db.execSQL("INSERT INTO person VALUES(\"Muhlifaïn\",\"Anvers\",\"Géma\",\"Hédroïge\",\"1973-9-11\",\"English\",\"other\",\"brown\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",196358304)");
        db.execSQL("INSERT INTO person VALUES(\"Mulipheïn\",\"Liege\",\"Géméda\",\"Hedwidge\",\"1935-8-25\",\"English\",\"red\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",80677855)");
        db.execSQL("INSERT INTO person VALUES(\"Muliphen\",\"Charleroi\",\"Gémélina\",\"Hedwilda\",\"1975-8-15\",\"English\",\"blond\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",131960453)");
        db.execSQL("INSERT INTO person VALUES(\"Muphrid\",\"Namur\",\"Géméline\",\"Hedwildée\",\"1962-8-8\",\"Français\",\"red\",\"black\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",69604319)");
        db.execSQL("INSERT INTO person VALUES(\"Muphride\",\"Anvers\",\"Gémélinia\",\"Hélanda\",\"1964-10-7\",\"Français\",\"other\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",246021688)");
        db.execSQL("INSERT INTO person VALUES(\"Murfach\",\"Bruxelles\",\"Gémélinie\",\"Hélanise\",\"1929-8-22\",\"Français\",\"brown\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",231927590)");
        db.execSQL("INSERT INTO person VALUES(\"Murzim\",\"Namur\",\"Gémélise\",\"Hélaria\",\"1952-0-5\",\"English\",\"red\",\"green\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",188840946)");
        db.execSQL("INSERT INTO person VALUES(\"Muscida\",\"Namur\",\"Gémila\",\"Hélarie\",\"1953-7-12\",\"Français\",\"brown\",\"brown\",\"password\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",238937317)");

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
