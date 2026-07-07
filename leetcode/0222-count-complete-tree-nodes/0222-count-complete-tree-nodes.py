# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def countNodes(self, root: Optional[TreeNode]) -> int:
        left, right, height = root, root, 0
        while left and right : left, right, height = left.left, right.right, height +1
        return 2 ** height -1 if left == right else sum(map(self.countNodes,(root.left, root.right))) + 1
