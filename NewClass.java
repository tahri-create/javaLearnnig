package Les_gestionnaire_de_placement;
import javax.swing.*;
import java.awt.*;
public class NewClass {

	private final static String[] chiffres= {"zero","un","deux","trois","quatre","cinq","six","sept","huit","neuf"};
	
	private static JPanel creerPanel(LayoutManager layout) {
		JPanel result=new JPanel(layout);
		for(int i=0;i<chiffres.length;i++){
			result.add(new JButton(chiffres[i]));
		}
		return result;
	}
	
	private static JPanel creerPanleBorderLayout(){
		JPanel result =new JPanel(new BorderLayout());
		result.add(new JButton("centre"),BorderLayout.CENTER);
		result.add(new JButton("EAST"),BorderLayout.EAST);
		result.add(new JButton("WEST"),BorderLayout.WEST);
		result.add(new JButton("NORTH"),BorderLayout.NORTH);
		return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
               JFrame fen=new JFrame ("Layout---Demonstration");
               Container contenu=fen.getContentPane();
               JTabbedPane onglets=new JTabbedPane();
               onglets.addTab("FlowLayout",creerPanel(new FlowLayout()));
               onglets.addTab("GridLayout",creerPanel(new GridLayout(3,4)));
               onglets.addTab("BorderLayout",creerPanleBorderLayout());
               contenu.add(onglets);
               fen.setSize(new Dimension(300,200));
               fen.setVisible(true);
               fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

}
