public class Rental {
    private Movie _movie;
    private int   _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie      = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

	double calculateRental() {
		return getMovie().calculateRental(getDaysRented());
	}

	int calculateFrequentRenterPoints() {
	    return getMovie().calculateFrequentRenterPoints(getDaysRented());
	}
	
	String getMovieTitle() {
		return getMovie().getTitle();
	}
}
