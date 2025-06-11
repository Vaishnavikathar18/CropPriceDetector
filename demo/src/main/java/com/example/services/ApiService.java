package com.example.services;

import com.farmer.app.model.User;
import com.farmer.app.model.Crop;

import java.util.*;

public class ApiService {

    // Simulate a user database
    private static final Map<String, User> mockUsers = new HashMap<>();

    // Simulate crop prices
    private static final Map<String, Double> cropPrices = new HashMap<>();

    // Simulate market data
    private static final Map<String, List<String>> markets = new HashMap<>();

    static {
        // Mock users (phone -> user)
        mockUsers.put("9999999999", new User("u1", "Ramesh", "9999999999", "Nagpur", "pass123"));
        mockUsers.put("8888888888", new User("u2", "Suresh", "8888888888", "Pune", "farm@456"));

        // Mock crop prices
        cropPrices.put("Wheat", 2200.0);
        cropPrices.put("Rice", 2500.0);
        cropPrices.put("Cotton", 6400.0);
        cropPrices.put("Sugarcane", 3100.0);
        cropPrices.put("Maize", 1900.0);

        // Mock markets
        markets.put("nagpur", Arrays.asList("Nagpur Mandi", "Itwari Market"));
        markets.put("pune", Arrays.asList("Pune Market Yard", "Hadapsar Mandi"));
        markets.put("amravati", Arrays.asList("Badnera Mandi", "Amravati Sabji Bazaar"));
    }

    // ========== USER LOGIN ==========

    public static User login(String phone, String password) {
        User user = mockUsers.get(phone);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    // ========== CROP PRICE PREDICTION ==========

    public static Crop predictPrice(String cropName, String season, String location) {
        double price = cropPrices.getOrDefault(cropName, 0.0);
        return new Crop(cropName, season, location, price);
    }

    // ========== NEARBY MANDIS ==========

    public static List<String> getNearbyMarkets(String location) {
        String key = location.toLowerCase().trim();
        return markets.getOrDefault(key, new ArrayList<>());
    }

    // ========== USER REGISTRATION ==========

    public static boolean registerUser(User newUser) {
        if (mockUsers.containsKey(newUser.getPhone())) return false; // Already exists
        mockUsers.put(newUser.getPhone(), newUser);
        return true;
    }
}
