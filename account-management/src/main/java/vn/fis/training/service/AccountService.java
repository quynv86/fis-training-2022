package vn.fis.training.service;

import vn.fis.training.domain.Account;

import java.util.ArrayList;
import java.util.List;

public interface AccountService {

    Account createAccount(Account account);

    Account updateAccount(Account account);

    void deleteAccount(Long accountId);

    List<Account> findAllAccountOrderByIdAsc();

}
