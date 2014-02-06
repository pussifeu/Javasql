/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import bean.Personne;
import bean.PersonneDao;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PUSSIFEU
 */
public class Main {

    /**
     * Methode qui charge l'affichage des messages
     * @param message 
     */
    private static void affiche(String message) {
        System.out.println(message);
    }

    /**
     * Methode qui charge les des personnes a la base de donnes
     */
    public static void liste() {
        PersonneDao requete = new PersonneDao();
        ArrayList<Personne> liste = requete.selectAllPersonne();
        for (int i = 0; i < liste.size(); i++) {
            affiche("Id:" + liste.get(i).getId() + "\tNom:" + liste.get(i).getNom() + "\tAdresse:" + liste.get(i).getAdresse());
        }
    }

    /**
     * Methode qui charge l'ajout des nouveaux personnes a la base de donnes
     */
    public static void ajout() {
        PersonneDao requete = new PersonneDao();
        Scanner sc = new Scanner(System.in);
        affiche("Saisir nom:");
        String nom = sc.nextLine();
        affiche("Saisir adresse:");
        String ardresse = sc.nextLine();
        Personne personne = new Personne(nom, ardresse);
        requete.insertOnePersonne(personne);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        affiche("Listes des personnes avant ajout dans la base de donnes:");
        liste();
        affiche("Insertion des nouvelles données dans la base de donnees:");
        ajout();
        affiche("Listes des personnes apres ajout dans la base de donnes:");
        liste();
        
    }
}
