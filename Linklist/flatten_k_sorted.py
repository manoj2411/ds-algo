'''
class Node:
    def __init__(self, d):
        self.data=d
        self.next=None
        self.bottom=None
'''

def flatten(root):
    result = root
    curr = root.next
    while curr is not None:
        result = merge(result, curr)
        curr = curr.next
    return result

def merge(h1, h2):
    result = Node("dummy")
    curr = result

    while h1 is not None and h2 is not None:
        if h1.data > h2.data:
            curr.bottom = h2
            h2 = h2.bottom
        else:
            curr.bottom = h1
            h1 = h1.bottom
        curr = curr.bottom

    while h1 is not None:
        curr.bottom = h1
        h1 = h1.bottom
        curr = curr.bottom

    while h2 is not None:
        curr.bottom = h2
        h2 = h2.bottom
        curr = curr.bottom

    return result.bottom

# TEST in terminal with these inputs:
#
# 1
# 4
# 4 2 3 4
# 5 7 8 30 10 20 19 22 50 28 35 40 45



#{
#  Driver Code Starts

class Node:
    def __init__(self, d):
        self.data=d
        self.next=None
        self.bottom=None



def printList(node):
    while(node is not None):
        print(node.data,end=" ")
        node=node.bottom

    print()


if __name__=="__main__":
    t=int(input())
    while(t>0):
        head=None
        N=int(input())
        arr=[]

        arr=[int(x) for x in input().strip().split()]
        temp=None
        tempB=None
        pre=None
        preB=None

        flag=1
        flag1=1
        listo=[int(x) for x in input().strip().split()]
        it=0
        for i in range(N):
            m=arr[i]
            m-=1
            a1=listo[it]
            it+=1
            temp=Node(a1)
            if flag is 1:
                head=temp
                pre=temp
                flag=0
                flag1=1
            else:
                pre.next=temp
                pre=temp
                flag1=1

            for j in range(m):
                a=listo[it]
                it+=1
                tempB=Node(a)
                if flag1 is 1:
                    temp.bottom=tempB
                    preB=tempB
                    flag1=0
                else:
                    preB.bottom=tempB
                    preB=tempB
        root=flatten(head)
        printList(root)

        t-=1

# } Driver Code Ends
