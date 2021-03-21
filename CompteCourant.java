import java.util.Date;

public class CompteCourant extends CompteBancaire {
	
	public CompteCourant() {
	}
	
	public CompteCourant(int nc, String n, String p, double s, Date d, double[] tc) {
		super(nc,n,p,s,d,tc);
	}
	
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
		double nouveau_solde = this.getSolde();
		double pourcentage_agios = 7;
		if (this.getSolde() < 0) {
			double agios = (Math.abs(this.getSolde())*pourcentage_agios*0.01)/365;
			this.setSolde(nouveau_solde - agios);
		}
			
	}
	
	
}
