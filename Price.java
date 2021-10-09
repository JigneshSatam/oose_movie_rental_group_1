public abstract class Price {
	abstract int getPrice();
	abstract double calculateRental(int numberOfDaysRented);
	
	int calculateFrequentRenterPoints(int numberOfDaysRented) {
		return 1;
	}
	
}