-- Write your query below
SELECT
    employee_id,
    CASE
        WHEN name NOT LIKE 'M%' AND employee_id % 2 = 1 THEN salary
        ELSE 0
    END AS bonus
FROM employees
ORDER BY employee_id;