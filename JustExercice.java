package Les_gestionnaire_de_placement;

import javax.swing.*;
import java.awt.*;


public class JustExercice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        JFrame fenetre =new JFrame();
        fenetre.setSize(400,200);
        fenetre.setTitle("Note Forme");
        JPanel panel=new JPanel(new GridLayout(5,1)); 
 
       
        
        
        GridBagConstraints c=new GridBagConstraints();
        c.gridx=0;
        c.gridy=1;
        c.gridwidth=1;
        c.gridheight=1;
   
        JLabel nomLab=new JLabel("Nom:");
        JTextField nom=new JTextField(30);
        panel.add(nomLab,c);
        panel.add(nom,c);
        
      //  GridBagConstraints c1=new GridBagConstraints();
        c.gridx=1;
        c.gridy=1;
        c.gridwidth=1;
        c.gridheight=1;
  
        JLabel passLab=new JLabel("Mot de passe:");
        JPasswordField pass=new JPasswordField(); 
        panel.add(passLab,c);
        panel.add(pass,c);
        
      //  GridBagConstraints c2=new GridBagConstraints();
        c.gridx=2;
        c.gridy=1;
        c.gridwidth=1;
        c.gridheight=1;
    
        
        JLabel newPassLab=new JLabel("nouveau mot de passe:");
        JPasswordField pass1=new JPasswordField(); 
        panel.add(newPassLab,c);
        panel.add(pass1,c);
        
       // GridBagConstraints c4=new GridBagConstraints();
        c.gridx=3;
        c.gridy=1;
        c.gridwidth=1;
        c.gridheight=1;
       
        JLabel retapPassLab=new JLabel("retapez mot de passe:");
        JPasswordField pass2=new JPasswordField(); 
        panel.add(retapPassLab,c);
        panel.add(pass2,c);
        
        JButton button=new JButton("lancez la modification");
        
        panel.add(button);
        fenetre.add(panel);
        
        fenetre.setVisible(true);
	}

}
