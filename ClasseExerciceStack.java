package projet_piles;

import java.util.Stack;

public class ClasseExerciceStack {

    public static void main(String[] args) {

        // 1. Créer une pile générique (Object)
        Stack<Object> pile = new Stack<>();

        // 1 ajouter une cravate de code "718" dans la pile
        pile.push(new Cravate("718"));

        // 2 ajouter une cravate de code "22" dans la pile
        pile.push(new Cravate("22"));

        // 3 ajouter un maillot de code "123" et taille "M"
        pile.push(new Maillot("123", "M"));

        // 4 afficher le nombre d'objets dans la pile
        System.out.println("Nombre d'objets dans la pile : " + pile.size());

        // 5 créer une deuxième pile identique à la première (clone)
        @SuppressWarnings("unchecked")
        Stack<Object> pile2 = (Stack<Object>) pile.clone();

        // 6 retirer un par un les objets de la pile originale et calculer total des prix
        double totalPrix = 0;
        while (!pile.isEmpty()) {
            Object obj = pile.pop();
            if (obj instanceof Article) {
                totalPrix += ((Article) obj).getPrix();
            }
        }
        System.out.println("Total prix retirés de la pile originale : " + totalPrix);

        // 7 créer une pile ne contenant que des Articles
        Stack<Article> pileArticles = new Stack<>();

        // 8 ajouter un objet Cravate code "565" à cette pile
        pileArticles.push(new Cravate("565"));  // OK

        // 9 essayer d'ajouter un String (décommente pour voir erreur)
//      pileArticles.push("Une chaîne");  // NON, compile error

        // 10 ajouter deux autres cravates code "456" et "242"
        pileArticles.push(new Cravate("456"));
        pileArticles.push(new Cravate("242"));

        // 11 retirer un par un et calculer total des prix
        double totalPrix2 = 0;
        while (!pileArticles.isEmpty()) {
            Article art = pileArticles.pop();
            totalPrix2 += art.getPrix();
        }
        System.out.println("Total prix retirés de la pile Articles : " + totalPrix2);

        // 12 utiliser search pour trouver la position de la cravate "22" dans la pile2
        Cravate rechercheCravate22 = new Cravate("22");
        int position22 = pile2.search(rechercheCravate22);
        System.out.println("Position cravate '22' dans pile2 : " + position22);

        // Rechercher cravate absente ("999")
        Cravate rechercheCravate999 = new Cravate("999");
        int position999 = pile2.search(rechercheCravate999);
        System.out.println("Position cravate '999' dans pile2 (absente) : " + position999);
    }
}
