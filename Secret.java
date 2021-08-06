package p3;

import java.util.Random;

class Utils{
	// genere un entier entre 1 et max (compris)
	public static int randomInt(int max) {
		Random r =new Random();
		int val =r.nextInt();
		val = Math.abs(val);
        val=val % max;
        val +=1;
        return val;
	}
}

abstract class Code{
	protected String nom;
	abstract public String code(String s);
	abstract public String decode(String s);
	

	
	public Code(String nom){
		this.nom=nom;
	}
	
	public void affiche(){
		System.out.println(nom);
	}
}

class ACle extends Code{
	
	   private String cle;
      	
	
	   
       public ACle(String nom,String cle){
    	   super(nom);
    	   this.cle=cle;
       }
      
      
       public void setCle(String uneCle){
    	   cle=uneCle;
       }
       
       public int longueur(){
    	   return cle.length();
       }
       
       public String code(String message){
    	        String codage="";
    	        int charMessage;
    	        int charKey;
    	        int somme;
 
    	        for(int i=0;i<message.length();++i){
    	        	charMessage=message.charAt(i)-'A'+1;
    	        	charKey = cle.charAt(i % longueur()) - 'A' + 1;
    	        	somme=(charMessage+charKey)%26;
    	        	if(somme==0){
    	        		codage+='Z';
    	        	}else{
    	        		codage+=(char)('A'+somme-1);
    	        	}
    	        }
    	        return codage;
       }      
       
       public String decode(String codage){
    	   String message="";
    	   int charCodage;
    	   int charKey;
    	   int diffrance;
    	   
    	   for(int i=0;i<codage.length();++i){
    		   charCodage=codage.charAt(i)-'A'+1;
    		   charKey=cle.charAt(i % longueur()) - 'A' + 1;
    		   diffrance=(charCodage-charKey+26)%26;
    		   if(diffrance==0){
    			   message+='Z';
    		   }else {
    			   message+=(char)('A'+diffrance-1);
    		   }
    	   }
    	   return message;
       }
       public void affiche(){
    	   super.affiche();
    	   System.out.println(" avec " + cle + " comme cle");
    	   }
	
}


class ACleAleatoire extends ACle{
	    public int longeurCle;
        private String cleA;
	    
	    public void genereCle(){
	    	String newKey="";
	    	int randomPosition;
	    	Utils u=new Utils();
	        
	    	for(int i=0;i<getLongeur();i++){
	    		randomPosition=u.randomInt(26);
	    		newKey+=(char)(randomPosition+(int)'A'-1);
	    	}
	    	 
	    	setCle(newKey);
	    }
	    
	    public ACleAleatoire(int lgCle){
	    	super("a cle aleatoire","");
	    	this.longeurCle=lgCle;
	    	genereCle();
	    }
      
	   
	    public int getLongeur(){
	    	return longeurCle;
	    }

	    
}	
	
	
class Cesar extends ACle{
	private int crans;
	public Cesar(String nomCode, int crans) {
	super(nomCode, "");
	setCle("" + (char)('A' + crans%26 - 1));
	this.crans = crans;
	}
	public void affiche() {
	System.out.println(nom + " a " + crans + " crans");
	}


}
	


public class Secret {

	public static void main(String[] args) {
		String message = "COURAGEFUYONS";
		String cryptage;
		// PARTIES A DECOMMENTER AU FUR ET A MESURE SELON l'ENONCE
		
		// TEST A CLE
		Code acle1 = new ACle("a cle", "EQUINOXE");
		System.out.print("Avec le code : " );
		acle1.affiche();
		cryptage = acle1.code(message);
		System.out.print("Codage de " + message + " : ");
		System.out.println(cryptage);
		System.out.print("Decodage de " + cryptage + " : ");
		System.out.println(acle1.decode(cryptage));
		System.out.println("-----------------------------------");
		System.out.println();
		// FIN TEST A CLE
		
		
		// TEST A CLE ALEATOIRE
		Code acle2 = new ACleAleatoire(5);
		System.out.print("Avec le code : " );
		acle2.affiche();
		cryptage = acle2.code(message);
		System.out.print("Codage de " + message + " : ");
		System.out.println(cryptage);
		System.out.print("Decodage de " + cryptage + " : ");
		System.out.println(acle2.decode(cryptage));
		System.out.println("-----------------------------------");
		System.out.println();
		// FIN TEST A CLE ALEATOIRE
		
		
		// TEST CESAR
		Code cesar1 = new Cesar("Cesar", 5);
		System.out.print("Avec le code : " );
		cesar1.affiche();
		cryptage = cesar1.code(message);
		System.out.print("Codage de " + message + " : ");
		System.out.println(cryptage);
		System.out.print("Decodage de " + cryptage + " : ");
		System.out.println(cesar1.decode(cryptage));
		System.out.println("-----------------------------------");
		System.out.println();
		// FIN TEST CESAR
		
		/*
		// TEST CODAGES
		System.out.println("Test CODAGES: ");
		System.out.println("------------- ");
		System.out.println();
		Code[] tab = { // Decommentez la ligne suivante
		// si vous avez fait la classe Cesar
		new Cesar("cesar", 5),
		new ACle("a cle", "EQUINOXE") ,
		new ACleAleatoire(5),
		new ACleAleatoire(10)};
		Codages codes = new Codages(tab);
		codes.test(message);
		// FIN TEST CODAGE
		*/


	}
}
		
		       		

	



