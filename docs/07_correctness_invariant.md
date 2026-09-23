# 7. Correctness / Invariant

## Algorithm A

Invariant หลังจาก Insert แต่ละตัวเสร็จ:

> Subtree ที่เกิดขึ้นจากข้อมูลที่ใส่ไปแล้วเป็น Max Heap

เมื่อเพิ่ม Node ใหม่ Node นี้อยู่ที่ตำแหน่ง Leaf จึงอาจผิดเงื่อนไขเฉพาะเส้นทางจาก Node ไป Root เท่านั้น `heapifyUp` จะสลับขึ้นจน Parent มีค่ามากกว่าหรือเท่ากับลูก ทำให้ Heap กลับมาถูกต้อง

## Algorithm B

ก่อน `heapifyDown(i)`:

> Subtree ของลูกทั้งสองข้างของ i เป็น Max Heap อยู่แล้ว

`heapifyDown` เลือกค่าที่มากที่สุดระหว่าง Node และ Children แล้วนำค่ามากที่สุดขึ้นด้านบน จากนั้นปัญหาจะถูกส่งต่อไปยัง Subtree เดียว จน Heap Property ถูกต้อง

เมื่อทำจาก Last Internal Node ย้อนถึง Root ทุก Subtree จะถูกต้อง ดังนั้น Array สุดท้ายเป็น Max Heap

## Invariant ของ MaxHeap

ทุก Node ต้องมี

`Priority(parent) >= Priority(child)`

สำหรับทั้ง Left Child และ Right Child ที่มีอยู่
