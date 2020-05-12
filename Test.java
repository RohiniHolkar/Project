package corejava;

public class Test {
	public static void main(String args[]) {

		int fact = factWithRecursion(5);

		System.err.println("Factorial with recusrion : " + fact);

		int fact1 = factWithoutRecutsion(5);

		System.err.println("Factorial without recusrion : " + fact1);

		int fib = fiboWithRecusrions(9);

		System.err.println("Fibb with recusrion : " + fib);

		int fib1 = fiboWithoutRecusrions(9);

		System.err.println("Fibb without recusrion : " + fib1);

		int fib2 = fiboWithDynamicProgramming(9);

		System.err.println("Fibb with DynamicProgramming : " + fib2);

		int a[] = { 5, 3, 7, 1, 9, 3, 0, 4, 1, 8 };

		int linearSearchResult = linearSearch(a, 9);
		System.err.println("Linear Search : " + linearSearchResult);

		int b[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int binarySearchResult = binarySearch(b, 9);
		System.err.println("BInary Search : " + binarySearchResult);

	}

	private static int binarySearch(int[] a, int num) {
		int min = 0;
		int max = a.length - 1;
		int mid = (min + max) / 2;

		while (max >= min) {
			mid = (min + max) / 2;
			if (num == a[mid]) {
				return mid;
			} else if (num > a[mid]) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}

		return -1;
	}

	private static int linearSearch(int[] a, int i) {
		for (int j = 0; j <= a.length - 1; j++) {
			if (a[j] == i) {
				return a[j];
			}
		}
		return -1;
	}

	private static int fiboWithDynamicProgramming(int i) {
		int f[] = new int[i + 2];
		f[0] = 0;
		f[1] = 1;
		for (int j = 2; j <= i; j++) {
			f[j] = f[j - 1] + f[j - 2];
		}
		return f[i];
	}

	private static int fiboWithoutRecusrions(int n) {
		int first = 0;
		int second = 1;
		int nth = 1;

		for (int i = 2; i <= n; i++) {
			nth = first + second;
			first = second;
			second = nth;
		}
		return nth;
	}

	private static int fiboWithRecusrions(int i) {
		if (i <= 1) {
			return i;
		}
		return fiboWithRecusrions(i - 1) + fiboWithRecusrions(i - 2);
	}

	private static int factWithoutRecutsion(int num) {
		int fact = 1;

		for (int i = 1; i <= num; i++) {
			fact = fact * i;
		}
		return fact;
	}

	private static int factWithRecursion(int i) {
		if (i <= 1)
			return i;

		return i * factWithRecursion(i - 1);
	}
}
