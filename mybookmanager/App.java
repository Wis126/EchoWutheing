package hus.oop.WW.hus.oop.mybookmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        init();

        /* Yêu cầu:
        - Hoàn thiện code chương trình theo mẫu đã cho.
        - Viết code để test cho tất cả các hàm test bên dưới.

        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_MyBookManager>.txt (Ví dụ, NguyenVanA_123456_MyBookManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_BookMyManager>.zip (Ví dụ, NguyenVanA_123456_BookMyManager.zip),
          nộp lên classroom.
         */
        testOriginalData();
        testFilterBooksOfAuthor();
        testFilterBooksOfPublisher();
        testFilterBooksOfGenre();
        testGetHighestPriceBook();
        testGetLowestPriceBook();
        testGetHighestNumberOfPagesBook();
        testGetLowestNumberOfPagesBook();
    }

    public static void init() {
        String filePath = "data/books.csv";
        readListData(filePath);
    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 6) {
                    continue;
                }

                if (dataList.get(0).equals("title")) {
                    continue;
                }

                /*
                TODO
                Đọc được dữ liệu, tạo ra các đối tượng Book ở đây, và cho vào BookManager để quản lý.

                Gợi ý:
                Các đội tượng Book không thể được tạo trực tiếp ở đây do hàm dựng là private,
                các đối tượng này được tạo ra bằng cách sử dụng Builder Pattern, ví dụ theo cách sau:
                Book newBook = new Book.BookBuilder(title).
                    .withAuthor(author)
                    .withGenre(genre)
                    ...
                    .build();
                */
                // Create Book object using Builder Pattern
                String title = dataList.get(0);
                String author = dataList.get(1);
                String genre = dataList.get(2);
                int pages = Integer.parseInt(dataList.get(3));
                double price = Double.parseDouble(dataList.get(4));
                String publisher = dataList.get(5);

                Book newBook = new Book.BookBuilder(title)
                        .withAuthor(author)
                        .withGenre(genre)
                        .withPages(pages)
                        .withPrice(price)
                        .withPublisher(publisher)
                        .build();

                // Add the new book to the BookManager
                BookManager.getInstance().insertAtEnd(newBook);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void testOriginalData() {
        MyList bookList = BookManager.getInstance().getBookList();
        System.out.println("Original data:");
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(bookList.getNodeByIndex(i).data);
        }
    }

    /**
     * Test lọc ra những book theo tác giả.
     */
    public static void testFilterBooksOfAuthor() {
        /* TODO */
        String author = "AuthorName"; // Change this to a specific author's name from your data
        MyList booksByAuthor = BookManager.getInstance().filterBooksOfAuthor(author);
        System.out.println("Books by author " + author + ":");
        for (int i = 0; i < booksByAuthor.size(); i++) {
            System.out.println(booksByAuthor.getNodeByIndex(i).data);
        }
    }

    /**
     * Test lọc ra những book theo nhà xuất bản.
     */
    public static void testFilterBooksOfPublisher() {
        /* TODO */
        String publisher = "PublisherName"; // Change this to a specific publisher's name from your data
        MyList booksByPublisher = BookManager.getInstance().filterBooksOfPublisher(publisher);
        System.out.println("Books by publisher " + publisher + ":");
        for (int i = 0; i < booksByPublisher.size(); i++) {
            System.out.println(booksByPublisher.getNodeByIndex(i).data);
        }
    }

    /**
     * Test lọc ra những book theo thể loại.
     */
    public static void testFilterBooksOfGenre() {
        /* TODO */
        String genre = "GenreName"; // Change this to a specific genre from your data
        MyList booksByGenre = BookManager.getInstance().filterBooksOfGenre(genre);
        System.out.println("Books in genre " + genre + ":");
        for (int i = 0; i < booksByGenre.size(); i++) {
            System.out.println(booksByGenre.getNodeByIndex(i).data);
        }
    }

    /**
     * Test lấy ra sách có giá cao nhất.
     */
    public static void testGetHighestPriceBook() {
        Book highestPriceBook = BookManager.getInstance().highestPriceBook();
        System.out.println("Book with highest price:");
        System.out.println(highestPriceBook);
    }

    /**
     * Test lấy ra sách có giá thấp nhất.
     */
    public static void testGetLowestPriceBook() {
        Book lowestPriceBook = BookManager.getInstance().lowestPriceBook();
        System.out.println("Book with lowest price:");
        System.out.println(lowestPriceBook);
    }

    /**
     * Test lấy ra sách có số trang cao nhất.
     */
    public static void testGetHighestNumberOfPagesBook() {
        Book highestPagesBook = BookManager.getInstance().highestNumberOfPagesBook();
        System.out.println("Book with highest number of pages:");
        System.out.println(highestPagesBook);
    }

    /**
     * Test lấy ra sách có số trang thấp nhất.
     */
    public static void testGetLowestNumberOfPagesBook() {
        Book lowestPagesBook = BookManager.getInstance().lowestNumberOfPagesBook();
        System.out.println("Book with lowest number of pages:");
        System.out.println(lowestPagesBook);
    }
}
