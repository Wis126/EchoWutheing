package hus.oop.WW.hus.oop.vector;

import java.util.Random;

public class TestVector {
    public static void main(String[] args) {
                /*
         TODO

         Thực hiện các yêu cầu sau.

         I. Test chức năng vector
           - Sinh ngẫu nhiên một số tự nhiên, lưu giá trị sinh ra vào biến n.
           - Tạo ra các vector có kích thước n, với các phần tử được sinh ngẫu nhiên. Trong đó có 2 vector kiểu MyArrayList
             và 2 vector có kiểu MyListVector.
           - Viết các hàm để test các chứ năng của các vector, như thêm vào phần tử, xóa bớt phần tử, sửa giá trị các
             phần tử, cộng các vector, nhân vector với vô hướng, tích vô hướng 2 vector, chuẩn vector, ... Mỗi lần thay
             đổi vector hoặc tính toán, in kết quả ra terminal.

         II. Lưu các kết quả chạy chương trình vào file text có tên <Ten_MaSinhVien_Vector>.txt
              (ví dụ NguyenVanA_123456_Vector.txt). Nén các file source code và file kết quả vào file zip có tên
              <Ten_MaSinhVien_Vector>.zip (ví dụ NguyenVanA_123456_Vector.zip), nộp lên classroom.
         */

        // Generate a random number
        Random random = new Random();
        int n = random.nextInt(10) + 1; // Generate a random number between 1 and 10

        // Create vectors
        MyArrayVector vector1 = createRandomVector(n);
        MyArrayVector vector2 = createRandomVector(n);
        MyListVector vector3 = createRandomListVector(n);
        MyListVector vector4 = createRandomListVector(n);

        // Test vector functionalities
        testVectorFunctionalities(vector1);
        testVectorFunctionalities(vector2);
        testVectorFunctionalities(vector3);
        testVectorFunctionalities(vector4);

    }

    // Function to create a random MyArrayList vector with size n
    private static MyArrayVector createRandomVector(int n) {
        MyArrayVector vector = new MyArrayVector();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            vector.add(random.nextDouble());
        }
        return vector;
    }

    // Function to create a random MyListVector with size n
    private static MyListVector createRandomListVector(int n) {
        MyListVector vector = new MyListVector();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            vector.add(random.nextDouble());
        }
        return vector;
    }

    // Function to test vector functionalities
    private static void testVectorFunctionalities(MyVector vector) {
        // Implement tests for vector functionalities here
        // For example:
        System.out.println("Vector: " + vector);
        System.out.println("Size: " + vector.size());
        System.out.println("Norm: " + vector.norm());
        // Test other functionalities...
    }
}
