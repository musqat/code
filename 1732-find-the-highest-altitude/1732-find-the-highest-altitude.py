class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        top = 0
        start = 0
        for i in gain :
            start += i
            top = max(start,top)
        return top