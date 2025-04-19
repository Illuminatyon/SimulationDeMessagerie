import java.util.ArrayList;

public class Messagerie {

    private Client client;
    private ArrayList<Message> listeMessagesDuClient;

    public Messagerie(Client client) {
        this.client = client;
        this.listeMessagesDuClient = new ArrayList<Message>();
    }

    public void ajouterMessage(Message message) {
        this.listeMessagesDuClient.add(message);
    }

    public ArrayList<Message> getListeMessagesDuClient() {
        return this.listeMessagesDuClient;
    }

    public ArrayList<Message> getListeMessageAvecAdresseMail(String adresseMail){
        ArrayList<Message> listeDeMessage = new ArrayList<Message>();
        for (Message message : this.listeMessagesDuClient) {
            if (message.getClientDestinataire().getAdresseEmail().equals(adresseMail)) {
                listeDeMessage.add(message);
            }
        }
        return listeDeMessage;
    }

    public Client getClient() {
        return client;
    }


    public ArrayList<Message> getListeMessageAvecIdClient(int idClient){
        ArrayList<Message> listeDeMessage = new ArrayList<Message>();
        for (Message message : this.listeMessagesDuClient) {
            if (message.getClientDestinataire().getIdClient() == idClient) {
                listeDeMessage.add(message);
            }
        }
        return listeDeMessage;
    }

}
