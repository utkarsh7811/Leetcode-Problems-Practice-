# Write your MySQL query statement below
Select today.id
From Weather as today
Cross Join Weather as yesterday
Where DATEDIFF(today.recordDate, yesterday.recordDate) = 1
  And today.temperature > yesterday.temperature;