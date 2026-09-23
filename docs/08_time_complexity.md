# 8. Time Complexity

| Operation | Complexity |
|---|---:|
| INSERT | O(log n) |
| PEEK_MAX | O(1) |
| REMOVE_MAX | O(log n) |
| INCREASE_PRIORITY | O(log n) |
| Build Heap A | O(n log n) |
| Build Heap B | O(n) |
| DISPLAY_HEAP | O(n) |

## ทำไม Algorithm A เป็น O(n log n)

มีการ Insert n ครั้ง และแต่ละ Insert อาจเดินขึ้นสูงสุดถึงความสูงของ Tree ซึ่งคือ `O(log n)`

ดังนั้น

`n * O(log n) = O(n log n)`

## ทำไม Algorithm B เป็น O(n)

แม้จะเรียก Heapify หลายครั้ง แต่ Node ส่วนใหญ่ไม่ได้อยู่ใกล้ Leaf และจึงเดินลงได้เพียงระยะสั้น ๆ

จำนวน Node ที่อยู่ที่ความสูง h ลดลงประมาณ `n / 2^(h+1)` ดังนั้นผลรวมงานเป็น

`sum(n / 2^(h+1) * h)`

ซึ่งมีค่ารวมเป็น `O(n)`

ดังนั้น Bottom-Up Build Heap เป็น `O(n)` ไม่ใช่ `O(n log n)`
