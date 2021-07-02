set names utf8mb4;
set charset utf8mb4;

drop database if exists frida;
create database frida charset utf8mb4;
use frida;

CREATE TABLE snacks (
  id int unsigned NOT NULL AUTO_INCREMENT primary key,
  naam varchar(50) NOT NULL,
  prijs decimal(10,2) NOT NULL
);

INSERT INTO snacks(naam,prijs) VALUES 
('Frikandel',1.50),
('Viandel',2.3),
('Brochette',2.9),
('Boulet',2),
('Lookworst',2.1),
('Kippets',2),
('Kipvingers',3.5),
('Bitterballen',2.5),
('Kippenboutje',3.7),
('Taco',3.5),
('Kipkorn',2.5),
('Zigeunerstick',2.5),
('Visbrochette',3.2),
('Garnaalkroket',4),
('Scampikroket',4),
('Mini loempia',3.5),
('Kaaskroket',2.2),
('Kaasballetjes',2),
('Ragouzi',2.5),
('Mexicano',2.2),
('Loempia',4),
('Vuurvreter',2.5),
('Ribster',2.5),
('Bamischijf ',2.5),
('Lucifer',3);

create user if not exists cursist identified by 'cursist';
grant select,insert,update,delete on snacks to cursist;