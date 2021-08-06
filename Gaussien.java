package ImagePackage;

public class Gaussien extends Filter {

     public Gaussien (String filename) {
    	 super(filename);
     }
     
	
	public int filterPixel(int [][]G){
		
		int max=0;
		int res;
		for(int i=0;i<9;i++) {
		   for(int j=0;j<9;j++){
			    res=G[i][j] * 1/16;
		   }
	    }
			
		
		
		for(int i=0;i<9;i++) {
		  for(int j=0;j<9;j++){
			 if(G[i][j]>max){
				 max=G[i][j];
			 }
		  }
		}
		
		
		
		return max;
	}
	
}
