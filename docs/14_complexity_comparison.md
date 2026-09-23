# 14. เปรียบเทียบผลกับ Complexity เชิงทฤษฎี

| ประเด็น | Algorithm A | Algorithm B |
|---|---|---|
| วิธีสร้าง | Insert ทีละตัว | Bottom-Up |
| Heapify | Up | Down |
| Build Heap | O(n log n) | O(n) |
| Extra idea | ทำงานตามลำดับข้อมูล | ใช้ Subtree ที่สร้างไว้แล้ว |
| เหมาะกับ | ข้อมูลที่ทยอยเข้ามา | มีข้อมูลทั้งหมดอยู่แล้ว |

เชิงทฤษฎี Algorithm B มีลำดับการเติบโตของเวลาในการ Build Heap ดีกว่า Algorithm A

อย่างไรก็ตามตัวเลขจริงจาก Performance Test ต้องดูจาก `performance_results.csv` ที่ได้จากการรันบนเครื่องจริง ไม่ควรสรุปจากตัวเลขที่สร้างขึ้นเอง
