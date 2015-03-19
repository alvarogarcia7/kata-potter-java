/**
 * Created by alvaro on 19/03/15.
 */
public class PotterLibrary {

	public static final int BOOK_PRICE = 8;

	public double price (final int... book) {

		final double basePrice = BOOK_PRICE * book.length;

		double discount = getDiscount(book);
		return basePrice * (1- discount);
	}

	private double getDiscount (final int[] book) {
		double discount = 0;
		switch (book.length) {
			case 2:
				discount = 0.05;
				break;
			case 3:
				discount = 0.1;
				break;
			case 4:
				discount = 0.2;
				break;
			case 5:
				discount = 0.25;
				break;
		}
		return discount;
	}
}
