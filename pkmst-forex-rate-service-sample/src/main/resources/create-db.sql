CREATE table forex (
    ticker   VARCHAR(6) PRIMARY KEY,
    opening_price DECIMAL,
    closing_price DECIMAL,
    high_price DECIMAL,
    low_price DECIMAL,            
  );