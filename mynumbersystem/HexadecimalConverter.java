package hus.oop.WW.hus.oop.mynumbersystem;

public class HexadecimalConverter extends AbstractNumberSystemConverter {
    public HexadecimalConverter(ANumber aNumber) {
        /* TODO */
        super(aNumber); // Gọi constructor của lớp cha để khởi tạo số gốc
        this.convertedNumber = decimalTo(originalNumber.getNumberPresentation()); // Chuyển đổi số gốc sang hệ cơ số 16
    }

    /**
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 16.
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 16.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    @Override
    public String decimalTo(String decimal) {
        /* TODO */
        int decimalInt = Integer.parseInt(decimal);
        StringBuilder result = new StringBuilder();

        while (decimalInt != 0) {
            int remainder = decimalInt % 16;
            // Chuyển phần dư thành ký tự hexadecimal tương ứng
            char digit = (char) (remainder < 10 ? remainder + '0' : remainder + 'A' - 10);
            result.insert(0, digit); // Chèn ký tự vào đầu chuỗi kết quả
            decimalInt /= 16;
        }

        return result.toString();
    }

    /**
     * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
     * hoặc cơ số của số ban đầu thay đổi.
     */
    @Override
    public void update(ANumber number) {
        /* TODO */
        this.originalNumber = number; // Cập nhật số gốc
        this.convertedNumber = decimalTo(originalNumber.getNumberPresentation()); // Chuyển đổi số gốc sang hệ cơ số 16
    }

    /**
     * Hiển thị số ra terminal theo định dạng a1a2...an(16).
     */
    @Override
    public void display() {
        /* TODO */
        System.out.println(convertedNumber + "(16)"); // Hiển thị số đã chuyển đổi và cơ số là 16
    }
}
