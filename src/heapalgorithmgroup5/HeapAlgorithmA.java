package heapalgorithmgroup5;

import java.util.ArrayList;
import java.util.List;

public class HeapAlgorithmA {
    public static List<Integer> build(int[] values) {
        List<Integer> heap = new ArrayList<>();

        for (int value : values) {
            heap.add(value);
            int i = heap.size() - 1;

            while (i > 0) {
                int parent = (i - 1) / 2;
                if (heap.get(parent) >= heap.get(i)) {
                    break;
                }
                int temp = heap.get(parent);
                heap.set(parent, heap.get(i));
                heap.set(i, temp);
                i = parent;
            }
        }

        return heap;
    }

    public static List<List<Integer>> trace(int[] values) {
        List<Integer> heap = new ArrayList<>();
        List<List<Integer>> trace = new ArrayList<>();

        for (int value : values) {
            heap.add(value);
            int i = heap.size() - 1;

            while (i > 0) {
                int parent = (i - 1) / 2;
                if (heap.get(parent) >= heap.get(i)) {
                    break;
                }
                int temp = heap.get(parent);
                heap.set(parent, heap.get(i));
                heap.set(i, temp);
                i = parent;
            }

            trace.add(new ArrayList<>(heap));
        }

        return trace;
    }
}
