package com.sites.navkar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sites.navkar.entity.Bus;
import com.sites.navkar.entity.Payment;
import com.sites.navkar.repository.BusRepository;
import com.sites.navkar.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	PaymentRepository paymentRepository;

	public Payment createPaymentDetails(Payment payment) {
		return paymentRepository.save(payment);
	}
	
	public List<Payment> getAllPayment() {
	    return paymentRepository.findAll();
}

public Payment getPaymentDetail(Long id) {
	return paymentRepository.findById(id).get();
}

public String deletePayment(Long id) {
    paymentRepository.deleteById(id);
	return "Payment Deleted Successfully";
}

public Payment updatePayment(Payment correctPayment, Long id) {
    // Fetch the user by ID, if not found, return null
    Payment payment = paymentRepository.findById(id).orElse(null);

    if (payment == null) {
        return null;
    }

 

    // Save the updated user back to the repository
    return paymentRepository.save(payment);
}



}
