package skyla.v1;

import java.util.Random;
import java.util.Scanner;

/**
 * Prototype d'int?ligence artifielle
 * Gestion de l'apprentissage dans un fichier texte
 * @author Jean-Charles Luans
 * @version 1.0
 */
public class Skyla {

    /**
     * Doit converser avec l'utilisateur
     * Gestion des erreurs de saisie, si l'IA ne comprend pas
     * @param args non utilis?
     */
    public static void main(String[] args) {

        String reponce,         // Réponce de l'utilisateur
               resultatRequete, // Ce que dit la machine
               aTraiter;        // Réponce que va traiter la machine

        int id,                 // Id de la requete
            nombreAleatoire;

        boolean ok;             // Indicateur pour continuer la conversation

        /* Compte le nombre de reponce possible */
        resultatRequete = DataBase.connection(
                "Select COUNT(reponse) FROM t_reponses WHERE id_question=1");

        id = Integer.parseInt(resultatRequete);

        nombreAleatoire = aleatoire(1, id);

        resultatRequete = DataBase.connection(
                "Select reponse FROM t_reponses WHERE id_reponse="+nombreAleatoire);

        System.out.println(resultatRequete +" Je suis Skyla, voulez-vous entamer la conversation ?");
        reponce = saisieUser();
        ok = reponce.equals("oui");
        while (ok) {
            System.out.println("Avons-nous finis de discuter ?");
            ok = !saisieUser().equals("oui");
        }


    }

    /**
     * Convertie une réponce de l'utilisateur entierement en minuscule
     * @return la string entrée entierement en minuscule
     */
    public static String saisieUser() {
        System.out.print("==> ");
        Scanner entree = new Scanner(System.in);
        String aConvertir;
        aConvertir = entree.nextLine();
        return aConvertir.toLowerCase();
    }

    /**
     * Genere un nombre aléatoire dans un intervalle
     * @param min : minimum de l'intervale
     * @param max : maximum de l'intervale
     * @return un nombre aléatoire
     */
    public static int aleatoire(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
