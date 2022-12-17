package com.example.serverapp.controler;

import android.content.Context;
import com.example.serverapp.model.AccesLocal;
import com.example.serverapp.model.Patient;
import com.example.serverapp.Outil.Serializer;
import java.util.Date;
public final class HomeControler {
    private static HomeControler instance = null;
    private static Patient patient;
    //Nom du fichier
    private static String nonFichier = "savePatient";
    private static AccesLocal accesLocal;
    private HomeControler(){
        super();
    }
    public static final HomeControler getInstance(Context context)
    {
        if(HomeControler.instance == null) {
            HomeControler.instance = new HomeControler();
// recupeSerialize(context);
            accesLocal=new AccesLocal(context);
//récuper
            patient=accesLocal.recupDernier();
        }
        return HomeControler.instance;
    }
    public void createPatient (double taille, double poids,
                               Context context)
    {
        patient = new Patient( new Date(),taille,poids);

        accesLocal.ajout(patient);
    }
    /**
     * Récuparation de l'objet sérailiser càd players
     * @param context
     */
    private static void recupeSerialize(Context context)
    {
        patient = (Patient) Serializer.deSerialize(nonFichier,context);
    }
    public double getTaille()
    {
        if(patient == null) return 0;
        return patient.getTaille();
    }
    public double getPoids()
    {
        if(patient== null) return 0;
        return patient.getPoids();
    }
}
