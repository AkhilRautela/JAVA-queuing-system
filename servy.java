package server;
import java.io.*;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class servy {
   public static void main(String args[]) {
	   try {for(;;) {
		   ServerSocket s = new ServerSocket(3000);
		   System.out.println("WAITING FOR CLIENTS ");
		   Socket ss = s.accept();
		   System.out.println("CONNECTED");
		   Date dNow = new Date();
		   SimpleDateFormat ft = 
		   new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
	       InputStreamReader isr = new InputStreamReader(ss.getInputStream());
	       BufferedReader br = new BufferedReader(isr);
	       String name=br.readLine();
	       String data=br.readLine();
	       System.out.println("REQUESTED APPOINTMENT\n");
	       System.out.println("DATE AND TIME : " + ft.format(dNow)); 
	       System.out.println("NAME : "+name);
	       System.out.println("BOOKED APPOINTMENT IN :"+data);
	       System.out.println("RESTARTING SERVER .........");
	       FileOutputStream fos = new FileOutputStream("test.txt",true);
	       OutputStreamWriter osw= new OutputStreamWriter(fos);
	       BufferedWriter bw = new BufferedWriter(osw); 
	       bw.write("NAME : "+name+" \t DATA : "+data);
	       bw.write("\n");
	       bw.flush();
	       System.out.println("DATA STORED");
	       s.close();
	   }}
	   catch(Exception e){
		   System.out.println(e);
	   }
   }
}
