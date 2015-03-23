import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
* Created by alvaro on 23/03/15.
*/
class CollectionSplitter {
	private final int[] book;

	public CollectionSplitter (final int... book) {
		this.book = book;
	}

	public List<int[]> split () {
		return splitInCollections(book);
	}

	private List<int[]> splitInCollections ( final int[] allBooks) {
		final List<Set<Integer>> collections = getCollections(allBooks);
		return toIntArray(collections);
	}

	private List<Set<Integer>> getCollections (final int[] allBooks) {
		final List<Set<Integer>> collections = new ArrayList<>();

		for (int current : allBooks) {
			List<Set<Integer>> candidateCollections = new ArrayList<>();
			for (Set<Integer> collection : collections) {
				if (!collection.contains(current)) {
					candidateCollections.add(collection);
				}
			}

			final Set<Integer> destination;
			if (candidateCollections.isEmpty()) {
				destination = new HashSet<>();
				collections.add(destination);
			} else {
				sortBySize(candidateCollections);
				destination = candidateCollections.get(0);
			}
			destination.add(current);
		}
		return collections;
	}


	public void sortBySize (final List<Set<Integer>> candidateCollections) {
		candidateCollections.sort(new Comparator<Set<Integer>>() {
			@Override
			public int compare (final Set<Integer> o1, final Set<Integer> o2) {
				return o1.size() - o2.size();
			}
		});
	}

	private List<int[]> toIntArray (final List<Set<Integer>> collections) {
		final List<int[]> result = new ArrayList<>();

		for (Set<Integer> collection : collections) {

			final int[] currentResult = new int[collection.size()];
			int i = 0;
			for (Integer current : collection) {
				currentResult[i] = current;
				i++;
			}

			result.add(currentResult);
		}

		return result;
	}


}
