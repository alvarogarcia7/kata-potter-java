/**
 * Created by alvaro on 19/03/15.
 */
public class PotterLibrary {

	public double price (final int... book) {
		if(book.length == 2){
			return 15.2d;
		}
		return 8 * book[0];
	}
}
