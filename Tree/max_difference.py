# Maximum difference between node and its ancestor in Binary Tree

class Node:
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None

def maxDiff(root):
    '''
    :param root: Root of given tree
    :return: Integer
    '''
    defaultMax = float('-inf')
    res = [defaultMax]
    util(root, res, defaultMax)
    return res[0]

def util(node, res, Max):
    if node is None:
        return
    diff = Max - node.data
    if diff > res[0] :
        res[0] = diff

    Max = max(Max, node.data)
    util(node.left, res, Max)
    util(node.right, res, Max)


if __name__ == '__main__':
    root = Node(8)
    root.left = Node(3)

    root.left.left = Node(1)
    root.left.right = Node(6)
    root.left.right.left = Node(4)
    root.left.right.right = Node(7)

    root.right = Node(10)
    root.right.right = Node(14)
    root.right.right.left = Node(13)

    print("Max difference b/w a node and its ancestor is: ", maxDiff(root)) # 7

