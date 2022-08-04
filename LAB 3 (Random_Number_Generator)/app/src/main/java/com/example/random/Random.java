package com.example.random;

public class Random {

    public int generateRandomInt(int start, int end) {
        return (int) (Math.random() * (end - start + 1)) + start;
    }
}
