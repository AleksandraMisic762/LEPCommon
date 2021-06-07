package  rs.ac.bg.fon.ai.npcommon.communication;

import java.io.Serializable;

import com.google.gson.Gson;

public class Request implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private Operation operation;
//    private Object argument;
	private Gson argument;

    public Request() {
    }

    public Request(Gson argument) {
        this.argument = argument;
    }

    public Gson getArgument() {
        return argument;
    }

    public void setArgument(Gson argument) {
        this.argument = argument;
    }
    
}
