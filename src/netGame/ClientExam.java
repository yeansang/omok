package netGame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientExam
{
	public static void main(String[] args)
	{
		try
		{
			Socket socket = new Socket("127.0.0.1", 8000);
			
			// 서버에게 보내기 위한 준비
			BufferedWriter bufferedWriter = 
					new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			for(int i = 0;i<10;i++){
			bufferedWriter.write("안녕하세요!");
			bufferedWriter.newLine(); //readLine()으로 읽기 때문에 개행 추가
			bufferedWriter.flush();

			BufferedReader bufferedReader = 
					new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// 서버부터 메시지 입력받음
			String clientMessage = bufferedReader.readLine();
			// 입력받은 내용을 서버 콘솔에 출력
			System.out.println("서버가 보내온 내용 : " + clientMessage);
			}
			socket.close();//접속 종료
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} 
	}
}