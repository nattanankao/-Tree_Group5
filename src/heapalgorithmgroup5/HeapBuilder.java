package heapalgorithmgroup5;

import java.util.ArrayList;
import java.util.List;

public final class HeapBuilder {
    private HeapBuilder() {
    }

    public static List<Integer> buildByAlgorithmA(int[] values) {
        MaxIntHeap heap = new MaxIntHeap();
        List<Integer> result = new ArrayList<>();

        for (int value : values) {
            heap.insert(value);
            result.addAll(heap.toList());
            result.add(Integer.MIN_VALUE);
        }

        if (!result.isEmpty()) {
            result.remove(result.size() - 1);
        }
        return result;
    }

    public static List<List<Integer>> traceAlgorithmA(int[] values) {
        MaxIntHeap heap = new MaxIntHeap();
        List<List<Integer>> trace = new ArrayList<>();

        for (int value : values) {
            heap.insert(value);
            trace.add(heap.toList());
        }
        return trace;
    }

    public static List<List<Integer>> traceAlgorithmB(int[] values) {
        MaxIntHeap heap = new MaxIntHeap();
        for (int value : values) {
            heap.addRaw(value);
        }

        List<List<Integer>> trace = new ArrayList<>();
        trace.add(heap.toList());

        for (int i = values.length / 2 - 1; i >= 0; i--) {
            heap.heapifyDownPublic(i);
            trace.add(heap.toList());
        }
        return trace;
    }

    public static List<Integer> buildByAlgorithmB(int[] values) {
        MaxIntHeap heap = new MaxIntHeap();
        for (int value : values) {
            heap.addRaw(value);
        }
        heap.buildBottomUp();
        return heap.toList();
    }

    private static final class MaxIntHeap {
        private final List<Integer> heap = new ArrayList<>();

        void insert(int value) {
            heap.add(value);
            int i = heap.size() - 1;

            while (i > 0) {
                int parent = (i - 1) / 2;
                if (heap.get(parent) >= heap.get(i)) {
                    break;
                }
                swap(parent, i);
                i = parent;
            }
        }

        void addRaw(int value) {
            heap.add(value);
        }

        void buildBottomUp() {
            for (int i = heap.size() / 2 - 1; i >= 0; i--) {
                heapifyDownPublic(i);
            }
        }

        void heapifyDownPublic(int i) {
            while (true) {
                int left = 2 * i + 1;
                int right = left + 1;
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
                swap(i, largest);
                i = largest;
            }
        }

        List<Integer> toList() {
            return new ArrayList<>(heap);
        }

        private void swap(int i, int j) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }
    }
}
