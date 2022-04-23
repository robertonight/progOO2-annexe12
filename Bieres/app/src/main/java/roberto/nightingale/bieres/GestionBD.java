package roberto.nightingale.bieres;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Vector;

public class GestionBD extends SQLiteOpenHelper {

    private static GestionBD instance;
    private static SQLiteDatabase database;

    public GestionBD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        openDB();
    }

    @Override
    public void onCreate(SQLiteDatabase db) { // est appel/ au tout debut
        db.execSQL("CREATE TABLE evaluations (_id INTEGER PRIMARY KEY AUTOINCREMENT, nom TEXT, etoiles REAL, microbrasserie TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS evaluations");
        onCreate(db);
    }

    public static GestionBD getInstance(Context context) {
        if (instance == null)
            instance = new GestionBD(context, "db", null, 1);
        return instance;
    }

    public void ajouterEvaluation(Evaluation evaluation) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nom", evaluation.getNom());
        contentValues.put("microbrasserie", evaluation.getMicrobrasserie());
        contentValues.put("etoiles", evaluation.getEtoiles());
        database.insert("evaluations", null, contentValues);
    }

    public void openDB() {
        database = this.getWritableDatabase();
    }

    public void closeDB() {
        database.close();
    }

    public Vector<String> retournerMeilleurs(){
        Cursor c;
        int i = 0;
        Vector<String> v = new Vector<>();
        c = database.query("evaluations", new String[]{"nom"}, null, null, null, null,"nbEtoiles DESC", "3");
        c = database.rawQuery("SELECT nom FROM evaluations ORDER BY nbEtoiles DESC LIMIT 3", null);

        while (i<3){
            c.moveToNext();
            v.add(c.getString(0));
            i++;
        }
        return v;
    }

}
