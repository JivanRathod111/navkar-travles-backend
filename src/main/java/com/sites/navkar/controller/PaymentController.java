package com.sites.navkar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sites.navkar.entity.Bus;
import com.sites.navkar.entity.Payment;
import com.sites.navkar.service.BusService;
import com.sites.navkar.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/")
	public Payment createPaymentDetails(@RequestBody Payment payment) {
		return paymentService.createPaymentDetails(payment);
	}
	
	@GetMapping("/{id}")
	public Payment findPaymentByID(@PathVariable Long id) {
		return paymentService.getPaymentDetail(id);
	}
	
	@GetMapping("/")
	public List<Payment> findAllPayment() {
		return paymentService.getAllPayment();
	}
	
	@DeleteMapping("/{id}")
	public String deletePayment(@PathVariable Long id) {
		return paymentService.deletePayment(id);
	}
	
	@PutMapping("/id")
	public Payment  updatePayment(@RequestBody Payment payment, @PathVariable Long id) {
		return paymentService.updatePayment(payment , id);
	}


}
