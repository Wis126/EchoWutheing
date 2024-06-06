package hus.oop.WW.hus.oop.mybookmanager;

public class BookManager {
    private static BookManager instance;
    private MyList bookList;

    private BookManager() {
        /* TODO */
        bookList = new MyLinkedList();
    }

    public static BookManager getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new BookManager();
        }
        return instance;
    }

    public MyList getBookList() {
        /* TODO */
        return bookList;
    }

    /**
     * Thêm book vào đầu danh sách.
     * @param book
     */
    public void insertAtStart(Book book) {
        /* TODO */
        bookList.insertAtStart(book);
    }

    /**
     * Thêm book vào cuối danh sách.
     * @param book
     */
    public void insertAtEnd(Book book) {
        /* TODO */
        bookList.insertAtEnd(book);
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     * @param book
     * @param index
     */
    public void insertAPosition(Book book, int index) {
        /* TODO */
        bookList.insertAtPosition(book, index);
    }

    /**
     * Xóa book ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        bookList.remove(index);
    }

    /**
     * Lấy ra book ở vị trí index
     * @param index
     * @return
     */
    public Book bookAt(int index) {
        /* TODO */
        Node node = ((MyLinkedList) bookList).getNodeByIndex(index);
        if (node != null) {
            return (Book) node.data;
        }
        return null;
    }

    /**
     * Lấy ra sách có giá cao nhất.
     * @return
     */
    public Book highestPriceBook() {
        if (bookList.size() == 0) return null;
        Book highest = (Book) bookList.getNodeByIndex(0).data;
        for (int i = 1; i < bookList.size(); i++) {
            Book current = (Book) bookList.getNodeByIndex(i).data;
            if (current.getPrice() > highest.getPrice()) {
                highest = current;
            }
        }
        return highest;
    }

    /**
     * Lấy ra sách có giá thấp nhất.
     * @return
     */
    public Book lowestPriceBook() {
        if (bookList.size() == 0) return null;
        Book lowest = (Book) bookList.getNodeByIndex(0).data;
        for (int i = 1; i < bookList.size(); i++) {
            Book current = (Book) bookList.getNodeByIndex(i).data;
            if (current.getPrice() < lowest.getPrice()) {
                lowest = current;
            }
        }
        return lowest;
    }

    /**
     * Lấy ra sách có số trang cao nhất.
     * @return
     */
    public Book highestNumberOfPagesBook() {
        if (bookList.size() == 0) return null;
        Book highest = (Book) bookList.getNodeByIndex(0).data;
        for (int i = 1; i < bookList.size(); i++) {
            Book current = (Book) bookList.getNodeByIndex(i).data;
            if (current.getPages() > highest.getPages()) {
                highest = current;
            }
        }
        return highest;
    }

    /**
     * Lấy ra sách có số trang thấp nhất.
     * @return
     */
    public Book lowestNumberOfPagesBook() {        if (bookList.size() == 0) return null;
        if (bookList.size() == 0) return null;
        Book lowest = (Book) bookList.getNodeByIndex(0).data;
        for (int i = 1; i < bookList.size(); i++) {
            Book current = (Book) bookList.getNodeByIndex(i).data;
            if (current.getPages() < lowest.getPages()) {
                lowest = current;
            }
        }
        return lowest;
    }

    /**
     * Lọc ra những book theo nhà xuất bản.
     * @param publisher
     * @return
     */
    public MyList filterBooksOfPublisher(String publisher) {
        /* TODO */
        MyList result = new MyLinkedList();
        for (int i = 0; i < bookList.size(); i++) {
            Book current = (Book) bookList.getNodeByIndex(i).data;
            if (current.getPublisher().equalsIgnoreCase(publisher)) {
                result.insertAtEnd(current);
            }
        }
        return result;
    }

    /**
     * Lọc ra những book theo thể loại.
     * @param genre
     * @return
     */
    public MyList filterBooksOfGenre(String genre) {
        /* TODO */
        MyList result = new MyLinkedList();
        for (int i = 0; i < bookList.size(); i++) {
            Book current = (Book) bookList.getNodeByIndex(i).data;
            if (current.getGenre().equalsIgnoreCase(genre)) {
                result.insertAtEnd(current);
            }
        }
        return result;
    }

    /**
     * Lọc ra những book theo tác giả.
     * @param author
     * @return
     */
    public MyList filterBooksOfAuthor(String author) {
        /* TODO */
        MyList result = new MyLinkedList();
        for (int i = 0; i < bookList.size(); i++) {
            Book current = (Book) bookList.getNodeByIndex(i).data;
            if (current.getAuthor().equalsIgnoreCase(author)) {
                result.insertAtEnd(current);
            }
        }
        return result;
    }
}
