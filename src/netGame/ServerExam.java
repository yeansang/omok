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
			ServerSocket serverSocket = new ServerSocket(8000); // �������� ����

			while (true)
			{
				System.out.println("Ŭ���̾�Ʈ ���� ��� ��...");
				Socket socket = serverSocket.accept(); // �����������κ��� ���� ��ü ��������

				System.out.println(socket.getInetAddress() + "�� ���ӵǾ����ϴ�.");

				// InputStream inputStream = socket.getInputStream();
				// InputStreamReader inputStreamReader = new
				// InputStreamReader(inputStream);
				// BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

				// ���� ������ ���ٷ� ǥ��
				BufferedReader bufferedReader = 
						new BufferedReader(new InputStreamReader(socket.getInputStream()));

				// Ŭ���̾�Ʈ�κ��� �޽��� �Է¹���
				String clientMessage = bufferedReader.readLine();

				// �Է¹��� ������ ���� �ֿܼ� ���
				System.out.println("Ŭ���̾�Ʈ�� ������ ���� : " + clientMessage);

				// Ŭ���̾�Ʈ���� ������ ���� �غ�
				BufferedWriter bufferedWriter = 
						new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				
				bufferedWriter.write("JAVA�� ���迡 ���� ���� ȯ���մϴ�!");
				bufferedWriter.newLine(); //readLine()���� �����Ƿ� ���ٳ��� �˸�
				bufferedWriter.flush();
				
				//PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
				//printWriter.println("JAVA�� ���迡 ���� ���� ȯ���մϴ�!!");
				
				socket.close();//���� ����
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}