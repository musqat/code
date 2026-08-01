class Solution:
    def isHappy(self, n: int) -> bool:
        visit = set()

        def get_next_number(n) :
            output = 0

            while n :
                digit = n % 10
                output += digit ** 2
                n = n // 10

            return output
        
        n1 = get_next_number(n)
        n2 = get_next_number(get_next_number(n))

        while n1 != n2 :
            if n2 == 1: return True
            n1 = get_next_number(n1)
            n2 = get_next_number(get_next_number(n2))

        return n1 == 1

