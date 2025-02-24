package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;

import java.util.Base64;
import java.util.Map;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/code")
public class CodeExecutionController {

    private final String JUDGE0_URL = "https://judge0-ce.p.rapidapi.com/submissions?base64_encoded=true&wait=false";
    private final String API_KEY = "1233a526admsh91da75c68e6bec4p161b08jsn0a315458ef6e"; // Replace with your actual API key

    
    @GetMapping("/test")
    public String testAPI() {
        return "index.html";
    }
    
    @PostMapping("/execute")
    public ResponseEntity<?> executeCode(@RequestBody Map<String, String> request) {
        RestTemplate restTemplate = new RestTemplate();

        // Convert source code & input to Base64 (since base64_encoded=true)
        String sourceCodeBase64 = Base64.getEncoder().encodeToString(request.get("code").getBytes());
        String stdinBase64 = Base64.getEncoder().encodeToString(request.getOrDefault("input", "").getBytes());

        // Judge0 requires language_id as an integer
        int languageId = 91; // 54 = Java, 71 = Python3, 52 (C++)

        // Request payload
        Map<String, Object> payload = Map.of(
                "source_code", sourceCodeBase64,
                "language_id", languageId,
                "stdin", stdinBase64
        );
        
        System.out.println(payload);

        // Headers for RapidAPI
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", API_KEY);
        headers.set("x-rapidapi-host", "judge0-ce.p.rapidapi.com");
        headers.set("Content-Type", "application/json");

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(payload, headers);

        // Send request to Judge0
        ResponseEntity<Map> response = restTemplate.postForEntity(JUDGE0_URL, entity, Map.class);

        return ResponseEntity.ok(response.getBody());
    }

    @GetMapping("/result/{token}")
    public ResponseEntity<?> getExecutionResult(@PathVariable String token) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://judge0-ce.p.rapidapi.com/submissions/" + token + "?base64_encoded=true&fields=*";

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", API_KEY);
        headers.set("x-rapidapi-host", "judge0-ce.p.rapidapi.com");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange(url, org.springframework.http.HttpMethod.GET, entity, Map.class);

        return ResponseEntity.ok(response.getBody());
    }
}
