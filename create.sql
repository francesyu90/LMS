CREATE TABLE library (
    id	INT	NOT NULL,  
    name  VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)                 
);

CREATE TABLE book (
    id      INT NOT NULL,  
    title  VARCHAR(255)     NOT NULL,
    author   VARCHAR(255)     NOT NULL,
    library_id  INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (library_id) REFERENCES library (id) ON DELETE CASCADE                    
);