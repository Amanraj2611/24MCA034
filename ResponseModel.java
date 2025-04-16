package com.example.averagecalculator.model;

import java.util.List;

public class ResponseModel {
    private List<Integer> windowPrevState;
    private List<Integer> windowCurrState;
    private List<Integer> numbers;
    private double avg;

    public ResponseModel(List<Integer> prev, List<Integer> curr, List<Integer> nums, double avg) {
        this.windowPrevState = prev;
        this.windowCurrState = curr;
        this.numbers = nums;
        this.avg = avg;
    }

    // Getters and Setters
    public List<Integer> getWindowPrevState() { return windowPrevState; }
    public List<Integer> getWindowCurrState() { return windowCurrState; }
    public List<Integer> getNumbers() { return numbers; }
    public double getAvg() { return avg; }

    public void setWindowPrevState(List<Integer> windowPrevState) { this.windowPrevState = windowPrevState; }
    public void setWindowCurrState(List<Integer> windowCurrState) { this.windowCurrState = windowCurrState; }
    public void setNumbers(List<Integer> numbers) { this.numbers = numbers; }
    public void setAvg(double avg) { this.avg = avg; }
}
