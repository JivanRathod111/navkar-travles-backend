package com.sites.navkar.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sites.navkar.entity.Bus;
import com.sites.navkar.entity.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long>{
}

