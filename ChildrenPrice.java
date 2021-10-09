public class ChildrenPrice extends PriceType {
	@Override
	PriceCode getPrice() {
		return PriceCode.CHILDRENS;
	}

	@Override
	double calculateRental(int numberOfDaysRented) {
		double rental = 1.5;
        if (numberOfDaysRented > 3) {
            rental += (numberOfDaysRented - 3) * 1.5;
        }
        return rental;
	}
}
