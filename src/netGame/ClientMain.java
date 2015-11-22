package netGame;

public class ClientMain {
	public static void main(String[] args){
		gameEngine e = new gameEngine();
		gameFrame h = new gameFrame(e);
		GameClient client = new GameClient("127.0.0.1", 8080);
		Piece temp;
		h.setTitle("¿À¸ñ Client");
		
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
				h.win.setText(e.winnerChecker()+"Win!!");
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
					h.win.setText(e.winnerChecker()+"Win!!");
					h.view();
					break;
				}
			}
			client.closeClient();
		}
	}

