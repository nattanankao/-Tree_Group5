# 3. โครงสร้าง Tree

Binary Heap เป็น Complete Binary Tree และเก็บใน Array

สำหรับ Array

`[10, 9, 8, 5, 6, 3, 7, 4, 2, 1]`

สามารถมองเป็น Tree ได้ดังนี้

```text
              10
           /      \
          9        8
        /   \    /   \
       5     6  3     7
      / \
     4   2
    /
   1
```

เงื่อนไข Max Heap คือทุก Parent ต้องมีค่ามากกว่าหรือเท่ากับ Children

ใน Array:
- parent(i) = `(i - 1) / 2`
- left(i) = `2i + 1`
- right(i) = `2i + 2`
