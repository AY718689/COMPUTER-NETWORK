import java.net.*;
import java.io.*;
public class TCPEchoServer {
    public static void main(String[] args)throws IOException{
        if(args.length!=1)
            throw new IllegalArgumentException("Parameter :<port>");
        int servPort = Integer.parseInt(args[0]);
        ServerSocket ss = new ServerSocket(servPort);
        while(true)
        {
            Socket s = ss.accept();
            byte[] buf = new byte[80];
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            int rcvmsg;
            while((rcvmsg=in.read(buf))!=-1)
            {
                out.write(buf, 0, rcvmsg);
            }
            s.close();
        }

    }
}
