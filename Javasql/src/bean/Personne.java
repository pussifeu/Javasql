/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author NJAKA
 */

/** Cette classe est la representation du table personne dans la base de donnees **/
public class Personne {
    private int id;
    private String nom;
    private String adresse;

    public Personne() {
    }

    public Personne(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    public Personne(int id, String nom, String adresse) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
}
