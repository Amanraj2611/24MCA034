package com.example.averagecalculator.service;

import com.example.averagecalculator.model.ResponseModel;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NumberService {

    private static final int WINDOW_SIZE = 10;
    private final LinkedList<Integer> window = new LinkedList<>();

    public ResponseModel handleRequest(String numberId) {
        long startTime = System.currentTimeMillis();
        List<Integer> windowPrev = new ArrayList<>(window);
        List<Integer> fetched = mockThirdPartyFetch(numberId);

        for (int num : fetched) {
            if (!window.contains(num)) {
                if (window.size() == WINDOW_SIZE) {
                    window.pollFirst(); // remove oldest
                }
                window.addLast(num);
            }
        }

        double avg = window.stream().mapToInt(i -> i).average().orElse(0.0);
        long endTime = System.currentTimeMillis();

        // Simulate 500ms limit
        if (endTime - startTime > 500) {
            fetched.clear();
        }

        return new ResponseModel(windowPrev, new ArrayList<>(window), fetched, avg);
    }

    // This simulates a third-party API call
    private List<Integer> mockThirdPartyFetch(String type) {
        switch (type.toLowerCase()) {
            case "p": return Arrays.asList(2, 3, 5, 7);
            case "f": return Arrays.asList(0, 1, 1, 2, 3, 5);
            case "e": return Arrays.asList(2, 4, 6, 8);
            case "r": return Arrays.asList(new Random().nextInt(100));
            default: return Collections.emptyList();
        }
    }
}
