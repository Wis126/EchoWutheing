package hus.oop.WW.hus.oop.vector;

import java.util.ArrayList;
import java.util.List;

public class MyListVector extends AbstractMyVector {
    private List<Double> data;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyListVector() {
        /* TODO */
        this.data = new ArrayList<>();
    }

    @Override
    public int size() {
        /* TODO */
        return data.size();
    }

    @Override
    public double coordinate(int index) {
        /* TODO */
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + data.size());
        }
        return data.get(index);
    }

    @Override
    public double[] coordinates() {
        /* TODO */
        double[] coordinates = new double[data.size()];
        for (int i = 0; i < data.size(); i++) {
            coordinates[i] = data.get(i);
        }
        return coordinates;
    }

    @Override
    public void set(double value, int index) {
        /* TODO */
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + data.size());
        }
        data.set(index, value);
    }

    /**
     * Cộng các phần tử của vector với value.
     * @param value
     * @return vector mới.
     */
    public MyListVector add(double value) {
        /* TODO */
        data.add(value);
        return this;
    }

    /**
     * Cộng vector hiện tại với một vector khác.
     * Nếu hai vector không cùng số chiều thì không cộng được.
     * In ra thông báo lỗi hoặc ném exception.
     * @param another
     * @return vector mới.
     */
    public MyListVector add(MyVector another) {
        /* TODO */
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same size.");
        }
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) + another.coordinate(i));
        }
        return this;
    }

    /**
     * Cộng các phần tử của vector với value.
     * @param value
     * @return vector hiện tại.
     */
    public MyListVector addTo(double value) {
        /* TODO */
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) + value);
        }
        return this;
    }

    /**
     * Cộng vector hiện tại với một vector khác.
     * Nếu hai vector không cùng số chiều thì không cộng được.
     * In ra thông báo lỗi hoặc ném exception.
     * @param another
     * @return vector hiện tại.
     */
    public MyListVector addTo(MyVector another) {
        /* TODO */
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same size.");
        }
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) + another.coordinate(i));
        }
        return this;
    }

    /**
     * Trừ các phần tử của vector cho value.
     * @return vector mới.
     */
    public MyListVector minus(double value) {
        /* TODO */
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) - value);
        }
        return this;
    }

    /**
     * Trừ vector hiện tại cho vector khác.
     * Nếu hai vector không cùng số chiều thì không trừ được.
     * In ra thông báo lỗi hoặc ném exception.
     * @return vector mới.
     */
    public MyListVector minus(MyVector another) {
        /* TODO */
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same size.");
        }
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) - another.coordinate(i));
        }
        return this;
    }

    /**
     * Trừ các phần tử của vector cho value.
     * @return vector hiện tại.
     */
    public MyListVector minusFrom(double value) {
        /* TODO */
        for (int i = 0; i < data.size(); i++) {
            data.set(i, value - data.get(i));
        }
        return this;
    }

    /**
     * Trừ vector hiện tại cho vector khác.
     * Nếu hai vector không cùng số chiều thì không trừ được.
     * In ra thông báo lỗi hoặc ném exception.
     * @return vector hiện tại.
     */
    public MyListVector minusFrom(MyVector another) {
        /* TODO */
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same size.");
        }
        for (int i = 0; i < data.size(); i++) {
            data.set(i, another.coordinate(i) - data.get(i));
        }
        return this;
    }

    /**
     * Tích vô hướng của hai vector.
     * Hai vector chỉ có tích vô hướng nếu có cùng số chiều.
     * Nếu hai vector không cùng số chiều, in ra thông báo lỗi hoặc ném exception.
     * @return tích vô hướng.
     */
    public double dot(MyVector another) {
        /* TODO */
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same size.");
        }
        double result = 0;
        for (int i = 0; i < data.size(); i++) {
            result += data.get(i) * another.coordinate(i);
        }
        return result;
    }

    /**
     * Các phần tử vector được lấy mũ power.
     * @param power
     * @return vector hiện tại.
     */
    public MyListVector pow(double power) {
        /* TODO */
        for (int i = 0; i < data.size(); i++) {
            data.set(i, Math.pow(data.get(i), power));
        }
        return this;
    }

    /**
     * Các phần tử vector được nhân với value.
     * @return vector hiện tại.
     */
    public MyListVector scale(double value) {
        /* TODO */
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) * value);
        }
        return this;
    }

    /**
     * Lấy chuẩn của vector.
     * @return chuẩn của vector.
     */
    @Override
    public double norm() {
        /* TODO */
        double sum = 0;
        for (int i = 0; i < data.size(); i++) {
            sum += data.get(i) * data.get(i);
        }
        return Math.sqrt(sum);
    }

    /**
     * Thêm một giá trị value vào vector ở vị trí cuối cùng.
     * @param value
     * @return vector hiện tại.
     */
    public MyListVector insert(double value) {
        /* TODO */
        data.add(value);
        return this;
    }

    /**
     * Thêm một giá trị vào vector ở vị trí index.
     * @param value
     * @param index
     * @return vector hiện tại.
     */
    public MyListVector insert(double value, int index) {
        /* TODO */
        if (index < 0 || index > data.size()) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + data.size());
        }
        data.add(index, value);
        return this;
    }

    /**
     * Xóa phần tử ở vị trí index.
     * Nếu index không hợp lệ thì in ra thông báo lỗi hoặc ném exception.
     * @param index
     * @return vector hiện tại.
     */
    public MyListVector remove(int index) {
        /* TODO */
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + data.size());
        }
        data.remove(index);
        return this;
    }

    /**
     * Trích xuất ra một vector con của vector ban đầu, có các phần tử
     * được lấy theo các chỉ số của mảng đầu vào.
     * Ví dụ, cho vector [1 2 3 4 5], cho mảng đầu vào là {2, 1} thì vector trích xuất ra
     * có tọa độ là [2 1].
     * Nếu có thỉ số trong mảng đầu vào không hợp lệ thì in ra thông báo lỗi,
     * hoặc ném exception.
     * @param indices
     * @return vector mới có kiểu MyListVector có các phần tử được trích xuất từ vector hiện tại.
     */
    public MyListVector extract(int[] indices) {
        /* TODO */
        MyListVector result = new MyListVector();
        for (int index : indices) {
            if (index < 0 || index >= data.size()) {
                throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + data.size());
            }
            result.add(data.get(index));
        }
        return result;
    }
}
