import java.net.*;
import java.io.*;
public class DayTimeClient {
    public static void main(String[] args){
        Socket s;
        String hostname;
        DataInputStream in;
        if(args.length>0)
            hostname = args[0];
        else    
            hostname = "localhost";
        try{
            s = new Socket(hostname,13);
            in = new DataInputStream(s.getInputStream());
            String str = in.readLine();
            System.out.println(str);
          
        }
        catch(IOException e){
            System.err.println(e);
        }
    }
    
}