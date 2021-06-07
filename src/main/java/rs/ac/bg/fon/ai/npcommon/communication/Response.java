package  rs.ac.bg.fon.ai.npcommon.communication;

import java.io.Serializable;

import com.google.gson.Gson;

public class Response  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private Object result;
//    private Exception exception;
	private Gson result;

    public Response() {
    }

    public Response(Gson result) {
        this.result = result;
    }

    public Gson getResult() {
        return result;
    }

    public void setResult(Gson result) {
        this.result = result;
    }
  
    
}
