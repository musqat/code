# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
       if not root: return 0
       l, r = self.minDepth(root.left), self.minDepth(root.right)
       if not root.left or not root.right:
           return 1 + max(l, r)
       return min(l, r) + 1
