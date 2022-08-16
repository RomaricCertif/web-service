package com.doranco.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Deamon implements Runnable {

	public static void main(String[] args) {
		Thread thread = new Thread(new Deamon());
		thread.start();
	}

	@Override
	public void run() {
		ServerSocket s;
		Socket incoming;
		BufferedInputStream bis;
		BufferedOutputStream bos;
		int num;
		try {
			s = new ServerSocket(8888);
			s.setSoTimeout(200000);
			incoming = s.accept();
			while (true) {
				
				InputStream inStream = incoming.getInputStream();
				BufferedReader inm = new BufferedReader(new InputStreamReader(inStream));
				//OutputStream outStream = incoming.getOutputStream();
	
				
				byte[] receivedData = new byte[8192];
				bis = new BufferedInputStream(incoming.getInputStream());
				bos = new BufferedOutputStream(new FileOutputStream("request.xml"));
				while ((num = bis.read(receivedData)) != -1) {
					bos.write(receivedData, 0, num);
				}
				
				//PrintWriter out = new PrintWriter(outStream, true);
				bos.close();
				bis.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
