package hus.oop.WW.hus.oop.mynumbersystem;

public class BinaryConverter extends AbstractNumberSystemConverter {
    public BinaryConverter(ANumber aNumber) {
        /* TODO */
        super(aNumber); // Gọi constructor của lớp cha để khởi tạo số gốc
        this.convertedNumber = decimalTo(originalNumber.getNumberPresentation()); // Chuyển đổi số gốc sang hệ cơ số 2
    }

    /**
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 2.
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 2.
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
            int remainder = decimalInt % 2;
            result.insert(0, remainder); // Chèn phần dư vào đầu chuỗi kết quả
            decimalInt /= 2;
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
        this.convertedNumber = decimalTo(originalNumber.getNumberPresentation()); // Chuyển đổi số gốc sang hệ cơ số 2
    }

    /**
     * Hiển thị số ra terminal theo định dạng a1a2...an(2).
     */
    @Override
    public void display() {
        /* TODO */
        System.out.println(convertedNumber + "(2)"); // Hiển thị số đã chuyển đổi và cơ số là 2
    }
}
