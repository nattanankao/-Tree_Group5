package heapalgorithmgroup5;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    private final List<Job> heap = new ArrayList<>();

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public Job peekMax() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    public void insert(Job job) {
        if (job == null) {
            throw new IllegalArgumentException("Job must not be null");
        }
        heap.add(job);
        heapifyUp(heap.size() - 1);
    }

    public Job removeMax() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        Job max = heap.get(0);
        Job last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return max;
    }

    public void increasePriority(int index, int newPriority) {
        if (index < 0 || index >= heap.size()) {
            throw new IndexOutOfBoundsException("Invalid heap index: " + index);
        }
        if (newPriority < heap.get(index).getPriority()) {
            throw new IllegalArgumentException(
                    "New priority must be >= current priority");
        }

        heap.get(index).setPriority(newPriority);
        heapifyUp(index);
    }

    public void buildHeap(List<Job> jobs) {
        heap.clear();
        if (jobs == null) {
            throw new IllegalArgumentException("Jobs must not be null");
        }
        heap.addAll(jobs);

        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    public List<Job> getHeap() {
        return new ArrayList<>(heap);
    }

    public boolean isValidMaxHeap() {
        for (int i = 0; i < heap.size(); i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < heap.size() && compare(heap.get(i), heap.get(left)) < 0) {
                return false;
            }
            if (right < heap.size() && compare(heap.get(i), heap.get(right)) < 0) {
                return false;
            }
        }
        return true;
    }

    public String displayHeap() {
        return heap.toString();
    }

    private void heapifyUp(int index) {
        int i = index;
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (compare(heap.get(parent), heap.get(i)) >= 0) {
                break;
            }
            swap(parent, i);
            i = parent;
        }
    }

    private void heapifyDown(int index) {
        int i = index;

        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left < heap.size()
                    && compare(heap.get(left), heap.get(largest)) > 0) {
                largest = left;
            }

            if (right < heap.size()
                    && compare(heap.get(right), heap.get(largest)) > 0) {
                largest = right;
            }

            if (largest == i) {
                break;
            }

            swap(i, largest);
            i = largest;
        }
    }

    private int compare(Job a, Job b) {
        int priorityCompare = Integer.compare(a.getPriority(), b.getPriority());
        if (priorityCompare != 0) {
            return priorityCompare;
        }
        return b.getJobId().compareTo(a.getJobId());
    }

    private void swap(int i, int j) {
        Job temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
