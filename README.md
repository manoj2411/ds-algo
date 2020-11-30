# ds-algo
Playground for popular algorithms and data-structures problems.

## Problems


#### Graphs

* **Snake and Ladder Problem**: Given a snake and ladder game, find the minimum number of dice throws required to reach the destination from source. ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Graphs/snake_ladder.rb))

* **Course Schedule** There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses-1`. There are course prerequisites like [0,1], meaning to take `0` you have to `1` first. Find out if it is possible for you to finish all courses? [Ref](https://leetcode.com/problems/course-schedule/). ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Graphs/course_schedule.rb))

* Reorder Routes to Make All Paths Lead to the City Zero, [ref](https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/). ([Solution](https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/discuss/662080/on-clean-solution-in-ruby-bfs-faster-than-100-submissions))

* **Cheapest Flights Within K Stops** [ref](https://leetcode.com/problems/cheapest-flights-within-k-stops/). ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Graphs/cheapest_flights_within_k_stops.rb))

* **Surrounded Regions** Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'. A region is captured by flipping all 'O's into 'X's in that surrounded region, [ref](https://leetcode.com/problems/surrounded-regions/). ([Solution](https://leetcode.com/problems/surrounded-regions/discuss/692397/ruby-clean-solution-bfs-faster-than-100-submissions))

* Find shortest distances between every pair of vertices of weighted directed Graph - Floyd–Warshall's Algorithm, [ref](https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall/0). ([solution](https://github.com/manoj2411/ds-algo/blob/master/Graphs/shortest_distances_floyd_warshall.rb))


#### Arrays

* Binary search ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Array/binary_search.rb))

* Ternary Search ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Array/ternary_search.py))

* Subarray with given sum, non-negative numbers. ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Array/subarray_for_sum_non-nag.rb))

* Rearrange an array in maximum minimum form, O(1) extra space. ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Array/rearrange_sorted_to_max_min.rb))

* **Maximum Subarray**: given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum. ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Array/maximum_subarray.rb))

* Move all zeroes to end of array with minimum operations and in-place ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Array/move_zeros_to_end.rb))

* Sort an array of 0s, 1s and 2s ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Array/sort_012.rb))

* Equilibrium point/index of an array ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Array/equilibrium.rb))

* Reverse an array in groups of given size ([details](https://www.geeksforgeeks.org/reverse-an-array-in-groups-of-given-size/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/Array/reverse_in_group.py)


* **Counting Elements** - Given an integer array, count element `x` such that `x + 1` is also in array. If there're duplicates in array, count them seperately. ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Array/count_elements.rb))

* **Last Stone Weight** - Given an integer array as collection of stones, Each turn, we choose the two heaviest stones and smash them together. The result of this smash is: If `x == y`, both stones are totally destroyed otherwise weight of `x` is destroyed, and the stone of weight `y` has new weight y-x ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Array/last_stone_weight.rb))

* **Contiguous Array** Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1. ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Array/contiguous_array.rb))

* **Product of Array Except Self** Given an array of integers, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i]. Without using division. ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Array/product_except_self.rb))

* Find the point where maximum intervals overlap ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Array/max_intervals_overlap.rb))

* Maximum Sum Circular Subarray ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Array/max_subarray_sum_circular.rb))

* Online Stock Span : collect daily price quotes of a stock and return the `span` of the stock's price for the current day. Span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price. For example, if the price of a stock over the next 7 days were `[100, 80, 60, 70, 60, 75, 85]`, then the stock spans would be `[1, 1, 1, 2, 1, 4, 6]`. ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Array/online_stock_span.rb))

* Find leaders : An element is leader if it is greater than all the elements to its right side, rightmost element is always a leader. ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Array/find_leaders.rb))

* Interval List Intersections : Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order. Return the intersection of these two interval lists. [Ref](https://leetcode.com/problems/interval-list-intersections). ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Array/interval_intersection.rb))

* **Search Insert Position** Given a sorted array and a target value, return the index if the target is found otherwise return the index where it would be if it were inserted in order [ref](https://leetcode.com/problems/search-insert-position/). [Solution](https://github.com/manoj2411/ds-algo/blob/master/Array/search_insert_position.rb)

* **H-Index II** Given an array of citations sorted in ascending order of a researcher, write a function to compute the [researcher's h-index](https://en.wikipedia.org/wiki/H-index), [ref](https://leetcode.com/problems/h-index-ii/). ([solution](https://github.com/manoj2411/ds-algo/blob/master/Array/h_index_ii.rb))

* **Avoid Flood in The City** [full details](https://leetcode.com/problems/avoid-flood-in-the-city/)
  * [Solution exceeds time for large input](https://github.com/manoj2411/ds-algo/blob/master/Array/avoid_flood.rb)

* [**Largest Divisible Subset**](https://leetcode.com/problems/largest-divisible-subset/)  - [solution](https://github.com/manoj2411/ds-algo/blob/master/Array/largest_divisible_subset.rb)

* [**Top K Frequent Elements**](https://leetcode.com/problems/top-k-frequent-elements/) - [solution](https://github.com/manoj2411/ds-algo/blob/master/Array/top_k_frequent.rb)

* Given a sorted and rotated array, find if there is a pair with a given sum ([ref](https://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/))
  * [solution in `.py`](https://github.com/manoj2411/ds-algo/blob/master/Array/sum_pair_in_sorted_rotated_arr.py)
  * [solution in `.rb`, optimised](https://github.com/manoj2411/ds-algo/blob/master/Array/pair_sum_in_sorted_rotated_arr.rb)

* Sort elements by frequency ([ref](https://www.geeksforgeeks.org/sort-elements-frequency-set-4-efficient-approach-using-hash/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/Array/SortByFrequency.java)

* Sort a nearly sorted (or K sorted) array ([ref](https://www.geeksforgeeks.org/nearly-sorted-algorithm/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/Heap/SortNearlySortedList.java)

* Duplicates in an array : Given an array containing elements from `0` to `n-1`, with any of these numbers appearing any number of times, find these repeating numbers in **O(n)** and using only constant memory space. ([ref](https://www.geeksforgeeks.org/duplicates-array-using-o1-extra-space-set-2/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/Array/DuplicatesInArray.java)

* Relative Sorting : Sort A1 in such a way that the relative order among the elements will be same as those in A2. For the elements not present in A2, append them at last in sorted order ([ref](https://practice.geeksforgeeks.org/problems/relative-sorting/0)). [solution](https://github.com/manoj2411/ds-algo/blob/master/Array/RelativeSorting.java)


#### Linked List

* Reverse a linked list
  * [Recursive solution](https://github.com/manoj2411/ds-algo/blob/master/Linklist/reverse_recur.rb)
  * [Iterative solution](https://github.com/manoj2411/ds-algo/blob/master/Linklist/reverse_ite.rb)

* Merge two sorted linked lists such that merged list is in reverse order. ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Linklist/merge_reverse.rb))

* Merge two sorted lists (in-place).
  * [Iterative solution](https://github.com/manoj2411/ds-algo/blob/master/Linklist/merge_sorted_in_place_iterative.rb)
  * [Recursive solution](https://github.com/manoj2411/ds-algo/blob/master/Linklist/merge_sorted_in_place_recurr.rb)

* Merge k sorted lists or Flattening a Linked List, [ref](https://www.geeksforgeeks.org/flattening-a-linked-list/)
  * [Recursive solution](https://github.com/manoj2411/ds-algo/blob/master/Linklist/flatten_k_sorted.rb)
  * [Iterative solution](https://github.com/manoj2411/ds-algo/blob/master/Linklist/flatten_k_sorted.py)

* Sort a linked list of 0s, 1s and 2s by changing links ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Linklist/sort_012.rb))

* Add two numbers represented by linked lists, digits are stored in reverse order and each node contain a single digit. ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Linklist/add_numbers.rb))

* Add two numbers represented by linked lists. Lists are non-empty. Reversing the lists is not allowed ([details](https://leetcode.com/problems/add-two-numbers-ii/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/Linklist/AddTwoNumbersII.java)

* **Rotate a Linked List** counter-clockwise by k nodes, where `0 < k <= len(list)` ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Linklist/rotate.rb))

* Remove loop in Linked List ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Linklist/remove_loop.rb))

* Intersection of two Sorted Linked Lists ([ref](https://www.geeksforgeeks.org/intersection-of-two-sorted-linked-lists/))
  * [Iterative solution](https://github.com/manoj2411/ds-algo/blob/master/Linklist/intersection_list.rb)
  * [Recursive solution](https://github.com/manoj2411/ds-algo/blob/master/Linklist/intersection_list_recursive.rb)

* Flatten a Multilevel Doubly Linked List, [ref](https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/). ([solution](https://github.com/manoj2411/ds-algo/blob/master/Linklist/flatten_multi_level_doubly.rb))

* Reverse a Linked List in groups of given size. ([solution](https://github.com/manoj2411/ds-algo/blob/master/Linklist/reverse_in_group.rb))

* Flatten a multilevel linked list in way that all nodes at first level should come first, then nodes of second level, and so on. ([ref](https://www.geeksforgeeks.org/flatten-a-linked-list-with-next-and-child-pointers/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/Linklist/flatten_multilevel.rb)

#### Tree

valid_path.rb

* Maximum width of a binary tree. ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Tree/max_width_of_tree.rb))

* A program to check if a binary tree is BST or not. ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Tree/is_bst.rb))

* Height of Binary Tree. ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Tree/height_recursive.rb))

* Binary Search Tree - Search and Insertion ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Tree/bst_insert_and_search.rb))

* Print left view of Binary tree ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Tree/print_left_view.rb))

* Construct bst from preorder traversal ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Tree/bst_from_preorder.rb))

* **Diameter of Binary Tree** : Diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root. ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Tree/diameter-binary-tree.rb))

* Convert a Binary Tree into its Mirror Tree. Also known as **[Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/)** ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Tree/mirror_tree.rb))

* Root to leaf path sum equal to a given number ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Tree/has_path_sum.rb))

* Check if tree is Symmetric i.e. mirror image of itself ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Tree/is_symmetric.rb))

* Double Tree ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Tree/double_tree.rb))

* Cousins in Binary Tree ([ref](https://leetcode.com/problems/cousins-in-binary-tree/)). [Solution](https://github.com/manoj2411/ds-algo/blob/master/Tree/is_cousins.rb)

* Maximum Path Sum from one leaf node to another of a binary tree. ([ref](https://practice.geeksforgeeks.org/problems/maximum-path-sum/1)). [Solution](https://github.com/manoj2411/ds-algo/blob/master/Tree/max_path_sum.rb)

* Convert a given Binary Tree to Doubly Linked List in-place, [ref](https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1)
  * [solution in ruby](https://github.com/manoj2411/ds-algo/blob/master/Tree/binary_tree_to_dll.rb)
  * [solution in python](https://github.com/manoj2411/ds-algo/blob/master/Tree/binary_tree_to_dll.py)

* Given a **complete binary tree**, count the number of nodes, [ref](https://leetcode.com/problems/count-complete-tree-nodes/). ([solution](https://github.com/manoj2411/ds-algo/blob/master/Tree/count_complete_tree_nodes.rb))

* Given a binary tree containing digits from `0-9 `only, each root-to-leaf path could represent a number, ex: path `1->2->3` represents the number 123. Find the total sum of all **root-to-leaf numbers** [ref](https://leetcode.com/problems/sum-root-to-leaf-numbers/). ([solution](https://github.com/manoj2411/ds-algo/blob/master/Tree/sum_root_leaf_numbers.rb))

* Maximum difference between node and its ancestor in Binary Tree, [ref](https://practice.geeksforgeeks.org/problems/maximum-difference-between-node-and-its-ancestor/1). ([solution](https://github.com/manoj2411/ds-algo/blob/master/Tree/max_difference.py))

* Lowest Common Ancestor in a BST, assuming both the values exist in the tree. [solution](https://github.com/manoj2411/ds-algo/blob/master/Tree/lca_bst.py)

* Vertical Order Traversal of a Binary Tree, ([ref](https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/Tree/vertical_order_traversal.rb)

* **Path Sum III** Each node of the tree contains an integer value, find the number of paths that sum to a given value. The path does not need to start or end at the root or a leaf, but it must go downwards, ([ref](https://leetcode.com/problems/path-sum-iii/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/Tree/path_sum_iii.rb)

* Delete Node in a BST ([ref](https://leetcode.com/problems/delete-node-in-a-bst/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/Tree/DeleteNodeInBST.java)

* Check if a binary tree is subtree of another binary tree ([ref](https://practice.geeksforgeeks.org/problems/check-if-subtree/1)). [solution](https://github.com/manoj2411/ds-algo/blob/master/Tree/is_subtree.rb)

* Preorder to Postorder : Given an array of N nodes representing preorder traversal of BST, print its postorder traversal in O(N) time ([ref](https://practice.geeksforgeeks.org/problems/preorder-to-postorder/0)). [solution](https://github.com/manoj2411/ds-algo/blob/master/Tree/PreorderToPostorderBST.java)

* Find k-th smallest element in BST (Order Statistics in BST) ([ref](https://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/Tree/find_k_th_in_bst.rb)

* Reverse Level Order Traversal ([ref](https://www.geeksforgeeks.org/reverse-level-order-traversal/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/Tree/ReverseLevelOrderTraversal.java)

#### String

* **Backspace String Compare**: Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character. ([Solution](https://github.com/manoj2411/ds-algo/blob/master/String/backspace_compare.rb))

* **Perform String shifts**: given list of pairs `[direction, amount]` to perform shift on a given string. `direction` 0 means left shift and `1` means right shift. ([Solution](https://github.com/manoj2411/ds-algo/blob/master/String/string_shift.rb))

* **Group Anagrams**: given an array of strings, group anagrams together. ([Solution](https://github.com/manoj2411/ds-algo/blob/master/String/group_anagrams.rb))

* **Valid Parenthesis String** string has 3 types of characters: `(`, `)` and `*`. `*` can be treated as `(` or `)` or empty string. ([Solution](https://github.com/manoj2411/ds-algo/blob/master/String/check_valid_string.rb))

* Balanced parenthesis : determine if are the parenthesis balanced in a given string
  * [Solution where string has other chars as well](https://github.com/manoj2411/ds-algo/blob/master/String/balanced_parenthesis.rb)
  * [Solution where string only has parenthesis](https://github.com/manoj2411/ds-algo/blob/master/String/parenthesis_checker.rb)

* Find All Anagrams in a String ([ref](https://leetcode.com/problems/find-all-anagrams-in-a-string/)). [Solution](https://github.com/manoj2411/ds-algo/blob/master/String/find_anagrams_in_string.rb)

* **Making File Names Unique** Given a list of names, create `n` folders in your file system such that, create a folder for every name. Since two files cannot have the same name, if you enter a folder name which is previously used, the system will have a suffix addition to its name in the form of (k), where, k is the smallest positive integer such that the obtained name remains unique, [ref](https://leetcode.com/problems/making-file-names-unique/). ([solution](https://leetcode.com/problems/making-file-names-unique/discuss/698020/Ruby-or-super-easy-solution-or-faster-than-100-submissions))

* Reverse words in a string OR reverse string word by word
  * [manage extra spaces](https://leetcode.com/problems/reverse-words-in-a-string/) : [solution](https://github.com/manoj2411/ds-algo/blob/master/String/reverse_words.rb)
  * in place : [solution](https://github.com/manoj2411/ds-algo/blob/master/String/reverse_word.rb)

* Partition Labels : partition the given string into as many parts(groups) as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts. For example: for  string `"ababcbacadefegdehijhklij"` result would be `[9,7,8]` ([ref](https://leetcode.com/problems/partition-labels/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/String/PartitionLabels.java)

* Roman Number to Integer. [solution](https://github.com/manoj2411/ds-algo/blob/master/String/roman_to_int.py)

#### Sortings

* QuickSort for array ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Sortings/quick_sort.rb))

* 3-Way QuickSort (Dutch National Flag)
  * [Solution in ruby](https://github.com/manoj2411/ds-algo/blob/master/Sortings/3_way_quick_sort.rb)
  * [Solution in python](https://github.com/manoj2411/ds-algo/blob/master/Sortings/3_way_quick_sort.py)

#### Stack

* **Min Stack** : Design a stack that supports push, pop, top, and retrieving the minimum element in constant time. ([Solution](https://github.com/manoj2411/ds-algo/blob/master/Stack/min_stack.rb))

* **Infix to Postfix** [ref](https://practice.geeksforgeeks.org/problems/infix-to-postfix/0). ([solution](https://github.com/manoj2411/ds-algo/blob/master/Stack/infix_to_postfix.rb))
* **Evaluation of Postfix Expression** ex: `'1 2 3 + * 8 -'` => `-3`, [ref](https://practice.geeksforgeeks.org/problems/evaluation-of-postfix-expression/0). ([solution](https://github.com/manoj2411/ds-algo/blob/master/Stack/postfix_experssion_evaluation.rb))


#### Matrix / 2D

* Flood fill Algorithm ([Solution](https://github.com/manoj2411/ds-algo/blob/master/2D/flood_fill.rb))

* Count square submatrices with all ones ([Solution](https://github.com/manoj2411/ds-algo/blob/master/2D/count_squares.rb))

* Island Perimeter, [ref](https://leetcode.com/problems/island-perimeter/)

* Set every cell in matrix to 0 if that row or column contains a 0 ([details](https://www.geeksforgeeks.org/a-boolean-matrix-question/), [details](https://leetcode.com/problems/set-matrix-zeroes/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/2D/SetMatrixZeroes.java)


#### Advance Data Structures

* **Trie** operations with prefix search i.e. `insert`, `search`, `starts_with`, [ref](https://leetcode.com/problems/implement-trie-prefix-tree/). ([Solution](https://leetcode.com/problems/implement-trie-prefix-tree/discuss/693234/Ruby-or-Clean-solution))

* Add and Search Word - Data structure design, ([ref](https://leetcode.com/problems/add-and-search-word-data-structure-design/)). [solutuon](https://github.com/manoj2411/ds-algo/blob/master/AdvanceDataStructures/Trie/add_and_search_word.rb)

* Auto-complete feature using Trie. [solution](https://github.com/manoj2411/ds-algo/blob/master/AdvanceDataStructures/Trie/auto_complete.rb)

* Stream of Characters, ([details](https://leetcode.com/problems/stream-of-characters/)). [solution](https://leetcode.com/problems/stream-of-characters/discuss/808764/ruby-trie-with-reversed-words-faster-than-100-submissions)


#### DP

* **Making Change** Given an amount and coins, write a function to compute the minimum number of coins required to make that amount of change.
  * [top-down solution](https://github.com/manoj2411/ds-algo/blob/master/Dp/make_coin_change_recursive.rb)
  * [bottom-up solution](https://github.com/manoj2411/ds-algo/blob/master/Dp/make_coin_change_iterative.rb)

* **0-1 Knapsack** You have a knapsack which can carry a certain maximum amount of weight and you have a set of items with their own weight and a monetary value. You can only carry what fits in the knapsack. Find the maximize amount of money that you can earn.
  * [top-down solution](https://github.com/manoj2411/ds-algo/blob/master/Dp/knapsack_recursive.rb)
  * [bottom-up solution](https://github.com/manoj2411/ds-algo/blob/master/Dp/knapsack_iterative.rb)

* **Paint House III** Given an array `houses`, an `m * n` matrix cost and an integer `target`, return minimum cost of painting all the remaining houses in such a way that there are exactly `target` neighborhoods, if not possible return `-1` ([ref](https://leetcode.com/problems/paint-house-iii/))
  * [recursive solution](https://github.com/manoj2411/ds-algo/blob/master/Dp/paint_house_iii_brute_force.rb) brute force
  * [top-down solution](https://github.com/manoj2411/ds-algo/blob/master/Dp/paint_house_iii_top_down.rb)

* **Target Sum** Given a list of non-negative numbers and a target, S. Find the number of ways that we can `add` and `subtract` the values in `nums` to add up to T [(ref)](https://leetcode.com/problems/target-sum/).
  * [brute force solution](https://github.com/manoj2411/ds-algo/blob/master/Dp/target_sum_brute_force.rb)
  * [top down solution](https://github.com/manoj2411/ds-algo/blob/master/Dp/target_sum_top_down.rb)

* **Coin Change 2** Find number of combinations that make up that amount, assume that you have infinite coins ([ref](https://leetcode.com/problems/coin-change-2/)).
  * [top-down solution](https://github.com/manoj2411/ds-algo/blob/master/Dp/coin_change_2_top_down.rb)

* Find maximum possible stolen value from houses ([ref](https://www.geeksforgeeks.org/find-maximum-possible-stolen-value-houses/ )). [solution](https://github.com/manoj2411/ds-algo/blob/master/Dp/max_possible_stolen_value_houses.py)

* **Word Break II** Given a non-empty string `s` and a dictionary wordDict, add spaces in `s` to construct a sentence where each word is a valid dictionary word. Return all such possible sentences, [ref](https://leetcode.com/problems/word-break-ii/). [solution](https://github.com/manoj2411/ds-algo/blob/master/Dp/word_break_ii.rb)


#### Bit Manipulation

* The **Hamming distance** between two integers is the number of positions at which the corresponding bits are different, [ref](https://leetcode.com/problems/hamming-distance/). ([solution](https://github.com/manoj2411/ds-algo/blob/master/BitManioulation/hamming_distance.rb))

* Position of first set bit found from right side in the binary representation of given the number. ([solution](https://github.com/manoj2411/ds-algo/blob/master/BitManioulation/first_set_bit.py))

* Find most significant set bit of a number. ([solution](https://github.com/manoj2411/ds-algo/blob/master/BitManioulation/MostSignificantSetBit.java))


#### Bacltracking

* Word Search from a 2D board of characters, [(ref)](https://leetcode.com/problems/word-search/). [solution](https://github.com/manoj2411/ds-algo/blob/master/backtracking/word_search.rb)

* Print all distinct permutations of a given string. ([solution](https://github.com/manoj2411/ds-algo/blob/master/backtracking/permute_unique.rb))


#### Misc

* **Insert Delete GetRandom O(1) or Randomized Set** Design a data structure that supports all the operations in constant time O(1) [ref](https://leetcode.com/problems/insert-delete-getrandom-o1/). [Solution](https://github.com/manoj2411/ds-algo/blob/master/misc/randomized_set.rb)

* Given a list of `coordinates`, find if all of them are part of a same straign line. [solution](https://github.com/manoj2411/ds-algo/blob/master/misc/check_straight_line.rb)

* **Ugly Number II** Program to find `nth` ugly number i.e. a positive number whose prime factors only include `2, 3, 5`, [ref](https://leetcode.com/problems/ugly-number-ii/). ([solution](https://github.com/manoj2411/ds-algo/blob/master/Heap/ugly_number_ii.rb))

* **Subsets or Powerset** for given set of distinct integers, [ref](https://leetcode.com/problems/subsets/)
  * [cascade solution](https://github.com/manoj2411/ds-algo/blob/master/Array/subsets_powerset.rb)
  * [backtracking solution](https://github.com/manoj2411/ds-algo/blob/master/backtracking/subsets_powerset.rb)

* Angle Between Hands of a Clock, [ref](https://leetcode.com/problems/angle-between-hands-of-a-clock/). ([solution](https://github.com/manoj2411/ds-algo/blob/master/misc/angle_clock.rb))

* Find all prime factors of a given number in increasing order. [solution](https://github.com/manoj2411/ds-algo/blob/master/misc/prime_factors.py)

* Given a non-negative index k where 0 ≤ k ≤ 33, return the kth index row of the Pascal's triangle ([ref](https://leetcode.com/problems/pascals-triangle-ii/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/misc/pascals_triangle_ii.rb)

* Iterator for Combination, [problem details](https://leetcode.com/problems/iterator-for-combination/). [solution](https://github.com/manoj2411/ds-algo/blob/master/misc/combination_iterator.rb)

* Find Right Interval ([problem details](https://leetcode.com/problems/find-right-interval/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/misc/FindRightInterval.java)

#### Leetcode

* Word Pattern ([details](https://leetcode.com/problems/word-pattern/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/WordPattern.java)

* Word Ladder ([details](https://leetcode.com/problems/word-ladder/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/WordLadder.java), [optimized solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/WordLadderAlt.java)

* Maximum Product Subarray ([details](https://leetcode.com/problems/maximum-product-subarray/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/MaximumProductSubarray.java)

* Unique Paths III ([details](https://leetcode.com/problems/unique-paths-iii/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/UniquePathsIII.java)

* Car Pooling ([details](https://leetcode.com/problems/car-pooling/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/CarPooling.java)

* Majority Element II ([details](https://leetcode.com/problems/majority-element-ii/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/MajorityElementII.java)

* Gas Station ([details](https://leetcode.com/problems/gas-station/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/GasStation.java)

* Teemo Attacking ([details](https://leetcode.com/problems/teemo-attacking/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/TeemoAttacking.java)

* Evaluate Division ([details](https://leetcode.com/problems/evaluate-division/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/EvaluateDivision.java)

* Subarray Product Less Than K ([details](https://leetcode.com/problems/subarray-product-less-than-k/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/SubarrayProductLessThanK.java)

* Word Break ([details](https://leetcode.com/problems/word-break/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/WordBreak.java)

* Insert Interval ([details](https://leetcode.com/problems/insert-interval/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/InsertInterval.java)

* First Missing Positive ([details](https://leetcode.com/problems/first-missing-positive/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/FirstMissingPositive.java)

* Design Parking System ([details](https://leetcode.com/problems/design-parking-system/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/ParkingSystem.java)

* Combination Sum ([details](https://leetcode.com/problems/combination-sum/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/CombinationSum.java)

* Serialize and Deserialize BST ([details](https://leetcode.com/problems/serialize-and-deserialize-bst/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/SerializeDeserializeBST.java)

* Minimum Number of Arrows to Burst Balloons ([details](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/MinArrowstoBurstBalloons.java)

* Remove Duplicate Letters ([details](https://leetcode.com/problems/remove-duplicate-letters/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/RemoveDuplicateLetters.java)

* Sliding Window Median ([details](https://leetcode.com/problems/sliding-window-median/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/SlidingWindowMedian.java)

* Buddy Strings ([details](https://leetcode.com/problems/buddy-strings/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/BuddyStrings.java)

* House Robber II ([details](https://leetcode.com/problems/house-robber-ii/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/HouseRobberII.java)

* Clone Graph ([details](https://leetcode.com/problems/clone-graph/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/CloneGraph.java)

* Search a 2D Matrix ([details](https://leetcode.com/problems/search-a-2d-matrix/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/SearchA2DMatrix.java)

* Minimum Domino Rotations For Equal Row ([details](https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/MinDominoRotations.java)

* Asteroid Collision ([details](https://leetcode.com/problems/asteroid-collision/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/AsteroidCollision.java)

* Minimum Depth of Binary Tree ([details](https://leetcode.com/problems/minimum-depth-of-binary-tree/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/AsteroidCollisionMinDepthBinaryTree.java)

* Bag of Tokens ([details](https://leetcode.com/problems/bag-of-tokens/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/BagOfTokens.java)

* Stone Game IV ([details](https://leetcode.com/problems/stone-game-iv/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/StoneGameIV.java)

* Champagne Tower ([details](https://leetcode.com/problems/champagne-tower/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/ChampagneTower.java)

* Maximize Distance to Closest Person ([details](https://leetcode.com/problems/maximize-distance-to-closest-person/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/MaxDistanceToClosestPerson.java)

* Number of Longest Increasing Subsequence ([details](https://leetcode.com/problems/number-of-longest-increasing-subsequence/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/CountLongestIncreasingSubsequence.java)

* Furthest Building You Can Reach ([details](https://leetcode.com/problems/furthest-building-you-can-reach/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/FurthestBuildingCanReach.java)

* Convert Binary Number in a Linked List to Integer ([details](https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/ConvertBinInLinkedListToInt.java)

* Mini Parser ([details](https://leetcode.com/problems/mini-parser/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/MiniParser.java)

* Minimum Cost to Move Chips to The Same Position ([details](https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/MinCostToMoveChips.java)

* Minimum Height Trees ([details](https://leetcode.com/problems/minimum-height-trees/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/MinHeightTrees.java)

* Find the Smallest Divisor Given a Threshold ([details](https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/SmallestDivisorBelowThreshold.java)

* Add Two Numbers II ([details](https://leetcode.com/problems/add-two-numbers-ii/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/Linklist/AddTwoNumbersII.java)

* Binary Tree Tilt ([details](https://leetcode.com/problems/binary-tree-tilt/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/BinaryTreeTilt.java)

* Maximum Difference Between Node and Ancestor ([details](https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/MaxDiffBtwnNodeAndAncestor.java)

* Flipping an Image ([details](https://leetcode.com/problems/flipping-an-image/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/FlippingImage.java)

* Valid Square ([details](https://leetcode.com/problems/valid-square/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/valid_square.rb)

* Permutations II ([details](https://leetcode.com/problems/permutations-ii/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/PermutationsII.java)

* Populating Next Right Pointers in Each Node ([details](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/PopulatingNextRightPointers.java)

* Range Sum of BST ([details](https://leetcode.com/problems/range-sum-of-bst/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/RangeSumOfBST.java)

* Minimum Deletions to Make String Balanced ([details](https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/MinDeletionsToMakeStrBalanced.java)

* Minimum Operations to Reduce X to Zero ([details](https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/MinOpToReduceXtoZero.java)

* Longest Mountain in Array ([details](https://leetcode.com/problems/longest-mountain-in-array/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/LongestMountainInArray.java)

* Set Matrix Zeroes ([details](https://leetcode.com/problems/set-matrix-zeroes/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/2D/SetMatrixZeroes.java)

* Merge Intervals ([details](https://leetcode.com/problems/merge-intervals/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/MergeIntervals.java)

* Decode String ([details](https://leetcode.com/problems/decode-string/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/DecodeString.java)

* House Robber III ([details](https://leetcode.com/problems/house-robber-iii/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/HouseRobberIII.java)

* Basic Calculator II ([details](https://leetcode.com/problems/basic-calculator-ii/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/BasicCalculatorII.java)

* Longest Substring with At Least K Repeating Characters ([details](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/)). [solution](https://github.com/manoj2411/ds-algo/blob/master/leetcode/longest_substring_min_k_repeating.rb)
