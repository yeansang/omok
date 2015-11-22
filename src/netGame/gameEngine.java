package netGame;

class Piece{
	int x,y;
	boolean color = false;
	boolean visible = false;
	
	public Piece(int x, int y, boolean color){
		this.x = x; this.y = y; this.color = color;
	}
	public void blackTic(){
		this.color=true; this.visible=true;
	}
	public void whiteTic(){
		this.color=false; this.visible=true;
	}
}


public class gameEngine{
	final int paneX = 15;
	final int paneY = 15;
	
	Piece[][] pane = new Piece[paneX][paneY];
	
	public gameEngine(){
		for(int i=0;i<paneX;i++){
			for(int j=0;j<paneY;j++){
				pane[i][j] = new Piece(i,j,false);
			}
		}
	}
	//gameInput 판에 돌을 놓는다. 만약 돌의 위치가 잘못되면 false리턴.
	public boolean gameInput(int x, int y, boolean black){
		if(x<0||y<0||x>paneX||y>paneY) return false;
		if((black==true)&&(pane[x][y].visible==false)){ pane[x][y].blackTic(); return true; }
		if(black==false&&(pane[x][y].visible==false)){ pane[x][y].whiteTic(); return true; }
		return false;
	}
	 
	public boolean winningCheck(boolean black){
		for(int i=0;i<paneY;i++){
			for(int j=0;j<paneX;j++){
				if((pane[j][i].color==black)&&(pane[j][i].visible==true)){
					int count = 1;
					while(true){ //오른쪽으로 5개 
						
						if(count==5) return true;
						if(j+count>paneX||i+count>paneY) break;
						if(!((pane[j+count][i].color==black)&&(pane[j+count][i].visible==true))) break;
						count++;
						
					}
					count = 1;
					while(true){ //오른쪽 대각선으로 5개 
						
						if(count==5) return true;
						if(j+count>paneX||i+count>paneY) break;
						if(!((pane[j+count][i+count].color==black)&&(pane[j+count][i+count].visible==true))) break;
						count++;
						
					}
					count = 1;
					while(true){ //아래쪽으로 5개 
						
						if(count==5) return true;
						if(j+count>paneX||i+count>paneY) break;
						if(!((pane[j][i+count].color==black)&&(pane[j][i+count].visible==true))) break;
						count++;
					}
					count = 1;
					while(true){ //왼쪽 대각선 으로 5개 
						
						if(count==5) return true;
						if(j-count<0||i-count<0) break;
						if(!((pane[j-count][i-count].color==black)&&(pane[j-count][i-count].visible==true))) break;
						count++;
					}
					count = 1;
				}
			}
		}
		return false;
	}

	//winnerChecker 스트링으로 승리한 색 리턴. 만약 승리자가 없다면 null리턴.
	public String winnerChecker(){
		if(winningCheck(true)) return "Black";
		if(winningCheck(false)) return "White";
		else return null;
	}

}
