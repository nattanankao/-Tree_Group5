# 4. Algorithm A และ Algorithm B

## Algorithm A: Incremental Heap Construction

นำข้อมูลเข้าทีละตัว

1. เพิ่มค่าที่ท้าย Array
2. ตรวจสอบกับ Parent
3. ถ้าค่าของลูกมากกว่า Parent ให้สลับ
4. ทำต่อจนถึง Root หรือ Parent ถูกต้อง

ใช้ `heapifyUp`

Complexity รวม: `O(n log n)`

## Algorithm B: Bottom-Up Heap Construction

1. ใส่ข้อมูลทั้งหมดลง Array โดยยังไม่ต้อง Heapify
2. เริ่มจากโหนดสุดท้ายที่มีลูก
3. ทำ `heapifyDown`
4. ทำย้อนกลับไปจนถึง Root

Complexity รวม: `O(n)`

## Operations ของ MaxHeap

- INSERT: `O(log n)`
- PEEK_MAX: `O(1)`
- REMOVE_MAX: `O(log n)`
- INCREASE_PRIORITY: `O(log n)` เมื่อเพิ่ม Priority
- BUILD_HEAP แบบ Bottom-Up: `O(n)`
- DISPLAY_HEAP: `O(n)`
