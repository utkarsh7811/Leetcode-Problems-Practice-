# Write your MySQL query statement below
select email as Email
from (select email,count(email) as num
    from Person
    group by email) as t
where num>1