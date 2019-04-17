package skyla.v1;

import java.sql.*;

public class DataBase {

    public static String connection(String requete) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K."); //Indicateur du driver

            /* URL de la base de donnée */
            String url = "jdbc:postgresql://postgresql-insertthenamehere.alwaysdata.net/insertthenamehere_skyla";

            /* Utilisateur de la base de donnée */
            String user = "insertthenamehere_skyjc";

            /* Mot de passe pour se connecter a la BD */
            String passwd = "QjP8fCp";

            /* Se connecte */
            Connection co = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion effective !");

            Statement state = co.createStatement();
            //L'objet ResultSet contient le résultat de la requête SQL
            ResultSet result = state.executeQuery(requete);
            //On récupère les MetaData
            ResultSetMetaData resultMeta = result.getMetaData();

            return resultMeta.toString();
            //TODO renvoyer le resultat de la requete

        } catch (Exception e) {
            e.printStackTrace();
            return "Je n'ai pas compris";
        }
    }


}