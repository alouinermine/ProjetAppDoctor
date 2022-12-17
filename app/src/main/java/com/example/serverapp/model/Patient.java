package com.example.serverapp.model;
import java.io.Serializable;
import java.util.Date;
public class Patient implements Serializable  {
        private double taille;
        private double poids;
        private Date Date;
        public Patient(Date Date, double taille, double poids) {
            this.taille = taille;
            this.poids= poids;
            this.Date =Date;
        }
        public double getTaille() {
            return taille ;
        }
        public double getPoids() {
            return poids;
        }
        public Date getDate(){return Date;}
    }

