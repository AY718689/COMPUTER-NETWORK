import java.net.*;
import java.io.*;
import java.util.*;
public class TCPClient {
    public static void main(String[] args) throws Exception {
        String old,new1;
        System.out.println("Enter the Sentence :");
        Scanner sc = new Scanner(System.in);
        old = sc.nextLine();
        ObjectOutputStream op;
        ObjectInputStream in;
        Socket s = new Socket("localhost",1222);
        op = new ObjectOutputStream(s.getOutputStream());
        op.writeObject(old);
        op.flush();

        in = new ObjectInputStream(s.getInputStream());
        new1 = (String)in.readObject();
        System.out.println("From SERVER : "+new1);
        s.close();
    }
}
