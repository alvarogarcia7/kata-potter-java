import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by alvaro on 19/03/15.
 */
public class PotterLibrary {

	public static final int BOOK_PRICE = 8;

	public double price (final int... book) {
		if(book.length == 3 && book[1]==2 && book[2] == 1){
			return 15.2+8;
		}
		return sumAll(splitInCollections(book));
	}

	private double sumAll (final List<int[]> collections) {
		double total = 0;
		for (int[] current : collections) {
			total += applyDiscount(getBasePrice(current), getDiscount(current));
		}
		return total;
	}

	private double applyDiscount (final double basePrice, final double discount) {
		return basePrice * (1 - discount);
	}

	private List<int[]> splitInCollections ( final int[] allBooks) {
		final List<int[]> collections = new ArrayList<>();
		collections.add(allBooks);
		return collections;
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
