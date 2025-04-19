import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Serveur serveur = new Serveur();
        Scanner scanner = new Scanner(System.in);

        // Pré-enregistrement de quelques clients
        serveur.ajouterClient(new Client("Alice", "Dupont", "alice@mail.com"));
        serveur.ajouterClient(new Client("Bob", "Martin", "bob@mail.com"));
        serveur.ajouterClient(new Client("Charlie", "Durand", "charlie@mail.com"));

        System.out.println("Bienvenue dans la messagerie !");
        System.out.print("Entrez votre nom pour vous connecter : ");
        String nomUtilisateur = scanner.nextLine();
        Client utilisateur = serveur.getClientParNom(nomUtilisateur);

        if (utilisateur == null) {
            System.out.println("Nom inconnu. Connexion refusée.");
            return;
        }

        System.out.println("Bonjour " + utilisateur.getPrenom() + "!");

        int choix;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Voir mes messages");
            System.out.println("2. Envoyer un message");
            System.out.println("3. Quitter");
            System.out.print("Choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // consomme le retour à la ligne

            switch (choix) {
                case 1:
                    Affichage.afficherMessagesPourClient(serveur, utilisateur.getNom());
                    break;
                case 2:
                    System.out.print("Nom du destinataire : ");
                    String destinataire = scanner.nextLine();
                    System.out.print("Contenu du message : ");
                    String contenu = scanner.nextLine();
                    serveur.envoyerMessage(utilisateur.getNom(), destinataire, contenu);
                    System.out.println("Message envoyé !");
                    break;
                case 3:
                    System.out.println("Déconnexion...");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }

        } while (choix != 3);

        scanner.close();
    }
}
