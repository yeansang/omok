package netGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class PButton extends JButton{
	int x, y;
	public PButton(String e, int x, int y){
		super(e);
		this.x = x; this.y = y;
	}
	public PButton(int x, int y){
		super();
		this.x = x; this.y = y;
	}
}

class chessL implements ActionListener {
	
	gameEngine in;
	boolean color;
	public chessL(gameEngine e, boolean color){
		in = e; this.color = color;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		PButton b = (PButton)e.getSource();
		//System.out.println(b.x+" "+b.y);
		in.gameInput(b.x, b.y, color);
	}
}


public class gameFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon white = new ImageIcon("res/white.gif");
	ImageIcon black = new ImageIcon("res/black.gif");
	
	gameEngine in;
	PButton[][] arr;
	int x, y;
	public gameFrame(gameEngine e) {
		in = e;
		int X = e.paneX;
		int Y = e.paneY;
		setTitle("오목 판");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container con = getContentPane();
		
		con.setLayout(new GridLayout(X,Y));
		
		arr = new PButton[e.paneX][e.paneY];
		
		for(int i=0;i<e.paneX;i++){
			for(int j=0;j<e.paneY;j++){
				arr[i][j] = new PButton(i, j);
				arr[i][j].setOpaque(true);
				arr[i][j].setBackground(Color.LIGHT_GRAY);
				arr[i][j].addActionListener(new chessL(e, true));
				//아이콘 삽입
				con.add(arr[i][j]);
			}
		}
		setSize(500,500);
		setVisible(true);
		repaint();
		
	}
	public void paint(Graphics g){
	}
	//돌 표시
	public void view(){
		for(int i=0;i<in.paneX;i++){
			for(int j=0;j<in.paneY;j++){
				if((in.pane[i][j].visible==true)&&(in.pane[i][j].color==true)) arr[i][j].setIcon(black);;//검은돌 놓기
				
				if((in.pane[i][j].visible==true)&&(in.pane[i][j].color==false)) arr[i][j].setIcon(white);;//흰돌 놓기
			}
		}
		
	}
	
	
}
