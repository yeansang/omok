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
	//gameInput �ǿ� ���� ���´�. ���� ���� ��ġ�� �߸��Ǹ� false����.
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
					while(true){ //���������� 5�� 
						
						if(count==5) return true;
						if(j+count>paneX||i+count>paneY) break;
						if(!((pane[j+count][i].color==black)&&(pane[j+count][i].visible==true))) break;
						count++;
						
					}
					count = 1;
					while(true){ //������ �밢������ 5�� 
						
						if(count==5) return true;
						if(j+count>paneX||i+count>paneY) break;
						if(!((pane[j+count][i+count].color==black)&&(pane[j+count][i+count].visible==true))) break;
						count++;
						
					}
					count = 1;
					while(true){ //�Ʒ������� 5�� 
						
						if(count==5) return true;
						if(j+count>paneX||i+count>paneY) break;
						if(!((pane[j][i+count].color==black)&&(pane[j][i+count].visible==true))) break;
						count++;
					}
					count = 1;
					while(true){ //���� �밢�� ���� 5�� 
						
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

	//winnerChecker ��Ʈ������ �¸��� �� ����. ���� �¸��ڰ� ���ٸ� null����.
	public String winnerChecker(){
		if(winningCheck(true)) return "Black";
		if(winningCheck(false)) return "White";
		else return null;
	}

}
