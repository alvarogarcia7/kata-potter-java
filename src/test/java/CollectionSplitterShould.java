import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CollectionSplitterShould {

	@Test
	public void split_into_two_collections () {

		assertThat(split(1,2,1).size(), is(2));
	}

	private List<int[]> split (final int... books) {
		return new CollectionSplitter(books).split();
	}

}
