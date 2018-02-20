CREATE table stock (
    ticker   VARCHAR(5) PRIMARY KEY,
    exchange VARCHAR(10),
    name VARCHAR(50),
    description VARCHAR(4000),        
    opening_price DECIMAL,
    closing_price DECIMAL,
    high_price DECIMAL,
    low_price DECIMAL,            
  );