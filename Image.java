package ImagePackage;

abstract class  Image extends ImageRoot {
	
	
	     
        protected int v; 
	
	     
	     public abstract int filterPixel(int v);
	
	public Image(String filename){
		 super(filename);
	 }
	 
	 
	 public void filter(Filter f){
		 filterPixel(v);
		 
	 }
	 
	 
	 

}
