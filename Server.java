import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.net.SocketException; 
import java.util.StringTokenizer;
  

public class Server
{ 
    public static void main(String[] args) throws IOException 
    { 
    	DatagramSocket ds = new DatagramSocket(2234); 
        byte[] r = new byte[65535]; 
        int a ,b;
  
        DatagramPacket DpReceive = null; 
        DatagramPacket DpSend=null;
        while (true) 
        { 
  
            DpReceive = new DatagramPacket(r, r.length); 
  
            ds.receive(DpReceive); 
            
            String inp = new String(r, 0, r.length); 
            
            //To remove extra spaces. 
            inp=inp.trim(); 
            System.out.println("Equation Received:- " + inp); 
  
   
  
            if (inp.equals("bye")) 
            { 
                System.out.println("Client sent bye");
                System.out.println(".....EXITING");
                break; 
            } 
            
            
            // Use StringTokenizer to break the 
            // equation into operand and operation 
            StringTokenizer st = new StringTokenizer(inp); 
  
            int oprnd1 = Integer.parseInt(st.nextToken()); 
            String operation = st.nextToken(); 
            int oprnd2 = Integer.parseInt(st.nextToken());
            int result=0; 

  switch(operation){
  case "+": 
                result = oprnd1 + oprnd2; 
                break;
  
  case "-": 
                result = oprnd1 - oprnd2; 
                break;
  
  case "*":
                result = oprnd1 * oprnd2; 
                break;
  
  case "/":
                result = oprnd1 / oprnd2; 
                break;
  }
            System.out.println("Sending the result..."); 
            String res = Integer.toString(result); 
  
                        
                        r = res.getBytes(); 
                        
                        // get the port of client. 
                        int port = DpReceive.getPort(); 
              
                        DpSend = new DatagramPacket(r, r.length, 
                                      InetAddress.getLocalHost(), port); 
                        ds.send(DpSend);
                        
                        r = new byte[65535]; 

        } 
    } 
  
} 


Output:

Equation Received:- 3+5
Sending the result...

