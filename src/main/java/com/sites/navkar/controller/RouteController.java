//package com.sites.navkar.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sites.navkar.entity.Bus;
//import com.sites.navkar.entity.Route;
//import com.sites.navkar.service.BusService;
//import com.sites.navkar.service.RouteService;
//
//@RestController
//@RequestMapping("/route")
//public class RouteController {
//	
//	@Autowired
//	RouteService routeService;
//	
//	@PostMapping("/")
//	public Route createRouteDetails(@RequestBody Route route) {
//		return routeService.createRouteDetails(route);
//	}
//	
//	 @GetMapping
//	    public ResponseEntity<Route> findRoute(@RequestParam String origin, @RequestParam String destination) {
//	        Optional<Route> route = routeService.findRoute(origin, destination);
//	        return route.map(ResponseEntity::ok)
//	                    .orElse(ResponseEntity.notFound().build());
//	    }
//	
//	@GetMapping("/{id}")
//	public Route findRouteByID(@PathVariable Long id) {
//		return routeService.getRouteDetail(id);
//	}
//	
//	@GetMapping("/")
//	public List<Route> findAllRoute() {
//		return routeService.getAllRoute();
//	}
//	
//	@DeleteMapping("/{id}")
//	public String deleteRoute(@PathVariable Long id) {
//		return routeService.deleteRoute(id);
//	}
//	
//	@PutMapping("/id")
//	public Route  updateRoute(@RequestBody Route route, @PathVariable Long id) {
//		return routeService.updateRoute(route , id);
//	}
//
//
//	
//	
//
//}
