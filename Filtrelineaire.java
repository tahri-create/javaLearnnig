package ImagePackage;

public class Filtrelineaire extends Filter {

	private float facteur;
	private  float constante;
	
	float []c;
	
	
	public Filtrelineaire(String filename,float []c,float facteur,float constante) {
		super(filename);	
		this.facteur=facteur;
		this.constante=constante;
		this.c=c;
		
	}
	
	public float filterPixel(float []c2){
		float resultas;
		
		float som=0;
		
		for(int i=1;i<c2.length;i++){
			som=som+c2[i];
		}
		
		resultas =som;
		
		return resultas;
	}
	
	
}
