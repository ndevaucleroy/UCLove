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
    public static final String AVAILABILITY_TABLE_DROP = "DROP TABLE IF EXISTS " + AvailibilityManager.TABLE_AVAILABILITY + ";";

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
        
        db.execSQL("INSERT INTO person VALUES(\"Maasym\",\"Anvers\",\"Gabeline\",\"Hadagonde\",\"1990-6-25\",\"English\",\"red\",\"blue\",\"xXx_Maasym_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",147911853)");
        db.execSQL("INSERT INTO person VALUES(\"Mabsuthat\",\"Bruxelles\",\"Gabrienne\",\"Haddée\",\"1997-11-16\",\"English\",\"red\",\"green\",\"xXx_Mabsuthat_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",123202182)");
        db.execSQL("INSERT INTO person VALUES(\"Maïa\",\"Anvers\",\"Gacienne\",\"Haddie\",\"1955-2-10\",\"Français\",\"black\",\"green\",\"xXx_Maïa_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",61565024)");
        db.execSQL("INSERT INTO person VALUES(\"Majya\",\"Namur\",\"Gadaline\",\"Hadeltrude\",\"1947-2-8\",\"English\",\"brown\",\"black\",\"xXx_Majya_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",207486327)");
        db.execSQL("INSERT INTO person VALUES(\"Manubrij\",\"Liege\",\"Gadélie\",\"Hailemine\",\"1902-7-11\",\"Français\",\"other\",\"brown\",\"xXx_Manubrij_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",129140661)");
        db.execSQL("INSERT INTO person VALUES(\"Marchab\",\"Anvers\",\"Gadélienne\",\"Hailemise\",\"1938-5-11\",\"English\",\"black\",\"green\",\"xXx_Marchab_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",227835255)");
        db.execSQL("INSERT INTO person VALUES(\"Marfak\",\"Mons\",\"Gaëlle\",\"Haïssa\",\"1974-5-11\",\"Français\",\"brown\",\"black\",\"xXx_Marfak_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",228201830)");
        db.execSQL("INSERT INTO person VALUES(\"Marfic\",\"Charleroi\",\"Gaëtina\",\"Halaïde\",\"1983-10-20\",\"Français\",\"brown\",\"blue\",\"xXx_Marfic_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",153764802)");
        db.execSQL("INSERT INTO person VALUES(\"Marfik\",\"Liege\",\"Galamine\",\"Halbondie\",\"1984-0-20\",\"English\",\"brown\",\"blue\",\"xXx_Marfik_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",55964666)");
        db.execSQL("INSERT INTO person VALUES(\"Marj\",\"Namur\",\"Galarmine\",\"Haldina\",\"1969-2-4\",\"English\",\"blond\",\"black\",\"xXx_Marj_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",200492414)");
        db.execSQL("INSERT INTO person VALUES(\"Markab\",\"Anvers\",\"Galianne\",\"Haliande\",\"1934-8-2\",\"English\",\"black\",\"blue\",\"xXx_Markab_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",19052340)");
        db.execSQL("INSERT INTO person VALUES(\"Markeb\",\"Anvers\",\"Galice\",\"Haliesca\",\"1936-11-1\",\"Français\",\"black\",\"blue\",\"xXx_Markeb_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",217124681)");
        db.execSQL("INSERT INTO person VALUES(\"Marrha\",\"Charleroi\",\"Galienne\",\"Halima\",\"1974-11-1\",\"English\",\"blond\",\"green\",\"xXx_Marrha_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",115632170)");
        db.execSQL("INSERT INTO person VALUES(\"Marsik\",\"Bruxelles\",\"Galina\",\"Halpéria\",\"1900-0-11\",\"Français\",\"red\",\"black\",\"xXx_Marsik_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",95182951)");
        db.execSQL("INSERT INTO person VALUES(\"Masym\",\"Charleroi\",\"Gallienne\",\"Halvina\",\"1933-3-5\",\"Français\",\"blond\",\"brown\",\"xXx_Masym_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",254060546)");
        db.execSQL("INSERT INTO person VALUES(\"Matar\",\"Anvers\",\"Gamélienne\",\"Halvine\",\"1910-4-10\",\"English\",\"other\",\"black\",\"xXx_Matar_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",139114604)");
        db.execSQL("INSERT INTO person VALUES(\"Meboula\",\"Bruxelles\",\"Gameline\",\"Hameline\",\"1990-4-17\",\"English\",\"other\",\"blue\",\"xXx_Meboula_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",47677326)");
        db.execSQL("INSERT INTO person VALUES(\"Mebsuta\",\"Mons\",\"Gamelire\",\"Hamida\",\"1921-8-9\",\"Français\",\"brown\",\"brown\",\"xXx_Mebsuta_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",36888496)");
        db.execSQL("INSERT INTO person VALUES(\"Media\",\"Mons\",\"Gamelise\",\"Hamilda\",\"1967-5-24\",\"Français\",\"black\",\"blue\",\"xXx_Media_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",128398774)");
        db.execSQL("INSERT INTO person VALUES(\"Megrets\",\"Louvain-La-Neuve\",\"Ganaïsse\",\"Hamildée\",\"1900-4-7\",\"Français\",\"black\",\"black\",\"xXx_Megrets_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",52399041)");
        db.execSQL("INSERT INTO person VALUES(\"Megrez\",\"Bruxelles\",\"Gardélia\",\"Handrianne\",\"1994-9-25\",\"Français\",\"other\",\"blue\",\"xXx_Megrez_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",203581678)");
        db.execSQL("INSERT INTO person VALUES(\"Meïssa\",\"Liege\",\"Gardéva\",\"Handrienne\",\"1932-11-6\",\"English\",\"blond\",\"black\",\"xXx_Meïssa_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",126195699)");
        db.execSQL("INSERT INTO person VALUES(\"Mejssa\",\"Charleroi\",\"Gardina\",\"Hantippe\",\"1978-6-12\",\"Français\",\"blond\",\"black\",\"xXx_Mejssa_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",66440647)");
        db.execSQL("INSERT INTO person VALUES(\"Mekbuda\",\"Anvers\",\"Gargonie\",\"Harégonde\",\"1923-1-0\",\"English\",\"brown\",\"green\",\"xXx_Mekbuda_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",252375880)");
        db.execSQL("INSERT INTO person VALUES(\"Melucta\",\"Mons\",\"Gargottine\",\"Harianne\",\"1944-0-10\",\"English\",\"red\",\"green\",\"xXx_Melucta_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",963173)");
        db.execSQL("INSERT INTO person VALUES(\"Men\",\"Liege\",\"Garnoise\",\"Harielle\",\"1942-6-1\",\"English\",\"other\",\"blue\",\"xXx_Men_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",143032224)");
        db.execSQL("INSERT INTO person VALUES(\"Menchi\",\"Mons\",\"Garsende\",\"Harienne\",\"1996-5-0\",\"Français\",\"blond\",\"brown\",\"xXx_Menchi_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",195714260)");
        db.execSQL("INSERT INTO person VALUES(\"Menka\",\"Bruxelles\",\"Gasparde\",\"Hariette\",\"1941-0-23\",\"Français\",\"other\",\"blue\",\"xXx_Menka_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",239609431)");
        db.execSQL("INSERT INTO person VALUES(\"Menkab\",\"Charleroi\",\"Gasparina\",\"Harilda\",\"1935-10-25\",\"English\",\"red\",\"blue\",\"xXx_Menkab_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",225975851)");
        db.execSQL("INSERT INTO person VALUES(\"Menkalina\",\"Louvain-La-Neuve\",\"Gasparine\",\"Harildée\",\"1925-9-3\",\"Français\",\"blond\",\"brown\",\"xXx_Menkalina_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",65222202)");
        db.execSQL("INSERT INTO person VALUES(\"Menkalinan\",\"Mons\",\"Gaspérina\",\"Harlina\",\"1948-10-15\",\"Français\",\"red\",\"brown\",\"xXx_Menkalinan_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",161971197)");
        db.execSQL("INSERT INTO person VALUES(\"Menkar\",\"Mons\",\"Gassienne\",\"Harline\",\"1929-4-9\",\"English\",\"red\",\"green\",\"xXx_Menkar_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",65713551)");
        db.execSQL("INSERT INTO person VALUES(\"Menkent\",\"Charleroi\",\"Gastelle\",\"Harlinia\",\"1923-0-3\",\"English\",\"red\",\"black\",\"xXx_Menkent_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",234922866)");
        db.execSQL("INSERT INTO person VALUES(\"Menkhib\",\"Liege\",\"Gastonia\",\"Harlinie\",\"1916-6-23\",\"English\",\"black\",\"blue\",\"xXx_Menkhib_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",26798057)");
        db.execSQL("INSERT INTO person VALUES(\"Menkib\",\"Bruxelles\",\"Gastonne\",\"Harmaïde\",\"1969-6-15\",\"Français\",\"brown\",\"brown\",\"xXx_Menkib_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",114478091)");
        db.execSQL("INSERT INTO person VALUES(\"Mentar\",\"Liege\",\"Gatienne\",\"Harmaïsse\",\"1954-3-16\",\"English\",\"other\",\"green\",\"xXx_Mentar_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",140159934)");
        db.execSQL("INSERT INTO person VALUES(\"Merach\",\"Louvain-La-Neuve\",\"Gauberte\",\"Harmance\",\"1940-0-9\",\"English\",\"brown\",\"blue\",\"xXx_Merach_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",183160227)");
        db.execSQL("INSERT INTO person VALUES(\"Merak\",\"Namur\",\"Gauchère\",\"Harmédia\",\"1930-1-20\",\"Français\",\"brown\",\"blue\",\"xXx_Merak_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",40135373)");
        db.execSQL("INSERT INTO person VALUES(\"Merakh\",\"Bruxelles\",\"Gauchette\",\"Harmélia\",\"1980-7-19\",\"Français\",\"brown\",\"brown\",\"xXx_Merakh_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",200699637)");
        db.execSQL("INSERT INTO person VALUES(\"Meres\",\"Anvers\",\"Gaudélia\",\"Harmélie\",\"1967-1-24\",\"English\",\"brown\",\"black\",\"xXx_Meres_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",145793401)");
        db.execSQL("INSERT INTO person VALUES(\"Merets\",\"Liege\",\"Gaudélie\",\"Harmélina\",\"1914-4-20\",\"Français\",\"black\",\"black\",\"xXx_Merets_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",199219061)");
        db.execSQL("INSERT INTO person VALUES(\"Merez\",\"Namur\",\"Gaudélina\",\"Harméline\",\"1920-0-13\",\"Français\",\"other\",\"black\",\"xXx_Merez_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",23283561)");
        db.execSQL("INSERT INTO person VALUES(\"Merga\",\"Gand\",\"Gaudéline\",\"Harmélinia\",\"1996-6-24\",\"Français\",\"black\",\"brown\",\"xXx_Merga_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",67069702)");
        db.execSQL("INSERT INTO person VALUES(\"Merkab\",\"Mons\",\"Gaudélinia\",\"Harmélinie\",\"1979-9-26\",\"Français\",\"blond\",\"blue\",\"xXx_Merkab_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",188564189)");
        db.execSQL("INSERT INTO person VALUES(\"Meropa\",\"Namur\",\"Gaudélise\",\"Harmélisa\",\"1916-1-8\",\"Français\",\"black\",\"brown\",\"xXx_Meropa_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",18695329)");
        db.execSQL("INSERT INTO person VALUES(\"Mérope\",\"Mons\",\"Gaudia\",\"Harmélise\",\"1934-5-0\",\"Français\",\"black\",\"brown\",\"xXx_Mérope_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",95862324)");
        db.execSQL("INSERT INTO person VALUES(\"Mesarthim\",\"Namur\",\"Gaudianna\",\"Harmelle\",\"1922-5-14\",\"English\",\"black\",\"brown\",\"xXx_Mesarthim_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",133992101)");
        db.execSQL("INSERT INTO person VALUES(\"Mesartkhim\",\"Louvain-La-Neuve\",\"Gaudianne\",\"Harménie\",\"1971-10-1\",\"English\",\"brown\",\"black\",\"xXx_Mesartkhim_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",77564523)");
        db.execSQL("INSERT INTO person VALUES(\"Mesartim\",\"Liege\",\"Gaudienne\",\"Harménise\",\"1959-1-22\",\"English\",\"red\",\"black\",\"xXx_Mesartim_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",7605564)");
        db.execSQL("INSERT INTO person VALUES(\"Metallah\",\"Anvers\",\"Gaudiosa\",\"Harmicia\",\"1904-10-13\",\"Français\",\"brown\",\"blue\",\"xXx_Metallah_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",78606146)");
        db.execSQL("INSERT INTO person VALUES(\"Metallakh\",\"Mons\",\"Gaudrière\",\"Harmina\",\"1923-11-24\",\"Français\",\"other\",\"brown\",\"xXx_Metallakh_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",246622649)");
        db.execSQL("INSERT INTO person VALUES(\"Mezartim\",\"Namur\",\"Gauthilda\",\"Harmonia\",\"1919-1-16\",\"English\",\"brown\",\"green\",\"xXx_Mezartim_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",75520778)");
        db.execSQL("INSERT INTO person VALUES(\"Miaplacidus\",\"Louvain-La-Neuve\",\"Gauthilde\",\"Harmonie\",\"1939-6-9\",\"English\",\"blond\",\"green\",\"xXx_Miaplacidus_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",117674153)");
        db.execSQL("INSERT INTO person VALUES(\"Miaplatsidus\",\"Namur\",\"Gauvine\",\"Harmoza\",\"1904-8-2\",\"Français\",\"red\",\"blue\",\"xXx_Miaplatsidus_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",161786905)");
        db.execSQL("INSERT INTO person VALUES(\"Mifrid\",\"Anvers\",\"Gaviria\",\"Harolda\",\"1994-3-12\",\"English\",\"brown\",\"blue\",\"xXx_Mifrid_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",240142512)");
        db.execSQL("INSERT INTO person VALUES(\"Mimosa\",\"Louvain-La-Neuve\",\"Gazalie\",\"Haroldine\",\"1987-8-7\",\"English\",\"blond\",\"green\",\"xXx_Mimosa_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",220297154)");
        db.execSQL("INSERT INTO person VALUES(\"Mimoza\",\"Anvers\",\"Gazéla\",\"Harriette\",\"1972-0-10\",\"English\",\"red\",\"green\",\"xXx_Mimoza_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",158461006)");
        db.execSQL("INSERT INTO person VALUES(\"Minchir\",\"Liege\",\"Gazélia\",\"Hartémise\",\"1903-7-0\",\"English\",\"brown\",\"green\",\"xXx_Minchir_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",194872035)");
        db.execSQL("INSERT INTO person VALUES(\"Minelaua\",\"Gand\",\"Gazélie\",\"Hattie\",\"1941-10-16\",\"Français\",\"black\",\"green\",\"xXx_Minelaua_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",83847876)");
        db.execSQL("INSERT INTO person VALUES(\"Minkar\",\"Charleroi\",\"Gazella\",\"Hauviette\",\"1904-10-17\",\"Français\",\"red\",\"brown\",\"xXx_Minkar_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",113593628)");
        db.execSQL("INSERT INTO person VALUES(\"Mintaka\",\"Charleroi\",\"Gaziéléa\",\"Hayda\",\"1983-9-20\",\"English\",\"brown\",\"blue\",\"xXx_Mintaka_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",38077272)");
        db.execSQL("INSERT INTO person VALUES(\"Mintika\",\"Mons\",\"Gaziella\",\"Hazilda\",\"1920-2-8\",\"Français\",\"red\",\"brown\",\"xXx_Mintika_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",55919299)");
        db.execSQL("INSERT INTO person VALUES(\"Mira\",\"Charleroi\",\"Gazielle\",\"Hazildée\",\"1927-4-3\",\"Français\",\"red\",\"green\",\"xXx_Mira_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",195661980)");
        db.execSQL("INSERT INTO person VALUES(\"Miram\",\"Gand\",\"Gazilda\",\"Hébée\",\"1925-0-12\",\"English\",\"blond\",\"brown\",\"xXx_Miram_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",160634853)");
        db.execSQL("INSERT INTO person VALUES(\"Mirac\",\"Gand\",\"Gazildée\",\"Hébernia\",\"1982-1-18\",\"English\",\"other\",\"brown\",\"xXx_Mirac_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",209617532)");
        db.execSQL("INSERT INTO person VALUES(\"Mirach\",\"Anvers\",\"Gédalia\",\"Hectérine\",\"1980-5-6\",\"Français\",\"other\",\"green\",\"xXx_Mirach_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",208903508)");
        db.execSQL("INSERT INTO person VALUES(\"Mirak\",\"Gand\",\"Gédalie\",\"Hectorette\",\"1932-1-20\",\"Français\",\"other\",\"black\",\"xXx_Mirak_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",103423971)");
        db.execSQL("INSERT INTO person VALUES(\"Mirakh\",\"Charleroi\",\"Gédégonde\",\"Hectoria\",\"1942-6-20\",\"Français\",\"blond\",\"blue\",\"xXx_Mirakh_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",49557359)");
        db.execSQL("INSERT INTO person VALUES(\"Mirfak\",\"Louvain-La-Neuve\",\"Gédélia\",\"Hectorienne\",\"1945-0-0\",\"Français\",\"brown\",\"green\",\"xXx_Mirfak_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",48734319)");
        db.execSQL("INSERT INTO person VALUES(\"Mirphak\",\"Anvers\",\"Gédéline\",\"Hectoriette\",\"1952-5-7\",\"English\",\"black\",\"green\",\"xXx_Mirphak_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",102084032)");
        db.execSQL("INSERT INTO person VALUES(\"Mirtsam\",\"Gand\",\"Gédélise\",\"Hectorina\",\"1901-11-20\",\"English\",\"other\",\"blue\",\"xXx_Mirtsam_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",33837075)");
        db.execSQL("INSERT INTO person VALUES(\"Mirza\",\"Mons\",\"Gédéonne\",\"Hectorine\",\"1906-9-0\",\"Français\",\"black\",\"green\",\"xXx_Mirza_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",186043915)");
        db.execSQL("INSERT INTO person VALUES(\"Mirzam\",\"Anvers\",\"Gédina\",\"Hectorise\",\"1937-2-27\",\"Français\",\"brown\",\"blue\",\"xXx_Mirzam_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",144987159)");
        db.execSQL("INSERT INTO person VALUES(\"Mismar\",\"Louvain-La-Neuve\",\"Gédinia\",\"Hectovie\",\"1910-8-2\",\"English\",\"other\",\"green\",\"xXx_Mismar_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",10737065)");
        db.execSQL("INSERT INTO person VALUES(\"Misam\",\"Gand\",\"Geffrine\",\"Hédélianne\",\"1917-0-17\",\"Français\",\"blond\",\"blue\",\"xXx_Misam_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",74924001)");
        db.execSQL("INSERT INTO person VALUES(\"Mitsar\",\"Charleroi\",\"Gélénora\",\"Hédélienne\",\"1984-7-12\",\"English\",\"other\",\"blue\",\"xXx_Mitsar_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",130910505)");
        db.execSQL("INSERT INTO person VALUES(\"Mizar\",\"Liege\",\"Gélinda\",\"Hédémora\",\"1907-4-10\",\"Français\",\"other\",\"blue\",\"xXx_Mizar_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",120558817)");
        db.execSQL("INSERT INTO person VALUES(\"Mizat\",\"Anvers\",\"Géline\",\"Hédia\",\"1962-4-2\",\"Français\",\"black\",\"green\",\"xXx_Mizat_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",167921540)");
        db.execSQL("INSERT INTO person VALUES(\"Monkar\",\"Louvain-La-Neuve\",\"Gélisée\",\"Hédine\",\"1933-1-8\",\"English\",\"other\",\"black\",\"xXx_Monkar_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",86986952)");
        db.execSQL("INSERT INTO person VALUES(\"Motallakh\",\"Mons\",\"Gélisette\",\"Hédivilda\",\"1941-5-11\",\"Français\",\"brown\",\"green\",\"xXx_Motallakh_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",58506552)");
        db.execSQL("INSERT INTO person VALUES(\"Mothallah\",\"Anvers\",\"Gelmira\",\"Hédola\",\"1991-5-17\",\"English\",\"brown\",\"green\",\"xXx_Mothallah_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",227634567)");
        db.execSQL("INSERT INTO person VALUES(\"Mufrid\",\"Mons\",\"Gelna\",\"Hédonine\",\"1943-5-22\",\"Français\",\"other\",\"brown\",\"xXx_Mufrid_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"B\",68237029)");
        db.execSQL("INSERT INTO person VALUES(\"Mufride\",\"Charleroi\",\"Gelsémina\",\"Hédonise\",\"1936-0-10\",\"English\",\"red\",\"black\",\"xXx_Mufride_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",149967301)");
        db.execSQL("INSERT INTO person VALUES(\"Muhlifaïn\",\"Anvers\",\"Géma\",\"Hédroïge\",\"1984-9-11\",\"English\",\"brown\",\"green\",\"xXx_Muhlifaïn_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"F\",237534074)");
        db.execSQL("INSERT INTO person VALUES(\"Mulipheïn\",\"Liege\",\"Géméda\",\"Hedwidge\",\"1966-10-4\",\"Français\",\"brown\",\"blue\",\"xXx_Mulipheïn_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",179241098)");
        db.execSQL("INSERT INTO person VALUES(\"Muliphen\",\"Bruxelles\",\"Gémélina\",\"Hedwilda\",\"1929-6-9\",\"Français\",\"red\",\"green\",\"xXx_Muliphen_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",219845997)");
        db.execSQL("INSERT INTO person VALUES(\"Muphrid\",\"Liege\",\"Géméline\",\"Hedwildée\",\"1919-2-4\",\"English\",\"red\",\"black\",\"xXx_Muphrid_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",192865109)");
        db.execSQL("INSERT INTO person VALUES(\"Muphride\",\"Namur\",\"Gémélinia\",\"Hélanda\",\"1955-9-4\",\"Français\",\"blond\",\"black\",\"xXx_Muphride_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"M\",193831209)");
        db.execSQL("INSERT INTO person VALUES(\"Murfach\",\"Louvain-La-Neuve\",\"Gémélinie\",\"Hélanise\",\"1956-3-13\",\"Français\",\"red\",\"brown\",\"xXx_Murfach_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"B\",153928915)");
        db.execSQL("INSERT INTO person VALUES(\"Murzim\",\"Anvers\",\"Gémélise\",\"Hélaria\",\"1926-3-0\",\"English\",\"blond\",\"blue\",\"xXx_Murzim_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"F\",\"M\",154796591)");
        db.execSQL("INSERT INTO person VALUES(\"Muscida\",\"Namur\",\"Gémila\",\"Hélarie\",\"1908-9-4\",\"Français\",\"black\",\"green\",\"xXx_Muscida_xXx\",\"Euh...flemme... prout d'ecrire une description\",\"M\",\"F\",59049455)");

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
