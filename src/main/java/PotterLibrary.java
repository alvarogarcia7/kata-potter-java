/**
 * Created by alvaro on 19/03/15.
 */
public class PotterLibrary {

	public static final int BOOK_PRICE = 8;

	public double price (final int... book) {

		final double basePrice = BOOK_PRICE * book.length;

		double multiplicator = 1;
		switch (book.length) {
			case 2:
				multiplicator = (1 - 0.05);
				break;
			case 3:
				multiplicator = (1 - 0.1);
				break;
			case 4:
				multiplicator = (1-0.2);
				break;
			case 5:
				multiplicator = (1-0.25);
				break;
		}
		return basePrice * multiplicator;
	}
}
