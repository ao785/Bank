
public class PersonneMorale extends Personne {
	
	//attributs
	
	private String nomCommercial;
	
	//Constructeurs
	
	public PersonneMorale() {
			
	}
	
	public PersonneMorale(String nom, String prenom, String nomCommercial) {
		super(nom,prenom);
		this.nomCommercial = nomCommercial;
	}
	
	//getters & setters
	
	public String getNomCommercial() {
		return this.nomCommercial;
	}
	
	public void setNomCommercial(String nomCommercial) {
		this.nomCommercial = nomCommercial;
	}
}
