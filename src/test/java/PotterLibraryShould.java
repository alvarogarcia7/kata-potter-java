import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by alvaro on 19/03/15.
 */
public class PotterLibraryShould {

	@Test
	public void sell_0_books_at_zero_price () {
		assertThat(PotterLibrary.price(0), is(0));
	}

	@Test
	public void sell_a_single_at_8_eur () {
		assertThat(priceFor(1), is(8));
	}

	private int priceFor (final int book) {
		return new PotterLibrary().price(book);
	}

}
