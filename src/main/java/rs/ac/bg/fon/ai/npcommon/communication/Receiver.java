package  rs.ac.bg.fon.ai.npcommon.communication;

import java.io.ObjectInputStream;
import java.net.Socket;

public class Receiver {
    private Socket socket;

    public Receiver(Socket socket) {
        this.socket = socket;
    }
    
    public Object receive() throws Exception{
        try {
            ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (Exception ex) {
            throw new Exception("Greska pri primanju objekta!\n" + ex.getMessage());
        }
    }
}
