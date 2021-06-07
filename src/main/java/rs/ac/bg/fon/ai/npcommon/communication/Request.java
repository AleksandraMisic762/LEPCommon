package  rs.ac.bg.fon.ai.npcommon.communication;

import java.io.Serializable;
import com.google.gson.JsonObject;

public class Request implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private Operation operation;
//    private Object argument;
	private JsonObject argument;


    public Request() {
    }

    public Request(JsonObject argument) {
        this.argument = argument;
    }

    public JsonObject getArgument() {
        return argument;
    }

    public void setArgument(JsonObject argument) {
        this.argument = argument;
    }
    
}
