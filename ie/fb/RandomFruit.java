import java.util.*;
/*
	https://softwareengineering.stackexchange.com/questions/150616/get-weighted-random-item/288599
*/
class RandomFruit {
	private String[] fruits;
	private int[] range;
	private Random random;

	RandomFruit(String[] fruits, int[] weight) {
		this.fruits = fruits;
		this.range = getRange(weight);
		this.random = new Random();
	}


	String getRandomFruit() {
		int limit = range[range.length - 1] + 1;
		int rand_num = random.nextInt(limit);
		int index = Arrays.binarySearch(range, rand_num);

		// set index to the next big element of the range. This is based on the fact
		//  that binarySearch return the -(insertionPoint - 1) for missing element.
		if (index < 0) {
			index = Math.abs(index) - 1;
		}

		return fruits[index];
	}

	private int[] getRange(int[] weight) {
		int[] arr = new int[weight.length];

		int currSum = 0;
		for(int i = 0; i < arr.length; i++) {
			currSum += weight[i];
			// adjust range to be inclusive
			arr[i] = currSum - 1;
		}
		return arr;
	}




	public static void main(String[] args ) {
		String[] fruits = {"apple", "orange", "lemon"};
		int[] weight = {4, 2, 1};
		RandomFruit rand = new RandomFruit(fruits, weight);

		for(int i = 0; i < 10; i++) {
			System.out.println(rand.getRandomFruit());
		}
	}
}

