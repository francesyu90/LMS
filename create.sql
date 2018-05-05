DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS library;

CREATE TABLE library (
    id	INT	NOT NULL AUTO_INCREMENT,  
    name  VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)                 
);

CREATE TABLE book (
    id      INT NOT NULL AUTO_INCREMENT,  
    title  VARCHAR(255)     NOT NULL,
    author   VARCHAR(255)     NOT NULL,
    library_id  INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (library_id) REFERENCES library (id) ON DELETE CASCADE                    
);