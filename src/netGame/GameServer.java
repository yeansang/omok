package netGame;

import java.io.*;
import java.net.*;

public class GameServer {
	
	ServerSocket serverSocket;
	Socket socket;

	public GameServer(){
		try{
			serverSocket = new ServerSocket(8000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean waiting(){
		try{
			System.out.println("클라이언트 접속 대기 중...");
			socket = serverSocket.accept(); // 서버소켓으로부터 소켓 객체 가져오기

			System.out.println(socket.getInetAddress() + "가 접속되었습니다.");
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean getPoint(){
		try{
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// 클라이언트로부터 메시지 입력받음
			String clientMessage = bufferedReader.readLine();

			// 입력받은 내용을 서버 콘솔에 출력
			System.out.println("클라이언트가 보내온 내용 : " + clientMessage);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean setPoint(){
		try{
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			bufferedWriter.write("JAVA의 세계에 오신 것을 환영합니다!");
			bufferedWriter.newLine(); //readLine()으로 읽으므로 한줄끝을 알림
			bufferedWriter.flush();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public static void main(String[] args){
		GameServer n = new GameServer();
		n.waiting();
		while(true){
		
		n.getPoint();
		n.setPoint();
		}
		
	}
}
