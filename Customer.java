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

    public String getTextStatement() {
        String  result = "Rental Record for " + getName() + "\n";

        for (Rental rental: _rentals) {
            // show figures for the rental
            result += "\t" + rental.getMovie().getTitle() +
                      "\t" + rental.calculateRental() + "\n";
        }

        // add footer lines
        result += "Amount owed is " + calculateTotalRental() + "\n";
        result += "You earned " + calculateTotalFrequentRenterPoints() +
                  " frequent renter points";
        return result;
    }
    
    public String getXMLStatement() {
        String  result = "<name> " + getName() + " </name>\n";

        for (Rental rental: _rentals) {
            // show figures for the rental
            result += "<movie>\n\t\t<name> " + rental.getMovieTitle() + " </name>\n" +
                      "\t\t<rent> " + rental.calculateRental() + " </rent>\n</movie>\n";
        }

        // add footer lines
        result += "<TotalRent> " + calculateTotalRental() + " </TotalRent>\n" +
        	"<FrequentRenterPoints> " + calculateTotalFrequentRenterPoints() + 
        	" </FrequentRenterPoints>\n";
        return result;
    }

    private double calculateTotalRental() {
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

    public static void main(String[] args) {
    	Customer customer = new Customer("Sam");
        customer.addRental(new Rental(new Movie("Movie1", PriceCode.REGULAR), 1));
        customer.addRental(new Rental(new Movie("Movie2", PriceCode.NEW_RELEASE), 3));
        customer.addRental(new Rental(new Movie("Movie3", PriceCode.CHILDRENS), 1));
        
        System.out.println("====Text Output====");
        System.out.println(customer.getTextStatement());
        
        System.out.println();
        System.out.println("====XML Output====");
        System.out.println(customer.getXMLStatement());
    }
}
