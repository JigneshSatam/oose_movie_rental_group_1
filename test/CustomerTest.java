import static org.junit.Assert.*;

import org.junit.Test;


public class CustomerTest {
	
	
	@Test
	public void shouldHaveEmptyStatementWithoutRentals() {
		Customer c = new Customer("Jig");
		String expected = "Rental Record for Jig\n" 
				+ "Amount owed is 0.0\n"
				+ "You earned 0 frequent renter points" ;
		String actual = c.getTextStatement();
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldHaveRegularRentalStatementWithRegularRentals() {
		Customer c = new Customer("Ash");
		c.addRental(new Rental(new Movie("M1", PriceCode.REGULAR), 1));
		String expected = "Rental Record for Ash\n"
				+ "\tM1\t2.0\n"
				+ "Amount owed is 2.0\n"
				+ "You earned 1 frequent renter points" ;
		String actual = c.getTextStatement();
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldHaveRegularRentalStatementWithLongRegularRentals() {
		Customer c = new Customer("Kartik");
		c.addRental(new Rental(new Movie("M1", PriceCode.REGULAR), 3));
		String expected = "Rental Record for Kartik\n"
				+ "\tM1\t3.5\n"
				+ "Amount owed is 3.5\n"
				+ "You earned 1 frequent renter points" ;
		String actual = c.getTextStatement();
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldHaveNewReleaseRentalStatementWithNewReleaseRentals() {
		Customer c = new Customer("Ranveer");
		c.addRental(new Rental(new Movie("M1", PriceCode.NEW_RELEASE), 1));
		String expected = "Rental Record for Ranveer\n"
				+ "\tM1\t3.0\n"
				+ "Amount owed is 3.0\n"
				+ "You earned 1 frequent renter points" ;
		String actual = c.getTextStatement();
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldAddExtraFrequentRenterPointsForNewReleaseRentalStatementWithForLongNewReleaseRentals() {
		Customer c = new Customer("Sam");
		c.addRental(new Rental(new Movie("M1", PriceCode.NEW_RELEASE), 3));
		String expected = "Rental Record for Sam\n"
				+ "\tM1\t9.0\n"
				+ "Amount owed is 9.0\n"
				+ "You earned 2 frequent renter points" ;
		String actual = c.getTextStatement();
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldHaveChildrenRentalStatementWithChildrenRentals() {
		Customer c = new Customer("Raj");
		c.addRental(new Rental(new Movie("M1", PriceCode.CHILDRENS), 1));
		String expected = "Rental Record for Raj\n"
				+ "\tM1\t1.5\n"
				+ "Amount owed is 1.5\n"
				+ "You earned 1 frequent renter points" ;
		String actual = c.getTextStatement();
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldHaveChildrenRentalStatementWithLongChildrenRentals() {
		Customer c = new Customer("Rajesh");
		c.addRental(new Rental(new Movie("M1", PriceCode.CHILDRENS), 4));
		String expected = "Rental Record for Rajesh\n"
				+ "\tM1\t3.0\n"
				+ "Amount owed is 3.0\n"
				+ "You earned 1 frequent renter points" ;
		String actual = c.getTextStatement();
		assertEquals(expected, actual);
	}

	@Test
	public void shouldAddMultipleMovieRentalToStatement(){
		Customer c = new Customer("Rads");
		c.addRental(new Rental(new Movie("M1", PriceCode.REGULAR), 4));
		c.addRental(new Rental(new Movie("M2", PriceCode.NEW_RELEASE), 5));
		c.addRental(new Rental(new Movie("M3", PriceCode.CHILDRENS), 6));
		c.addRental(new Rental(new Movie("M4", PriceCode.NEW_RELEASE), 7));
		
		String expected = "Rental Record for Rads\n"
				+ "\tM1\t5.0\n"
				+ "\tM2\t15.0\n" 
				+ "\tM3\t6.0\n" 
				+ "\tM4\t21.0\n" 
				+ "Amount owed is 47.0\n"
				+ "You earned 6 frequent renter points" ;
		String actual = c.getTextStatement();
		assertEquals(expected, actual);
	}
	
//	@Test
//	public void shouldHaveZeroRentalStatementWithWrongTypeRentals() {
//		Customer c = new Customer("Ram");
//		try {
//			c.addRental(new Rental(new Movie("M1", PriceCode.CHILDRENS), 1));
//		} 
//		catch (IllegalArgumentException e){
//			final String errorMsg = "illegal type";
//			assertEquals(errorMsg, e.getMessage());
//		}
//	}
}
