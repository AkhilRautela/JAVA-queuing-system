import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {
	public static void main(String args[]) {
		try {
			 Scanner scan = new Scanner(System.in);
			 String IP;
			
			for(;;)
		{
		   InputStreamReader isr = new InputStreamReader(System.in);
		   BufferedReader b1 = new BufferedReader(isr);
		   System.out.println("ENTER SERVER IP");
		   IP = b1.readLine();
	       Socket s = new Socket(IP,3000);
		   System.out.println("CONNECTED \nENTER YOUR NAME\n");
		   
		   String name =b1.readLine();
		   System.out.println("ENTER 1 FOR HOSPITAL\nENTER 2 FOR BARBERSHOP\nENTER 3 FOR REATAURANTS");
		   int i = Integer.parseInt((b1.readLine()));
		   String SDATA="";
		   if(i==1) {
			   SDATA="HOSPITAL";
		   }
		   else if(i==2) {
			   SDATA="BARBER SHOP";
		   }
		   else if(i==3) {
			   SDATA="RESTAURANTS";
		   }
		   else {
			   System.out.println("INVALID RESPONSE \nEXITING.........");
			   System.exit(0);
		   }
		   System.out.println("SENDING DATA");
		   PrintWriter p= new PrintWriter(s.getOutputStream());
		   p.write(name+"\n");
		   p.write(SDATA+"\n");
		   p.flush();
		   System.out.println(".................");
		   Thread.sleep(3000);
		   System.out.println("DATA SENT");
		   System.out.println("\n");
		   
		}
		   
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	
	
	}

}
