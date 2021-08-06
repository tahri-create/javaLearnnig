package p2;

import java.util.ArrayList;

class Couleur{
	private char valeur;
	
	public Couleur(char c){
		valeur=c;
	}
	
	public void Afficher(){
		this.Afficher(false);
	}
	
	public void Afficher(boolean feminin){
		switch(valeur) {
		case 'r':
			System.out.println("rouge");
		break;
		case 'v':
			System.out.println("vert");
			if (feminin) {
				System.out.println("e");
				}
        break;
		case 'b':
			System.out.println("bleu");
			if (feminin) {
				System.out.println("e");
				}
        break;
        
		}
	}
}


abstract class Carte{
  	public double cout;

	abstract void Afficher();
	
    public Carte () {
    	cout=0;
    }
	
	public Carte (double cout) {
		this.cout=cout;
	}
 	/*public String toString (){
 		return "on change de main\n";
 	}*/
	
}

class Terrain extends Carte{
	public  Couleur couleur;
	public Terrain(char c){
		couleur=new Couleur(c);
		System.out.println("un nouveau terrain.\n");
	}
	
	public void Afficher() {
		System.out.println("terrain");
		couleur.Afficher();
		System.out.println();

	}

		
		
  }
	


class Creature extends Carte{
      public String nom;
      public int NbrG;
      public int NbrV;
      public Creature(double c, String nom,int NbrG,int NbrV){
    	  super(c);
    	  this.nom=nom;
    	  this.NbrG=NbrG;
    	  this.NbrV=NbrV;
    	  System.out.println("Une nouvelle créature.\n");
      }
      
    
      public void Afficher() {
    	System.out.println("une creature"+nom+" "+NbrG+" "+NbrV);  
      }
	
} 

class  Sortilege extends Carte{
	    public String nom;
	    public String txt;
	    
	    public Sortilege(double c,String nom,String txt){
	    	super(c);
	    	this.nom=nom;
	    	this.txt=txt;
	    	System.out.println( "Un sortilège de plus.\n");
	    }
	
	
	    public void Afficher(){
	    	System.out.println("un  Sortilege"+nom);
	    }
}

class Jeu{
	
     private int nombreCartes;
     private Carte[] cartes;
     
     public Jeu(int nb){
    	 nombreCartes=nb;
    	 cartes=new Carte[nb];
    	 System.out.println("On change de main\n");
     }
   
     
     public void joue(){
    	 System.out.println("je joue une carte:...\n");
    	 int i = 0;
    	 while ((cartes[i] == null) && i < nombreCartes) {
    	 i++;
    	 }
    	 if ((i < nombreCartes) && (cartes[i] != null)) {
    	 System.out.println("La carte jouée est :");
    	 cartes[i].Afficher();
    	 cartes[i] = null;
    	 } else {
    	 System.out.println("Plus de cartes");
    	 }


     }
     
     
     public void piocher(Carte carte){
    	 
    	 for(int i=0;i<cartes.length;i++) {
    		 cartes[i]=carte;
    	 }
    	 
     }

     public void afficher() {
    	 for (int i = 0; i < nombreCartes; ++i) {
    	 if (cartes[i] != null) {
    	 cartes[i].Afficher();
    	 }
    	 }
    	 }

}


public class Magic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jeu maMain = new Jeu(10);
		maMain.piocher(new Terrain('b'));
		maMain.piocher(new Creature(6, "Golem", 4, 6));
		maMain.piocher(new Sortilege(1, "Croissance Gigantesque",
		"La créature ciblée gagne +3/+3 jusqu'à la fin du tour"));
		System.out.println("Là, j'ai en stock :");
		maMain.afficher();
		maMain.joue();
		}




}
