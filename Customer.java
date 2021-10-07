import java.util.ArrayList;

public class Customer {
    private String _name;
    private ArrayList<Rental> _rentals = new ArrayList<Rental>();

    public Customer (String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        String  result = "Rental Record for " + getName() + "\n";

        for (Rental rental: _rentals) {
            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() +
                      "\t" + rental.calculateRental() + "\n";
        }

        // add footer lines
        result += "Amount owed is " + calculateTotalRent() + "\n";
        result += "You earned " + calculateTotalFrequentRenterPoints() +
                  " frequent renter points";
        return result;
    }

    private double calculateTotalRent() {
		double totalRent = 0;
        for (Rental rental: _rentals) {
        	totalRent += rental.calculateRental();
        }
		return totalRent;
	}

	private int calculateTotalFrequentRenterPoints() {
		int totalFrequentRenterPoints = 0;
        for (Rental rental: _rentals) {
        	totalFrequentRenterPoints += rental.calculateFrequentRenterPoints();
        }
		return totalFrequentRenterPoints;
	}

//    public static void main(String args[]) {
////         CustomerTest.shouldNotPrintAnytingIfNoRentals();
//
//    }
}
