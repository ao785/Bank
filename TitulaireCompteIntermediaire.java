import java.util.ArrayList;

public class TitulaireCompteIntermediaire implements TitulaireCompte {

	//attributs 
	private String nomTitulaire, prenomTitulaire;
	private String adresseContact;	
	private ArrayList<PersonneMorale> liste_personne_morales; 
	private ArrayList<PersonnePhysique> liste_personne_physiques;
	
	//Constructeurs
	public TitulaireCompteIntermediaire() {
		
	}
	
	public TitulaireCompteIntermediaire(String nomTitulaire, String prenomTitulaire, String adresseContact, ArrayList<PersonneMorale> liste_personne_morales,ArrayList<PersonnePhysique> liste_personne_physiques) {
		this.nomTitulaire = nomTitulaire;
		this.prenomTitulaire = prenomTitulaire;
		this.adresseContact = adresseContact;
		this.liste_personne_morales = liste_personne_morales;
		this.liste_personne_physiques = liste_personne_physiques;
	}
	
	//getters & setters
	
	public String getNomTitulaire() {
		return this.nomTitulaire;
	}
	
	public String getPrenomTitulaire() {
		return this.prenomTitulaire;
	}
	
	public String getAdresseContact() {
		return this.adresseContact;
	}
	
	public ArrayList<PersonneMorale> getListePersonneMorales() {
		return this.liste_personne_morales;
	}
	
	public ArrayList<PersonnePhysique> getListePersonnePhysiques() {
		return this.liste_personne_physiques;
	}
	
	public void setNomTitulaire(String nomTitulaire) {
		this.nomTitulaire = nomTitulaire;
	}
	
	public void setPrenomTitulaire(String prenomTitulaire) {
		this.prenomTitulaire = prenomTitulaire;
	}
	
	public void setAdresseContact(String adresseContact) {
		this.adresseContact = adresseContact;
	}
	
	public void setListePersonneMorales(ArrayList<PersonneMorale> liste_personne_morales) {
		this.liste_personne_morales = liste_personne_morales;
	}
	
	public void setListePersonnePhysiques(ArrayList<PersonnePhysique> liste_personne_physiques) {
		this.liste_personne_physiques = liste_personne_physiques;
	}
	
	//methods
	public void ajouterPersonneMorale(PersonneMorale personne_morale) {
		this.liste_personne_morales.add(personne_morale);
	}
	
	public void ajouterPersonnePhysique(PersonnePhysique personne_physique) {
		this.liste_personne_physiques.add(personne_physique);
	}
}
