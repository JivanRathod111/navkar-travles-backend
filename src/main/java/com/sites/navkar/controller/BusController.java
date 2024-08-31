package com.sites.navkar.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sites.navkar.entity.Bus;
import com.sites.navkar.service.BusService;

@RestController
@RequestMapping("/bus")
public class BusController {

	@Autowired
	private BusService busService;

	@PostMapping("/")
	public Bus createBus(@RequestBody Bus bus) {
		return busService.saveBus(bus);
	}

	@GetMapping("/search")
	public List<Bus> searchBuses(@RequestParam String startPoint, @RequestParam String endPoint,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

		return busService.searchBuses(startPoint, endPoint, date);
	}

	@GetMapping("/{id}")
	public Bus findBusByID(@PathVariable Long id) {
		return busService.getBusDetail(id);
	}

	@GetMapping("/")
	public List<Bus> findAllBus() {
		return busService.getAllBus();
	}

	@DeleteMapping("/{id}")
	public String deleteBus(@PathVariable Long id) {
		return busService.deleteBus(id);
	}

	@PutMapping("update/id")
	public Bus updateBus(@RequestBody Bus bus, @PathVariable Long id) {
		return busService.updateBus(bus, id);
	}

}
