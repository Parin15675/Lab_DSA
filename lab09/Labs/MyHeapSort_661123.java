package lab09.Labs;

public class MyHeapSort extends MyMinHeap {

    public String sort() {
        StringBuilder sb = new StringBuilder();
        while (size > 0) { 
            int d = remove(); 
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(d);
        }
        return sb.toString();  
    }

}
