package com.example.accesskeybackend.template.controller;

import com.example.accesskeybackend.template.service.IPv6CheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class IPv6Controller {

    private static final Logger logger = LoggerFactory.getLogger(IPv6Controller.class);

    private final IPv6CheckService ipv6CheckService;

    public IPv6Controller(IPv6CheckService ipv6CheckService) {
        this.ipv6CheckService = ipv6CheckService;
    }

    @GetMapping("/api/web/checkIpv6Support")
    public ResponseEntity<Map<String, Boolean>> checkIPv6Support(@RequestParam("siteUrl") String siteUrl) {
        boolean success = ipv6CheckService.checkIPv6Support(siteUrl);
        Map<String, Boolean> response = new HashMap<>();
        response.put("success", success);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
