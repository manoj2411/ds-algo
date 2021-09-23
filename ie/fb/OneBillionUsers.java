class OneBillionUsers {

  public static void main(String[] args) {
    float[] test_1 = {1.1f, 1.2f, 1.3f};
    int expected_1 = 79;
    System.out.println(new Solution().getBillionUsersDay(test_1)); // 79

    float[] test_2 = {1.01f, 1.02f};
    System.out.println(new Solution().getBillionUsersDay(test_2)); // 1047
  }

}

class Solution {
  int oneBillion = 1000000000;

  private boolean canReachTarget(float[] growthRates, int t) {
    float users = 0;

    for(float g : growthRates) {
      users += Math.pow(g, t);
      if (users > oneBillion) return true;
    }
    return false;
  }

  int getBillionUsersDay(float[] growthRates) {

    int best = Integer.MAX_VALUE;
    long high = best;
    long low = 0;

    while(low <= high) {
      int mid = (int)((low + high) / 2);

      if (canReachTarget(growthRates, mid)) {
        best = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return best;
  }
}
