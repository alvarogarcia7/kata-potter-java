/**
 * Created by alvaro on 19/03/15.
 */
public class PotterLibrary {

	public static final int BOOK_PRICE = 8;

	public double price (final int... book) {


		final double basePrice = BOOK_PRICE * book.length;

		double multiplicator;
		switch (book.length) {
			case 2:
				multiplicator = (1 - 0.05);
				break;
			case 3:
				multiplicator = (1 - 0.1);
				break;
			default:
				multiplicator = 1;
		}
		return basePrice * multiplicator;
	}
}
