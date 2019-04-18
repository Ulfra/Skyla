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
     * Recupereune r�ponce de l'utilisateur et la
     * convertie entierement en minuscule
     * @return la string entr�e entierement en minuscule
     */
    public static String saisieUser() {
        System.out.print("==> ");
        Scanner entree = new Scanner(System.in);
        String aConvertir;
        aConvertir = entree.nextLine();
        return aConvertir.toLowerCase();
    }


    /**
     * Genere un nombre al�atoire dans un intervalle
     * @param min : minimum de l'intervale
     * @param max : maximum de l'intervale
     * @return un nombre al�atoire
     */
    public static int aleatoire(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }


    /**
     * Verifie si la chaine de chararctere est connu dans la base
     * de donn�es
     * @param aVerifier : resultat a v�rifier
     * @return true si le resultat est connue
     */
    public static boolean estConnue(String aVerifier) {

        String resultat;

        resultat = DataBase.envoiSelect(
                "Select COUNT(question) FROM t_question WHERE question='"+aVerifier+'\'');

        return !(Integer.parseInt(resultat) == 0);
    }

    /**
     * Determine la cat�gorie de la question
     * @param aChercher question dont on cherche la cat�gorie
     * @return le numero de la cat�gorie de la question
     */
    public static int getID(String aChercher) {

        String resultat;

        resultat = DataBase.envoiSelect(
                "Select categorie FROM t_question WHERE question='"+aChercher+'\'');
        return Integer.parseInt(resultat);

    }


    /**
     * Systeme de reponces de l'IA
     * @param categorie : id de la cat�gorie de la question de l'user
     * @return la reponce de l'IA
     */
    public static String repondre(int categorie) {

        String resultatRequete; // Resultat des requetes a traiter
        int nbReponce,          // Nombre de reponses possible en fonction de la cat�gorie
            nbAlea;             // ID generer al�atoirement de la r�ponse

        /* Compte le nombre de reponses possible dans cette cat�gorie */
        resultatRequete = DataBase.envoiSelect(
                "Select COUNT(reponse) FROM t_reponses WHERE categorie="+categorie);

        /* Conversion de l'ID en int */
        nbReponce = Integer.parseInt(resultatRequete);

        nbAlea = aleatoire(1, nbReponce);

        resultatRequete = DataBase.envoiSelect(
                "Select reponse FROM t_reponses WHERE id_reponse="+nbAlea +" AND categorie="+categorie);

        return  resultatRequete;
    }

    /**
     * Doit converser avec l'utilisateur
     * Gestion des erreurs de saisie, si l'IA ne comprend pas
     * @param args non utilis?
     */
    public static void main(String[] args) {

        String reponseUser,  // R�ponce de l'utilisateur
               reponseIa;   // R�ponses de l'IA

        Boolean ok;         // Indicateur de discution

        int categorieQuestion;

        reponseIa = repondre(1);

        System.out.println(reponseIa +" Je suis Skyla, voulez-vous entamer la conversation ?");
        reponseUser = saisieUser();
        ok = reponseUser.equals("oui");
        System.out.println("Je suis heureuse de discuter avec vous !");
        while (ok) {
            reponseUser = saisieUser();
            if (estConnue(reponseUser)) {
                categorieQuestion = getID(reponseUser);
            } else {
                categorieQuestion = 0;
            }
            reponseIa = repondre(categorieQuestion);
            System.out.println(reponseIa);


            System.out.println("Avons-nous finis de discuter ?");
            ok = !saisieUser().equals("oui");
        }


    }


}

