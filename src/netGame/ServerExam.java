package netGame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExam
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket serverSocket = new ServerSocket(8000); // 서버소켓 선언

			while (true)
			{
				System.out.println("클라이언트 접속 대기 중...");
				Socket socket = serverSocket.accept(); // 서버소켓으로부터 소켓 객체 가져오기

				System.out.println(socket.getInetAddress() + "가 접속되었습니다.");

				// InputStream inputStream = socket.getInputStream();
				// InputStreamReader inputStreamReader = new
				// InputStreamReader(inputStream);
				// BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

				// 위의 세줄을 한줄로 표현
				BufferedReader bufferedReader = 
						new BufferedReader(new InputStreamReader(socket.getInputStream()));

				// 클라이언트로부터 메시지 입력받음
				String clientMessage = bufferedReader.readLine();

				// 입력받은 내용을 서버 콘솔에 출력
				System.out.println("클라이언트가 보내온 내용 : " + clientMessage);

				// 클라이언트에게 보내기 위한 준비
				BufferedWriter bufferedWriter = 
						new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				
				bufferedWriter.write("JAVA의 세계에 오신 것을 환영합니다!");
				bufferedWriter.newLine(); //readLine()으로 읽으므로 한줄끝을 알림
				bufferedWriter.flush();
				
				//PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
				//printWriter.println("JAVA의 세계에 오신 것을 환영합니다!!");
				
				socket.close();//접속 종료
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}