package com.tn.controller;

import com.tn.account.CreatingAccountForm;
import com.tn.dto.AccountDTO;
import com.tn.entity.Account;
import com.tn.repository.AccountRepository;
import com.tn.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping()
    public String getAll(Model model){
        List<Account> accounts = accountService.getAll();
        List<AccountDTO> accountDTOS = new ArrayList<>();
        accounts.forEach(obj ->{
            AccountDTO accountDTO = new AccountDTO();
            accountDTO.setId(obj.getId());
            accountDTO.setUserName(obj.getUserName());
            accountDTO.setFullName(obj.getFullName());
            accountDTO.setEmail(obj.getEmail());
            accountDTO.setRole(obj.getRole());

            accountDTO.setDepartmentId(obj.getDepartment().getDepartmentName());

            accountDTOS.add(accountDTO);
        });
        System.out.println(accountDTOS);
        model.addAttribute("listAccount",accountDTOS);
        return "account-list";
    }

    @GetMapping("add")
    public String add(){
        return "account-add";
    }

//    @PostMapping("save")
//    public String save(@ModelAttribute Account account){
//        System.out.println("account");
//        System.out.println(account);
//        return "account-add";
//    }

    @PostMapping("update")
    public String createAccount(@ModelAttribute CreatingAccountForm form){
        accountService.createAccount(form);
        return "redirect:/account";
    }

    @PostMapping("update1")
    public  String update1(@ModelAttribute Account account){
        accountService.save(account);
        return "redirect:/account";
    }

    @GetMapping("deleteById/{id}")
    public String deleteById(@PathVariable Integer id){
        System.out.println(id);
        accountService.delete(id);
        return "redirect:/account";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable Integer id,Model model){
        Account account = accountService.getById(id);
        model.addAttribute("account",account);
        return "account-edit";
    }



}
