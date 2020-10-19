package com.bankofsimba.bank.controller;

import com.bankofsimba.bank.model.BankAccount;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BankAccountController {

  private List<BankAccount> bankAccountList = new ArrayList<>();

  public BankAccountController() {
    bankAccountList.add(new BankAccount("Simba", 2000, "lion", "good"));
    bankAccountList.add(new BankAccount("Mufasa", 5000, "lion", true, "good"));
    bankAccountList.add(new BankAccount("Nala", 1500, "lion", "good"));
    bankAccountList.add(new BankAccount("Timon", 500, "meerkat", "good"));
    bankAccountList.add(new BankAccount("Pumba", 500, "warthog", "good"));
    bankAccountList.add(new BankAccount("Scar", 3000, "lion", "bad"));
  }

  @GetMapping("/show")
  public String showDetails(Model model) {
    model.addAttribute("accounts", bankAccountList);
    return "bankDetails";
  }

  @PostMapping("/raised")
  public String updateDetails(@ModelAttribute(name = "accountName") String accountName) {
    for (BankAccount account: bankAccountList) {
      if (account.getName().equals(accountName)){
        int balance = account.getBalance();
        if (account.isKing()){
          balance += 100;
        } else {
          balance += 10;
        }
        account.setBalance(balance);
      }
    }
    return "redirect:/show";
  }

  @PostMapping("/add")
  public String addAccount(@ModelAttribute BankAccount newAccount){
    bankAccountList.add(newAccount);

    return "redirect:/show";
  }

  @GetMapping("/html")
  public String HTMLception(Model model) {
    model.addAttribute("utext", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");
    return "utext";
  }
}
