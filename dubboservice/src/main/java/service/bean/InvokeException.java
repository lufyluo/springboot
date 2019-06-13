package service.bean;

public class InvokeException extends RuntimeException {
    private static final long serialVersionUID = -4742832112872227456L;
    /**系统错误码*/
    private int code;
    /**错误描述*/
    private String msg;

    private String details;

    public InvokeException(){
        super();
    }
    public InvokeException(Throwable t){
        super(t);
    }
    public InvokeException(int code,String msg,String details){
        super();
        this.code = code;
        this.msg = msg;
        this.details = details;
    }
    public InvokeException(int code,String msg){
        super();
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

