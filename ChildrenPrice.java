public class ChildrenPrice extends Price {
	@Override
	int getPrice() {
		return Movie.CHILDRENS;
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
