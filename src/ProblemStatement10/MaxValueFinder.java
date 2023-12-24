package ProblemStatement10;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MaxValueFinder extends RecursiveTask<Integer> {
	
	private static final int THRESHOLD = 1000;
    private int[] array;
    private int start;
    private int end;

    public MaxValueFinder(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            int max = Integer.MIN_VALUE;
            int rangeStart = start;
            int rangeEnd = end;

            for (int i = start; i < end; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }

            System.out.println("Max value found: " + max + ", range: " + rangeStart + "-" + rangeEnd);
            return max;
        } else {
            int mid = (start + end) / 2;

            MaxValueFinder leftTask = new MaxValueFinder(array, start, mid);
            MaxValueFinder rightTask = new MaxValueFinder(array, mid, end);

            invokeAll(leftTask, rightTask);

            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            System.out.println("Subtask result: " + Math.max(leftResult, rightResult) + ", range: " + start + "-" + end);
            return Math.max(leftResult, rightResult);
        }
    }

	
	public static void main(String[] args) {
		int[] array = new int[10000];

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MaxValueFinder task = new MaxValueFinder(array, 0, array.length);

        int maxValue = forkJoinPool.invoke(task);

        System.out.println("Max value of the array: " + maxValue);
	}

}