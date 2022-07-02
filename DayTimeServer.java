import java.net.*;
import java.io.*;
import java.util.*;
public class DayTimeServer
{
    public static void main(String[] args) throws IOException {
        ServerSocket s;
        Socket ss;
        PrintStream p;
        try{
            s = new ServerSocket(13);
            try{
                ss = s.accept();
                while(true){
                    p = new PrintStream(ss.getOutputStream());
                    p.println(new Date());
                    ss.close();
                }
            }catch(IOException e){
                System.err.println(e);
            }
        }catch(IOException e){
            System.err.println(e);
        }
    }
}