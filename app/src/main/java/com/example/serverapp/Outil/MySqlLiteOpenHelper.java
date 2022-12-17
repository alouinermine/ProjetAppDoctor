package com.example.serverapp.Outil;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Nullable;
public class MySqlLiteOpenHelper extends SQLiteOpenHelper {



        //propriètés
        private String creation = "create table patient ("
                + "Date TEXT PRIMARY KEY,"
                + "taille TEXT NOT NULL,"
                + "poids TEXT NOT NULL)";

        public MySqlLiteOpenHelper(@Nullable Context context, @Nullable String
                name, @Nullable SQLiteDatabase.CursorFactory factory, int version)
        {
            super(context, name, factory, version);
        }
        /**
         * Si changement de la BD
         * @param sqLiteDatabase
         */
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase)
        {
            sqLiteDatabase.execSQL(creation);
        }
        /**
         * SI changement de la version
         * @param sqLiteDatabase
         * @param i // pour l'ancien version
         * @param i1 // la nouvelle version
         */
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        }
    }

