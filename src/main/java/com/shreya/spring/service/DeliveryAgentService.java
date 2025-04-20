package com.shreya.spring.service;

import com.shreya.spring.model.DeliveryAgent;
import com.shreya.spring.repository.DeliveryAgentRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.*;

@Service
@Data

public class DeliveryAgentService implements DeliveryAgentServiceInterface {

    @Autowired
    private DeliveryAgentRepository deliveryAgentRepository;
    private final Scanner sc = new Scanner(System.in);

    public void insertDeliveryAgent() {
        System.out.println("Pls enter deliveryAgent mobileNo:");
        int mobileNo = Integer.parseInt(sc.nextLine());
        System.out.println("Pls enter deliveryAgent id:");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Pls enter name:");
        String name = sc.nextLine();
        System.out.println("Pls enter city :");
        String city = sc.nextLine();

        DeliveryAgent deliveryAgent = new DeliveryAgent(mobileNo, id, name, city);

        try {
            if (deliveryAgentRepository.insertDeliveryAgent(deliveryAgent)) {
                System.out.println("deliveryAgent inserted successfully!");
            } else {
                System.out.println("Failed to insert deliveryAgent.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteDeliveryAgent() {

        try {
            if (deliveryAgentRepository.deleteDeliveryAgent(1)) {
                System.out.println("deliveryAgent deleted successfully!");
            } else {
                System.out.println("Failed to delete deliveryAgent.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void DeliveryAgent(DeliveryAgent deliveryAgent) {

        deliveryAgentRepository.retrieveDeliveryAgent(1, "abc");
    }

    public List<DeliveryAgent> retrieveDeliveryAgents() {

        return deliveryAgentRepository.retrieveDeliveryAgents();
    }

    public void createDeliveryAgent() {
        DeliveryAgent deliveryAgent = new DeliveryAgent();
        deliveryAgentRepository.createDeliveryAgent(deliveryAgent);
        deliveryAgentRepository.displayDeliveryAgent(deliveryAgent);
        deliveryAgentRepository.displayDeliveryAgentToBeClosed(1);
        try {

            System.out.println("Please enter mobileNo");
            int mobileNo = Integer.parseInt(sc.nextLine());

            System.out.println("Please enter id");
            int id = Integer.parseInt(sc.nextLine());

            System.out.println("Please enter name");
            String name = sc.nextLine();

            System.out.println("Please enter city");
            String city = String.valueOf(Integer.parseInt(sc.nextLine()));

            deliveryAgent.setMobileNo(mobileNo);
            deliveryAgent.setId(id);
            deliveryAgent.setName(name);
            deliveryAgent.setCity(city);
        } catch (Exception e) {
            System.out.println("Invalid input type correct data");
        }
    }

    public void displayDeliveryAgent() {

        try {
            //java 8 features forEach loop
            //deliveryAgents.forEach((id, deliveryAgents) -> System.out.println("deliveryAgents Id " + id + " = deliveryAgents info " + deliveryAgents));

        } catch (Exception e) {
            System.out.println("Invalid input type correct data");
        }
    }
}

