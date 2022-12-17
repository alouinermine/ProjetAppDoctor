package com.example.serverapp.model;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.serverapp.Outil.MySqlLiteOpenHelper;
import java.util.Date;


public class AccesLocal {
        //propriétés
        private String baseName ="bdPatientSQLite";
        private Integer baseVersion =1 ; // version de la BD
        private MySqlLiteOpenHelper accesBD;
        private SQLiteDatabase db;
        /**
         * Constructeur
         * @param context
         */
        public AccesLocal(Context context){
            accesBD = new MySqlLiteOpenHelper(context, baseName, null, baseVersion);
        }

        public void ajout (Patient patient){
            db=accesBD.getWritableDatabase();
            String req="insert into patient (Date, taille, poids) values";
            req+="(\""+ patient.getDate()+ "\",\"" +
                    patient.getTaille()+ "\",\"" + patient.getPoids()+"\")";
            db.execSQL(req);
        }
        /**
         * Récupération du derniers noms de joueurs (players) de la DB
         */
        public Patient recupDernier(){
            db = accesBD.getReadableDatabase();
            Patient patient = null;
            String req = "select * from patient"; // récuppérer tous les patient
            Cursor curseur =db.rawQuery(req, null); // lire ligne par ligne
            curseur.moveToLast();
            if (!curseur.isAfterLast()) {
                double taille = curseur.getDouble(1);
                double poids = curseur.getDouble(2);
                patient=new Patient(new Date(),taille,poids);
            }
            curseur.close();
            return patient;
        }
    }

