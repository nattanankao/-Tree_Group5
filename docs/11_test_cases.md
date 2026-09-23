# 11. Test Cases

| # | Test | Input/Action | Expected |
|---|---|---|---|
| 1 | Build A | `4 10 3 5 1 8 7 9 2 6` | Valid Max Heap |
| 2 | Build B | `4 10 3 5 1 8 7 9 2 6` | Valid Max Heap |
| 3 | Insert | Insert 10 into `[4]` | `[10,4]` |
| 4 | Peek | Heap `[10,9,8]` | Returns `10` |
| 5 | Remove | Remove from `[10,9,8]` | Returns `10`, heap remains valid |
| 6 | Increase Priority | Increase a node's priority | Node moves upward if needed |
| 7 | Duplicate | Insert equal priorities | Heap remains valid |
| 8 | Single item | Build `[5]` | `[5]` |
| 9 | Empty Peek | `PEEK_MAX` on empty | Error/exception |
| 10 | Empty Remove | `REMOVE_MAX` on empty | Error/exception |
