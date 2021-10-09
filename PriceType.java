public abstract class PriceType {
	abstract PriceCode getPrice();
	abstract double calculateRental(int numberOfDaysRented);
	
	int calculateFrequentRenterPoints(int numberOfDaysRented) {
		return 1;
	}
	
}