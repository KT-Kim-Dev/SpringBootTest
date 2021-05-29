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