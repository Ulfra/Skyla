package skyla.v1;

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

        String reponce;  // Réponce de l'utilisateur
        String dire;     // Ce que dit la machine
        String aTraiter; // Réponce que va traiter la machine
        boolean ok;      // Indicateur pour continuer la conversation

        /* Connection a la BD */
        dire = DataBase.connection("Select * FROM t_reponses");
        // TODO recuperer seulement le bon chemps

        System.out.println(dire +" je suis Skyla, voulez-vous entamer la conversation ?");
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
}
