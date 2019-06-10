package cz.speedygonzales.refactoringfowler.step001;

import java.util.Enumeration;
import java.util.Vector;

class Customer {

    private String name;
    private Vector<Rental> rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public String statement() {
        Enumeration rentals = this.rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
        }

        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";

        return result;
    }

    public String htmlStatement() {
        Enumeration rentals = this.rentals.elements();
        String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1>\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            //show figures for each rental
            result +=  each.getMovie().getTitle() + ": " + each.getCharge() + "</BR>\n";
        }

        //add footer lines result
        result += "<P>You owe <EM>" + getTotalCharge() + "</EM></P>\n";
        result += "On this rental you earned <EM>" + getTotalFrequentRenterPoints() + "</EM> frequent renter points";

        return result;
    }

    private int getTotalFrequentRenterPoints() {
        return rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
    }

    private double getTotalCharge() {
        return rentals.stream().mapToDouble(Rental::getCharge).sum();
    }

    public void addRental(Rental r) {
        rentals.add(r);
    }

    public String getName() {
        return name;
    }
}
