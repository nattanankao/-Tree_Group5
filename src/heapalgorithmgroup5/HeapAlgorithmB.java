package heapalgorithmgroup5;

import java.util.ArrayList;
import java.util.List;

public class HeapAlgorithmB {
    public static List<Integer> build(int[] values) {
        List<Integer> heap = new ArrayList<>();

        for (int value : values) {
            heap.add(value);
        }

        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            heapifyDown(heap, i);
        }

        return heap;
    }

    public static List<List<Integer>> trace(int[] values) {
        List<Integer> heap = new ArrayList<>();

        for (int value : values) {
            heap.add(value);
        }

        List<List<Integer>> trace = new ArrayList<>();
        trace.add(new ArrayList<>(heap));

        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            heapifyDown(heap, i);
            trace.add(new ArrayList<>(heap));
        }

        return trace;
    }

    private static void heapifyDown(List<Integer> heap, int index) {
        int i = index;

        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left < heap.size() && heap.get(left) > heap.get(largest)) {
                largest = left;
            }

            if (right < heap.size() && heap.get(right) > heap.get(largest)) {
                largest = right;
            }

            if (largest == i) {
                break;
            }

            int temp = heap.get(i);
            heap.set(i, heap.get(largest));
            heap.set(largest, temp);
            i = largest;
        }
    }
}
