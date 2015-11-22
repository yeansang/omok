package netGame;

public class SeverMain {
	public static void main(String[] args){
		gameEngine e = new gameEngine();
		gameFrame h = new gameFrame(e);
		GameServer server = new GameServer(8080);
		Piece temp;
		h.setTitle("¿À¸ñ Server");
		
		server.waiting();
		System.out.println("¿¬°áµÊ");
		
		
		while(true){
			h.view();
			boolean d = true;
			while(d){
			try{
				temp = h.cl.returnPoint();
				if(temp!=null) d=false;
				e.gameInput(temp.x, temp.y, true);
				server.setPoint(temp);
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
			d = true;
			h.view();
			while(d){
				try{
					temp = server.getPoint();
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
		}
	}
}
