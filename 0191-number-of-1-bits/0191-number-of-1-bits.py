class Solution:
    def hammingWeight(self, n: int) -> int:        
        num = bin(n)
        result = 0
        for c in num:
            if c == '1':
                result += 1
        return result
