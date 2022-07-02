import java.net.*;
import java.io.*;
public class TCPServer {
    public static void main(String[] args)throws Exception {
        String get,cap;
        ServerSocket ss = new ServerSocket(1222);
        ObjectInputStream in;
        ObjectOutputStream op;
        while(true)
        {
            Socket s = ss.accept();
            in = new ObjectInputStream(s.getInputStream());
            get = (String)in.readObject();
            cap = get.toUpperCase();
            op = new ObjectOutputStream(s.getOutputStream());
            op.writeObject(cap);
            op.flush();
        }
    }
}