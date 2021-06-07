package  rs.ac.bg.fon.ai.npcommon.communication;

import java.io.ObjectOutputStream;
import java.net.Socket;

import com.google.gson.JsonObject;

public class Sender {
    private final Socket socket;

    public Sender(Socket socket) {
        this.socket = socket;
    }
    
    public void send(JsonObject object) throws Exception{
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(object);
            out.flush();
        } catch (Exception ex) {
            socket.close();
            throw ex;
        }
    }
}
