package hus.oop.WW.hus.oop.mynumbersystem;

import java.util.Random;

public class NumberSystemTestDrive {
    public static void main(String[] args) {
        /* Yêu cầu:

        - Sinh ngẫu nhiên 3 số bằng cách:
            - Cơ số radix là một số tự nhiên khác 10 nằm trong đoạn [2, 16] được sinh ngẫu nhiên (nếu sinh ra 10 thì sinh lại).
            - Xâu ký tự biểu diễn số được sinh ra bằng cách:
                + Độ dài số là một số tự nhiên nằm trong đoạn [10, 30] được sinh ra ngẫu nhiên.
                + Mỗi chữ số được sinh ra bằng cách: sinh ra một chỉ số ngẫu nhiên nằm trong đoạn [0, radix - 1],
                  sau đó lấy tương ứng với chỉ số đó một chữ số nằm trong xâu "0123456789ABCDEF".

        - Mỗi lần sinh ra một số và một cơ số mới, thực hiện việc cập nhật và in ra các số được chuyển đổi
          tự động sang các số được biểu diễn trong hệ cơ số 2, 8, 16.

        - Thực hiện chạy chương trình để in ra terminal thông tin về các số ban đầu và các số chuyển đổi, ví dụ:
          Original number: 123456
          radix 12
          Binary: 1111111
          Octal: 7777777
          Hexadecimal: FFFFFF

          Original number: 456789
          radix 7
          Binary: 1111111
          Octal: 7777777
          Hexadecimal: FFFFFF

          Lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_NumberSystemConverter>.txt (Ví dụ, NguyenVanA_123456_NumberSystemConverter.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_NumberSystemConverter>.zip (Ví dụ, NguyenVanA_123456_NumberSystemConverter.zip),
          nộp lên classroom.
         */
        // Sinh số ngẫu nhiên và cơ số ngẫu nhiên
        Random random = new Random();
        int[] radices = {2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16}; // Cơ số từ 2 đến 16, trừ 10
        int index = random.nextInt(radices.length);
        int radix = radices[index]; // Chọn một cơ số ngẫu nhiên từ mảng radices

        int length = random.nextInt(21) + 10; // Độ dài số ngẫu nhiên từ 10 đến 30
        StringBuilder numberBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int digitIndex = random.nextInt(radix);
            char digit = (char) (digitIndex < 10 ? '0' + digitIndex : 'A' + digitIndex - 10);
            numberBuilder.append(digit);
        }
        String originalNumber = numberBuilder.toString();

        // In thông tin về số gốc và cơ số
        System.out.println("Original number: " + originalNumber);
        System.out.println("Radix: " + radix);

        // Tạo đối tượng số gốc
        ANumber aNumber = new ANumber(originalNumber, radix);

        // Tạo và đăng ký các converter
        BinaryConverter binaryConverter = new BinaryConverter(aNumber);
        OctalConverter octalConverter = new OctalConverter(aNumber);
        HexadecimalConverter hexadecimalConverter = new HexadecimalConverter(aNumber);

        NumberSystemController controller = new NumberSystemController();
        controller.registerConverter(binaryConverter);
        controller.registerConverter(octalConverter);
        controller.registerConverter(hexadecimalConverter);

        // Cập nhật và hiển thị số chuyển đổi
        controller.notifyConverters();

        // Hủy đăng ký các converter
        controller.unregisterConverter(binaryConverter);
        controller.unregisterConverter(octalConverter);
        controller.unregisterConverter(hexadecimalConverter);
    }
}
