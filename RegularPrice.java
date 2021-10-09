
public class RegularPrice extends PriceType {
	@Override
	PriceCode getPrice() {
		return PriceCode.REGULAR;
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
