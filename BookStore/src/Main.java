import com.har.liberary.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book[] b = new Book[5];
		
		b[0] = new Book(101, 199, "God's Eye", "Cheeko", "Novel");
		b[1] = new Book(102, 299, "God's Eye Part 1", "Cheeko", "Dictionary");
		b[2] = new Book(104, 499, "God's Eye", "Cheeko", "Novel");
		
		BookStore bs = new BookStore(b, "Buy Books Here", "Noida");
		try {
		bs.addBook(new Book(103, 399, "God's Eye", "Cheeko", "Encyclopedia"));
		bs.addBook(new Book(105, 599, "God's Eye Part 3", "Cheeko", "Autobiography"));
		//bs.searchBooksByCategory("Novel");
		bs.searchBooksByTitle("God's Eye Part 3");
		//bs.showAllBooks();
		}
		catch(BookStoreFullException e) {
			System.out.println(e);
		}
		//bs.showAllBooks();
	}

}
