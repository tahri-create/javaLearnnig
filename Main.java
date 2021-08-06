package Rev;
import javax.swing.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        JFrame fen=new JFrame();
        fen.setSize(500,300);
        fen.setTitle("Ma premier fenetre");
        JLabel text=new JLabel("Hello world");
        fen.getContentPane().add(text);
        fen.setVisible(true);
	}

}
