package ImagePackage;

public abstract class ImageRoot {

	protected int[][] data;
	protected int width, height;
	
	// M�thode � impl�menter
	abstract public void filter(Filter f);
	
	
	public ImageRoot (String filename) {
		
	}
	
	public int getWidth (){
		return width;
	}
	
	
	
	public int getHieght(){
		return height;
	}
	
	
	public void save (String filename){}
	
	
	
}







