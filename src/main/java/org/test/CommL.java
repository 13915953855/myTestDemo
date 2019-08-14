package org.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
//import base.util.XDate;

public class CommL {
	public static final String OK = "OK";
	public static final String ER = "ER";
	public static final String HEART_JSON = "\"code\":\"**\"";
	public static final String HEART_CODE = "**";
	
	public static final String GB2312 = "GB2312";
	public static final String UTF8 = "UTF-8";
	
	private Socket socket = null;
	/**
	 * 获取Socket的输入流，用来接收从客户端发送过来的数据
	 */
	private BufferedReader br = null; 
	/**
	 * 获取Socket的输出流，用来向客户端发送数据
	 */
	private PrintWriter pw = null; 
	
	public CommL(Socket socket) throws Exception{
		this.socket = socket;
		//获取Socket的输入流，用来接收从客户端发送过来的数据
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//获取Socket的输出流，用来向客户端发送数据  
		pw = new PrintWriter(socket.getOutputStream(),true);
	}

	public void setSoTimeout(int outTime) throws Exception{
		this.socket.setSoTimeout(outTime);
	}

	public void close(){
		try{socket.close();}catch(Exception e){}
		try{br.close();}catch(Exception e){}
		try{pw.close();}catch(Exception e){}
		socket = null;
		br = null;
		pw = null;
	}
	
	public void sendln(String str,String flag,boolean print,boolean shortPrint) throws Exception{
		pw.println(str);
		pw.flush();
		if(print && !str.contains(HEART_JSON)){	//不打印，心跳不打印
			if(shortPrint){
				String s = str.length()>48 ? str.substring(0,48)+"..."+str.length() : str;
				System.out.println(flag+"SL():"+s);
			}else{
				System.out.println(flag+"SL():"+str);
			}
		}
	}
	
	//**:心跳
	public String readln(String flag,boolean print,boolean shortPrint) throws Exception{
		String str = br.readLine();	//READ
		if(str == null){
			throw new Exception("READ NULL");
		}
		if(print && !str.contains(HEART_JSON)){	//心跳不打印
			if(shortPrint){
				String s = str.length()>48 ? str.substring(0,48)+"..."+str.length() : str;
				System.out.println(flag+"RL():"+s);
			}else{
				System.out.println(flag+"RL():"+str);
			}
		}
		return str;
	}

}