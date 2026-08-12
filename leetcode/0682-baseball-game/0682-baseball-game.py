class Solution:
    def calPoints(self, operations: List[str]) -> int:
        ops = []

        for op in operations:
            if op == "+":
                ops.append(ops[-1] + ops[-2])
            elif op == "D":
                ops.append(ops[-1] * 2)
            elif op == "C":
                ops.pop()
            else:
                ops.append(int(op))
        return sum(ops)