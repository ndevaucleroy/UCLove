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
        
        db.execSQL(INSERT INTO person VALUES("Maasym","Gand","Gabeline","Hadagonde","1968-6-5","English","brown","brown","xXx_Maasym_xXx","Euh...flemme... prout d'ecrire une description","F","M",220314968));
        db.execSQL(INSERT INTO person VALUES("Mabsuthat","Mons","Gabrienne","Haddée","1939-1-16","Français","brown","black","xXx_Mabsuthat_xXx","Euh...flemme... prout d'ecrire une description","M","F",123160124));
        db.execSQL(INSERT INTO person VALUES("Maïa","Charleroi","Gacienne","Haddie","1959-8-17","Français","other","blue","xXx_Maïa_xXx","Euh...flemme... prout d'ecrire une description","M","M",217256813));
        db.execSQL(INSERT INTO person VALUES("Majya","Namur","Gadaline","Hadeltrude","1936-3-1","Français","other","green","xXx_Majya_xXx","Euh...flemme... prout d'ecrire une description","F","M",24766032));
        db.execSQL(INSERT INTO person VALUES("Manubrij","Mons","Gadélie","Hailemine","1998-2-6","English","brown","brown","xXx_Manubrij_xXx","Euh...flemme... prout d'ecrire une description","M","B",166662746));
        db.execSQL(INSERT INTO person VALUES("Marchab","Liege","Gadélienne","Hailemise","1901-7-8","Français","brown","green","xXx_Marchab_xXx","Euh...flemme... prout d'ecrire une description","F","M",132360054));
        db.execSQL(INSERT INTO person VALUES("Marfak","Liege","Gaëlle","Haïssa","1958-8-15","Français","other","black","xXx_Marfak_xXx","Euh...flemme... prout d'ecrire une description","M","M",131179390));
        db.execSQL(INSERT INTO person VALUES("Marfic","Bruxelles","Gaëtina","Halaïde","1962-11-20","Français","black","blue","xXx_Marfic_xXx","Euh...flemme... prout d'ecrire une description","F","F",12515632));
        db.execSQL(INSERT INTO person VALUES("Marfik","Louvain-La-Neuve","Galamine","Halbondie","1900-5-23","English","black","green","xXx_Marfik_xXx","Euh...flemme... prout d'ecrire une description","M","B",83918713));
        db.execSQL(INSERT INTO person VALUES("Marj","Charleroi","Galarmine","Haldina","1950-4-17","English","other","brown","xXx_Marj_xXx","Euh...flemme... prout d'ecrire une description","F","M",79380696));
        db.execSQL(INSERT INTO person VALUES("Markab","Bruxelles","Galianne","Haliande","1946-11-11","English","other","blue","xXx_Markab_xXx","Euh...flemme... prout d'ecrire une description","F","F",56956643));
        db.execSQL(INSERT INTO person VALUES("Markeb","Gand","Galice","Haliesca","1998-3-6","Français","blond","black","xXx_Markeb_xXx","Euh...flemme... prout d'ecrire une description","M","B",88156798));
        db.execSQL(INSERT INTO person VALUES("Marrha","Namur","Galienne","Halima","1998-6-23","English","brown","green","xXx_Marrha_xXx","Euh...flemme... prout d'ecrire une description","M","B",61246795));
        db.execSQL(INSERT INTO person VALUES("Marsik","Bruxelles","Galina","Halpéria","1917-4-18","English","blond","black","xXx_Marsik_xXx","Euh...flemme... prout d'ecrire une description","F","M",48139955));
        db.execSQL(INSERT INTO person VALUES("Masym","Bruxelles","Gallienne","Halvina","1986-11-24","Français","red","brown","xXx_Masym_xXx","Euh...flemme... prout d'ecrire une description","F","M",76192790));
        db.execSQL(INSERT INTO person VALUES("Matar","Louvain-La-Neuve","Gamélienne","Halvine","1906-8-20","English","other","blue","xXx_Matar_xXx","Euh...flemme... prout d'ecrire une description","M","F",38355504));
        db.execSQL(INSERT INTO person VALUES("Meboula","Bruxelles","Gameline","Hameline","1918-4-16","Français","black","brown","xXx_Meboula_xXx","Euh...flemme... prout d'ecrire une description","F","B",227279742));
        db.execSQL(INSERT INTO person VALUES("Mebsuta","Liege","Gamelire","Hamida","1929-10-0","English","blond","brown","xXx_Mebsuta_xXx","Euh...flemme... prout d'ecrire une description","M","F",20024744));
        db.execSQL(INSERT INTO person VALUES("Media","Louvain-La-Neuve","Gamelise","Hamilda","1911-6-14","English","other","blue","xXx_Media_xXx","Euh...flemme... prout d'ecrire une description","F","F",160023689));
        db.execSQL(INSERT INTO person VALUES("Megrets","Charleroi","Ganaïsse","Hamildée","1972-6-25","Français","brown","blue","xXx_Megrets_xXx","Euh...flemme... prout d'ecrire une description","F","F",26125290));
        db.execSQL(INSERT INTO person VALUES("Megrez","Bruxelles","Gardélia","Handrianne","1969-2-21","English","brown","green","xXx_Megrez_xXx","Euh...flemme... prout d'ecrire une description","M","M",210202746));
        db.execSQL(INSERT INTO person VALUES("Meïssa","Liege","Gardéva","Handrienne","1980-1-15","English","other","black","xXx_Meïssa_xXx","Euh...flemme... prout d'ecrire une description","M","F",221887207));
        db.execSQL(INSERT INTO person VALUES("Mejssa","Anvers","Gardina","Hantippe","1947-4-5","Français","other","green","xXx_Mejssa_xXx","Euh...flemme... prout d'ecrire une description","F","B",232080597));
        db.execSQL(INSERT INTO person VALUES("Mekbuda","Charleroi","Gargonie","Harégonde","1955-5-13","Français","other","green","xXx_Mekbuda_xXx","Euh...flemme... prout d'ecrire une description","F","F",102697479));
        db.execSQL(INSERT INTO person VALUES("Melucta","Anvers","Gargottine","Harianne","1917-7-7","Français","blond","brown","xXx_Melucta_xXx","Euh...flemme... prout d'ecrire une description","M","F",89931692));
        db.execSQL(INSERT INTO person VALUES("Men","Bruxelles","Garnoise","Harielle","1964-1-23","Français","red","green","xXx_Men_xXx","Euh...flemme... prout d'ecrire une description","F","B",148297614));
        db.execSQL(INSERT INTO person VALUES("Menchi","Liege","Garsende","Harienne","1976-4-25","English","other","blue","xXx_Menchi_xXx","Euh...flemme... prout d'ecrire une description","M","M",107393946));
        db.execSQL(INSERT INTO person VALUES("Menka","Anvers","Gasparde","Hariette","1950-7-0","English","other","black","xXx_Menka_xXx","Euh...flemme... prout d'ecrire une description","F","F",86698447));
        db.execSQL(INSERT INTO person VALUES("Menkab","Louvain-La-Neuve","Gasparina","Harilda","1913-0-24","Français","red","blue","xXx_Menkab_xXx","Euh...flemme... prout d'ecrire une description","M","F",71199592));
        db.execSQL(INSERT INTO person VALUES("Menkalina","Bruxelles","Gasparine","Harildée","1977-0-21","English","red","green","xXx_Menkalina_xXx","Euh...flemme... prout d'ecrire une description","M","B",43004710));
        db.execSQL(INSERT INTO person VALUES("Menkalinan","Gand","Gaspérina","Harlina","1938-3-27","English","black","black","xXx_Menkalinan_xXx","Euh...flemme... prout d'ecrire une description","F","B",81277676));
        db.execSQL(INSERT INTO person VALUES("Menkar","Bruxelles","Gassienne","Harline","1939-0-14","English","black","brown","xXx_Menkar_xXx","Euh...flemme... prout d'ecrire une description","F","M",221472956));
        db.execSQL(INSERT INTO person VALUES("Menkent","Bruxelles","Gastelle","Harlinia","1944-2-9","Français","blond","blue","xXx_Menkent_xXx","Euh...flemme... prout d'ecrire une description","M","M",181239664));
        db.execSQL(INSERT INTO person VALUES("Menkhib","Bruxelles","Gastonia","Harlinie","1918-1-27","Français","brown","black","xXx_Menkhib_xXx","Euh...flemme... prout d'ecrire une description","M","F",196370752));
        db.execSQL(INSERT INTO person VALUES("Menkib","Louvain-La-Neuve","Gastonne","Harmaïde","1936-9-17","English","black","brown","xXx_Menkib_xXx","Euh...flemme... prout d'ecrire une description","F","M",180846701));
        db.execSQL(INSERT INTO person VALUES("Mentar","Bruxelles","Gatienne","Harmaïsse","1995-1-17","English","black","blue","xXx_Mentar_xXx","Euh...flemme... prout d'ecrire une description","F","M",45763309));
        db.execSQL(INSERT INTO person VALUES("Merach","Gand","Gauberte","Harmance","1981-1-20","Français","red","blue","xXx_Merach_xXx","Euh...flemme... prout d'ecrire une description","F","B",87954206));
        db.execSQL(INSERT INTO person VALUES("Merak","Liege","Gauchère","Harmédia","1960-9-10","Français","blond","green","xXx_Merak_xXx","Euh...flemme... prout d'ecrire une description","F","B",222315829));
        db.execSQL(INSERT INTO person VALUES("Merakh","Charleroi","Gauchette","Harmélia","1951-0-4","English","black","blue","xXx_Merakh_xXx","Euh...flemme... prout d'ecrire une description","F","B",97137413));
        db.execSQL(INSERT INTO person VALUES("Meres","Mons","Gaudélia","Harmélie","1998-6-10","Français","brown","black","xXx_Meres_xXx","Euh...flemme... prout d'ecrire une description","M","F",130066586));
        db.execSQL(INSERT INTO person VALUES("Merets","Louvain-La-Neuve","Gaudélie","Harmélina","1918-2-26","Français","blond","brown","xXx_Merets_xXx","Euh...flemme... prout d'ecrire une description","F","F",118902159));
        db.execSQL(INSERT INTO person VALUES("Merez","Charleroi","Gaudélina","Harméline","1977-10-23","Français","blond","black","xXx_Merez_xXx","Euh...flemme... prout d'ecrire une description","F","M",106622767));
        db.execSQL(INSERT INTO person VALUES("Merga","Bruxelles","Gaudéline","Harmélinia","1939-9-19","English","other","green","xXx_Merga_xXx","Euh...flemme... prout d'ecrire une description","F","B",122646629));
        db.execSQL(INSERT INTO person VALUES("Merkab","Liege","Gaudélinia","Harmélinie","1913-8-5","Français","blond","brown","xXx_Merkab_xXx","Euh...flemme... prout d'ecrire une description","F","M",253233950));
        db.execSQL(INSERT INTO person VALUES("Meropa","Mons","Gaudélise","Harmélisa","1950-8-5","English","red","blue","xXx_Meropa_xXx","Euh...flemme... prout d'ecrire une description","F","F",63843949));
        db.execSQL(INSERT INTO person VALUES("Mérope","Mons","Gaudia","Harmélise","1921-6-16","Français","brown","brown","xXx_Mérope_xXx","Euh...flemme... prout d'ecrire une description","M","B",136017469));
        db.execSQL(INSERT INTO person VALUES("Mesarthim","Louvain-La-Neuve","Gaudianna","Harmelle","1910-9-11","English","blond","black","xXx_Mesarthim_xXx","Euh...flemme... prout d'ecrire une description","F","F",244355412));
        db.execSQL(INSERT INTO person VALUES("Mesartkhim","Anvers","Gaudianne","Harménie","1923-5-0","Français","blond","blue","xXx_Mesartkhim_xXx","Euh...flemme... prout d'ecrire une description","F","M",195048154));
        db.execSQL(INSERT INTO person VALUES("Mesartim","Louvain-La-Neuve","Gaudienne","Harménise","1926-4-2","English","red","black","xXx_Mesartim_xXx","Euh...flemme... prout d'ecrire une description","F","M",149597222));
        db.execSQL(INSERT INTO person VALUES("Metallah","Namur","Gaudiosa","Harmicia","1993-9-21","Français","blond","green","xXx_Metallah_xXx","Euh...flemme... prout d'ecrire une description","F","B",222114482));
        db.execSQL(INSERT INTO person VALUES("Metallakh","Gand","Gaudrière","Harmina","1976-11-22","English","brown","green","xXx_Metallakh_xXx","Euh...flemme... prout d'ecrire une description","F","M",77212059));
        db.execSQL(INSERT INTO person VALUES("Mezartim","Anvers","Gauthilda","Harmonia","1977-5-21","Français","black","green","xXx_Mezartim_xXx","Euh...flemme... prout d'ecrire une description","F","B",139419152));
        db.execSQL(INSERT INTO person VALUES("Miaplacidus","Charleroi","Gauthilde","Harmonie","1969-10-16","Français","blond","green","xXx_Miaplacidus_xXx","Euh...flemme... prout d'ecrire une description","F","F",238762152));
        db.execSQL(INSERT INTO person VALUES("Miaplatsidus","Louvain-La-Neuve","Gauvine","Harmoza","1955-3-21","Français","red","black","xXx_Miaplatsidus_xXx","Euh...flemme... prout d'ecrire une description","M","M",219985962));
        db.execSQL(INSERT INTO person VALUES("Mifrid","Gand","Gaviria","Harolda","1938-5-1","English","brown","brown","xXx_Mifrid_xXx","Euh...flemme... prout d'ecrire une description","M","F",29257982));
        db.execSQL(INSERT INTO person VALUES("Mimosa","Louvain-La-Neuve","Gazalie","Haroldine","1969-0-16","English","other","black","xXx_Mimosa_xXx","Euh...flemme... prout d'ecrire une description","F","M",120336182));
        db.execSQL(INSERT INTO person VALUES("Mimoza","Mons","Gazéla","Harriette","1924-0-20","Français","other","green","xXx_Mimoza_xXx","Euh...flemme... prout d'ecrire une description","M","B",203472230));
        db.execSQL(INSERT INTO person VALUES("Minchir","Mons","Gazélia","Hartémise","1907-6-15","English","brown","blue","xXx_Minchir_xXx","Euh...flemme... prout d'ecrire une description","M","B",198923955));
        db.execSQL(INSERT INTO person VALUES("Minelaua","Anvers","Gazélie","Hattie","1985-9-13","English","other","brown","xXx_Minelaua_xXx","Euh...flemme... prout d'ecrire une description","F","M",161359068));
        db.execSQL(INSERT INTO person VALUES("Minkar","Louvain-La-Neuve","Gazella","Hauviette","1958-1-26","English","black","black","xXx_Minkar_xXx","Euh...flemme... prout d'ecrire une description","F","B",35371941));
        db.execSQL(INSERT INTO person VALUES("Mintaka","Namur","Gaziéléa","Hayda","1974-7-15","Français","red","black","xXx_Mintaka_xXx","Euh...flemme... prout d'ecrire une description","F","B",189494442));
        db.execSQL(INSERT INTO person VALUES("Mintika","Namur","Gaziella","Hazilda","1929-10-22","English","brown","blue","xXx_Mintika_xXx","Euh...flemme... prout d'ecrire une description","M","F",235286394));
        db.execSQL(INSERT INTO person VALUES("Mira","Anvers","Gazielle","Hazildée","1953-2-15","Français","other","blue","xXx_Mira_xXx","Euh...flemme... prout d'ecrire une description","F","B",228535443));
        db.execSQL(INSERT INTO person VALUES("Miram","Namur","Gazilda","Hébée","1901-2-10","English","blond","blue","xXx_Miram_xXx","Euh...flemme... prout d'ecrire une description","F","M",91588506));
        db.execSQL(INSERT INTO person VALUES("Mirac","Gand","Gazildée","Hébernia","1987-2-13","English","other","blue","xXx_Mirac_xXx","Euh...flemme... prout d'ecrire une description","F","B",258284178));
        db.execSQL(INSERT INTO person VALUES("Mirach","Charleroi","Gédalia","Hectérine","1936-5-19","Français","red","black","xXx_Mirach_xXx","Euh...flemme... prout d'ecrire une description","F","F",184666011));
        db.execSQL(INSERT INTO person VALUES("Mirak","Anvers","Gédalie","Hectorette","1998-0-6","Français","brown","black","xXx_Mirak_xXx","Euh...flemme... prout d'ecrire une description","M","F",132425609));
        db.execSQL(INSERT INTO person VALUES("Mirakh","Anvers","Gédégonde","Hectoria","1945-5-7","Français","red","brown","xXx_Mirakh_xXx","Euh...flemme... prout d'ecrire une description","F","M",240268628));
        db.execSQL(INSERT INTO person VALUES("Mirfak","Namur","Gédélia","Hectorienne","1971-1-22","Français","red","black","xXx_Mirfak_xXx","Euh...flemme... prout d'ecrire une description","M","F",258653342));
        db.execSQL(INSERT INTO person VALUES("Mirphak","Namur","Gédéline","Hectoriette","1925-7-13","Français","black","green","xXx_Mirphak_xXx","Euh...flemme... prout d'ecrire une description","F","B",139920655));
        db.execSQL(INSERT INTO person VALUES("Mirtsam","Liege","Gédélise","Hectorina","1962-5-14","Français","black","brown","xXx_Mirtsam_xXx","Euh...flemme... prout d'ecrire une description","M","F",176069585));
        db.execSQL(INSERT INTO person VALUES("Mirza","Anvers","Gédéonne","Hectorine","1972-10-23","Français","brown","black","xXx_Mirza_xXx","Euh...flemme... prout d'ecrire une description","F","F",8675409));
        db.execSQL(INSERT INTO person VALUES("Mirzam","Gand","Gédina","Hectorise","1986-11-14","Français","blond","blue","xXx_Mirzam_xXx","Euh...flemme... prout d'ecrire une description","M","M",65712874));
        db.execSQL(INSERT INTO person VALUES("Mismar","Bruxelles","Gédinia","Hectovie","1985-9-20","Français","blond","black","xXx_Mismar_xXx","Euh...flemme... prout d'ecrire une description","F","M",96673976));
        db.execSQL(INSERT INTO person VALUES("Misam","Gand","Geffrine","Hédélianne","1990-4-25","English","red","black","xXx_Misam_xXx","Euh...flemme... prout d'ecrire une description","M","M",198076271));
        db.execSQL(INSERT INTO person VALUES("Mitsar","Charleroi","Gélénora","Hédélienne","1968-8-9","English","black","black","xXx_Mitsar_xXx","Euh...flemme... prout d'ecrire une description","M","F",25108138));
        db.execSQL(INSERT INTO person VALUES("Mizar","Liege","Gélinda","Hédémora","1930-3-24","English","brown","green","xXx_Mizar_xXx","Euh...flemme... prout d'ecrire une description","F","M",187536903));
        db.execSQL(INSERT INTO person VALUES("Mizat","Gand","Géline","Hédia","1943-0-25","Français","brown","green","xXx_Mizat_xXx","Euh...flemme... prout d'ecrire une description","F","B",104790159));
        db.execSQL(INSERT INTO person VALUES("Monkar","Liege","Gélisée","Hédine","1984-10-5","Français","brown","green","xXx_Monkar_xXx","Euh...flemme... prout d'ecrire une description","F","F",151000385));
        db.execSQL(INSERT INTO person VALUES("Motallakh","Bruxelles","Gélisette","Hédivilda","1943-9-22","English","black","brown","xXx_Motallakh_xXx","Euh...flemme... prout d'ecrire une description","M","F",38507925));
        db.execSQL(INSERT INTO person VALUES("Mothallah","Gand","Gelmira","Hédola","1992-4-22","English","brown","blue","xXx_Mothallah_xXx","Euh...flemme... prout d'ecrire une description","F","F",15792488));
        db.execSQL(INSERT INTO person VALUES("Mufrid","Louvain-La-Neuve","Gelna","Hédonine","1995-8-26","English","black","green","xXx_Mufrid_xXx","Euh...flemme... prout d'ecrire une description","F","B",207207414));
        db.execSQL(INSERT INTO person VALUES("Mufride","Anvers","Gelsémina","Hédonise","1921-2-3","Français","blond","green","xXx_Mufride_xXx","Euh...flemme... prout d'ecrire une description","F","B",153906820));
        db.execSQL(INSERT INTO person VALUES("Muhlifaïn","Charleroi","Géma","Hédroïge","1958-8-2","Français","other","brown","xXx_Muhlifaïn_xXx","Euh...flemme... prout d'ecrire une description","M","M",144735489));
        db.execSQL(INSERT INTO person VALUES("Mulipheïn","Liege","Géméda","Hedwidge","1949-5-7","English","blond","black","xXx_Mulipheïn_xXx","Euh...flemme... prout d'ecrire une description","F","F",234770819));
        db.execSQL(INSERT INTO person VALUES("Muliphen","Charleroi","Gémélina","Hedwilda","1903-4-20","Français","red","blue","xXx_Muliphen_xXx","Euh...flemme... prout d'ecrire une description","M","M",218826528));
        db.execSQL(INSERT INTO person VALUES("Muphrid","Liege","Géméline","Hedwildée","1949-9-0","Français","black","brown","xXx_Muphrid_xXx","Euh...flemme... prout d'ecrire une description","F","M",71497718));
        db.execSQL(INSERT INTO person VALUES("Muphride","Gand","Gémélinia","Hélanda","1921-0-8","Français","other","blue","xXx_Muphride_xXx","Euh...flemme... prout d'ecrire une description","M","F",7262292));
        db.execSQL(INSERT INTO person VALUES("Murfach","Charleroi","Gémélinie","Hélanise","1923-3-10","Français","blond","green","xXx_Murfach_xXx","Euh...flemme... prout d'ecrire une description","M","F",172508542));
        db.execSQL(INSERT INTO person VALUES("Murzim","Mons","Gémélise","Hélaria","1950-5-15","Français","red","green","xXx_Murzim_xXx","Euh...flemme... prout d'ecrire une description","M","F",230484901));
        db.execSQL(INSERT INTO person VALUES("Muscida","Gand","Gémila","Hélarie","1945-0-27","Français","black","brown","xXx_Muscida_xXx","Euh...flemme... prout d'ecrire une description","F","M",130597541));

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
