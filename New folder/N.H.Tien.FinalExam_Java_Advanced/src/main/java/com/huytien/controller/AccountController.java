package com.huytien.controller;

import com.huytien.dto.entitydto.AccountDTO;
import com.huytien.entity.Account;
import com.huytien.from.AccountFormFilter;
import com.huytien.from.CreatingAccountForm;
import com.huytien.from.UpdateAccountForm;
import com.huytien.service.AccountService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("api/v1/accounts")
@Log4j2
@CrossOrigin("*")
public class AccountController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AccountService accountService;

    @GetMapping()
    public String viewListAccount(Model model){
        return findPaginated(1, "fullName", "asc", model);
    }

//    @GetMapping("/search")
//    public String search(Model model){
//        return null;
//    }

//     Get All List Account, seach, filter
//    @GetMapping("/search")
//    public String getAllAccounts(Pageable pageable,
//                                           @RequestParam(value = "search", required = false) String search,
//                                           AccountFormFilter filter,
//                                           Model model){
//
//        Page<Account> accountPage = accountService.getAllAccounts(pageable, search, filter);
//
//        List<AccountDTO> accountDTOS = modelMapper.map(accountPage.getContent(), new TypeToken<List<AccountDTO>>() {}.getType());
//
//        Page<AccountDTO> accountDTOPage = new PageImpl<>(accountDTOS, pageable, accountPage.getTotalElements());
//
//        model.addAttribute("listAccount", accountDTOPage);
//        String text = search;
//
//        model.addAttribute("search", search);
//        model.addAttribute("filter", filter);
//
//        return "list-account";
//    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") Integer pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model){
        Integer pageSize = 5;

        Page<Account> page = accountService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Account> accountList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : ("asc"));

        model.addAttribute("listAccount", accountList);

        return "list-account";
    }

    // Go to page add new Account
    @GetMapping("add")
    public String add() {
        return "account-creating";
    }

    // add new Account
    @PostMapping("creating")
    public String createAccount(@ModelAttribute CreatingAccountForm form){
        accountService.createAccount(form);
        return "redirect:/api/v1/accounts";
    }

    @GetMapping("username/{username}/exists")
    public boolean existsByName(@PathVariable String username){
        return accountService.isAccountExistsByUsername(username);
    }

    // Delete Account
    @GetMapping("delete/{id}")
    public String deleteById(@PathVariable Integer id){
        accountService.deleteById(id);
        return "redirect:/api/v1/accounts";
    }

    // Go to Page Edit Account
    @GetMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Account account = accountService.getById(id);

        model.addAttribute("account", account);
        return "account-edit";
    }

    // update
    @PostMapping("update")
    public String updateById(@ModelAttribute UpdateAccountForm form){
        accountService.update(form);
        return "redirect:/api/v1/accounts";
    }

    @DeleteMapping("{ids}")
    public void deleteByIds(@RequestParam List<Integer> ids){
        accountService.deleteAccountsByIds(ids);
    }

}
