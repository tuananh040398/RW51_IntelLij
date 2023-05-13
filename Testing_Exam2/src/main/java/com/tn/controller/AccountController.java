package com.tn.controller;

import com.tn.dto.AccountDTO;
import com.tn.dto.CreatingAccountForm;
import com.tn.entity.Account;
import com.tn.repository.AccountrRepository;
import com.tn.service.AccountService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@Controller
@RequestMapping("account")
public class AccountController {

    @Autowired
    private ModelMapper modelMapper;

//    @Autowired
//    private AccountrRepository accountrRepo;

    @Autowired
    private AccountService accountService;


//    @GetMapping("account")
//    public String getAllAccounts(Pageable pageable, Model model){
//
//        Page<Account> accountPage = accountService.getAllAccounts(pageable);
//
//        List<AccountDTO> accountDTOS = modelMapper.map(accountPage.getContent(), new TypeToken<List<AccountDTO>>(){
//        }.getType());
//
//        Page<AccountDTO> accountDTOPage = new PageImpl<>(accountDTOS, pageable, accountPage.getTotalElements());
//
//        model.addAttribute("listAccount", accountDTOPage);
//
//        return "account-list";
//    }

    @GetMapping
    public String viewListAccount(Model model){
        return findPaginated(1, "fullName", "asc", model);
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") Integer pageNo,
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

        return "account-list";
    }

    @GetMapping("add")
    public String add(){
        return "account-add";
    }

    @PostMapping("save")
    public String save(@ModelAttribute CreatingAccountForm form){
        TypeMap<CreatingAccountForm, Account> typeMap = modelMapper.getTypeMap(CreatingAccountForm.class, Account.class);
        modelMapper.addMappings(new PropertyMap<CreatingAccountForm, Account>() {

            @Override
            protected void configure() {
                skip(destination.getId());
            }
        });

        Account account = modelMapper.map(form, Account.class);

        accountService.save(account);
        return "redirect:/account";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Account account = accountService.getById(id);
        model.addAttribute("account", account);
        return "account-edit";
    }

    @PostMapping("update")
    public String update(@ModelAttribute Account account){
        accountService.save(account);
        return "redirect:/account";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Integer id){
        accountService.delete(id);

        return "redirect:/account";
    }

    @RequestMapping("search")
    public String viewSearch(Model model, @Param("keyword") String keyword){
        List<Account> accountList = accountService.listAll(keyword);

        model.addAttribute("listAccount", accountList);
        model.addAttribute("keyword", keyword);

        return "account-list";
    }
}
