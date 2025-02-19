CREATE TABLE IF NOT EXISTS "ninja" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(20) UNIQUE NOT NULL,        
    skill1 VARCHAR(255) NOT NULL,                
    skill2 VARCHAR(255) NOT NULL,                
    skill3 VARCHAR(255) NOT NULL,                
    skill4 VARCHAR(255) NOT NULL,
    version INT     
);

CREATE TABLE IF NOT EXISTS "user" (   
    id SERIAL PRIMARY KEY,
    username varchar(20) UNIQUE NOT NULL,
    password varchar(255) NOT NULL,
    version INT
);