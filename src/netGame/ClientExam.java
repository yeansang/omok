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
			
			// �������� ������ ���� �غ�
			BufferedWriter bufferedWriter = 
					new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			for(int i = 0;i<10;i++){
			bufferedWriter.write("�ȳ��ϼ���!");
			bufferedWriter.newLine(); //readLine()���� �б� ������ ���� �߰�
			bufferedWriter.flush();

			BufferedReader bufferedReader = 
					new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// �������� �޽��� �Է¹���
			String clientMessage = bufferedReader.readLine();
			// �Է¹��� ������ ���� �ֿܼ� ���
			System.out.println("������ ������ ���� : " + clientMessage);
			}
			socket.close();//���� ����
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} 
	}
}