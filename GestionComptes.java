import java.util.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class GestionComptes {
	
	//Conditions des exceptions
	public static void tauxInteretValide(double tauxInteret) throws TauxInvalideException {
		if (tauxInteret < 0 || tauxInteret > 100) {
			throw new TauxInvalideException("Taux d'inteteret invalide");
		}
	}
	
	public static void compteInexistant(int numero_compte) throws CompteInexistantException {
		if (numero_compte == 0) {
			throw new CompteInexistantException("Compte inexistant");
		}
	}
	
	public static void debitMaximalDepasse(double debit) throws DebitMaximalDepasseException {
		double debitMaximal = 100;
		if (debit > debitMaximal) {
			throw new DebitMaximalDepasseException("Debit maximal depassé");
		}
	}
	
	public static void decouvertAutoriseDepasse(double montant) throws DecouvertAutoriseDepasseException {
		double decouvert_maximal = -500;
		if (decouvert_maximal > montant) {
			throw new DecouvertAutoriseDepasseException("Decouvert depassé");
		}
	}
	
	public static void operationNonAutorise(double montant) throws OperationNonAutoriseException {
		double decouvert_maximal = -500;
		if (decouvert_maximal > montant) {
			throw new OperationNonAutoriseException("Opération non autorisé");
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//part 1
		double[] traces_compte = new double[100];
		
		// Question 1
		
		//Test Crediter Compte Bancaire
		
		CompteCourant compte_courant = new CompteCourant(1, "nom", "prénom", 100 , new Date(), traces_compte);
		System.out.println("Solde Compte courant avant crédit "+ compte_courant.getSolde() + " euros") ;
		compte_courant.crediter(10);
		 
		System.out.println("Solde Compte courant après crédit " + compte_courant.getSolde() + " euros");
		
		
		//Test Debiter Compte Bancaire
		
		CompteCourant compte_courant_1 = new CompteCourant(1, "nom", "prénom", 100 , new Date(), traces_compte);
		System.out.println("Solde Compte courant avant débit "+ compte_courant_1.getSolde() + " euros") ;
		compte_courant_1.debiter(10);
		System.out.println("Solde Compte courant après débit " + compte_courant_1.getSolde() + " euros");
		
		
		//Test traitement quotidien du Compte Epargne
		
		DecimalFormat f = new DecimalFormat();
		f.setMaximumFractionDigits(2);
		CompteEpargne compte_epargne = new CompteEpargne(1,"nom","prenom",25, new Date(), traces_compte,100);
		compte_epargne.traitementQuotidien();
		System.out.println("Solde Compte courant après traitement quotidien " + f.format(compte_epargne.getSolde()) + " euros");
		
		
		//Test traitement quotidien du Compte Courant
		
		DecimalFormat f1 = new DecimalFormat();
		f1.setMaximumFractionDigits(2);
		CompteCourant compte_courant_2 = new CompteCourant(1, "nom", "prénom", -100 , new Date(), traces_compte);
		compte_courant_2.traitementQuotidien();
		System.out.println("Solde Compte courant après traitement quotidien " + f1.format(compte_courant_2.getSolde()) + " euros");
		
		
		//Test impossibilité de créer un objet CompteBancaire
		/*
		CompteBancaire compte_bancaire = new CompteBancaire();
		*/
		
		//Question 2
		
		//Test Ajout Personne morale & physique
		
		PersonneMorale personne_morale = new PersonneMorale("nomPersonneMorale","prenomPersonneMorale","nomCommercial");
		PersonnePhysique personne_physique = new PersonnePhysique("nomPersonnePhysique", "prenomPersonnePhysique", 10);
		ArrayList<PersonneMorale> liste_personne_morales = new ArrayList<PersonneMorale>();
		ArrayList<PersonnePhysique> liste_personne_physiques = new ArrayList<PersonnePhysique>();
		TitulaireCompteIntermediaire titulaire_compte_intermediaire = new TitulaireCompteIntermediaire("nomTitulaire","prenomTitulaire","adresseTitulaire", liste_personne_morales, liste_personne_physiques);
		titulaire_compte_intermediaire.ajouterPersonneMorale(personne_morale);
		titulaire_compte_intermediaire.ajouterPersonnePhysique(personne_physique);
		
		System.out.println("Liste des personnes morales du titulaire du compte");
		for(int i=0; i< titulaire_compte_intermediaire.getListePersonneMorales().size(); i++) {
			System.out.println(titulaire_compte_intermediaire.getListePersonneMorales().get(i).getNom() + " " + titulaire_compte_intermediaire.getListePersonneMorales().get(i).getPrenom());
		}
		
		System.out.println("Liste des personnes physiques du titulaire du compte");
		for(int i=0; i< titulaire_compte_intermediaire.getListePersonnePhysiques().size(); i++) {
			System.out.println(titulaire_compte_intermediaire.getListePersonnePhysiques().get(i).getNom() + " " + titulaire_compte_intermediaire.getListePersonnePhysiques().get(i).getPrenom());
		}
		
		
		//Question 3
		
		//test exception TauxInvalideException
		
		CompteEpargne ce = new CompteEpargne(1,"nom","prenom",25, new Date(), traces_compte,150);
		try {
			tauxInteretValide(ce.getTaux_interet());
		} catch (TauxInvalideException e) {
			System.out.println("taux interet invalide");
		}
		
		
		//Question 4
		
		//test exception CompteInexistantException
		
		
		CompteCourant compte_courant_3 = new CompteCourant(1, "nom", "prénom", 100 , new Date(), traces_compte);
		ArrayList<CompteBancaire> liste_comptes = new ArrayList<CompteBancaire>();
		liste_comptes.add(compte_courant_3);
		BanqueIntermediaire banque = new BanqueIntermediaire("nom_banque", liste_comptes);
		try {
			compteInexistant(banque.chercherCompte(1).getNumero_compte());
		} catch (CompteInexistantException e) {
			System.out.println("Compte Inexistant");
		}
		
		
		//test exception DebitMaximalDepasse
		
		CompteCourant compte_courant_4 = new CompteCourant(1, "nom", "prénom", 100 , new Date(), traces_compte);
		double debit = 1000;
		try {
			debitMaximalDepasse(debit);
		} catch (DebitMaximalDepasseException e) {
			System.out.println("Debit maximal depassé");
		}
		
		
		//test exception Decouvert non autorisé
		
		CompteCourant compte_courant_5 = new CompteCourant(1, "nom", "prénom", -1000 , new Date(), traces_compte);
		try {
			decouvertAutoriseDepasse(compte_courant_5.getSolde());
		} catch (DecouvertAutoriseDepasseException e){
			System.out.println("Decouvert non autorisé");
		}
		
		
	}
}
