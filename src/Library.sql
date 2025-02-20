	CREATE DATABASE IF NOT EXISTS library;
    USE library;
    
    CREATE TABLE books (
		id INT AUTO_INCREMENT PRIMARY KEY,
        title VARCHAR(255) NOT NULL,
        author VARCHAR(255) NOT NULL,
        available BOOLEAN DEFAULT TRUE
	);
    
    CREATE TABLE loans (
		id INT AUTO_INCREMENT PRIMARY KEY,
        user_name VARCHAR(255) NOT NULL,
        book_id INT,
        loan_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        return_date TIMESTAMP NULL,
        FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE
	);
    
    INSERT INTO books (title, author) VALUES
    ('Harry Potter and the Philosophers Stone', 'J.K. Rowling'),
	('The Hobbit', 'J.R.R. Tolkien'),
	('Alices Adventures in Wonderland', 'Lewis Carroll');