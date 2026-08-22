class Solution {
    public int findComplement(int num) {
        if(num == 0) return 1;

        int bitlen = Integer.toBinaryString(num).length();

        int mask = (1 << bitlen) - 1;
        
        return num ^ mask;
    }
}