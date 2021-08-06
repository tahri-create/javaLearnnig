package dossierDuProjetPourCetExercice;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*******************************************
 * Completez le programme a partir d'ici.

 *******************************************/

class Employe{
	public String nom;
  	public double revenuM;
	public double taux=100;
    public double prime=0;
	
    
    
	public Employe(String nom,double revenuM,double taux){
		this.nom=nom;
		this.revenuM=revenuM;
		if(taux <10){
			taux=10;
		}else if(taux>100){
			taux=100;
		}else{
			this.taux=taux;
		}
		
	   
	}
	
	
	
	 public double revenuAnnuel(){
		double salaire=revenuM*12*taux+this.prime;
		
		return salaire;
	}
	 
	 public  String AffichPrime(){
		 String res;
		 
		 if (this.prime>0){
			 res=" la prime est :"+this.prime+" francs.\n";
		 }else {
			 res=" francs.\n";
		 }
		 
		 
		 
		 return res;
	 }
	
	 
	 public void demandePrime(){
		 Scanner clavier = new Scanner(System.in);
		 double ddprime=0;

		// boolean Error=false;
	     int i=0;
		
		 do {
			 
			 try {
		    	  System.out.println("Montant de la prime souhaitée par"+nom+"?\n");
		    	  ddprime=clavier.nextDouble();
		    	
		      }catch(Exception e){
		    	  System.out.println("Vous devez introduire un nombre!");
		    	// Error=true;
		         clavier.nextLine();
		         i++;
			}
			
			 if(ddprime>(0.02*revenuAnnuel())) {
				 System.out.println("c'est trop chers!");	 
				 ddprime=0;
				 i++;
			 }
		 }while((ddprime > (0.02*revenuAnnuel()) || ddprime==0) && i<5);
		 if(i < 5){
				
				this.prime = ddprime;
				
			}
		   
		 
	 }
	 
	@Override
		public String toString() {
			// TODO Auto-generated method stub
		String res;
		
        res="le salaire :"+String.format("%.2f",  revenuAnnuel());
        res+=AffichPrime();
			return res;
		}
	
	
}

class Manager  extends Employe {
	protected int nbrV;
	protected int nbrC;
	
	public Manager(String nom,double revenuM,double taux,int nbrV,int nbrC){
		super(nom,revenuM,taux);
		this.nbrC=nbrC;
		this.nbrV=nbrV;
		System.out.println("nous avons un nouvelle employe: "+nom+" c'est un manager");
	}
	
	public double revenuAnnuel(){
		double FACTEUR_GAIN_CLIENT =500;
		double FACTEUR_GAIN_VOYAGE =100;
		double salaire;
		if(nbrV>0){
		  salaire=revenuM*12*taux-FACTEUR_GAIN_VOYAGE;
		  System.out.println(nom+":\n A voyagé  "+nbrV+" jours");
		}else {
			salaire=revenuM*12*taux;
			System.out.println(" Salaire annuel : "+  salaire);
		} 
		if(nbrC>0){
			salaire=revenuM*12*taux+FACTEUR_GAIN_CLIENT;
			 System.out.println(" apporté "+nbrC+" nouveaux clients.");
		}else {
			salaire=revenuM*12*taux;
			System.out.println(" Salaire annuel : "+  salaire);
		}
		return salaire;
	}
	
}

class Testeur extends Employe{
	public int nbrEr;
	double FACTEUR_GAIN_ERREURS=10;
	public Testeur(String nom,double revenuM,double taux,int nbrEr){
		super(nom,revenuM,taux);
		this.nbrEr=nbrEr;
		System.out.println("nous avons un nouvelle employe: "+nom+" c'est un testeur");
	}

	public double revenuAnnuel(){
		double salaire;
	   if(nbrEr>0) {
		 salaire=revenuM*12*taux+ FACTEUR_GAIN_ERREURS;
		 System.out.println(nom+": \n A corrigé "+nbrEr);
	   }else {
		   salaire=revenuM*12*taux;  
	   }
	   return salaire;
	}
	
}

class Programmeur extends Employe{
	private int nbrP;
	double FACTEUR_GAIN_PROJETS=200;

	public Programmeur(String nom,double revenuM,double taux,int nbrP) {
		super(nom,revenuM,taux);
		this.nbrP=nbrP;
		System.out.println("nous avons un nouvelle employe: "+nom+" c'est un programmeur");
	}
	
	public double revenuAnnuel(){
		double salaire;
		if(nbrP>0) {
			 salaire=revenuM*12*taux+FACTEUR_GAIN_PROJETS;
			 System.out.println(nom+" :\n A mené à bien"+nbrP);
		}else {
			salaire=revenuM*12*taux;
		}
		return salaire;
	}
	
	
	
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
class Employes {
    public static void main(String[] args) {

        ArrayList<Employe> staff = new ArrayList<Employe>();

        // TEST PARTIE 1:

        System.out.println("Test partie 1 : ");
        staff.add(new Manager("Serge Legrand", 7456, 30, 4 ,2));
        staff.add(new Programmeur("Paul Lepetit" , 6456, 3, 75 ));
        staff.add(new Testeur("Pierre Lelong", 5456, 124,50 ));

        System.out.println("Affichage des employés : ");
        for (Employe modele : staff) {
            System.out.println(modele);
        }
        // FIN TEST PARTIE 1
        // TEST PARTIE 2
        System.out.println("Test partie 2 : ");

        staff.get(0).demandePrime();

        System.out.println("Affichage après demande de prime : ");
        System.out.println(staff.get(0));

        // FIN TEST PARTIE 2 */
    }
}

