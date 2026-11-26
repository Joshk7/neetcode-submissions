-- Write your query below
select sp.name
from sales_person sp
left join orders o
    on sp.sales_id = o.sales_id
left join company c
    on o.com_id = c.com_id
    and c.name = 'CRIMSON'
group by
    sp.sales_id,
    sp.name
having
    count(c.com_id) = 0;