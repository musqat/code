# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        one = head
        two = head

        while one and one.next:
            one = one.next.next
            two = two.next

            if one == two :
                return True
        return False