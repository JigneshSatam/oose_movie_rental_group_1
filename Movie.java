public class Movie {

    public static final int CHILDRENS   = 2;
    public static final int REGULAR     = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private Price _priceCode;

    public Movie(String title, int priceCode) {
        _title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return _priceCode.getPrice();
    }

    public void setPriceCode(int type) {
        switch (type) {
        case Movie.CHILDRENS:
        	_priceCode = new ChildrenPrice();
        	break;
        case Movie.REGULAR:
        	_priceCode = new RegularPrice();
        	break;
        case Movie.NEW_RELEASE:
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
