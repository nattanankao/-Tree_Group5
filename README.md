# Binary Heap: Heap Construction Two Methods

## รายละเอียดโครงงาน

โครงงานนี้แก้ปัญหา Server ที่ต้องจัดลำดับ Job ตาม Priority โดย Priority ที่มากกว่าจะถูกประมวลผลก่อน จึงใช้ **Max Binary Heap** ซึ่งเป็น Complete Binary Tree ที่มีเงื่อนไขว่า Parent มีค่า Priority มากกว่าหรือเท่ากับ Children

โครงงานเปรียบเทียบการสร้าง Heap 2 วิธี

- **Algorithm A: Incremental Build Heap** — เพิ่มข้อมูลทีละตัวและใช้ `heapifyUp`
- **Algorithm B: Bottom-Up Build Heap** — ใส่ข้อมูลทั้งหมดลง Array ก่อน แล้วใช้ `heapifyDown` จากโหนดสุดท้ายที่มีลูกขึ้นมาถึง Root

## โครงสร้างไฟล์

```text
heap-algorithm-group5/
├─ src/heapalgorithmgroup5/
│  ├─ Job.java
│  ├─ MaxHeap.java
│  ├─ HeapBuilder.java
│  ├─ HeapAlgorithmA.java
│  ├─ HeapAlgorithmB.java
│  ├─ Main.java
│  └─ PerformanceExperiment.java
├─ docs/
│  ├─ 01_problem_analysis.md
│  ├─ 02_node_design.md
│  ├─ 03_tree_structure.md
│  ├─ 04_algorithms.md
│  ├─ 05_pseudocode.md
│  ├─ 06_step_by_step.md
│  ├─ 07_correctness_invariant.md
│  ├─ 08_time_complexity.md
│  ├─ 09_space_complexity.md
│  ├─ 10_java_implementation.md
│  ├─ 11_test_cases.md
│  ├─ 12_edge_cases.md
│  ├─ 13_experiment.md
│  ├─ 14_complexity_comparison.md
│  └─ 15_conclusion.md
├─ data/
│  └─ sample_input.txt
└─ scripts/
   ├─ compile.bat
   └─ run.bat
```

## วิธี Compile

ต้องมี JDK 17 ขึ้นไป

### Windows

```bat
scripts\compile.bat
```

## วิธี Run โปรแกรมหลัก

```bat
scripts\run.bat
```

หรือ

```bash
java -cp out heapalgorithmgroup5.Main
```

## วิธีรันทดลอง Performance

Compile ก่อน แล้วใช้

```bash
java -cp out heapalgorithmgroup5.PerformanceExperiment
```

โปรแกรมจะสร้างไฟล์

```text
performance_results.csv
```

โดยทดสอบ n = 1,000, 10,000, 100,000 และ 500,000 และวัดเวลา Build Heap รวมถึง Remove Max 1,000 ครั้ง

> หมายเหตุ: เวลาที่ได้จากการทดลองขึ้นกับ CPU, JVM, RAM, ระบบปฏิบัติการ และโปรแกรมอื่นที่กำลังทำงาน จึงไม่ควรใส่ตัวเลขเวลาตายตัวเป็นผลการทดลองโดยไม่รันจริง

## ข้อมูลตัวอย่างที่โจทย์กำหนด

```text
4 10 3 5 1 8 7 9 2 6
```

ผลสุดท้ายของทั้งสองวิธีควรเป็น Max Heap เดียวกัน:

```text
[10, 9, 8, 5, 6, 3, 7, 4, 2, 1]
```

## Job Operations

`MaxHeap` รองรับ:

- `INSERT`
- `PEEK_MAX`
- `REMOVE_MAX`
- `INCREASE_PRIORITY`
- `BUILD_HEAP`
- `DISPLAY_HEAP`

การเปรียบเทียบ Heap ใช้ Priority ก่อน และใช้ Job ID เป็นตัวเปรียบเทียบเมื่อ Priority เท่ากัน เพื่อให้ผลการทำงาน deterministic

## การตรวจสอบโค้ด

โปรเจกต์นี้ถูกออกแบบให้แยกหน้าที่ของแต่ละคลาสชัดเจน และมีการ compile ด้วย `javac` หลังสร้างไฟล์ หาก compile ผ่านจึงถือว่าโค้ดไม่มี syntax/type error ในชุดไฟล์นี้ ส่วนผล Performance ต้องรันบนเครื่องจริงเพื่อเก็บตัวเลข
