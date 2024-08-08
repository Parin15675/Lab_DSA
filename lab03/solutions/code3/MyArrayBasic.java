package solutions.code3;

public class MyArrayBasic {
    protected int MAX_SIZE = 5;
    protected int data[] = new int[MAX_SIZE];
    protected int size = 0;

    // Default constructor
    public MyArrayBasic() {
        this.MAX_SIZE = 5;
        this.data = new int[MAX_SIZE];
    }

    // Constructor with multiple integers
    public MyArrayBasic(int... elements) {
        try
        {if (elements == null || elements.length == 0) {
            this.MAX_SIZE = 5; // default size if input is null or empty
            this.data = new int[MAX_SIZE];
        } else {
            this.MAX_SIZE = elements.length;
            this.data = new int[MAX_SIZE];
            for (int i = 0; i < elements.length; i++) {
                this.data[i] = elements[i];
            }
            this.size = elements.length;
        }}
        catch(Exception e){
            System.out.println("Error");
        }
    }
    public void add(int d) {
        try{
        data[size++] = d;}
        catch(Exception e){
            System.out.println("Error");
        }
    }

    public void insert(int d, int index) {
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = d;
        size++;
    }

    public int find(int d) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (data[i] == d) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int binarySearch(int d) {
        int a = 0, b = size - 1;
        while (a <= b) {
            int m = (a + b) / 2;
            if (data[m] == d) {
                return m;
            }
            if (d < data[m]) {
                b = m - 1;
            } else {
                a = m + 1; // d>data[m]

            }
        }
        return -1;
    }

    public void delete(int index) {
        if(this.size != 0){
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;}
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyArrayBasic: [");
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
