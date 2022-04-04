/*
	https://leetcode.com/problems/guess-number-higher-or-lower/
*/
class GuessNumberHigherOrLower {
	public static void main(String[] args) {
		System.out.println(new Solution(6).guessNumber(10)); // 6
		System.out.println(new Solution(1).guessNumber(1)); // 1
		System.out.println(new Solution(1).guessNumber(2)); // 1
		System.out.println(new Solution(2).guessNumber(2)); // 2
		System.out.println(new Solution(2147483640).guessNumber(2147483647)); // 2147483640

	}
}

/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

class Solution extends GuessGame {
	Solution(int pick) {
		super(pick);
	}

	/*
		This is nothing but binary search, keep integer overflow in mind
	*/
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while(left < right) {

            int num = left + ((right - left) / 2);

            int compare = guess(num);

            if (compare < 0) {
                right = num - 1;
            } else if (compare > 0 ){
                left = num + 1;
            } else {
                return num;
            }
        }

        return left;
    }
}

class GuessGame {
	int pick;

	GuessGame(int pick) {
		this.pick = pick;
	}

	int guess(int num) {
		return Integer.compare(pick, num);
	}
}
