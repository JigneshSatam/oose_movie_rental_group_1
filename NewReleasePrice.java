
public class NewReleasePrice extends PriceType {
	@Override
	PriceCode getPrice() {
		return PriceCode.NEW_RELEASE;
	}
	
	@Override
	double calculateRental(int numberOfDaysRented) { 
		return numberOfDaysRented * 3;
	}
	
	@Override
	int calculateFrequentRenterPoints(int numberOfDaysRented) {
		// ONE EXTRA FREQUENT RENTER POINT FOR MORE THAN A DAY RENTAL
		if (numberOfDaysRented > 1) {
			return 2;
		}

		return 1;
	}
}