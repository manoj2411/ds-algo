class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def LCA(root, n1, n2):
    if root is None:
        return root
    if n1 < root.data and n2 < root.data:
        return LCA(root.left, n1, n2)
    if n1 > root.data and n2 > root.data:
        return LCA(root.right, n1, n2)
    return root

root = Node(20)
root.left = Node(8)
root.right = Node(22)
root.left.left = Node(4)
root.left.right = Node(12)
root.left.right.left = Node(10)
root.left.right.right = Node(14)

print("lca 10, 14 : ", LCA(root, 10, 14).data) # 12
print("lca 8, 14 : ", LCA(root, 8, 14).data) # 8
print("lca 10, 22 : ", LCA(root, 10, 22).data) # 20
