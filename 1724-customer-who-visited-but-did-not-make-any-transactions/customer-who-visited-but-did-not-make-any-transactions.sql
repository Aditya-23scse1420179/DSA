# Write your MySQL query statement below
SELECT v.customer_id,Count(*) AS count_no_trans
FROM Visits as v
LEFT JOIN Transactions t
ON v.visit_id = t.visit_id
Where t.transaction_id IS NULL
Group BY v.customer_id;
