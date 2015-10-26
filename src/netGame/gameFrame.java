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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	gameEngine in;
	public gameFrame(gameEngine e) {
		in = e;
		int X = e.paneX;
		int Y = e.paneY;
		setTitle("오목 판");
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container con = getContentPane();
		
		con.setLayout(new GridLayout(X,Y));
		
		
	}
	//돌 표시
	public void view(){
		for(int i=0;i<in.paneX;i++){
			for(int j=0;j<in.paneY;j++){
				if((in.pane[i][j].visable==true)&&(in.pane[i][j].color==true)) ;//검은돌 놓기
				
				if((in.pane[i][j].visable==true)&&(in.pane[i][j].color==false)) ;//흰돌 놓기
			}
		}
		repaint();
	}
	public Piece userOut(){
		//사용자 입력 반환
		int x = 0;//x축
		int y = 0;//y축
		return (new Piece(x,y,true));
		
	}
	
	

}
