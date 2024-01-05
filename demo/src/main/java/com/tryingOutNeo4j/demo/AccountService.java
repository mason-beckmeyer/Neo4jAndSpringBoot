package com.tryingOutNeo4j.demo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepo accountRepo;
    private final UserRepo userRepo;

    public AccountService(AccountRepo accountRepo, UserRepo userRepo) {
        this.accountRepo = accountRepo;
        this.userRepo = userRepo;
    }

    public void createAccount(String name, String typeOfAccount, boolean isPremium, List<User> users){
        Account newAccount = new Account();
        newAccount.setName(name);
        newAccount.setTypeOfAccount(typeOfAccount);
        newAccount.setPremiumAccount(isPremium);
        if (users !=null){
            newAccount.setUsers(users);
        }
        accountRepo.save(newAccount);
    }

    public void linkUserToAccount(Long acctId,Long userId){

        Optional<Account> acct = accountRepo.findById(acctId);
        Optional<User> usr = userRepo.findById(userId);
        if (acct.isPresent() && usr.isPresent()){
            Account account = acct.get();
            account.addUser(usr.get());
            accountRepo.save(account);
        }

    }

}
