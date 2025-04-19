public class Client {
    private static int compteurId = 0;
    private int idClient;
    private String nom;
    private String prenom;
    private String adresseEmail;

    public Client(String nom, String prenom, String adresseEmail) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresseEmail = adresseEmail;
        this.idClient = compteurId++;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresseEmail() {
        return adresseEmail;
    }

    public int getIdClient() {
        return idClient;
    }
}
