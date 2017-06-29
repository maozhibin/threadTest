package Scoket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/*
 * 客户端
 */
public class Client {
	private String host = "localhost";// 默认连接到本机
	private int port = 1111;// 默认连接到端口8189

	public Client() {

	}

	// 连接到指定的主机和端口
	public Client(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void chat() {
		try {
			Socket socket = new Socket(host, port);
			try {
				// 读取服务器端传过来信息的DataInputStream
				DataInputStream in = new DataInputStream(socket.getInputStream());
				// 向服务器端发送信息的DataOutputStream
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				Scanner scanner = new Scanner(System.in);
				while (true) {
					String send = scanner.nextLine();
					System.out.println("客户端：" + send);
					// 把从控制台得到的信息传送给服务器
					out.writeUTF("客户端：" + send);
					// 读取来自服务器的信息
					String accpet = in.readUTF();
					System.out.println(accpet);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (socket != null) {
					socket.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Client().chat();
	}
}