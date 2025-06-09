package com.armaan.pastebin.utils;

import java.util.Random;

public class RandomGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generateId() {
        Random random = new Random();

        // Randomly select length between 2 and 6
        int length = 2 + random.nextInt(7); // random.nextInt(5) gives 0–4, so 2+ gives 2–6

        // Generate random string of selected length
        String randomString = generateRandomString(length, random);

        long timestamp = System.currentTimeMillis();

        // Convert to string and get last 6 characters
        String timestampStr = String.valueOf(timestamp);
        String last6Digits = timestampStr.substring(timestampStr.length() - 6);
        return randomString + last6Digits;
    }

    private static String generateRandomString(int length, Random random) {
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }

        return sb.toString();
    }
}
