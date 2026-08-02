class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        count = 0

        if x == y :
            return count
        
        while x > 0 or y > 0 :
            xbit = 0
            ybit = 0

            if x > 0 :
                xbit = x % 2
                x = x // 2
            
            if y > 0 :
                ybit = y % 2
                y = y // 2
            
            if xbit != ybit :
                count += 1

        return count