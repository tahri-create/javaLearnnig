package Les_gestionnaire_de_placement;
import javax.swing.*;
import java.awt.*;
public class TestGridBagLayout extends JFrame{

	TestGridBagLayout(){
		JPanel panneau=new JPanel();
		panneau.setBackground(new Color(220,220,255));
		panneau.setPreferredSize(new Dimension(400,300));
		panneau.setLayout(new GridBagLayout());
		ajout(panneau,new JLabel("Nom"),0,0,1,1,10,10,GridBagConstraints.NONE,GridBagConstraints.EAST);
		ajout(panneau,new JLabel("Pernom"),0,1,1,1,0,10,GridBagConstraints.NONE,GridBagConstraints.EAST);
		
		
		
		
		
		getContentPane().add(panneau);
		pack();
		setVisible(true);
	}
	
	private void ajout(Container contenu,Component composant,int gridx,int gridy,int gridwidth,int gridheight,
			int weightx,int weighty,int fill,int anchor
			) {
		      GridBagConstraints contrainte=new GridBagConstraints();
		      contrainte.gridx=gridx;
		      contrainte.gridy=gridy;
		      contrainte.gridwidth=gridwidth;
		      contrainte.gridheight=gridheight;
		      contrainte.weightx=weightx;
		      contrainte.weighty=weighty;
		      contrainte.fill=fill;
		      contrainte.anchor=anchor;
		      contenu.add(composant,contrainte);
		     
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
            new  TestGridBagLayout();
	}

}
