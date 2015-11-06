package netGame;

public class TempFrame {
	public static void main(String[] args){
		gameEngine e = new gameEngine();
		gameFrame h = new gameFrame(e);
		
		while(true){
		h.view();
		if(e.winnerChecker()!=null){
		System.out.println(e.winnerChecker());
		break;
		}
		}
	}

}
