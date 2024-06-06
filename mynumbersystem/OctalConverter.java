package hus.oop.WW.hus.oop.mynumbersystem;

public class OctalConverter extends AbstractNumberSystemConverter {
    public OctalConverter(ANumber aNumber) {
        /* TODO */
        super(aNumber); // Gọi constructor của lớp cha để khởi tạo số gốc
        this.convertedNumber = decimalTo(originalNumber.getNumber()); // Chuyển đổi số gốc sang hệ cơ số 8
    }

    /**
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 8.
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 8.
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
            int remainder = decimalInt % 8;
            result.insert(0, remainder); // Chèn phần dư vào đầu chuỗi kết quả
            decimalInt /= 8;
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
        this.convertedNumber = decimalTo(originalNumber.getNumber()); // Chuyển đổi số gốc sang hệ cơ số 8
    }

    /**
     * Hiển thị số ra terminal theo định dạng a1a2...an(8).
     */
    @Override
    public void display() {
        /* TODO */
        System.out.println(convertedNumber + "(8)"); // Hiển thị số đã chuyển đổi và cơ số là 8
    }
}
