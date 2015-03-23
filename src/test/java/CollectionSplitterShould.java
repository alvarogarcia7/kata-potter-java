import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
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
		assertThat(Arrays.asList(actual.get(0)), hasItem(new int[]{1, 2, 3, 4}));
		assertThat(Arrays.asList(actual.get(1)), hasItem(new int[]{1, 2, 3, 5}));
	}

	@Test
	public void sort_by_size () {
		final CollectionSplitter sut = new CollectionSplitter();
		final List<Set<Integer>> list = new ArrayList<>();
		list.add(new HashSet<>(Arrays.asList(1, 2, 3)));
		list.add(new HashSet<>(Arrays.asList(1)));
		list.add(new HashSet<>(Arrays.asList(1,2)));

		sut.sortBySize(list);

		assertThat(list.get(0).size(), is(1));
		assertThat(list.get(1).size(), is(2));
		assertThat(list.get(2).size(), is(3));
	}

	private List<int[]> split (final int... books) {
		return new CollectionSplitter(books).split();
	}

}
