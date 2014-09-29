package com.enniu.loan.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enniu.loan.domain.Account;
import com.enniu.loan.persistence.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/admin/**")
@Controller
public class Admin {

    @Autowired
    private AccountMapper accountMapper;

    @RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping
    public String index() {
        Account account = accountMapper.getAccountByUsername("demo");
        if (account == null) {
            System.out.println("where is my account?");
        }

        return "admin/index";
    }
}
