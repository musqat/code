# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def countNodes(self, root: Optional[TreeNode]) -> int:
        if not root :
            return 0

        left_height = self._get_height(root, go_left=True)
        right_height = self._get_height(root, go_left=False)

        if left_height == right_height:
            return (2 ** left_height) - 1

        return 1 + self.countNodes(root.left) + self.countNodes(root.right)
        
    def _get_height(self, node: Optional[TreeNode], go_left: bool) -> int:
        height = 0
        while node:
            node = node.left if go_left else node.right
            height += 1
        return height
