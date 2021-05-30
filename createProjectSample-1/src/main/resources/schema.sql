DROP TABLE IF EXISTS accounts;
 
CREATE TABLE accounts (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  email VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL
);
 
INSERT INTO accounts (email, name) VALUES
  ('email1@email.com', 'Elise'),
  ('email2@email.com', 'John'),
  ('email3@email.com', 'Mike;s);
  
 -- 입양 시각 구하기 2
 WITH RECURSIVE TIME 
 AS( SELECT 0 AS H UNION ALL
 	SELECT H+1 FROM TIME WHERE H < 23
 )
 SELECT H, COUNT(HOUR(DATETIME)) AS COUNT
 FROM TIME LEFT	OUTER JOIN ANIMAL_OUTS
 ON H=HOUR(DATETIME)
 GROUP BY H;