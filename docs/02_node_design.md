# 2. กำหนดข้อมูลที่เก็บใน Node

ในกรณี Job Heap แต่ละ Node แทนด้วย object `Job`

| Field | ความหมาย |
|---|---|
| jobId | รหัส Job |
| jobName | ชื่องาน |
| priority | ระดับความเร่งด่วน |
| arrivalTime | เวลาที่ Job เข้ามา |
| estimatedTime | เวลาที่คาดว่าจะใช้ |

การเปรียบเทียบหลักใช้ `priority` และเมื่อ Priority เท่ากันใช้ `jobId` เพื่อให้ผล deterministic

คลาสที่เกี่ยวข้องคือ `Job.java`
