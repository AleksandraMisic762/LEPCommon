package  rs.ac.bg.fon.ai.npcommon.communication;

import java.io.Serializable;

import com.google.gson.JsonObject;

public class Response  implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private Object result;
//    private Exception exception;
	private JsonObject result;

    public Response() {
    }

    public Response(JsonObject result) {
        this.result = result;
    }

    public JsonObject getResult() {
        return result;
    }

    public void setResult(JsonObject result) {
        this.result = result;
    }
  
    
}
