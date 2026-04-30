# Write your MySQL query statement below
select id ,count(*)as num
from(
    select requester_id as id ,accepter_id as friend 
    from RequestAccepted
    union all
    select accepter_id as id ,requester_id as friend
    from RequestAccepted
)as all_ids
group by id
order by num desc
limit 1
