import java.net.*;
import java.io.*;
import java.util.*;
/**
 * TimeServer
 */
public class TimeServer {

    public static void main(String[] args) {
        ServerSocket s;
        Socket ss;
        ObjectOutputStream out;
        try{
            s = new ServerSocket(8999);
            try{
                while(true)
                {
                    ss = s.accept();
                    out = new ObjectOutputStream(ss.getOutputStream());
                    out.writeObject(new Date());
                }
            }catch(IOException e){
                System.err.println(e);
            }
        }catch(IOException e){
        System.err.println(e);
        }
    }
}
