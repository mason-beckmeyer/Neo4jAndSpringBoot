package com.tryingOutNeo4j.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {
    private final AccountRepo accountRepo;
    private final UserRepo userRepo;
    private final AccountService accountService;

    @GetMapping
//@ResponseBody
    public String findAll(Model model) {
        Iterable<Account> accounts = accountRepo.findAll();
        model.addAttribute("accounts", accounts);
        return "accountsList.html";

    }

    @GetMapping("/createAccount")
    public String showForm() {
        return "createAccount.html";
    }

    @PostMapping("/submit")
    public String handleSubmit(
            @RequestParam String name,
            @RequestParam String type,
            @RequestParam(required = false) Boolean checkbox
    ) {
        Account account = new Account();
        account.setName(name);
        account.setTypeOfAccount(type);
        account.setPremiumAccount(checkbox);

        accountRepo.save(account);


        return "redirect:/accounts";
    }

    @GetMapping("/{name}")
    @ResponseBody
    public Iterable<Account> getAccountByName(@PathVariable String name) {
        return accountRepo.getAccountByName(name);
    }

    @GetMapping("/linkUserToAccount")
    public String linkUserToAccount() {
        return "linkUserToAccount.html";
    }

    @PostMapping("/linkUser")
    public String handleSubmit(
            @RequestParam Long accountId,
            @RequestParam Long userId
    ) {
        accountService.linkUserToAccount(accountId, userId);


        return "redirect:/accounts";
    }


}
