package com.sites.navkar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sites.navkar.entity.Bus;
import com.sites.navkar.entity.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long>{
	 List<Seat> findByBusId(Long busId);
}