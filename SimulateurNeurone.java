package dossierDuProjetPourCetExercice;

import java.util.ArrayList;

/*******************************************
 * Completez le programme a partir d'ici.

 *******************************************/
class Position {
	
	double x,y;
	Position(double x,double y){
		this.x=x;
		this.y=y;
	}
	public double getX() {
		return x;
	}
    public double getY() {
    	return y;
    }
    
    @Override
    	public String toString() {
    		// TODO Auto-generated method stub
    		return "(<"+x+">, <"+y+">)";
    	}
}

class Neurone{
	protected Position position;
	protected double signalInterne;
	protected double attenuation;
	
	protected ArrayList<Neurone> connexions;
	
	Neurone(Position p,double attenuation){
		this.position=p;
		this.attenuation=attenuation;
	    connexions=new ArrayList<Neurone>();
	}
	Neurone(){
		this.signalInterne=0.0;
	}
	
	public Position getPosition(){
		return position;
	}
	
	public int getNbConnexions() {
		return connexions.size();
	}
	
	public double getAttenuation(){
		 return attenuation; 
	}

	double getSignal(){
		return signalInterne;
	}
	
	public Neurone getConnexion( int index) {
		return  connexions.get(index);
	}
	
	public void connexion(Neurone n) {
		//for(Neurone i:connexions) {
		connexions.add(n);
	    //}
	}
	
	
	
	void recoitStimulus(double stimulus) {
		signalInterne=stimulus* getAttenuation();
		
		for(Neurone n:connexions){
			n.recoitStimulus(signalInterne);
		}
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String res="le neurone en position <"+position+"> avec attenuation<"+attenuation+"> en connexion \n";
		
			res+=" en connexion avec\n";
		    if(getNbConnexions() >0){
		    	for(Neurone i:connexions)
		    	res +="  -le neurone en position <"+i.position+"> ";
		    }else {
		    	res+="sans connexion\\n";
		    }
	    
		return res;
	}
}

class NeuroneCumulatif extends  Neurone{
	
	NeuroneCumulatif(Position position,double attenuation){
		super(position,attenuation);
	}
	
	/*void recoitStimulus(double stimulus) {
		signalInterne=signalInterne+stimulus* getAttenuation();
		
		for(Neurone n:connexions){
			n.recoitStimulus(signalInterne);
		}
		
	}*/
	public void recoitStimulus(double stimulus){
		super.recoitStimulus(getSignal()/getAttenuation() + stimulus);
	}
}

class Cerveau{
	protected ArrayList<Neurone>  creation;
    protected Neurone neurone;
	
	public Cerveau(){
		creation=new ArrayList<Neurone>();
	}
	
	public int getNbNeurones(){
		return creation.size();
	}
	public Neurone getNeurone(int index) {
		return creation.get(index);
	 } 
	 void ajouterNeurone(Position pos, double attenuation) {
		 creation.add(new Neurone(pos,attenuation));
	 }
	 void ajouterNeuroneCumulatif(Position pos,double attenuation){
		  creation.add(new NeuroneCumulatif( pos, attenuation));
	 }
	
	 void stimuler(int index,double stimulus){
		   neurone=getNeurone( index);
		   
		   neurone.recoitStimulus(stimulus);       
		 
	 }
	 
	 double sonder(int index){
		 neurone=getNeurone( index);
		 return neurone.getSignal();
	 }
	 
	 
	 void creerConnexions(){
		 if(creation.size()>1) {
			 creation.get(0).connexion(creation.get(1));
		 }
		 if(creation.size()>2){
			 creation.get(1).connexion(creation.get(2));
		 }
		 
		 
		 for(int i=0;i<creation.size()-2;i+=2) {
			 creation.get(i).connexion(creation.get(i+1));
			 creation.get(i+1).connexion(creation.get(i+2));
		 }
		 
	 }
     
	 @Override
	public String toString() {
		// TODO Auto-generated method stub
			String res = "Le cerveau contient " +getNbNeurones() + " neurone(s)\n";
			for (Neurone n: creation){
				res += n + "\n";
			}
			return res + "*----------*\n\n";
	}
}


/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/
public class SimulateurNeurone {

    public static void main(String[] args) {
        // TEST DE LA PARTIE 1
        System.out.println("Test de la partie 1:");
        System.out.println("--------------------");

        Position position1 = new Position(0, 1);
        Position position2 = new Position(1, 0);
        Position position3 = new Position(1, 1);

        Neurone neuron1 = new Neurone(position1, 0.5);
        Neurone neuron2 = new Neurone(position2, 1.0);
        Neurone neuron3 = new Neurone(position3, 2.0);

        neuron1.connexion(neuron2);
        neuron2.connexion(neuron3);
        neuron1.recoitStimulus(10);

        System.out.println("Signaux : ");
        System.out.println(neuron1.getSignal());
        System.out.println(neuron2.getSignal());
        System.out.println(neuron3.getSignal());

        System.out.println();
        System.out.println("Premiere connexion du neurone 1");
        System.out.println(neuron1.getConnexion(0));


        // FIN TEST DE LA PARTIE 1

        // TEST DE LA PARTIE 2
        System.out.println("Test de la partie 2:");
        System.out.println("--------------------");

        Position position5 = new Position(0, 0);
        NeuroneCumulatif neuron5 = new NeuroneCumulatif(position5, 0.5);
        neuron5.recoitStimulus(10);
        neuron5.recoitStimulus(10);
        System.out.println("Signal du neurone cumulatif  -> " + neuron5.getSignal());

        // FIN TEST DE LA PARTIE 2
        
        // TEST DE LA PARTIE 3
        System.out.println();
        System.out.println("Test de la partie 3:");
        System.out.println("--------------------");
        Cerveau cerveau = new Cerveau();

        // parametres de construction du neurone:
        // la  position et le facteur d'attenuation
        cerveau.ajouterNeurone(new Position(0,0), 0.5);
        cerveau.ajouterNeurone(new Position(0,1), 0.2);
        cerveau.ajouterNeurone(new Position(1,0), 1.0);

        // parametres de construction du neurone cumulatif:
        // la  position et le facteur d'attenuation
        cerveau.ajouterNeuroneCumulatif(new Position(1,1), 0.8);
        cerveau.creerConnexions();
        cerveau.stimuler(0, 10);

        System.out.println("Signal du 3eme neurone -> " + cerveau.sonder(3));
        System.out.println(cerveau);
        // FIN TEST DE LA PARTIE 3 */
    }
}
