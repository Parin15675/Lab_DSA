package solutions.code3;

public class MyArray extends MyArrayBasic {
    private static final int DEFAULT_MAX_SIZE = 100_000;

    // Default constructor with default MAX_SIZE
    public MyArray() {
        super();
        this.MAX_SIZE = DEFAULT_MAX_SIZE;
        this.data = new int[MAX_SIZE];
        this.size = 0;
    }

    // Constructor with supplied MAX_SIZE
    public MyArray(int max) {
        super();
        this.MAX_SIZE = max;
        this.data = new int[MAX_SIZE];
        this.size = 0;
    }

    // Constructor with multiple integers
    public MyArray(int... elements) {
        super(elements);
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int[] expandByK(int k) {
        int newMaxSize = k * MAX_SIZE;
        int[] newData = new int[newMaxSize];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
        MAX_SIZE = newMaxSize;
        return data;
    }

    public int[] expand() {
        return expandByK(2);
    }

    @Override
    public void add(int value) {
        if (isFull()) {
            expand();
        }
        data[size++] = value;
    }

    @Override
    public void insert(int d, int index) {
        if (isFull()) {
            expand();
        }
        super.insert(d, index);
    }

    public int delete() {
        if (isEmpty()) {
            throw new IllegalStateException("Error, isEmpty");
        }
        return data[--size];
    }

    public int getSize() {
        return size;
    }

    public int getMaxSize() {
        return MAX_SIZE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyArray: [");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
