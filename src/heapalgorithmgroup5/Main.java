package heapalgorithmgroup5;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] values = {4, 10, 3, 5, 1, 8, 7, 9, 2, 6};

        System.out.println("=== Algorithm A: Incremental Build Heap ===");
        List<List<Integer>> traceA = HeapAlgorithmA.trace(values);
        for (int i = 0; i < traceA.size(); i++) {
            System.out.println("Insert " + values[i] + " -> " + traceA.get(i));
        }

        System.out.println();
        System.out.println("=== Algorithm B: Bottom-Up Build Heap ===");
        List<List<Integer>> traceB = HeapAlgorithmB.trace(values);
        System.out.println("Initial Array -> " + traceB.get(0));
        for (int i = 1; i < traceB.size(); i++) {
            int nodeIndex = values.length / 2 - i;
            System.out.println("HeapifyDown index " + nodeIndex + " -> " + traceB.get(i));
        }

        System.out.println();
        List<Integer> heapA = HeapAlgorithmA.build(values);
        List<Integer> heapB = HeapAlgorithmB.build(values);
        System.out.println("Final Heap A = " + heapA);
        System.out.println("Final Heap B = " + heapB);
        System.out.println("Same final heap = " + heapA.equals(heapB));

        System.out.println();
        System.out.println("=== Job Heap Operations ===");
        MaxHeap jobHeap = new MaxHeap();

        jobHeap.insert(new Job("J01", "Backup", 3, "08:00", 30));
        jobHeap.insert(new Job("J02", "Emergency", 10, "08:01", 10));
        jobHeap.insert(new Job("J03", "Report", 5, "08:02", 20));
        jobHeap.insert(new Job("J04", "DatabaseFix", 9, "08:03", 40));
        jobHeap.insert(new Job("J05", "Email", 2, "08:04", 5));
        jobHeap.insert(new Job("J06", "SecurityScan", 8, "08:05", 25));

        System.out.println("DISPLAY_HEAP: " + jobHeap.displayHeap());
        System.out.println("PEEK_MAX: " + jobHeap.peekMax());
        System.out.println("Heap valid: " + jobHeap.isValidMaxHeap());

        Job removed = jobHeap.removeMax();
        System.out.println("REMOVE_MAX: " + removed);
        System.out.println("After REMOVE_MAX: " + jobHeap.displayHeap());

        jobHeap.increasePriority(2, 12);
        System.out.println("After INCREASE_PRIORITY(index=2, newPriority=12): "
                + jobHeap.displayHeap());

        System.out.println();
        System.out.println("BUILD_HEAP with all sample jobs:");
        jobHeap.buildHeap(Arrays.asList(
                new Job("J01", "Backup", 3, "08:00", 30),
                new Job("J02", "Emergency", 10, "08:01", 10),
                new Job("J03", "Report", 5, "08:02", 20),
                new Job("J04", "DatabaseFix", 9, "08:03", 40),
                new Job("J05", "Email", 2, "08:04", 5),
                new Job("J06", "SecurityScan", 8, "08:05", 25)
        ));
        System.out.println(jobHeap.displayHeap());
    }
}
