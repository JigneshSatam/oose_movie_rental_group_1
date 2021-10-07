
public class RegularPrice extends Price {
	@Override
	int getPrice() {
		return Movie.REGULAR;
	}

	@Override
	double calculateRental(int numberOfDaysRented) {
		double rental = 2;
        if (numberOfDaysRented > 2) {
            rental += (numberOfDaysRented - 2) * 1.5;
        }
        return rental;
	}
}
