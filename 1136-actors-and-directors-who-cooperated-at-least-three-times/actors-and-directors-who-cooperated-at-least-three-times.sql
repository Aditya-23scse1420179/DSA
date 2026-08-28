# Write your MySQL query statement below
select actor_id,director_id
from (
    select actor_id,director_id,count(timestamp)as coop_count
    from ActorDirector
    group by actor_id,director_id
)as time_table
where coop_count>=3;