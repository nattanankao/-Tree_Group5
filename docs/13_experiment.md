# 13. การทดลอง

ทดสอบ

```text
n = 1,000
n = 10,000
n = 100,000
n = 500,000
```

แต่ละขนาดจะสร้างข้อมูลสุ่มด้วย Seed ที่กำหนด เพื่อให้สามารถทำซ้ำได้

วัด:

1. Build Heap ของ Algorithm A
2. Build Heap ของ Algorithm B
3. Remove Max 1,000 ครั้งจาก Heap ที่สร้างด้วย A
4. Remove Max 1,000 ครั้งจาก Heap ที่สร้างด้วย B

ใช้ `System.nanoTime()`

เพื่อให้ผลมีเสถียรภาพ โปรแกรม warm-up JVM 3 รอบ และวัดจริง 5 รอบ จากนั้นใช้ค่าเฉลี่ย

## Output

โปรแกรมสร้าง

`performance_results.csv`

รูปแบบ:

```text
n,algorithm,build_avg_ns,remove_max_1000_avg_ns
```

## ข้อควรระวัง

เวลาจริงขึ้นกับ CPU, JVM, RAM, OS และโปรแกรมอื่น ดังนั้นรายงานควรใช้ค่าที่ได้จากเครื่องของผู้ทำงานจริง
