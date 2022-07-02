import java.net.*;
import java.io.*;
import java.util.*;
/**
 * TimeClient
 */
public class TimeClient {
    public static void main(String[] args)throws IOException {
        Socket s=null;
        try{
            s = new Socket("localhost",8999);
        }
        catch(IOException e){
            System.err.println(e);
        }
        try{
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            Date str = (Date)in.readObject();
            System.out.println(str);
        }catch(ClassNotFoundException e)
        {
            System.err.println(e);
        }
        s.close();
    }
    
}