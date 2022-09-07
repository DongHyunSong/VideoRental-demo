package video.rental.demo.domain;

import java.util.List;

public class Report {
    private final Customer customer;
    private String result;
    private double totalCharge = 0;
    private int totalPoint = 0;

    public Report(Customer customer) {
        this.customer = customer;
    }
    
    public String makeReport() {
        appendHead();
        retrieveRentals();
        appendTail();
        return result;
    }

    private void appendHead() {
        result = "Customer Report for " + customer.getName() + "\n";
    }

    private void appendTail() {
        result += "Total charge: " + totalCharge + "\tTotal Point: " + totalPoint + "\n";
        if (totalPoint >= 10) {
            System.out.println("Congratulations! You earned two free coupons");
        } else if (totalPoint >= 5) {
            System.out.println("Congratulations! You earned one free coupon");
        }
    }

    private void retrieveRentals() {
        List<Rental> rentals = customer.getRentals();
        for (Rental each : rentals) {
            appendRentalResult(each);
        }
    }

    private void appendRentalResult(Rental each) {
        int daysRented = each.getDaysRented();
        int eachPoint = each.getEachPoint();
        double eachCharge = each.getEachCharge();

        totalCharge += eachCharge;
        totalPoint += eachPoint;
        result += "\tTitle: " + each.getVideo().getTitle() + "\tDays rented: " + daysRented + "\tCharge: " + eachCharge
                + "\tPoint: " + eachPoint + "\n";
    }
}
