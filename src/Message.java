public class Message {

    private Client clientEnvoyeur;
    private Client clientDestinataire;
    private String message;

    public Message(Client clientEnvoyeur, Client clientDestinataire, String message) {
        this.clientEnvoyeur = clientEnvoyeur;
        this.clientDestinataire = clientDestinataire;
        this.message = message;
    }

    public Client getClientEnvoyeur() {
        return clientEnvoyeur;
    }

    public void setClientEnvoyeur(Client clientEnvoyeur) {
        this.clientEnvoyeur = clientEnvoyeur;
    }

    public Client getClientDestinataire() {
        return clientDestinataire;
    }

    public String getMessage() {
        return message;
    }
}
