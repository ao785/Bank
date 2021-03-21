import java.util.Date;

public abstract class CompteBancaire {
	//attributs
	private int numero_compte;
	private String nom, prenom;
	private double solde;
	private Date date_ouverture;
	private double[] traces_compte = new double[100];
	
	//Constructeurs
	public CompteBancaire() {
		this.date_ouverture = new Date();
	}
	
	public CompteBancaire(int nc, String n, String p, double s, Date d, double[] tc) {
		this.numero_compte = nc;
		this.nom = n;
		this.prenom = p;
		this.solde = s;
		this.date_ouverture = d;
		this.traces_compte = tc;
	}
	
	//getters & setters
	public int getNumero_compte() {
		return numero_compte;
	}

	public void setNumero_compte(int numero_compte) {
		this.numero_compte = numero_compte;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Date getDate_ouverture() {
		return date_ouverture;
	}

	public void setDate_ouverture(Date date_ouverture) {
		this.date_ouverture = date_ouverture;
	}

	public double[] getTraces_compte() {
		return traces_compte;
	}

	public void setTraces_compte(double[] traces_compte) {
		this.traces_compte = traces_compte;
	}
	
	//methods
	
	public abstract void crediter(double mont);
	public abstract void debiter(double mont);
	
}
