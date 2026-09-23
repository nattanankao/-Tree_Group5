# 12. Edge Cases

## 1. Empty Heap

`PEEK_MAX` และ `REMOVE_MAX` ต้องไม่คืนค่าปลอม แต่แจ้งว่า Heap ว่างด้วย exception

## 2. มีข้อมูลเพียง 1 ตัว

ไม่ต้องสลับตำแหน่งและยังเป็น Max Heap

## 3. Priority เท่ากัน

Heap ยังถูกต้องเพราะ Parent มี Priority เท่ากับ Child ได้ และใช้ Job ID เป็น tie-breaker เพื่อให้ผล deterministic

## 4. Increase Priority เป็นค่าเดิม

ไม่จำเป็นต้องย้าย Node แต่ยังคงถูกต้อง

## 5. Increase Priority ให้ต่ำลง

Operation นี้ไม่ใช่ Increase จึงถูกปฏิเสธด้วย `IllegalArgumentException`

## 6. Job เป็น null

`INSERT` ปฏิเสธด้วย `IllegalArgumentException`
