class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        n = len(nums)
        count = [0] * (n + 1)

        for a in nums:
            count[a] += 1

        
        dup = mis = 0

        for k in range(1, n + 1):
            if count[k] == 2:
                dup = k
            elif count[k] == 0:
                mis = k
        
        return [dup,mis]
