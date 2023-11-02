package com.booking.service;

import java.util.List;

import com.booking.models.Customer;
import com.booking.models.Employee;
import com.booking.models.Person;
import com.booking.models.Reservation;
import com.booking.models.Service;

public class PrintService {
    public static void printMenu(String title, String[] menuArr){
        int num = 1;
        System.out.println(title);
        for (int i = 0; i < menuArr.length; i++) {
            if (i == (menuArr.length - 1)) {   
                num = 0;
            }
            System.out.println(num + ". " + menuArr[i]);   
            num++;
        }
    }

    public static String printServices(List<Service> serviceList){
        String result = "";
        // Bisa disesuaikan kembali
        for (Service service : serviceList) {
            result += service.getServiceName() + ", ";
        }
        return result;
    }

    // Function yang dibuat hanya sebgai contoh bisa disesuaikan kembali
    public static void showRecentReservation(List<Reservation> reservationList){
        int num = 1;
        System.out.printf("| %-4s | %-7s | %-11s | %-15s | %-15s | %-15s | %-10s |\n",
                "No.", "ID", "Nama Customer", "Service", "Biaya Service", "Pegawai", "Workstage");
        System.out.println("+========================================================================================+");
        for (Reservation reservation : reservationList) {
            if (reservation.getWorkstage().equalsIgnoreCase("Waiting") || reservation.getWorkstage().equalsIgnoreCase("In process")) {
                System.out.printf("| %-4s | %-7s | %-11s | %-15s | %-15s | %-15s | %-10s |\n",
                num, reservation.getReservationId(), reservation.getCustomer().getName(), printServices(reservation.getServices()), String.format("%,.2f", reservation.getReservationPrice()), reservation.getEmployee().getName(), reservation.getWorkstage());
                num++;
            }
        }
    }

    public static void showAllCustomer(List<Person> personList){
        int num = 1;
        System.out.printf("| %-4s | %-7s | %-11s | %-15s | %-15s | %-15s |\n",
                "No.", "ID", "Nama Customer", "Alamat", "Membership", "Uang");
        System.out.println("+========================================================================================+");
        for (Person person : personList) {
            if(person instanceof Customer){
            System.out.printf("| %-4s | %-7s | %-11s | %-15s | %-15s | %-15s |\n",
            num, person.getId(), person.getName(), person.getAddress(), ((Customer)person).getMember().getMembershipName(), ((Customer)person).getWallet());
            num++;
            } 
        }
    }

    public static void showAllEmployee(List<Person> personList){
        int num = 1;
        System.out.printf("| %-4s | %-7s | %-11s | %-15s | %-15s|\n",
                "No.", "ID", "Nama", "Alamat", "Pengalaman");
        System.out.println("+========================================================================================+");
        for (Person person : personList) {
            if(person instanceof Employee){
            System.out.printf("| %-4s | %-7s | %-11s | %-15s | %-15s |\n",
            num, person.getId(), person.getName(), person.getAddress(), ((Employee)person).getExperience());
            num++;
            } 
        }
    }

    public static void showHistoryReservation(List<Reservation> reservationList){
        int num = 1;
        double totalKeuntungan = 0;
        System.out.printf("| %-4s | %-15s | %-11s | %-50s | %-15s| %-15s |\n",
                "No.", "ID", "Nama Customer", "Service", "Total Biaya", "Workstage");
        System.out.println("+========================================================================================================================+");
        for (Reservation reservation : reservationList) {
            System.out.printf("| %-4s | %-15s | %-11s | %-50s | %-15s| %-15s |\n",
            num, reservation.getReservationId(), reservation.getCustomer().getName(), printServices(reservation.getServices()),  "Rp. " + reservation.getReservationPrice(), reservation.getWorkstage());
            num++;  

            if (reservation.getWorkstage().equalsIgnoreCase("Finished")){
                totalKeuntungan += reservation.getReservationPrice();
            }
        }
        System.out.println("+========================================================================================================================+");
        System.out.printf("| %-83s | %-32s |\n",
                "Total Keuntungan", "Rp. " + String.format("%,.2f", totalKeuntungan));
        System.out.println("+========================================================================================================================+");
    }

    public static void showServices(List<Service> servicesList){
        int num = 1;
        System.out.printf("| %-4s | %-15s | %-15s |\n",
                "No.", "ID", "Nama", "Harga");
        System.out.println("+========================================================================================+");
        for (Service service : servicesList) {
            System.out.printf("| %-4s | %-15s | %-15s |\n",
            num, service.getServiceId(), service.getServiceName(), service.getPrice());
            num++;  
        }
    }
}
