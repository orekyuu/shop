select products.id as product_id,
       name,
       description,
       circle_id,
       release_date,
       wholesale_price,
       registered_at,
       created_at,
       product_images.id as image_id
from products
         left join product_images on products.id = product_images.product_id
where circle_id in /*ids*/(1)