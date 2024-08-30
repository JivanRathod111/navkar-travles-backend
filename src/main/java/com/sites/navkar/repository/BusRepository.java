package com.sites.navkar.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.sites.navkar.entity.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long>{

	List<Bus> findByStartPointAndEndPointAndDate(String startPoint, String endPoint, LocalDate date);
	                                      
}
