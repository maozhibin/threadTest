package Scoket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
 * 基于TCP协议的Socket通信，实现用户登陆
 * 服务器端
 */
public class Server {
	private static int port = 1111;

	public static void server() {

		try {
			// 建立服务器连接
			ServerSocket server = new ServerSocket(port);
			// 等待客户连接
			Socket socket = server.accept();
			try {
				// 读取客户端传过来信息的DataInputStream
				DataInputStream in = new DataInputStream(socket.getInputStream());
				// 向客户的传送信息
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				Scanner scanner = new Scanner(System.in);
				while (true) {
					// 读取来自客户端的信息
					String accpet = in.readUTF();
					System.out.println(accpet);
					String send = scanner.nextLine();
					System.out.println("服务器：" + send);
					// 把服务器端的输入发给客户端
					out.writeUTF("服务器：" + send);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		server();
	}
}