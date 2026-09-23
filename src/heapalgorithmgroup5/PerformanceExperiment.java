package heapalgorithmgroup5;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

public class PerformanceExperiment {
    private static final int[] SIZES = {1_000, 10_000, 100_000, 500_000};
    private static final int REMOVE_COUNT = 1_000;
    private static final int WARMUP = 3;
    private static final int REPEAT = 5;

    public static void main(String[] args) throws IOException {
        String outputFile = "performance_results.csv";

        try (PrintWriter out = new PrintWriter(new FileWriter(outputFile))) {
            out.println("n,algorithm,build_avg_ns,remove_max_1000_avg_ns");

            for (int n : SIZES) {
                int[] values = generateValues(n, 12345L + n);

                // Warm-up JVM/JIT
                for (int i = 0; i < WARMUP; i++) {
                    HeapAlgorithmA.build(values);
                    HeapAlgorithmB.build(values);
                }

                long aBuild = averageBuildA(values);
                long bBuild = averageBuildB(values);
                long aRemove = averageRemoveA(values);
                long bRemove = averageRemoveB(values);

                out.printf("%d,A,%d,%d%n", n, aBuild, aRemove);
                out.printf("%d,B,%d,%d%n", n, bBuild, bRemove);

                System.out.printf(
                        "n=%d | A Build=%d ns | B Build=%d ns | A Remove1000=%d ns | B Remove1000=%d ns%n",
                        n, aBuild, bBuild, aRemove, bRemove
                );
            }
        }

        System.out.println("Saved results to: " + outputFile);
    }

    private static long averageBuildA(int[] values) {
        long total = 0;
        for (int r = 0; r < REPEAT; r++) {
            long start = System.nanoTime();
            HeapAlgorithmA.build(values);
            total += System.nanoTime() - start;
        }
        return total / REPEAT;
    }

    private static long averageBuildB(int[] values) {
        long total = 0;
        for (int r = 0; r < REPEAT; r++) {
            long start = System.nanoTime();
            HeapAlgorithmB.build(values);
            total += System.nanoTime() - start;
        }
        return total / REPEAT;
    }

    private static long averageRemoveA(int[] values) {
        long total = 0;
        for (int r = 0; r < REPEAT; r++) {
            List<Integer> built = HeapAlgorithmA.build(values);
            total += measureRemove(built);
        }
        return total / REPEAT;
    }

    private static long averageRemoveB(int[] values) {
        long total = 0;
        for (int r = 0; r < REPEAT; r++) {
            List<Integer> built = HeapAlgorithmB.build(values);
            total += measureRemove(built);
        }
        return total / REPEAT;
    }

    private static long measureRemove(List<Integer> heap) {
        long start = System.nanoTime();

        int count = Math.min(REMOVE_COUNT, heap.size());
        for (int i = 0; i < count; i++) {
            removeMax(heap);
        }

        return System.nanoTime() - start;
    }

    private static void removeMax(List<Integer> heap) {
        int lastIndex = heap.size() - 1;
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);

        if (heap.isEmpty()) {
            return;
        }

        int i = 0;
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
                return;
            }

            int temp = heap.get(i);
            heap.set(i, heap.get(largest));
            heap.set(largest, temp);
            i = largest;
        }
    }

    private static int[] generateValues(int n, long seed) {
        Random random = new Random(seed);
        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = random.nextInt(1_000_000_000);
        }

        return values;
    }
}
