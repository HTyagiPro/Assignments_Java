package com.har.spMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.har.spMVC.dao.BankAccountDao;

@Controller
public class BankAccountController {
	
	@Autowired
	BankAccountDao badao;
	
	@GetMapping("/MoneyTransferForm")
	public String getMoneyTransfer() {
		
		return "MoneyTransferForm";
	}
	
	@GetMapping("/transferMoney")
	public String transferMoney(@CookieValue String username,  @RequestParam double amount, Model model) throws ClassNotFoundException {
		String message = "Money Transfer is Failed !!!";
		
		System.out.println(username);
		
		if(badao.updateBalance(username, amount))
			message = "Money Transfered Sucessfully !!!";
		model.addAttribute("Usermessage",message);
		return "Display";
	}
}
