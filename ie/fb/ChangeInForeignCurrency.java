import java.util.*;

class ChangeInForeignCurrency {
	public static void main(String[] args) {
		int target_1 = 94;
		int arr_1[] = {5, 10, 25, 100, 200};
		System.out.println(new Solution().canGetExactChange(target_1, arr_1)); // false

		int target_2 = 75;
		int arr_2[] = {4, 17, 29};
		System.out.println(new Solution().canGetExactChange(target_2, arr_2)); // true

		int target_3 = 1000000;
		int arr_3[] = {3,6,9,12,15};
		System.out.println(new Solution().canGetExactChange(target_3, arr_3)); // false

		int target_4 = 999999;
		int arr_4[] = {54,52,50,48,46,44,42,40,38,36,34,32,30,28,26,24,22,20,18,16,14,12,10,8,6,4,2};
		System.out.println(new Solution().canGetExactChange(target_4, arr_4)); // false
	}
}

class Solution {

	boolean canGetExactChange(int targetMoney, int[] denominations) {
		Arrays.sort(denominations);

		Stack<Integer> stack = new Stack<>();
		stack.push(targetMoney);
		boolean[] visited = new boolean[targetMoney + 1];

		while(!stack.isEmpty()) {
			int target = stack.pop();

			// System.out.println(target);
			for(int coin : denominations) {
				if (coin > target) break;
				if (target % coin == 0) return true;
				if (!visited[target - coin]){
					stack.push(target - coin);
					visited[target - coin] = true;
				}
			}
		}

		return false;
	}

}
