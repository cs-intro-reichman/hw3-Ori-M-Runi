// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5 
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7 
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
		System.out.println(sqrt(0));
		System.out.println(sqrt(1));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// If we recive a negative number we need to subtract that amount from x1 instead
		if (x2 < 0) {
			for (int i = 0; i > x2; i--) {
				x1--;
			}
		}
		else {
			for (int i = 0; i < x2; i++) {
				x1++;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// If we recive a negative number we need to add that amount to x1 instead
		if (x2 < 0) {
			for (int i = 0; i > x2; i--) {
				x1++;
			}
		}
		else {
			for (int i = 0; i < x2; i++) {
				x1--;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// using sum instead of directly adding to x1 so the case where x1 = 0 or x2 = 0 is covered
		int sum = 0;
		// whether the sum needs to be negative or not
		boolean neg = false;

		// Covers the case where x1 is negative
		if (x1 < 0) {
			x1 = Math.abs(x1);
			neg = !neg;
		}
		// covers the case where x2 is negative
		if (x2 < 0) {
			x2 = Math.abs(x2);
			neg = !neg;
		}

		for (int i = 0; i < x2; i++) {
			sum = plus(sum, x1);
		}
		if (neg) {	sum = minus(0, sum);	}
		return sum;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// using sum instead of directly multiplying x1 so that the case where x1 OR x2 are 0 (not both)
		int sum = 1;
		// Covers the case where x1 AND x2 are 0
		if (x == 0 && n == 0) {	sum = 0;	}

		for (int i = 0; i < n; i++) {
			sum = times(sum, x);
		}

		return sum;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		// keeps track of how many times x2 is subtracted from x1
		int count = 0;
		
		if (x2 == 0) {	return Integer.MAX_VALUE;	}
		// whether the sum needs to be negative or not
		boolean neg = false;

		// Covers the case where x1 is negative
		if (x1 < 0) {
			x1 = Math.abs(x1);
			neg = !neg;
		}
		// covers the case where x2 is negative
		if (x2 < 0) {
			x2 = Math.abs(x2);
			neg = !neg;
		}
		
		while (x1 >= x2) {
			count++;
			x1 = minus(x1, x2);
		}
		// checks if the number returned needs to be negative, and makes in negative if it needs to be
		if (neg) {	count = minus(0, count);	}

		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// finds the whole div of x1 and x2, then times that by x2 (the mod) and subtracts that from x1 - getting the remainder
		int modulu = x1 - (times(x2, div(x1, x2)));
		return modulu;
	}

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		
		// i <= x so that 0 and 1 are caught
		for (int i = 0; i <= x; i++) {
			if (times(i, i) == x) {	return i;	}
			else if (times(i, i) > x) {	return minus(i, 1);	}
		}

		return -1;	// If it reaches here i must be negative, return -1 as a default fail
	}	  	  
}