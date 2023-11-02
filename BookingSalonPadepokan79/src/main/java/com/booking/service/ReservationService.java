package com.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.booking.models.Customer;
import com.booking.models.Employee;
import com.booking.models.Person;
import com.booking.models.Reservation;
import com.booking.models.Service;

public class ReservationService {
    public static void createReservation(Scanner input, List<Person> personList, List<Service> listServices){
        String customerId, employeeId, serviceId, serviceLain;
        boolean isPickingServices = true;

        List<Customer> customerList = new ArrayList<>();
        List<Employee> employeeList = new ArrayList<>();
        List<Service> serviceList = new ArrayList<>();

        for (Person person : personList) {
            if (person instanceof Customer) {
                customerList.add((Customer)person);
            } else{
                employeeList.add((Employee)person);
            }
        }

        PrintService.showAllCustomer(personList);

        do {
            System.out.println("Silahkan Masukkan Customer Id:");
            customerId = input.nextLine();
        } while (!ValidationService.validateCustomerId(customerList, customerId));

        PrintService.showAllEmployee(personList);

        do {
            System.out.println("Silahkan Masukkan Employee Id");
            employeeId = input.nextLine();
        } while (!ValidationService.validateEmployeeId(employeeList, employeeId));

        PrintService.showServices(listServices);

        do {
            System.out.println("Silahkan Masukkan Service Id");

            serviceId = doServiceIdLoop(input, listServices);

            serviceList.add(getServiceByServiceId(serviceId));

            System.out.println("Ingin pilih service yang lain (Y/N)?");
            serviceLain = ValidationService.validateInput2Choice(input, "y", "n");
            if (serviceLain.equalsIgnoreCase("n")) {
                isPickingServices = false;
            }
        } while (isPickingServices);

        Reservation reservation = new Reservation(generateReservationId(), getCustomerByCustomerId(customerId)
        , getEmployeeByEmployeeId(employeeId), serviceList,"In Process");
            MenuService.reservationList.add(reservation);
    }

    public static Customer getCustomerByCustomerId(String customerId){
        Customer customer = new Customer();
        for (int i = 0; i < MenuService.personList.size(); i++) {
            if (MenuService.personList.get(i) instanceof Customer) {
                if (MenuService.personList.get(i).getId().equalsIgnoreCase(customerId)) {
                    customer = (Customer)MenuService.personList.get(i);
                }
            }
        }
        return customer;
    }

    public static Employee getEmployeeByEmployeeId(String employeeId){
        Employee employee = new Employee();
        for (int i = 0; i < MenuService.personList.size(); i++) {
            if (MenuService.personList.get(i) instanceof Employee) {
                if (MenuService.personList.get(i).getId().equalsIgnoreCase(employeeId)) {
                    employee = (Employee)MenuService.personList.get(i);
                }
            }
        }
        return employee;
    }

    public static Service getServiceByServiceId(String serviceId){
        Service service = new Service();
        for (int i = 0; i < MenuService.serviceList.size(); i++) {
            if (MenuService.serviceList.get(i).getServiceId().equalsIgnoreCase(serviceId)) {
                service = MenuService.serviceList.get(i);
            }
        }
        return service;
    }

    public static Reservation getReservationByReversationId(String reversationId){
        Reservation reservation = new Reservation();
        for (int i = 0; i < MenuService.reservationList.size(); i++) {
            if (MenuService.reservationList.get(i).getReservationId().equalsIgnoreCase(reversationId)) {
                reservation = MenuService.reservationList.get(i);
            }
        }
        return reservation;
    }

    public static void editReservationWorkstage(Scanner input){
        PrintService.showRecentReservation(MenuService.reservationList);
        Reservation reservation = new Reservation();
        String reservationId, reservationStatus;

        do {
            System.out.println("Silahkan Masukkan Reservation Id:");
            reservationId = input.nextLine();
        } while (!ValidationService.validateReservationId(MenuService.reservationList, reservationId));

        System.out.println("Selesaikan reservasi:");
        reservationStatus = ValidationService.validateInput2Choice(input, "Finished", "Cancel");

        reservation = getReservationByReversationId(reservationId);
        reservation.setWorkstage(reservationStatus);
    }

    private static String generateReservationId(){
        int reservationNum = 1;
        String employeeId = "Rsv-" + String.format("%02d", reservationNum);
        reservationNum++;
        return employeeId;
    }

    private static String doServiceIdLoop(Scanner input, List<Service> listServices){
        String result;

        do {
            result = input.nextLine();
        } while (!ValidationService.validateServiceId(listServices, result));

        return result;
    }

    // Silahkan tambahkan function lain, dan ubah function diatas sesuai kebutuhan
}
