package com.tn.controller;

import com.tn.dto.AccountDTO;
import com.tn.entity.Account;
import com.tn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public String getAll(Model model){
        List<Account> accounts = accountService.getAll();

        List<AccountDTO> accountDTOS = new ArrayList<>();
        accounts.forEach(obj ->{
            AccountDTO accountDTO = new AccountDTO();
            accountDTO.setId(obj.getId());
            accountDTO.setUsername(obj.getUsername());

            accountDTOS.add(accountDTO);
        });
        model.addAttribute("listAccount", accountDTOS);

        return "account-list";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Integer id){
        System.out.println(id);

        accountService.delete(id);
        return "redirect:/account";
    }

    @PostMapping("createdata")
    public String save(@RequestBody Account obj){
        accountService.save(obj);
        return "save success";
    }

    @PutMapping("updatedata/{id}")
    public String update(@PathVariable Integer id, @RequestBody Account obj){
        obj.setId(id);
        accountService.save(obj);
        return "Update success";
    }
}
