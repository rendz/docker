package com.epam.simple_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SpringBootApplication
public class SimpleService {

    public static void main(String[] args) {
        SpringApplication.run(SimpleService.class, args);
    }

    @Autowired FortuneRepo fortuneRepo;

    private String latestFortune;
    private Object latestFortuneLock = new Object();

    @RequestMapping("/fortune/latest")
    public ResponseEntity<String> getLatestFortune() {

        synchronized (latestFortuneLock) {
            if (latestFortune == null) {
                List<Fortune> latest = fortuneRepo.findTopByOrderByIdDesc();
                if (!latest.isEmpty()) {
                    latestFortune = latest.get(0).getFortune();
                }
            }
        }

        return ResponseEntity.ok(latestFortune == null ? "no luck" : latestFortune);
    }

    @RequestMapping(value = "/fortune", method = RequestMethod.POST)
    public ResponseEntity addFortune(@RequestBody Fortune fortune) {

        if (StringUtils.isEmpty(fortune.getFortune())) {
            return ResponseEntity.badRequest().build();
        }

        fortuneRepo.save(fortune);

        synchronized (latestFortuneLock) {
            latestFortune = fortune.getFortune();
        }

        return ResponseEntity.ok().build();
    }
}
