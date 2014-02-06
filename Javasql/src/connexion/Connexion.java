package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author NJAKA
 */
/**Cette classe est utilisé pour la connexion dans la base de donnees **/
public class Connexion {

    private static Connection connection = null;
    private static Statement statment = null;
    private static ResultSet resultset = null;
    private static int resultat = 0;
    private static String driver = "com.mysql.jdbc.Driver", //Charge le driver MySQL
            base = "jdbc:mysql://localhost/essai", //Charge la base de données
            user = "root", //super utilisateur de la base de données
            password = "";  //mot de passe du super utilisateur

    /*
     * Constructeur 
     */
    public Connexion() {
    }

    /*
     * Ouverture de la connexion / accès à la base
     */
    public static Connection ouvrirConnexion() {
        try {
            Class.forName(driver); //chargement du driver
            connection = DriverManager.getConnection(base, user, password); //connexion à la base
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return connection; //récuperation de la connexion

    }

    /*
     * Mise à jour des données
     */
    public static int majDonnees(Connection conn, String requete) {
        try {
            statment = conn.createStatement(); //création d'un statement
            resultat = statment.executeUpdate(requete); //execution de la requete
            statment.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return resultat; //récuperation du resultat
    }

    /*
     * Séléction des données
     */
    public static ResultSet selectDonnees(Connection conn, String requete) {
        try {
            statment = conn.createStatement(); //création d'un statement
            resultset = statment.executeQuery(requete); //execution de la requete
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return resultset; //récuperation des données
    }
}