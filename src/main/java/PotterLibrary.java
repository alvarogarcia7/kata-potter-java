/**
 * Created by alvaro on 19/03/15.
 */
public class PotterLibrary {

	public static final int BOOK_PRICE = 8;

	public double price (final int... book) {
		if(book.length == 2){
			return BOOK_PRICE *2*(1-0.05);
		} else if (book.length == 3){
			return BOOK_PRICE*3*(1-0.1);
		}
		return BOOK_PRICE * book[0];
	}
}
