//package com.sites.navkar.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.sites.navkar.entity.Bus;
//import com.sites.navkar.entity.Route;
//import com.sites.navkar.repository.BusRepository;
//import com.sites.navkar.repository.RouteRepository;
//
//@Service
//public class RouteService {
//	
//	@Autowired
//	RouteRepository routeRepository;
//
//	public Route createRouteDetails(Route route) {
//		return routeRepository.save(route);
//	}
//	
//	public List<Route> getAllRoute() {
//	    return routeRepository.findAll();
//}
//
//public Route getRouteDetail(Long id) {
//	return routeRepository.findById(id).get();
//}
//
//public Optional<Route> findRoute(String origin, String destination) {
//    return routeRepository.findByStartPointAndEndPoint(origin, destination);
//}
//
//public String deleteRoute(Long id) {
//	routeRepository.deleteById(id);
//	return "route Deleted Successfully";
//}
//
//public Route updateRoute(Route correctRoute, Long id) {
//    // Fetch the user by ID, if not found, return null
//    Route route = routeRepository.findById(id).orElse(null);
//
//    if (route == null) {
//        return null;
//    }
//
//    // Save the updated user back to the repository
//    return routeRepository.save(route);
//}
//
//
//}
