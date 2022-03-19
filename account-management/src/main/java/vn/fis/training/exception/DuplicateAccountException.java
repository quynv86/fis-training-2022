package vn.fis.training.exception;

public class DuplicateAccountException extends AppException{
    public DuplicateAccountException(String code, String message) {
        super(code, message);
    }
}
