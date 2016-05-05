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
        
        db.execSQL(INSERT INTO person VALUES("Maasym","Anvers","Gabeline","Hadagonde","1926-2-23","English","black","blue","xXx_Maasym_xXx","Euh...flemme... prout d'ecrire une description","M","M",156567121);)
        db.execSQL(INSERT INTO person VALUES("Mabsuthat","Louvain-La-Neuve","Gabrienne","Haddée","1926-5-10","English","brown","brown","xXx_Mabsuthat_xXx","Euh...flemme... prout d'ecrire une description","F","B",96784398);)
        db.execSQL(INSERT INTO person VALUES("Maïa","Louvain-La-Neuve","Gacienne","Haddie","1917-10-12","English","red","black","xXx_Maïa_xXx","Euh...flemme... prout d'ecrire une description","F","F",163768853);)
        db.execSQL(INSERT INTO person VALUES("Majya","Gand","Gadaline","Hadeltrude","1948-6-19","Français","black","black","xXx_Majya_xXx","Euh...flemme... prout d'ecrire une description","M","B",209758262);)
        db.execSQL(INSERT INTO person VALUES("Manubrij","Liege","Gadélie","Hailemine","1947-10-22","English","black","black","xXx_Manubrij_xXx","Euh...flemme... prout d'ecrire une description","M","B",226636511);)
        db.execSQL(INSERT INTO person VALUES("Marchab","Namur","Gadélienne","Hailemise","1996-1-9","English","black","black","xXx_Marchab_xXx","Euh...flemme... prout d'ecrire une description","M","M",135007724);)
        db.execSQL(INSERT INTO person VALUES("Marfak","Anvers","Gaëlle","Haïssa","1905-0-14","Français","brown","black","xXx_Marfak_xXx","Euh...flemme... prout d'ecrire une description","F","M",115419315);)
        db.execSQL(INSERT INTO person VALUES("Marfic","Louvain-La-Neuve","Gaëtina","Halaïde","1942-9-12","English","brown","green","xXx_Marfic_xXx","Euh...flemme... prout d'ecrire une description","M","F",200578797);)
        db.execSQL(INSERT INTO person VALUES("Marfik","Bruxelles","Galamine","Halbondie","1991-8-22","Français","other","blue","xXx_Marfik_xXx","Euh...flemme... prout d'ecrire une description","M","F",213539441);)
        db.execSQL(INSERT INTO person VALUES("Marj","Bruxelles","Galarmine","Haldina","1905-7-15","English","black","brown","xXx_Marj_xXx","Euh...flemme... prout d'ecrire une description","F","M",166491958);)
        db.execSQL(INSERT INTO person VALUES("Markab","Gand","Galianne","Haliande","1923-10-21","Français","black","black","xXx_Markab_xXx","Euh...flemme... prout d'ecrire une description","F","M",220440022);)
        db.execSQL(INSERT INTO person VALUES("Markeb","Liege","Galice","Haliesca","1981-1-21","English","blond","brown","xXx_Markeb_xXx","Euh...flemme... prout d'ecrire une description","M","M",13131867);)
        db.execSQL(INSERT INTO person VALUES("Marrha","Liege","Galienne","Halima","1993-5-13","Français","red","brown","xXx_Marrha_xXx","Euh...flemme... prout d'ecrire une description","M","F",191476178);)
        db.execSQL(INSERT INTO person VALUES("Marsik","Gand","Galina","Halpéria","1977-5-10","English","red","green","xXx_Marsik_xXx","Euh...flemme... prout d'ecrire une description","F","B",135292005);)
        db.execSQL(INSERT INTO person VALUES("Masym","Gand","Gallienne","Halvina","1952-3-27","Français","other","black","xXx_Masym_xXx","Euh...flemme... prout d'ecrire une description","F","B",168459151);)
        db.execSQL(INSERT INTO person VALUES("Matar","Namur","Gamélienne","Halvine","1958-2-12","English","red","blue","xXx_Matar_xXx","Euh...flemme... prout d'ecrire une description","M","F",36611232);)
        db.execSQL(INSERT INTO person VALUES("Meboula","Charleroi","Gameline","Hameline","1961-0-6","English","blond","brown","xXx_Meboula_xXx","Euh...flemme... prout d'ecrire une description","M","B",25344094);)
        db.execSQL(INSERT INTO person VALUES("Mebsuta","Louvain-La-Neuve","Gamelire","Hamida","1928-7-14","Français","brown","green","xXx_Mebsuta_xXx","Euh...flemme... prout d'ecrire une description","M","F",255113828);)
        db.execSQL(INSERT INTO person VALUES("Media","Liege","Gamelise","Hamilda","1998-7-10","Français","blond","black","xXx_Media_xXx","Euh...flemme... prout d'ecrire une description","M","M",185831630);)
        db.execSQL(INSERT INTO person VALUES("Megrets","Mons","Ganaïsse","Hamildée","1991-10-25","English","red","brown","xXx_Megrets_xXx","Euh...flemme... prout d'ecrire une description","M","B",154799012);)
        db.execSQL(INSERT INTO person VALUES("Megrez","Bruxelles","Gardélia","Handrianne","1942-5-17","English","blond","green","xXx_Megrez_xXx","Euh...flemme... prout d'ecrire une description","F","F",98732981);)
        db.execSQL(INSERT INTO person VALUES("Meïssa","Bruxelles","Gardéva","Handrienne","1902-4-6","English","other","blue","xXx_Meïssa_xXx","Euh...flemme... prout d'ecrire une description","F","B",126655196);)
        db.execSQL(INSERT INTO person VALUES("Mejssa","Mons","Gardina","Hantippe","1994-2-23","Français","red","black","xXx_Mejssa_xXx","Euh...flemme... prout d'ecrire une description","M","M",220064423);)
        db.execSQL(INSERT INTO person VALUES("Mekbuda","Mons","Gargonie","Harégonde","1939-6-5","English","black","blue","xXx_Mekbuda_xXx","Euh...flemme... prout d'ecrire une description","M","M",146904955);)
        db.execSQL(INSERT INTO person VALUES("Melucta","Mons","Gargottine","Harianne","1982-0-20","Français","brown","green","xXx_Melucta_xXx","Euh...flemme... prout d'ecrire une description","M","M",109934682);)
        db.execSQL(INSERT INTO person VALUES("Men","Namur","Garnoise","Harielle","1923-10-6","Français","brown","blue","xXx_Men_xXx","Euh...flemme... prout d'ecrire une description","M","M",9388408);)
        db.execSQL(INSERT INTO person VALUES("Menchi","Mons","Garsende","Harienne","1915-5-13","English","blond","brown","xXx_Menchi_xXx","Euh...flemme... prout d'ecrire une description","F","B",3628624);)
        db.execSQL(INSERT INTO person VALUES("Menka","Gand","Gasparde","Hariette","1902-8-2","English","blond","green","xXx_Menka_xXx","Euh...flemme... prout d'ecrire une description","M","B",247159456);)
        db.execSQL(INSERT INTO person VALUES("Menkab","Liege","Gasparina","Harilda","1952-9-13","English","brown","black","xXx_Menkab_xXx","Euh...flemme... prout d'ecrire une description","F","F",58776264);)
        db.execSQL(INSERT INTO person VALUES("Menkalina","Charleroi","Gasparine","Harildée","1982-8-20","English","brown","green","xXx_Menkalina_xXx","Euh...flemme... prout d'ecrire une description","F","M",42214896);)
        db.execSQL(INSERT INTO person VALUES("Menkalinan","Bruxelles","Gaspérina","Harlina","1943-7-24","Français","red","black","xXx_Menkalinan_xXx","Euh...flemme... prout d'ecrire une description","F","M",56507434);)
        db.execSQL(INSERT INTO person VALUES("Menkar","Namur","Gassienne","Harline","1964-4-8","English","blond","blue","xXx_Menkar_xXx","Euh...flemme... prout d'ecrire une description","F","F",256759739);)
        db.execSQL(INSERT INTO person VALUES("Menkent","Anvers","Gastelle","Harlinia","1988-2-26","Français","black","brown","xXx_Menkent_xXx","Euh...flemme... prout d'ecrire une description","M","M",144626491);)
        db.execSQL(INSERT INTO person VALUES("Menkhib","Namur","Gastonia","Harlinie","1977-2-6","English","brown","black","xXx_Menkhib_xXx","Euh...flemme... prout d'ecrire une description","M","B",31738163);)
        db.execSQL(INSERT INTO person VALUES("Menkib","Bruxelles","Gastonne","Harmaïde","1928-10-0","English","red","brown","xXx_Menkib_xXx","Euh...flemme... prout d'ecrire une description","M","F",103531131);)
        db.execSQL(INSERT INTO person VALUES("Mentar","Gand","Gatienne","Harmaïsse","1943-6-26","Français","brown","green","xXx_Mentar_xXx","Euh...flemme... prout d'ecrire une description","M","M",190802009);)
        db.execSQL(INSERT INTO person VALUES("Merach","Gand","Gauberte","Harmance","1918-10-20","Français","red","black","xXx_Merach_xXx","Euh...flemme... prout d'ecrire une description","M","M",44258116);)
        db.execSQL(INSERT INTO person VALUES("Merak","Bruxelles","Gauchère","Harmédia","1944-3-14","Français","red","blue","xXx_Merak_xXx","Euh...flemme... prout d'ecrire une description","M","F",146908712);)
        db.execSQL(INSERT INTO person VALUES("Merakh","Namur","Gauchette","Harmélia","1944-9-23","English","other","blue","xXx_Merakh_xXx","Euh...flemme... prout d'ecrire une description","F","B",121677904);)
        db.execSQL(INSERT INTO person VALUES("Meres","Bruxelles","Gaudélia","Harmélie","1988-2-6","English","brown","black","xXx_Meres_xXx","Euh...flemme... prout d'ecrire une description","M","F",28484160);)
        db.execSQL(INSERT INTO person VALUES("Merets","Namur","Gaudélie","Harmélina","1939-11-27","English","black","brown","xXx_Merets_xXx","Euh...flemme... prout d'ecrire une description","M","F",95344499);)
        db.execSQL(INSERT INTO person VALUES("Merez","Louvain-La-Neuve","Gaudélina","Harméline","1992-5-4","Français","red","blue","xXx_Merez_xXx","Euh...flemme... prout d'ecrire une description","M","B",242950170);)
        db.execSQL(INSERT INTO person VALUES("Merga","Charleroi","Gaudéline","Harmélinia","1930-1-26","English","brown","green","xXx_Merga_xXx","Euh...flemme... prout d'ecrire une description","F","B",160944759);)
        db.execSQL(INSERT INTO person VALUES("Merkab","Gand","Gaudélinia","Harmélinie","1941-5-14","English","red","green","xXx_Merkab_xXx","Euh...flemme... prout d'ecrire une description","M","B",19596388);)
        db.execSQL(INSERT INTO person VALUES("Meropa","Liege","Gaudélise","Harmélisa","1996-9-15","Français","red","black","xXx_Meropa_xXx","Euh...flemme... prout d'ecrire une description","M","B",71000356);)
        db.execSQL(INSERT INTO person VALUES("Mérope","Bruxelles","Gaudia","Harmélise","1982-4-11","English","blond","brown","xXx_Mérope_xXx","Euh...flemme... prout d'ecrire une description","F","M",147484855);)
        db.execSQL(INSERT INTO person VALUES("Mesarthim","Louvain-La-Neuve","Gaudianna","Harmelle","1985-2-19","English","blond","black","xXx_Mesarthim_xXx","Euh...flemme... prout d'ecrire une description","M","F",58090912);)
        db.execSQL(INSERT INTO person VALUES("Mesartkhim","Mons","Gaudianne","Harménie","1906-1-27","Français","brown","blue","xXx_Mesartkhim_xXx","Euh...flemme... prout d'ecrire une description","M","F",116816771);)
        db.execSQL(INSERT INTO person VALUES("Mesartim","Louvain-La-Neuve","Gaudienne","Harménise","1944-4-13","English","other","green","xXx_Mesartim_xXx","Euh...flemme... prout d'ecrire une description","M","F",19612531);)
        db.execSQL(INSERT INTO person VALUES("Metallah","Louvain-La-Neuve","Gaudiosa","Harmicia","1915-11-25","Français","other","brown","xXx_Metallah_xXx","Euh...flemme... prout d'ecrire une description","M","B",158756540);)
        db.execSQL(INSERT INTO person VALUES("Metallakh","Charleroi","Gaudrière","Harmina","1913-10-16","Français","other","black","xXx_Metallakh_xXx","Euh...flemme... prout d'ecrire une description","F","F",204863644);)
        db.execSQL(INSERT INTO person VALUES("Mezartim","Namur","Gauthilda","Harmonia","1942-0-20","English","brown","brown","xXx_Mezartim_xXx","Euh...flemme... prout d'ecrire une description","F","M",28592977);)
        db.execSQL(INSERT INTO person VALUES("Miaplacidus","Bruxelles","Gauthilde","Harmonie","1990-10-16","Français","black","black","xXx_Miaplacidus_xXx","Euh...flemme... prout d'ecrire une description","F","M",22389827);)
        db.execSQL(INSERT INTO person VALUES("Miaplatsidus","Bruxelles","Gauvine","Harmoza","1971-4-20","English","red","green","xXx_Miaplatsidus_xXx","Euh...flemme... prout d'ecrire une description","F","M",119164983);)
        db.execSQL(INSERT INTO person VALUES("Mifrid","Namur","Gaviria","Harolda","1941-0-20","English","brown","blue","xXx_Mifrid_xXx","Euh...flemme... prout d'ecrire une description","F","B",131948214);)
        db.execSQL(INSERT INTO person VALUES("Mimosa","Mons","Gazalie","Haroldine","1933-8-7","English","other","green","xXx_Mimosa_xXx","Euh...flemme... prout d'ecrire une description","F","B",139519065);)
        db.execSQL(INSERT INTO person VALUES("Mimoza","Anvers","Gazéla","Harriette","1939-2-8","English","red","green","xXx_Mimoza_xXx","Euh...flemme... prout d'ecrire une description","M","F",116371570);)
        db.execSQL(INSERT INTO person VALUES("Minchir","Charleroi","Gazélia","Hartémise","1948-4-18","English","other","black","xXx_Minchir_xXx","Euh...flemme... prout d'ecrire une description","F","F",30735985);)
        db.execSQL(INSERT INTO person VALUES("Minelaua","Louvain-La-Neuve","Gazélie","Hattie","1924-11-15","Français","brown","blue","xXx_Minelaua_xXx","Euh...flemme... prout d'ecrire une description","F","M",239265846);)
        db.execSQL(INSERT INTO person VALUES("Minkar","Mons","Gazella","Hauviette","1926-1-12","Français","brown","green","xXx_Minkar_xXx","Euh...flemme... prout d'ecrire une description","M","M",135587945);)
        db.execSQL(INSERT INTO person VALUES("Mintaka","Bruxelles","Gaziéléa","Hayda","1934-7-10","Français","other","green","xXx_Mintaka_xXx","Euh...flemme... prout d'ecrire une description","F","F",224938528);)
        db.execSQL(INSERT INTO person VALUES("Mintika","Charleroi","Gaziella","Hazilda","1960-1-16","English","blond","brown","xXx_Mintika_xXx","Euh...flemme... prout d'ecrire une description","M","M",21490287);)
        db.execSQL(INSERT INTO person VALUES("Mira","Gand","Gazielle","Hazildée","1988-1-3","English","other","brown","xXx_Mira_xXx","Euh...flemme... prout d'ecrire une description","M","F",244340733);)
        db.execSQL(INSERT INTO person VALUES("Miram","Liege","Gazilda","Hébée","1902-9-4","Français","other","green","xXx_Miram_xXx","Euh...flemme... prout d'ecrire une description","M","M",11494064);)
        db.execSQL(INSERT INTO person VALUES("Mirac","Anvers","Gazildée","Hébernia","1948-4-5","Français","blond","blue","xXx_Mirac_xXx","Euh...flemme... prout d'ecrire une description","M","M",218537509);)
        db.execSQL(INSERT INTO person VALUES("Mirach","Charleroi","Gédalia","Hectérine","1954-0-6","Français","black","black","xXx_Mirach_xXx","Euh...flemme... prout d'ecrire une description","F","B",223575325);)
        db.execSQL(INSERT INTO person VALUES("Mirak","Namur","Gédalie","Hectorette","1914-2-1","English","black","black","xXx_Mirak_xXx","Euh...flemme... prout d'ecrire une description","M","F",142286915);)
        db.execSQL(INSERT INTO person VALUES("Mirakh","Gand","Gédégonde","Hectoria","1932-3-24","Français","blond","black","xXx_Mirakh_xXx","Euh...flemme... prout d'ecrire une description","M","B",215978863);)
        db.execSQL(INSERT INTO person VALUES("Mirfak","Charleroi","Gédélia","Hectorienne","1949-10-16","Français","red","brown","xXx_Mirfak_xXx","Euh...flemme... prout d'ecrire une description","F","F",247358617);)
        db.execSQL(INSERT INTO person VALUES("Mirphak","Anvers","Gédéline","Hectoriette","1931-0-11","English","brown","black","xXx_Mirphak_xXx","Euh...flemme... prout d'ecrire une description","M","B",125003023);)
        db.execSQL(INSERT INTO person VALUES("Mirtsam","Charleroi","Gédélise","Hectorina","1957-2-14","Français","black","blue","xXx_Mirtsam_xXx","Euh...flemme... prout d'ecrire une description","F","M",184552308);)
        db.execSQL(INSERT INTO person VALUES("Mirza","Charleroi","Gédéonne","Hectorine","1963-4-0","English","brown","brown","xXx_Mirza_xXx","Euh...flemme... prout d'ecrire une description","M","M",113172816);)
        db.execSQL(INSERT INTO person VALUES("Mirzam","Mons","Gédina","Hectorise","1947-1-3","Français","brown","green","xXx_Mirzam_xXx","Euh...flemme... prout d'ecrire une description","F","B",220320646);)
        db.execSQL(INSERT INTO person VALUES("Mismar","Bruxelles","Gédinia","Hectovie","1978-2-0","Français","black","green","xXx_Mismar_xXx","Euh...flemme... prout d'ecrire une description","F","F",203020938);)
        db.execSQL(INSERT INTO person VALUES("Misam","Anvers","Geffrine","Hédélianne","1974-6-2","Français","other","brown","xXx_Misam_xXx","Euh...flemme... prout d'ecrire une description","M","B",195008365);)
        db.execSQL(INSERT INTO person VALUES("Mitsar","Anvers","Gélénora","Hédélienne","1968-10-21","English","other","green","xXx_Mitsar_xXx","Euh...flemme... prout d'ecrire une description","F","B",171712421);)
        db.execSQL(INSERT INTO person VALUES("Mizar","Bruxelles","Gélinda","Hédémora","1993-1-6","English","black","green","xXx_Mizar_xXx","Euh...flemme... prout d'ecrire une description","M","F",104274188);)
        db.execSQL(INSERT INTO person VALUES("Mizat","Gand","Géline","Hédia","1942-4-25","English","black","black","xXx_Mizat_xXx","Euh...flemme... prout d'ecrire une description","M","M",86116407);)
        db.execSQL(INSERT INTO person VALUES("Monkar","Charleroi","Gélisée","Hédine","1979-9-23","English","other","green","xXx_Monkar_xXx","Euh...flemme... prout d'ecrire une description","F","B",36207748);)
        db.execSQL(INSERT INTO person VALUES("Motallakh","Namur","Gélisette","Hédivilda","1937-6-0","Français","other","black","xXx_Motallakh_xXx","Euh...flemme... prout d'ecrire une description","F","M",51571135);)
        db.execSQL(INSERT INTO person VALUES("Mothallah","Gand","Gelmira","Hédola","1908-10-24","English","other","green","xXx_Mothallah_xXx","Euh...flemme... prout d'ecrire une description","F","M",127252337);)
        db.execSQL(INSERT INTO person VALUES("Mufrid","Anvers","Gelna","Hédonine","1979-11-10","Français","black","blue","xXx_Mufrid_xXx","Euh...flemme... prout d'ecrire une description","F","F",121231255);)
        db.execSQL(INSERT INTO person VALUES("Mufride","Mons","Gelsémina","Hédonise","1939-8-24","English","other","brown","xXx_Mufride_xXx","Euh...flemme... prout d'ecrire une description","F","M",253378829);)
        db.execSQL(INSERT INTO person VALUES("Muhlifaïn","Namur","Géma","Hédroïge","1925-1-13","English","blond","blue","xXx_Muhlifaïn_xXx","Euh...flemme... prout d'ecrire une description","F","B",231216363);)
        db.execSQL(INSERT INTO person VALUES("Mulipheïn","Louvain-La-Neuve","Géméda","Hedwidge","1995-2-1","Français","blond","green","xXx_Mulipheïn_xXx","Euh...flemme... prout d'ecrire une description","M","B",112229122);)
        db.execSQL(INSERT INTO person VALUES("Muliphen","Gand","Gémélina","Hedwilda","1957-2-23","Français","brown","brown","xXx_Muliphen_xXx","Euh...flemme... prout d'ecrire une description","M","F",11226896);)
        db.execSQL(INSERT INTO person VALUES("Muphrid","Louvain-La-Neuve","Géméline","Hedwildée","1968-7-6","Français","brown","blue","xXx_Muphrid_xXx","Euh...flemme... prout d'ecrire une description","M","M",209928410);)
        db.execSQL(INSERT INTO person VALUES("Muphride","Mons","Gémélinia","Hélanda","1976-4-2","Français","blond","blue","xXx_Muphride_xXx","Euh...flemme... prout d'ecrire une description","F","F",170852743);)
        db.execSQL(INSERT INTO person VALUES("Murfach","Gand","Gémélinie","Hélanise","1902-5-26","Français","other","blue","xXx_Murfach_xXx","Euh...flemme... prout d'ecrire une description","F","F",38633702);)
        db.execSQL(INSERT INTO person VALUES("Murzim","Louvain-La-Neuve","Gémélise","Hélaria","1937-4-7","Français","other","green","xXx_Murzim_xXx","Euh...flemme... prout d'ecrire une description","F","F",22065874);)
        db.execSQL(INSERT INTO person VALUES("Muscida","Bruxelles","Gémila","Hélarie","1980-0-21","English","red","blue","xXx_Muscida_xXx","Euh...flemme... prout d'ecrire une description","F","F",252492828);)
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
