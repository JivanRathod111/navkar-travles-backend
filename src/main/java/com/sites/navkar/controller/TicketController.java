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
import com.sites.navkar.entity.Ticket;
import com.sites.navkar.service.BusService;
import com.sites.navkar.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	@PostMapping("/")
	public Ticket createTicketDetails(@RequestBody Ticket ticket) {
		return ticketService.createTicketDetails(ticket);
	}
	
	@GetMapping("/{id}")
	public Ticket findTicketByID(@PathVariable Long id) {
		return ticketService.getTicketDetail(id);
	}
	
	@GetMapping("/")
	public List<Ticket> findAllTicket() {
		return ticketService.getAllTicket();
	}
	
	@DeleteMapping("/{id}")
	public String deleteTicket(@PathVariable Long id) {
		return ticketService.deleteTicket(id);
	}
	
	@PutMapping("/id")
	public Ticket  updateTicket(@RequestBody Ticket ticket, @PathVariable Long id) {
		return ticketService.updateTicket(ticket , id);
	}


}
