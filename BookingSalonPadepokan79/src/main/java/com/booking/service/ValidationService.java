package com.booking.service;

import java.util.List;
import java.util.Scanner;

import com.booking.models.Customer;
import com.booking.models.Employee;
import com.booking.models.Reservation;
import com.booking.models.Service;

import lombok.CustomLog;

public class ValidationService {
    // Buatlah function sesuai dengan kebutuhan
    // "[0-9]+"
    public static int validateInputNumber(Scanner input, String regex){
        String numString;

        do {
            numString = String.valueOf(input.nextLine());
        } while (!numString.matches(regex));

        return Integer.valueOf(numString);
    }

    public static String validateInputWordWithSpace(Scanner input){
        String wordString;

        do {
            wordString = input.nextLine();
        } while (!wordString.matches("[a-zA-Z\\s]+"));

        return wordString;
    }

    public static String validateInput2Choice(Scanner input, String choice1, String choice2){
        String wordString;

        do {
            wordString = input.nextLine();
        } while (!(wordString.equalsIgnoreCase(choice1) || wordString.equalsIgnoreCase(choice2)));

        return wordString;
    }

    public static boolean validateCustomerId(List<Customer> listCustomer, String customerId){
        boolean isValid = false;

        for (int i = 0; i < listCustomer.size(); i++) {
            if (listCustomer.get(i).getId().equalsIgnoreCase(customerId)) {
                isValid = true;
                break;
            }
        }

        return isValid;
    }

    public static boolean validateEmployeeId(List<Employee> listEmployees, String employeeId){
        boolean isValid = false;

        for (int i = 0; i < listEmployees.size(); i++) {
            if (listEmployees.get(i).getId().equalsIgnoreCase(employeeId)) {
                isValid = true;
                break;
            }
        }

        return isValid;
    }

    public static boolean validateServiceId(List<Service> listServices, String serviceId){
        boolean isValid = false;

        for (int i = 0; i < listServices.size(); i++) {
            if (listServices.get(i).getServiceId().equalsIgnoreCase(serviceId)) {
                isValid = true;
                break;
            }
        }

        return isValid;
    }

    public static boolean validateReservationId(List<Reservation> reservationsList, String reservationId){
        boolean isValid = false;

        for (int i = 0; i < reservationsList.size(); i++) {
            if (reservationsList.get(i).getReservationId().equalsIgnoreCase(reservationId)) {
                isValid = true;
                break;
            }
        }

        return isValid;
    }
}
