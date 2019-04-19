package skyla.v1;

import java.sql.*;

public class DataBase {



    public static String envoiSelect(String requete) {

        String aRetourner;
        try {
            Class.forName("org.postgresql.Driver");
            // System.out.println("Driver O.K."); //Indicateur du driver

            /* URL de la base de donnée */
            String url = "jdbc:postgresql://postgresql-insertthenamehere.alwaysdata.net/insertthenamehere_skyla";

            /* Utilisateur de la base de donnée */
            String user = "insertthenamehere_skyjc";

            /* Mot de passe pour se connecter a la BD */
            String passwd = "QjP8fCp";

            /* Se connecte */
            Connection co = DriverManager.getConnection(url, user, passwd);
            //System.out.println("Connexion effective !");

            Statement state = co.createStatement();
            //L'objet ResultSet contient le résultat de la requête SQL
            ResultSet result = state.executeQuery(requete);
            //On récupère les MetaData
            ResultSetMetaData resultMeta = result.getMetaData();

            result.next();
            aRetourner = result.getString(1);


            result.close();
            state.close();

            return aRetourner;

        } catch (Exception e) {
            //e.printStackTrace();
            return "Je n'ai pas compris";
        }
    }

    public static void affichageCategorie() {

        try {
            Class.forName("org.postgresql.Driver");
            // System.out.println("Driver O.K."); //Indicateur du driver

            /* URL de la base de donnée */
            String url = "jdbc:postgresql://postgresql-insertthenamehere.alwaysdata.net/insertthenamehere_skyla";

            /* Utilisateur de la base de donnée */
            String user = "insertthenamehere_skyjc";

            /* Mot de passe pour se connecter a la BD */
            String passwd = "QjP8fCp";

            /* Se connecte */
            Connection co = DriverManager.getConnection(url, user, passwd);
            //System.out.println("Connexion effective !");

            //Création d'un objet Statement
            Statement state = co.createStatement();
            //L'objet ResultSet contient le résultat de la requête SQL
            ResultSet result = state.executeQuery("SELECT * FROM t_categorie");
            //On récupère les MetaData
            ResultSetMetaData resultMeta = result.getMetaData();

            System.out.println("\n**********************************");
            //On affiche le nom des colonnes
            for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");

            System.out.println("\n**********************************");

            while(result.next()){
                for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                    System.out.print("\t" + result.getObject(i).toString() + "\t |");

                System.out.println("\n---------------------------------");

            }


            result.close();
            state.close();

        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Connection impossible");
        }
    }


}