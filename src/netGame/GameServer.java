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
			System.out.println("Ŭ���̾�Ʈ ���� ��� ��...");
			socket = serverSocket.accept(); // �����������κ��� ���� ��ü ��������

			System.out.println(socket.getInetAddress() + "�� ���ӵǾ����ϴ�.");
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean getPoint(){
		try{
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// Ŭ���̾�Ʈ�κ��� �޽��� �Է¹���
			String clientMessage = bufferedReader.readLine();

			// �Է¹��� ������ ���� �ֿܼ� ���
			System.out.println("Ŭ���̾�Ʈ�� ������ ���� : " + clientMessage);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean setPoint(){
		try{
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			bufferedWriter.write("JAVA�� ���迡 ���� ���� ȯ���մϴ�!");
			bufferedWriter.newLine(); //readLine()���� �����Ƿ� ���ٳ��� �˸�
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
