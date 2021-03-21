import java.util.Date;

public class CompteEpargne extends CompteBancaire {
	//attributs
	private double taux_interet;
	
	//Constructeurs
	public CompteEpargne() {
	}
	
	public CompteEpargne(int nc, String n, String p, double s, Date d, double[] tc, double ti) {
		super(nc,n,p,s,d,tc);
		this.taux_interet = ti;
	}
	//getters / setter
	
	public double getTaux_interet() {
		return this.taux_interet;
	}
	
	public void setTaux_interet(double taux_interet) {
		this.taux_interet = taux_interet;
	}
	//methods
	
	public void crediter(double mont) {
		double solde_intermediaire = 0;
		solde_intermediaire = mont + this.getSolde();
		double[] tab_intermediaire = this.getTraces_compte();
		for (int i = 0; i< tab_intermediaire.length;i++) {
			if (tab_intermediaire[i] == 0 ) {
				tab_intermediaire[i] = solde_intermediaire;
				this.setTraces_compte(tab_intermediaire);
				break;
			}
		}
		this.setSolde(solde_intermediaire);
	}
	
	public void debiter(double mont) {
		double solde_actuel = this.getSolde();
		solde_actuel = solde_actuel - mont;
		double[] tab_intermediaire = this.getTraces_compte();
		this.setSolde(solde_actuel);
		for (int i = 0; i<tab_intermediaire.length;i++) {
			if (tab_intermediaire[i] == 0 ) {
				tab_intermediaire[i] = solde_actuel;
				break;
			}
		}
		this.setTraces_compte(tab_intermediaire);
		
	}
	
	public void traitementQuotidien() {
		double solde_actuel = this.getSolde();	
		this.setSolde(((solde_actuel*this.taux_interet*0.01)/365) + solde_actuel);
	}
	
}
