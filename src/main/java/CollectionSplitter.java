import java.util.ArrayList;
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

		Set<Integer> currentCollection = new HashSet<>();
		collections.add(currentCollection);


		for (int current : allBooks) {
			if (currentCollection.contains(current)) {
				boolean found = false;
				for (Set<Integer> collection : collections) {
					if(!collection.contains(current)){
						currentCollection = collection;
						found = true;
					}
				}
				if(!found) {
					currentCollection = new HashSet<>();
					collections.add(currentCollection);
				}

			}
			currentCollection.add(current);
		}
		return collections;
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
