package  rs.ac.bg.fon.ai.npcommon.communication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class Receiver {
    private Socket socket;
    private Gson gson;

    public Receiver(Socket socket) {
        this.socket = socket;
        gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
    }
    
    public JsonObject receive() throws Exception{
        try {
        	BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            return  gson.fromJson(in, JsonObject.class);
        } catch (Exception ex) {
            throw new Exception("Greska pri primanju objekta!\n" + ex.getMessage());
        }
    }
}
