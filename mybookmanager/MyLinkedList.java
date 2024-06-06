package hus.oop.WW.hus.oop.mybookmanager;

public class MyLinkedList extends AbstractMyList {
    private Node head;

    private class MyLinkedListIterator implements MyIterator {
        private int currentPosition;
        private Node currentNode;

        public MyLinkedListIterator(int start) {
            /* TODO */
            currentNode = head;
            for (int i = 0; i < start && currentNode != null; i++) {
                currentNode = currentNode.next;
            }
        }

        @Override
        public boolean hasNext() {
            /* TODO */
            return currentNode != null;
        }

        @Override
        public Object next() {
            /* TODO */
            Object data = currentNode.data;
            currentNode = currentNode.next;
            return data;
        }
    }

    /**
     * Hàm dựng khởi tạo list để chứa dữ liệu.
     */
    public MyLinkedList() {
        /* TODO */
        head = null;
    }

    @Override
    public int size() {
        /* TODO */
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Sửa dữ liệu ở vị trí index thành data.
     * @param data
     * @param index
     */
    @Override
    public void set(Object data, int index) {
        /* TODO */
        if (checkBoundaries(index, size() - 1)) {
            Node current = getNodeByIndex(index);
            current.data = data;
        }
    }

    /**
     * Thêm phần tử dữ liệu vào đầu tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtStart(Object value) {
        /* TODO */
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    /**
     * Thêm phần tử dữ liệu vào cuối tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtEnd(Object value) {
        /* TODO */
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của tập dữ liệu.
     * Chỉ thêm được nếu index nằm trong đoạn [0 - size()].
     * @param value
     * @param index
     */
    @Override
    public void insertAtPosition(Object value, int index) {
        /* TODO */
        if (checkBoundaries(index, size())) {
            if (index == 0) {
                insertAtStart(value);
            } else {
                Node newNode = new Node(value);
                Node current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
        }
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size() - 1)]
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        if (checkBoundaries(index, size() - 1)) {
            if (index == 0) {
                head = head.next;
            } else {
                Node current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                current.next = current.next.next;
            }
        }
    }

    /**
     * Phương thức lấy Node ở vị trí index.
     * @param index
     * @return
     */
    Node getNodeByIndex(int index) {
        /* TODO */
        if (checkBoundaries(index, size() - 1)) {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
    }

    @Override
    public MyIterator iterator(int start) {
        /* TODO */
        return new MyLinkedListIterator(start);
    }
}
