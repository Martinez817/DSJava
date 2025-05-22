import java.util.ArrayList;

public class DoubleStack {
    private ArrayList<Double> list;

    public DoubleStack() {
        list = new ArrayList<>();
    }

    public void push(double value) {
        list.add(value);
    }

    public double pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack Underflow");
        }
        return list.remove(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append("\n");
        }
        return sb.toString();
    }
}
