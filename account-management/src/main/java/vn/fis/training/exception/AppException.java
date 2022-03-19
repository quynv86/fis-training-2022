package vn.fis.training.exception;

public class AppException  extends RuntimeException{
    private String code;
    public AppException(String code, String message) {
        super(message);
        this.code = code;
    }
}
