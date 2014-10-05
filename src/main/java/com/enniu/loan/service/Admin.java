package com.enniu.loan.service;

import com.enniu.loan.domain.LoanOrder;
import com.enniu.loan.domain.LoanOrderCriteria;
import com.enniu.loan.persistence.LoanOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

@RequestMapping("/admin/**")
@Controller
public class Admin {

    @Autowired
    private LoanOrderMapper loanOrderMapper;

    @RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping
    public String index() {
        LoanOrderCriteria criteria = new LoanOrderCriteria();
        criteria.or().andAmountEqualTo(100.0);

        List<LoanOrder> orderList = loanOrderMapper.selectByCriteria(criteria);

        checkResult(orderList);

        // ========

        criteria.clear();
        criteria.or().andAmountEqualTo(99.0);
        orderList = loanOrderMapper.selectByCriteria(criteria);

        checkResult(orderList);

        return "admin/index";
    }

    private void checkResult(List<LoanOrder> orderList) {
        if (orderList == null) {
            System.out.println("where is my account?");
        } else {
            System.out.println("Credit card number is: " + orderList.get(0));
        }
    }
}
