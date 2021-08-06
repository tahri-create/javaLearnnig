package exo1;


class Fleur{
	private String color1;
	private String color2;
	
	public Fleur(String s1,String s2){
		color1=s1;
		color2=s2;
		System.out.println(s1+" fraichement cueillie");
		System.out.println("Fragile corolle taillée ");
	}
	
	public String getColor1(){
		return color1;
	}
	public String getColor2(){
		return color2;
	}
	
	
	public Fleur(Fleur f){
		color1=f.color1;
		color2=f.color2;
	} 
	
	public void eclore(){
		System.out.println("veiné de "+getColor2());
	}
	
	public String toString() {
		return"qu'un simple souffle ";
	}
}



public class Poeme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fleur f1 = new Fleur("Violette", "bleu");
		Fleur f2 = new Fleur(f1); 
		System.out.println("dans un cristal ");
		f2.eclore();
		System.out.print("ne laissant plus ");
		System.out.println(f1);
		System.out.println(f2);
		
		
  
	}

}
