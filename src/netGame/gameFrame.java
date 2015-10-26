package netGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class chessL implements ActionListener {
	
	public chessL(gameEngine e){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		
		
		
	}
	
	
	
}


public class gameFrame extends JFrame {
	public gameFrame() {
		setTitle("¿À¸ñ ÆÇ");
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container con = getContentPane();
		
		con.setLayout(new GridLayout(8,8));
		
	}
	public void init(){
		
	}
	

}
