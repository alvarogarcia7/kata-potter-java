import java.util.ArrayList;
import java.util.List;

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
		final List<int[]> collections = new ArrayList<>();
		collections.add(allBooks);
		return collections;
	}
}
