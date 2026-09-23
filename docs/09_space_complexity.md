# 9. Space Complexity

## Algorithm A

ถ้าสร้าง Heap ใหม่จาก Array จะใช้พื้นที่สำหรับ Heap `O(n)`

ตัว Algorithm เองใช้ตัวแปรเพิ่มเติมคงที่ จึงมี auxiliary space ประมาณ `O(1)` หากไม่รวมพื้นที่เก็บผลลัพธ์

## Algorithm B

ถ้าทำ In-place บน Array สามารถใช้ auxiliary space `O(1)`

ในโปรแกรมนี้ใช้ `List<Integer>` เป็น Heap จึงมีพื้นที่เก็บข้อมูล `O(n)` และสร้าง List ใหม่เพื่อความปลอดภัยของ API ในบาง method

## Job Object

แต่ละ Job เก็บข้อมูลคงที่ 5 fields ดังนั้น Job n ตัวใช้พื้นที่รวม `O(n)`
