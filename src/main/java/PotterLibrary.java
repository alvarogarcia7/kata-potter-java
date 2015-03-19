import java.util.HashSet;
import java.util.Set;

/**
 * Created by alvaro on 19/03/15.
 */
public class PotterLibrary {

	public static final int BOOK_PRICE = 8;

	public double price (final int... book) {
		final double basePrice = getBasePrice(book);
		double discount = getDiscount(book);
		return applyDiscount(basePrice, discount);
	}

	private double applyDiscount (final double basePrice, final double discount) {
		return basePrice * (1- discount);
	}

	private double getBasePrice (final int[] book) {
		return BOOK_PRICE * book.length;
	}

	private double getDiscount (final int[] book) {

		double discount = 0;
		final int uniqueBooks = unique(book);
		switch (uniqueBooks) {
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

	private int unique (final int[] book) {
		Set<Integer> uniqueBooks = new HashSet<>();
		for (int current : book) {
			uniqueBooks.add(current);
		}
		return uniqueBooks.size();
	}
}
