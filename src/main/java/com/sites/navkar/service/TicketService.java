package com.sites.navkar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sites.navkar.entity.Bus;
import com.sites.navkar.entity.Ticket;
import com.sites.navkar.repository.BusRepository;
import com.sites.navkar.repository.TicketRepository;

@Service
public class TicketService {
	@Autowired
	TicketRepository ticketRepository;

	public Ticket createTicketDetails(Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	
	public List<Ticket> getAllTicket() {
	    return ticketRepository.findAll();
}

public Ticket getTicketDetail(Long id) {
	return ticketRepository.findById(id).get();
}

public String deleteTicket(Long id) {
	ticketRepository.deleteById(id);
	return "Ticket Deleted Successfully";
}

public Ticket updateTicket(Ticket correctTicket, Long id) {
    // Fetch the user by ID, if not found, return null
    Ticket ticket = ticketRepository.findById(id).orElse(null);

    if (ticket == null) {
        return null;
    }

 

    // Save the updated user back to the repository
    return ticketRepository.save(ticket);
}



}
