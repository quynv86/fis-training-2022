package vn.fis.training.repository.inmemory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vn.fis.training.domain.Account;
import vn.fis.training.repository.AccountRepository;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class AccountRepositoryInMemoryTest {

    static final Logger LOG = LogManager.getLogger(AccountRepositoryInMemoryTest.class);
    AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
        LOG.info("Init Account Repository...");
        accountRepository  = new AccountRepositoryInMemory();
    }

    @Test void given_anValid_Account_Call_AddAccount_Should_Success() {
        Account account = new Account(1L,"045112345678", "Nguyen Van A", 10000.0, 1);
        Account addedAccount = accountRepository.addAccount(account);
        assertTrue(addedAccount.equals(account));
    }

    @Test void given_anValid_AccountId_Call_Delete_Should_Success() {
        Account account = new Account(1L,"045112345678", "Nguyen Van A", 10000.0, 1);
        accountRepository.addAccount(account);
        accountRepository.deleteAccount(1L);
        assertTrue(accountRepository.findAllAccountOrderByIdAsc().size()==0);
    }

    @Test void given_Unsorted_Account_List_Call_FindAll_Should_Return_Sorted_Account_List() {
//        Account smallerAccount = new Account(1L,"045112345678", "Nguyen Van A", 10000.0, 1);
//        Account biggerAccount = new Account(3L,"045112345674", "Nguyen Van B", 10000.0, 1);
//        Account biggerAccount = new Account(3L,"045112345674", "Nguyen Van B", 10000.0, 1);
//        Account biggerAccount = new Account(3L,"045112345674", "Nguyen Van B", 10000.0, 1);
//        Account biggerAccount = new Account(3L,"045112345674", "Nguyen Van B", 10000.0, 1);

//        accountRepository.addAccount(biggerAccount);
//        accountRepository.addAccount(smallerAccount);

//        Stream.of(new Account(3L,"045112345678", "Nguyen Van A", 10000.0, 1)
//                ,new Account(1L,"045112345678", "Nguyen Van A", 10000.0, 1))
//            .forEach((account)-> {
//                accountRepository.addAccount(account);
//            });

//        Stream.of(new Account(3L,"045112345678", "Nguyen Van A", 10000.0, 1)
//                ,new Account(1L,"045112345678", "Nguyen Van A", 10000.0, 1))
//                .forEach(accountRepository::addAccount);

        Stream.of(1L,3L)
                .map((accountId) -> {
                    return new Account(accountId,"045112345678", "Nguyen Van A", 10000.0, 1);
                })
                .forEach(accountRepository::addAccount);
        List<Account> sortedAccounts = accountRepository.findAllAccountOrderByIdAsc();

        assertTrue(sortedAccounts.get(0).getId() == 1L && sortedAccounts.get(1).getId() == 3L);
    }

}