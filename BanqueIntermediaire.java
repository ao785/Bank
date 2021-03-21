import java.util.ArrayList;

public class BanqueIntermediaire implements Banque {
	
	private String nom;
	private ArrayList<CompteBancaire> tab_compte_bancaire;
	
	//Constructeurs
	public BanqueIntermediaire() {
		
	}
	
	public BanqueIntermediaire(String n, ArrayList<CompteBancaire> tcb) {
		this.nom = n;
		this.tab_compte_bancaire = tcb;
	}
	
	//getters/setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<CompteBancaire> getTab_compte_bancaire() {
		return tab_compte_bancaire;
	}

	public void setTab_compte_bancaire(ArrayList<CompteBancaire> tab_compte_bancaire) {
		this.tab_compte_bancaire = tab_compte_bancaire;
	}
	
	//methods
	@Override
	public CompteBancaire chercherCompte(int num) {
		// TODO Auto-generated method stub
		CompteBancaire compte_voulu = null;
		for (int i = 0; i<this.tab_compte_bancaire.size(); i++) {
			if (this.tab_compte_bancaire.get(i).getNumero_compte() == num) {
				compte_voulu = tab_compte_bancaire.get(i);
			}
		}
		return compte_voulu;
	}

	@Override
	public void AjouterCompte(CompteBancaire cpt) {
		// TODO Auto-generated method stub
		this.tab_compte_bancaire.add(cpt);
	}

	@Override
	public void SupprimerCompte(int num) {
		// TODO Auto-generated method stub
		for (int i=0; i<this.tab_compte_bancaire.size(); i++) {			
			if (this.tab_compte_bancaire.get(i).getNumero_compte() == num) {
				this.tab_compte_bancaire.remove(this.tab_compte_bancaire.get(i));
			}
		}
	}
	
}
