package App;

import java.util.Collection;
import java.util.Collections;
import java.util.Arrays;
abstract class Personne {

	String nom;
	String prenom;
	int age;
	
	public abstract void afficherType();
	
	public Personne(String nom,String prenom,int age){
		this.nom=nom;
		this.prenom=prenom;
		this.age=age;
	}

	public void Affiche(){
		System.out.println("nom: "+nom+" ,prenom: "+prenom+" ,age: "+age);
	}
}


class Enseignant extends Personne{
	long nss;
	String module [];
	
	public void afficherType() {
		System.out.println("le type de objet est : Enseignant ");
	}
	
	public Enseignant(long nss,String []module,String nom,String prenom,int age){
	super(nom,prenom,age);	
		this.nss=nss;
		this.module=new  String[3];
		System.out.println(Arrays.toString(module));
		
	}
	public void Affiche(){
	
		System.out.println("nom: "+nom+", prenom: "+prenom+", age: "+age+", numéro de sécurité sociale: "+nss);
	}
	
}


class Etudiant extends Personne{
	int matricule ;
	double notes[];
	
	public void afficherType() {
		System.out.println("le type de objet est : Etudiant ");
	}	
	public Etudiant(int matricule ,double note,String nom,String prenom,int age){
		super(nom,prenom,age);
		this.matricule=matricule; 
		this.notes=new double[3];
		remplirTab(notes,note);
		  double moy =	claculMoyenne(notes);
		  System.out.println("le nom :"+nom +" la moyenne est :"+moy);
	}
	


    public void remplirTab(double [] notes,double note){
    	for(int i=0;i<notes.length;i++){
			this.notes[i]=note;
		}
    }
	
	public double claculMoyenne(double[] notes){
		double som=0;
		
		for(int i=0;i<notes.length;i++){
			som=som+notes[i];
		}
		return som/notes.length;
	}

	
	public void Affiche(){
	
		System.out.println("nom: "+nom+" ,prenom: "+prenom+" ,age: "+age);
}
}

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		Personne t[] =new Personne [5];
	    
	    t[0]=new Enseignant(12345678910L,new String[]{"poo", "se","bdd"},"youcef","mohamed",40  );  
	    t[1]=new Enseignant(12345632914L,new String[]{"poo", "THL","bdd"},"kamal","ali",40);
	    t[2]=new Enseignant(12345678910L,new String[]{"poo", "se","RESEAUX"},"ait ahmed","rafik",40);
	    t[3]=new Etudiant(17173165,13.5,"jamel","makhlofi",21);
	    t[4]=new Etudiant(18183443,11.75,"amine","abde kader",21);
	   
	    
	
	    for(int i=0;i<5;i++){
	    	t[i].Affiche();
	    }
	    
	    
	    for(int i=0;i<5;i++){
	    	t[i].afficherType();
	    }
	   

	    Arrays.sort(t,Collections.reverseOrder());
	    for(Personne i: t) {
	    	i.Affiche();
	    }
	    
	}

}
