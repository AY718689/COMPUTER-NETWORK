import java.net.*;
import java.io.*;

public class TCPEchoClient {
    public static void main(String[] args)throws IOException {
        if((args.length<2)||(args.length>3))
            throw new IllegalArgumentException("Parameter(s) :<server> <word> [<port>]");
        String server = args[0];
        int port = (args.length==3) ? Integer.parseInt(args[2]) : 7;
        Socket s = new Socket(server,port);
        InputStream in = s.getInputStream();
        OutputStream out =s.getOutputStream();
        byte[] buf = args[1].getBytes();
        out.write(buf);
        int totalbytesrcvd = 0;
        int bytesrcvd;
        while(totalbytesrcvd<buf.length)
        {
            if((bytesrcvd = in.read(buf,totalbytesrcvd,buf.length-totalbytesrcvd))==-1)
                throw new SocketException("Connection close prematurely");
            totalbytesrcvd += bytesrcvd;
        } 
        System.out.println("From SERVER :"+new String(buf));
        s.close();
    }
}
