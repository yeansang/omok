package netGame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class GameClient {
	Socket socket;
	DataInputStream in;
	DataOutputStream out;
	
	public GameClient(String ip, int SOCKET){
		try{
			socket = new Socket(ip, SOCKET);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
		}catch (Exception e){
			e.printStackTrace();
		} 
	}
	public Piece getPoint(){
		while (in != null) {
            try {
            	StringTokenizer b = new StringTokenizer(in.readUTF(),"%");
            	int x = Integer.parseInt(b.nextToken());
            	int y = Integer.parseInt(b.nextToken());
            	System.out.println(b.toString());
            	return new Piece(x, y, true);
            } catch (IOException e) {
            }
        }
		return null;
	}
	
	public void setPoint(Piece input){
		try {
			out.writeUTF(input.x+"%"+input.y);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean closeClient(){
		try{
			socket.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

}
