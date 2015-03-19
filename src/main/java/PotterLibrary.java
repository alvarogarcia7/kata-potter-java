/**
 * Created by alvaro on 19/03/15.
 */
public class PotterLibrary {

	public static final int BOOK_PRICE = 8;

	public double price (final int... book) {
		switch (book.length) {
			default:
			case 1:
				return BOOK_PRICE * book[0];
			case 2:
				return BOOK_PRICE * book.length * (1 - 0.05);
			case 3:
				return BOOK_PRICE * book.length * (1 - 0.1);
		}
	}
}
