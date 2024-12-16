CREATE TABLE IF NOT EXISTS Ninja (
    id SERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,        
    skill1 VARCHAR(255) NOT NULL,                
    skill2 VARCHAR(255) NOT NULL,                
    skill3 VARCHAR(255) NOT NULL,                
    skill4 VARCHAR(255) NOT NULL,
    version INT     
);