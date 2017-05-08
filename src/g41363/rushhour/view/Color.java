/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41363.rushhour.view;

/**
 *
 * @author Pedro
 */
public class Color {
    /**
     * Méthode de couleur default du BASH.
     * @return La couleur default.
     */
    private static String toDefault() {
        return "\033[0m";
    }

    /**
     * Colorie une chaine en noir.
     * @param a La chaine à colorer.
     * @return La chaine colorié.
     */
    public static String toBlack(String a) {
        return "\033[30m"+a+toDefault();
    }

    /**
     * Colorie une chaine en rouge.
     * @param a La chaine à colorer.
     * @return La chaine colorié.
     */
    public static String toRed(String a) {
        return "\033[31m"+a+toDefault();
    }

    /**
     * Colorie une chaine en vert.
     * @param a La chaine à colorer.
     * @return La chaine colorié.
     */
    public static String toGreen(String a) {
        return "\033[32m"+a+toDefault();
    }

    /**
     * Colorie une chaine en jaune.
     * @param a La chaine Ã  colorer.
     * @return La chaine colorÃ©e.
     */
    public static String toYellow(String a) {
        return "\033[33m"+a+toDefault();
    }

    /**
     * Colorie une chaine en bleu.
     * @param a La chaine à colorer.
     * @return La chaine colorié.
     */
    public static String toBlue(String a) {
        return "\033[34m"+a+toDefault();
    }

    /**
     * Colorie une chaine en mauve.
     * @param a La chaine à colorer.
     * @return La chaine colorié.
     */
    public static String toPurple(String a) {
        return "\033[35m"+a+toDefault();
    }

    /**
     * Colorie une chaine en cyan.
     * @param a La chaine à colorer.
     * @return La chaine colorié.
     */
    public static String toCyan(String a) {
        return "\033[36m"+a+toDefault();
    }

    /**
     * Colorie une chaine en blanc.
     * @param a La chaine à colorer.
     * @return La chaine colorié.
     */
    public static String toWhite(String a) {
        return "\033[37m"+a+toDefault();
    }
}
