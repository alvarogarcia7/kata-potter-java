/**
 * Created by alvaro on 19/03/15.
 */
public class PotterLibrary {

	public double price (final int... book) {
		if(book.length == 2){
			return 15.2d;
		} else if (book.length == 3){
			return 8*3*(1-0.1);
		}
		return 8 * book[0];
	}
}
