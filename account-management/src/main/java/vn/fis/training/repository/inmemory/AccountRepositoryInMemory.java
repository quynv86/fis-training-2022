package vn.fis.training.repository.inmemory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.fis.training.domain.Account;
import vn.fis.training.exception.AccountIdNotFoundException;
import vn.fis.training.repository.AccountRepository;

import java.util.*;


public class AccountRepositoryInMemory implements AccountRepository {
    static final Logger  LOG  = LogManager.getLogger(AccountRepositoryInMemory.class);

    private Map<Long, Account> storage;

    public AccountRepositoryInMemory() {
        storage = new HashMap<>();
    }


    @Override
    public Account addAccount(Account account) {
        LOG.info("Adding account to storage: {}", account);
        storage.put(account.getId(), account);
        return account;
    }

    @Override
    public Account updateAccount(Account account) {
        Account existedAccount = this.findById(account.getId());
        if(existedAccount==null) {
            throw new AccountIdNotFoundException(account.getId(), String.format("Not Found Account With Id %d",+ account.getId()));
        }
        // Thuc hien update
        return account;
    }

    @Override
    public void deleteAccount(Long accountId) {
        LOG.info("Deleting Account with Id: {}", accountId);
        storage.remove(accountId);
    }

    @Override
    public List<Account> findAllAccountOrderByIdAsc() {
        LOG.info("Find All Account");
        List<Account> accounts = new ArrayList<>(storage.values());
        Collections.sort(accounts, new Comparator<Account>() {
            @Override
            public int compare(Account firstAccount, Account secondAccount) {
                return firstAccount.getId().compareTo(secondAccount.getId());
            }
        });
        return accounts;
    }

    @Override
    public Account findById(Long accountId) {
        LOG.info("Find Account By Id: {}", accountId);
         Account foundAccount = storage.get(accountId);
         if(foundAccount==null) {
             LOG.info("Not found account with Id: {}. Return Null value instate", accountId);
         }
         return foundAccount;
    }
}
