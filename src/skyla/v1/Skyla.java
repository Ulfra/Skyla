package skyla.v1;

import java.util.Scanner;

/**
 * Prototype d'int�ligence artifielle
 * Gestion de l'apprentissage dans un fichier texte
 * @author Jean-Charles Luans
 * @version 1.0
 */
public class Skyla {

    /**
     * Doit converser avec l'utilisateur
     * Gestion des erreurs de saisie, si l'IA ne comprend pas
     * @param args non utilis�
     */
    public static void main(String[] args) {

        Scanner entree = new Scanner(System.in);

        String reponce; //R�ponce de l'utilisateur
        boolean ok;     //Indicateur pour continuer la conversation

        System.out.println("Bonjour, je suis Skyla, voulez-vous entamer la conversation ?");
        System.out.print("==> ");
        reponce = entree.nextLine();

        ok = reponce.equals("oui");

        System.out.println(ok);

    }

    /**
     * Convertie une r�ponce de l'utilisateur entierement en minuscule
     * @param aConvertir : le striing a convertir
     * @return la string entr�e entierement en minuscule
     */
    public static String enMinuscule(String aConvertir) {
        //TODO convertir l'entrer en minuscule
    }
}
