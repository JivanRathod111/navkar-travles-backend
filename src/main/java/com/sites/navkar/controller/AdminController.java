package com.sites.navkar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sites.navkar.entity.Admin;
import com.sites.navkar.entity.Bus;
import com.sites.navkar.entity.Seat;
import com.sites.navkar.repository.BusRepository;
import com.sites.navkar.repository.SeatRepository;
import com.sites.navkar.service.AdminService;
import com.sites.navkar.service.BusService;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private BusService busService;

}

