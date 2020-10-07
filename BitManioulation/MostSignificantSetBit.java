
class MostSignificantSetBit {

    /* Problem : Find most significant set bit of a number

        Idea : one by one set bits from MSB till end towards right, then
            add 1 so that only the bit after MSB is set. Finally right shift
            by 1 and return the answer.
    */
    static int findMsb(int n) {
        // Assuming int is 32 bit
        n |= (n >> 1); // 1000000001 => 1100000001
        n |= (n >> 2); // 1100000001 => 1111000001
        // similarly copi set bits till 16 bits
        n |= (n >> 4);
        n |= (n >> 8);
        n |= (n >> 16);

        return ((n + 1) >> 1);

    }

    static int findMsbTrivial(int n) {
        if(n == 0) return 0;

        int result = 1;

        while(n > 1) {
            n >>= 1;
            result <<= 1;
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println("most significant set bit of 10 " + findMsb(10));
        System.out.println("most significant set bit of 18 " + findMsb(18));
    }
}
