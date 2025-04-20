package com.shreya.spring.service;

import com.shreya.spring.model.Restaurant;
import com.shreya.spring.repository.RestaurantRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

@Service
@Data

public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;
    private static final Scanner sc = new Scanner(System.in);

    public List<Restaurant> retrieveRestaurants() {
        return restaurantRepository.retrieveRestaurants();
    }

    public  void insertRestaurant(Restaurant restaurant) throws SQLException {
        restaurantRepository.addRestaurant(restaurant);
    }

    public void Restaurant(Restaurant restaurant) {
        restaurantRepository.retrieveRestaurant(1, "abc");
    }

    public void deleteRestaurant() {
        try {
            if (restaurantRepository.deleteRestaurant(1)) {
                System.out.println("Restaurant deleted successfully!");
            } else {
                System.out.println("Failed to delete Restaurant.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateRestaurant() throws SQLException {
        if (restaurantRepository.updateRestaurant(2, "shreya")) {
            System.out.println("Restaurant updated successfully");
        } else {
            System.out.println("Failed to update Restaurant");
        }
    }

    public  void createRestaurant() {
        Restaurant restaurant = new Restaurant();
        restaurantRepository.createRestaurant(restaurant);
        restaurantRepository.displayRestaurant(restaurant);
        restaurantRepository.displayRestaurantToBeClosed("name");

        try {
            System.out.println("Please enter registerNo");
            int registerNo = Integer.parseInt(sc.nextLine());

            System.out.println("Please enter name");
            String name = sc.nextLine();

            System.out.println("Please enter city");
            String city = sc.nextLine();

            System.out.println("Please enter area");
            String area = sc.nextLine();

            restaurant.setRegisterNo(registerNo);
            restaurant.setName(name);
            restaurant.setCity(city);
            restaurant.setArea(area);

        } catch (Exception e) {
            System.out.println("Invalid input type. Please enter correct data.");
        }
    }

    public static void displayRestaurant() {
        try {
//            restaurants.forEach((id, restaurant) ->
//                    System.out.println("Restaurant Id " + id + " = " + restaurant));
        } catch (Exception e) {
            System.out.println("Invalid input type. Please enter correct data.");
        }
    }
}
