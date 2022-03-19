package vn.fis.training.exception;

import vn.fis.training.Constants;

public class AccountIdNotFoundException extends  AppException{
    private Long accountId;
    public AccountIdNotFoundException(Long accountId, String message) {
        super(Constants.AccountError.ID_NOT_FOUND, message);
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }
}
