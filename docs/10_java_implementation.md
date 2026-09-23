# 10. Java Implementation

## ไฟล์หลัก

- `Job.java` — model ของ Job
- `MaxHeap.java` — Max Heap สำหรับ Job และ Operations
- `HeapAlgorithmA.java` — Algorithm A
- `HeapAlgorithmB.java` — Algorithm B
- `HeapBuilder.java` — utility สำหรับ trace ของ integer heap
- `Main.java` — ตัวอย่างการทำงาน
- `PerformanceExperiment.java` — การทดลอง Performance

## การออกแบบ

`Main` ทำหน้าที่แสดงตัวอย่างเท่านั้น ส่วน Algorithm และ Data Structure แยกออกเป็น class เพื่อให้ง่ายต่อการทดสอบและวิเคราะห์

`MaxHeap` มี validation เช่น ห้าม Priority ติดลบ และห้ามเพิ่ม Priority ให้ต่ำกว่าค่าเดิม

## การตรวจสอบ Max Heap

เมธอด `isValidMaxHeap()` ตรวจทุก Parent กับ Children และคืน `true` เมื่อ Heap Property ถูกต้อง
