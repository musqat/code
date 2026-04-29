class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        result = 0
        for i in range(len(nums)) :
            if nums[i] < target :
                result += 1
            else :
                return result
        return result