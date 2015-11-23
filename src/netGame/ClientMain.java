package netGame;

import java.util.Scanner;

public class ClientMain {
	public static void main(String[] args){
		gameEngine e = new gameEngine();
		gameFrame h = new gameFrame(e);
		h.setTitle("오목 Client");
		Scanner s = new Scanner(System.in);
		h.win.setText("커맨드 창에 ip 주소 입력");
		GameClient client = new GameClient(s.nextLine(), 8080);
		s.close();
		Piece temp;
		h.win.setText("게임중...");
		
		while(true){
			boolean d = true;
			
			h.view();
			
			while(d){
				try{
					temp = client.getPoint();
					if(temp!=null) d=false;
					e.gameInput(temp.x, temp.y, false);
				}catch(NullPointerException e1){
					d = true;
				}
			}
			if(e.winnerChecker()!=null){
				System.out.println(e.winnerChecker());
				h.win.setText(e.winnerChecker()+" Win!!");
				h.view();
				break;
			}
			
			h.view();
			d = true;
			while(d){
				try{
					temp = h.cl.returnPoint();
					if(temp!=null) d=false;
					e.gameInput(temp.x, temp.y, true);
					client.setPoint(temp);
				}catch(NullPointerException e1){
					d = true;
				}
				}
				if(e.winnerChecker()!=null){
					System.out.println(e.winnerChecker());
					h.win.setText(e.winnerChecker()+" Win!!");
					h.view();
					break;
				}
				
			}
			client.closeClient();
		}
	}

