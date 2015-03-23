import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

public class CollectionSplitterShould {

	@Test
	public void split_into_two_collections () {

		assertThat(split(1,2,1).size(), is(2));
	}

	@Test
	public void not_matter_the_order() {
		assertThat(split(2,2,1,1).size(), is(2));
	}

	@Test
	public void find_the_best_grouping () {
		final List<int[]> actual = split(1, 1, 2, 2, 3, 3, 4, 5);
		assertThat(actual.size(), is(2));
		assertThat(Arrays.asList(actual.get(0)), contains(1, 2, 3, 4));
		assertThat(Arrays.asList(actual.get(1)), contains(1, 2, 3, 5));
	}

	private List<int[]> split (final int... books) {
		return new CollectionSplitter(books).split();
	}

}
