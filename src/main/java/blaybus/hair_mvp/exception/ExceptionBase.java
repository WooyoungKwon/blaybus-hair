package blaybus.hair_mvp.exception;

import lombok.Getter;

@Getter
public abstract class ExceptionBase extends RuntimeException {
    public abstract int getStatusCode();
    protected String errorMessage;
    protected ErrorResponseCode errorCode;
}
