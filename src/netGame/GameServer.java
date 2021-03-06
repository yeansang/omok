package netGame;

import java.io.*;
import java.net.*;
import java.util.*;

public class GameServer {
	
	ServerSocket serverSocket;
	Socket socket;
	DataInputStream in; 
	DataOutputStream out;
	

	public GameServer(int SOKET){
		try{
			serverSocket = new ServerSocket(SOKET);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean waiting(){
		try{
			System.out.println("클라이언트 접속 대기 중...");
			socket = serverSocket.accept(); // 서버소켓으로부터 소켓 객체 가져오기

			System.out.println(socket.getInetAddress() + "가 접속되었습니다.");
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
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
}
