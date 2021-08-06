package ImagePackage;

public class NegativeFiltre extends Filter {

   
	
	public NegativeFiltre (String filename) {
   	 super(filename);
   	 
    }
      
  	public int filterPixel(int i){
		return 255-i;
	}
	
	
}


