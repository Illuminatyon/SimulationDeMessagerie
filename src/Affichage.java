import java.util.ArrayList;

public class Affichage {

    public static void afficherMessagesPourClient(Serveur serveur, String nomClient) {
        Client c = serveur.getClientParNom(nomClient);
        if (c == null) {
            System.out.println("Client " + nomClient + " non trouvé.");
            return;
        }

        Messagerie m = serveur.getMessagerieParClient(c);
        if (m == null) {
            System.out.println("Messagerie non trouvée pour le client " + nomClient);
            return;
        }

        ArrayList<Message> messages = m.getListeMessagesDuClient();
        if (messages.isEmpty()) {
            System.out.println(nomClient + " n’a aucun message.");
        } else {
            System.out.println("Messages pour " + nomClient + " :");
            for (Message msg : messages) {
                System.out.println("- De : " + msg.getClientEnvoyeur().getNom() + " | Message : " + msg.getMessage());
            }
        }
    }
}
