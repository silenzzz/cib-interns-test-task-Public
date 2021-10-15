package com.demmage.cibinternstesttask.controller;

import com.demmage.cibinternstesttask.domain.Socks;
import com.demmage.cibinternstesttask.service.SocksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Vadim Guseynov
 */

@RestController
@RequestMapping("/api/socks")
@RequiredArgsConstructor
public class SocksController {

    private final SocksService service;

    @GetMapping
    public ResponseEntity<Integer> find(@RequestParam String color, @RequestParam String operation, @RequestParam int cottonPart) {
        return ResponseEntity.ok(service.get(color, operation, cottonPart));
    }

    @PostMapping("/income")
    public void acceptIncome(@RequestBody Socks socks) {
        service.acceptIncome(socks);
    }

    @PostMapping("/outcome")
    public void acceptOutcome(@RequestBody Socks socks) {
        service.acceptOutcome(socks);
    }
}