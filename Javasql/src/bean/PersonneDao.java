/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PUSSIFEU
 */
public class PersonneDao {

    public ArrayList<Personne> selectAllPersonne() {
        ArrayList<Personne> liste = new ArrayList<Personne>();
        Connection conn = Connexion.ouvrirConnexion();
        ResultSet resmet = Connexion.selectDonnees(conn, "SELECT * FROM personne");
        try {
            while (resmet.next()) {
                liste.add(new Personne(resmet.getInt("id"), resmet.getString("nom"), resmet.getString("adresse")));
            }

            resmet.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println("erreur-na SQL metier");
            ex.printStackTrace();
        }
        return liste;
    }

    public void insertOnePersonne(Personne pers) {
        try {
            Connection conn = Connexion.ouvrirConnexion();
            Connexion.majDonnees(conn, "INSERT INTO personne(nom,adresse)"
                    + " VALUES('" + pers.getNom() + "','" + pers.getAdresse() + "')");
          
            conn.close();
        } catch (Exception ex) {
            System.out.println("erreur-na SQL");
            ex.printStackTrace();
          
        }
    }
}
