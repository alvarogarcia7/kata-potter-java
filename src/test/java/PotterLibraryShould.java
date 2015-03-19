import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by alvaro on 19/03/15.
 */
public class PotterLibraryShould {

	@Test
	public void sell_0_books_at_zero_price () {
		assertThat(priceFor(), is(0.));
	}

	@Test
	public void sell_a_single_at_8_eur () {
		assertThat(priceFor(1), is(8.));
	}

	@Test
	public void sell_two_different_books_at_5percent_discount () {
		assertThat(priceFor(1,2), is(percent_discount(5,2)));
	}

	@Test
	public void sell_three_different_books_at_10percent_discount () {
		assertThat(priceFor(1,2,3), is(percent_discount(10,3)));
	}

	private double percent_discount (final int percent, final int books) {
		final double totalOfOne = percent / 100d;
		final double priceOfOne = 1 - totalOfOne;
		return (8*books)*(priceOfOne);
	}

	private double priceFor (final int... book) {
		return new PotterLibrary().price(book);
	}

}
