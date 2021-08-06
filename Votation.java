package dossierDuProjetPourCetExercice;

import java.util.ArrayList;

import java.util.Random;


/*******************************************
 * Completez le programme à partir d'ici.
 *******************************************/

class Postulant{
	protected  String nom;
	protected int nbrE=0;
	
	public Postulant(String nom,int nbrE){
		this.nom=nom;
		this.nbrE=nbrE;
	}
	
	public Postulant(Postulant p){
		nom=p.nom;
		nbrE=p.nbrE;
	}
	
	public int elect(){
		return this.nbrE++;	
	}
	
	public void init(){
	    this.nbrE=0;
	}
	
	public int getVotes(){
		return elect();
	}
	
	public String getNom(){
		return this.nom;
	}
	
}

class Scrutin{

	private ArrayList<Postulant> listePostulants;
//	private ArrayList<Vote> votes;
	private int maxVotants;
	private int date;
	
	public Scrutin(ArrayList<Postulant> postulants, int maxVotants, int date, boolean init){
		
		this.listePostulants = new ArrayList<Postulant>();
		for(Postulant p : postulants){
			
			if (init){
				
				Postulant newPostulant = new Postulant (p);
				newPostulant.init();
				
				this.listePostulants.add(newPostulant);
				
			} else {
				
				this.listePostulants.add(new Postulant (p));
				
			}
			
			
			
		}
		
		this.maxVotants = maxVotants;
		this.date = date;
		
//		this.votes = new ArrayList<Vote>();
	}
	
	public Scrutin(ArrayList<Postulant> postulants, int maxVotants, int date){
		
		this.listePostulants = new ArrayList<Postulant>();
		for(Postulant p : postulants){

			Postulant newPostulant = new Postulant(p);
			newPostulant.init();
			
			this.listePostulants.add(newPostulant);

		}
		
		this.maxVotants = maxVotants;
		this.date = date;
	//	this.votes = new ArrayList<Vote>();
	}
	
	public int calculerVotants(){
		
		int totalVotants = 0;
		
		for(Postulant p : this.listePostulants){
			
			totalVotants += p.getVotes();
			
		}
		
		return totalVotants;
		
	}
	
	public String gagnant(){
		
		String gagnant = "";
		int maxVotes = 0;
		
		for (Postulant p : this.listePostulants){
			
			if(p.getVotes() >= maxVotes){
				
				maxVotes = p.getVotes();
				gagnant = p.getNom();
				
			}
			
		}
				
		return gagnant;
	}
	
	public void resultats(){
		
		String str = "";
		
		if(this.calculerVotants() == 0){
			
			str += "Scrutin annul�, pas de votants\n";
			
		} else {
		
			str += "Taux de participation -> ";
			str += String.format("%.1f", (double)this.calculerVotants() / this.maxVotants * 100);
			str += " pour cent\n";
			str += "Nombre effectif de votants -> ";
			str += this.calculerVotants() + "\n";
			str += "Le chef choisi est -> ";
			str += this.gagnant();
			str += "\n\nR�partition des electeurs\n";
			
			for (Postulant p : this.listePostulants){
				
				str += p.getNom() + " -> ";
				str += String.format("%.1f",(double) p.getVotes() / this.calculerVotants()*100);
				str += " pour cent des �lecteurs\n";
				
			}
			
		}
		
		System.out.println(str);
		
		
	}
	

	
}


/*
"vote électronique"
System.out.println("Scrutin annulé, pas de votants");
"Répartition des électeurs "
" -> %.1f pour cent des électeurs\n"
/*******************************************
 * Ne pas modifier les parties fournies
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/

class Utils {

    private static final Random RANDOM = new Random();

    // NE PAS UTILISER CETTE METHODE DANS LES PARTIES A COMPLETER
    public static void setSeed(long seed) {
        RANDOM.setSeed(seed);
    }

    // génère un entier entre 0 et max (max non compris)
    public static int randomInt(int max) {
        return RANDOM.nextInt(max);
    }
}

/**
 * Classe pour tester la simulation
 */

class Votation {

    public static void main(String args[]) {
        Utils.setSeed(20000);
        // TEST 1
        System.out.println("Test partie I:");
        System.out.println("--------------");

        ArrayList<Postulant> postulants = new ArrayList<Postulant>();
        postulants.add(new Postulant("Tarek Oxlama", 2));
        postulants.add(new Postulant("Nicolai Tarcozi", 3));
        postulants.add(new Postulant("Vlad Imirboutine", 2));
        postulants.add(new Postulant("Angel Anerckjel", 4));

        // 30 -> nombre maximal de votants
        // 15 jour du scrutin
        Scrutin scrutin = new Scrutin(postulants, 30, 15, false);

        scrutin.resultats();

        // FIN TEST 1

   /*     // TEST 2
        System.out.println("Test partie II:");
        System.out.println("---------------");

        scrutin = new Scrutin(postulants, 20, 15);
        // tous les bulletins passent le check de la date
        // les parametres de simuler sont dans l'ordre:
        // le pourcentage de votants et le jour du vote
        scrutin.simuler(0.75, 12);
        scrutin.compterVotes();
        scrutin.resultats();

        scrutin = new Scrutin(postulants, 20, 15);
        // seuls les bulletins papier non courrier passent
        scrutin.simuler(0.75, 15);
        scrutin.compterVotes();
        scrutin.resultats();

        scrutin = new Scrutin(postulants, 20, 15);
        // les bulletins electroniques ne passent pas
        scrutin.simuler(0.75, 15);
        scrutin.compterVotes();
        scrutin.resultats();
        //FIN TEST 2  */

    }
}
