drop table if exists `soft_drinks` CASCADE;
CREATE table soft_drinks (
id BIGINT AUTO_INCREMENT, 
calories INTEGER NOT NULL, 
millilitres_of_drink INTEGER NOT NULL, 
name VARCHAR(255) NOT NULL, 
owned_by VARCHAR(255), 
uk_price double, 
primary key (id)
);