import java.util.ArrayList;

public class Serveur {
    private ArrayList<Client> listeDeClient;
    private ArrayList<Messagerie> messageries;

    public Serveur() {
        listeDeClient = new ArrayList<Client>();
        messageries = new ArrayList<Messagerie>();
    }

    public void ajouterClient(Client c) {
        listeDeClient.add(c);
        messageries.add(new Messagerie(c));
    }

    public Client getClientParNom(String nom) {
        for (Client c : listeDeClient) {
            if (c.getNom().equals(nom)) {
                return c;
            }
        }
        return null;
    }

    public Messagerie getMessagerieParClient(Client c) {
        for (Messagerie m : messageries) {
            if (m.getClient().equals(c)) {
                return m;
            }
        }
        return null;
    }

    public void envoyerMessage(String nomExpediteur, String nomDestinataire, String contenu) {
        Client expediteur = getClientParNom(nomExpediteur);
        Client destinataire = getClientParNom(nomDestinataire);

        if (expediteur == null || destinataire == null) {
            System.out.println("Client non trouvé.");
            return;
        }

        Message message = new Message(expediteur, destinataire, contenu);
        Messagerie messagerieDest = getMessagerieParClient(destinataire);
        if (messagerieDest != null) {
            messagerieDest.ajouterMessage(message);
        }
    }

    public void afficherMessagesPourClient(String nomClient) {
        Client c = getClientParNom(nomClient);
        Messagerie m = getMessagerieParClient(c);
        if (m != null) {
            ArrayList<Message> messages = m.getListeMessagesDuClient();
            if (messages.isEmpty()) {
                System.out.println(nomClient + " n’a aucun message.");
            } else {
                for (Message msg : messages) {
                    System.out.println("De : " + msg.getClientEnvoyeur().getNom() + " | Message : " + msg.getMessage());
                }
            }
        }
    }
}
