package blaybus.hair_mvp.exception;

import java.util.HashMap;
public class ErrorResponse extends HashMap<String, Object> {
    public ErrorResponse(ExceptionBase exception) {
        super();
        this.put("error", true);
        //this.put("http_status_code", exception.getStatusCode());
        this.put("error_code", exception.getErrorCode().getCode());
        this.put("error_message", exception.getErrorMessage());
    }
}