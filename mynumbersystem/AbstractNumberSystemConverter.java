package hus.oop.WW.hus.oop.mynumbersystem;

import java.math.BigInteger;

public abstract class AbstractNumberSystemConverter implements NumberSystemConverter {
    protected String convertedNumber;         // Số được chuyển đổi theo cơ số nào đó từ số gốc

    protected ANumber originalNumber; // Số gốc

    public AbstractNumberSystemConverter(ANumber aNumber) {
        /* TODO */
        this.originalNumber = aNumber;
    }

    /**
     * Chuyển đổi số decimal từ hệ cơ số 10 thành số có hệ cơ số nào đó.
     * @param decimal
     * @return xâu ký tự biểu diễn một số trong hệ cơ số nào đó.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     *
     * Gợi ý: có thể sử dụng lớp trung gian BigInteger để thuận lợi hơn cho việc tính toán.
     */
    public abstract String decimalTo(String decimal);

    /**
     * Chuyển đổi số được biểu diễn trong originalNumber sang biểu diễn số trong hệ cơ số 10.
     * @return xâu ký tự biểu diễn một số trong hệ cơ số 10.
     *
     * Yêu cầu: sử dụng thuật toán Horner để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    public String toDecimal() {
        /* TODO */

        String original = originalNumber.getNumberPresentation(); // Lấy số gốc
        int radix = originalNumber.getRadix(); // Lấy cơ số của số gốc

        BigInteger result = BigInteger.ZERO;

        for (int i = 0; i < original.length(); i++) {
            char digit = original.charAt(i);
            int value = Character.digit(digit, radix); // Chuyển ký tự sang giá trị số tương ứng

            // Sử dụng thuật toán Horner để chuyển đổi
            result = result.multiply(BigInteger.valueOf(radix)).add(BigInteger.valueOf(value));
        }

        return result.toString(); // Trả về số đã chuyển đổi về hệ cơ số 10 dưới dạng xâu ký tự
    }
}
