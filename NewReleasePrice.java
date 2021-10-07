
public class NewReleasePrice extends Price {
	@Override
	int getPrice() {
		return Movie.NEW_RELEASE;
	}
	
	@Override
	double calculateRental(int numberOfDaysRented) { 
		return numberOfDaysRented * 3;
	}
}