class Node:
    """ Class Node """
    def __init__(self, value):
        self.left = None
        self.data = value
        self.right = None

def bToDLL(root):
    dummy = Node("dummy")
    prev = [dummy]
    inorder(root, prev)
    head = dummy.right
    head.left = None
    return head

def inorder(node, prev):
    if node is None:
        return
    inorder(node.left, prev)

    node.left = prev[0]
    prev[0].right = node
    prev[0] = node

    inorder(node.right, prev)


def printInOrder(root):
    if root is None:
        return
    printInOrder(root.left)
    print(root.data, end = ' ')
    printInOrder(root.right)

def printLinear(head):
    while head != None:
        print(head.data, end = ' ')
        head = head.right
    print()


root = Node(10)
root.left = Node(12)
root.right = Node(15)
root.right.left = Node(36)
root.left.left = Node(25)
root.left.right = Node(30)

print("Tree inorder: ")
printInOrder(root)
print()

head = bToDLL(root)

print("DLL: ")
printLinear(head)
