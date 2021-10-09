public class Movie {

    private String _title;
    private PriceType _priceCode;

    public Movie(String title, PriceCode priceCode) {
        _title = title;
        setPriceCode(priceCode);
    }

    public PriceCode getPriceCode() {
        return _priceCode.getPrice();
    }

    public void setPriceCode(PriceCode type) {
        switch (type) {
        case CHILDRENS:
        	_priceCode = new ChildrenPrice();
        	break;
        case REGULAR:
        	_priceCode = new RegularPrice();
        	break;
        case NEW_RELEASE:
        	_priceCode = new NewReleasePrice();
        	break;
        default:
        	throw new IllegalArgumentException("illegal type");
        }
    }

    public String getTitle() {
        return _title;
    }

    double calculateRental(int numberOfDaysRented) {
    	return _priceCode.calculateRental(numberOfDaysRented);
	}

	int calculateFrequentRenterPoints(int numberOfDaysRented) {
		return _priceCode.calculateFrequentRenterPoints(numberOfDaysRented);
	}
}
