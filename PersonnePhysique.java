
public class PersonnePhysique extends Personne {
	
	//attributs 
	
	private int pointFidelite;
	
	//Constructeurs
	
	public PersonnePhysique() {
		
	}
	
	public PersonnePhysique(String nom, String prenom, int pointFidelite) {
		super(nom,prenom);
		this.pointFidelite = pointFidelite;
	}
	
	//getters & setters
	
	public int getPointFidelite() {
		return this.pointFidelite;
	}
	
	public void setPointFidelite(int pointFidelite) {
		this.pointFidelite = pointFidelite;
	}
}
