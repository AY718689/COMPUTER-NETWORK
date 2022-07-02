import java.io.*;
import java.net.*;
import java.util.*;
public class MulticastDateServer {
    public static void main(String[] args) throws IOException,InterruptedException {
        DatagramSocket socket = new DatagramSocket(6050);
        InetAddress group = InetAddress.getByName("230.0.0.1");
        for(int i=0;i<10;i++){
            byte[] buf = (new Date().toString()).getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length,group,1313);
            socket.send(packet);
            Thread.sleep(8000);
        }
        socket.close();
    }
}
