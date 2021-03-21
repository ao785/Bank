

public interface Banque {
	
	//methods
	
	public CompteBancaire chercherCompte(int num);
	
	public void AjouterCompte(CompteBancaire cpt);
	
	public void SupprimerCompte(int num);
	
}
