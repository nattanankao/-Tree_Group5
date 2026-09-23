# 1. วิเคราะห์ปัญหา

## Problem

Server ต้องจัดการ Job หลายงานที่มี Priority แตกต่างกัน โดย Priority มากหมายถึงงานเร่งด่วนกว่า จึงต้องการโครงสร้างข้อมูลที่สามารถเข้าถึง Job ที่ Priority สูงสุดได้อย่างรวดเร็ว

## Input

Job ประกอบด้วย

- Job ID
- Job Name
- Priority
- Arrival Time
- Estimated Time

สำหรับส่วนทดลอง Heap ใช้ข้อมูล

`4 10 3 5 1 8 7 9 2 6`

## Output

- Max Heap ที่ถูกต้อง
- Job ที่ Priority สูงสุด
- Job ที่ถูก Remove
- Heap หลัง Increase Priority
- Array หลังแต่ละขั้นตอนของการสร้าง Heap
- เวลาในการ Build Heap และ Remove Max

## Constraint / Assumption

1. Priority มากกว่าถือว่าเร่งด่วนกว่า
2. ใช้ Max Heap
3. Heap เก็บใน Array/List
4. Index ของ Parent คือ `(i-1)/2`
5. Left Child คือ `2i+1`
6. Right Child คือ `2i+2`
7. Priority เป็นจำนวนเต็มไม่ติดลบ
8. Estimated Time เป็นจำนวนเต็มไม่ติดลบ
