-- Inserting multiple borrowers at once
INSERT INTO borrower (name, email)
VALUES
    ('John Doe', 'john.doe@example.com'),
    ('Jane Smith', 'jane.smith@example.com'),
    ('Alice Johnson', 'alice.johnson@example.com'),
    ('Bob Brown', 'bob.brown@example.com'),
    ('Charlie Davis', 'charlie.davis@example.com'),
    ('Diana Miller', 'diana.miller@example.com'),
    ('Edward Wilson', 'edward.wilson@example.com'),
    ('Fiona Green', 'fiona.green@example.com'),
    ('George Hall', 'george.hall@example.com'),
    ('Hannah Scott', 'hannah.scott@example.com');


INSERT INTO book (isbn, title, author, is_borrowed)
VALUES
    ('978-3-16-148410-0', 'Spring Boot in Action', 'Craig Walls', false),
    ('978-0-12-374514-9', 'Effective Java', 'Joshua Bloch', false),
    ('978-1-59327-599-0', 'Clean Code', 'Robert C. Martin', false),
    ('978-1-118-37016-6', 'Head First Design Patterns', 'Eric Freeman', false),
    ('978-0-321-35668-0', 'Refactoring', 'Martin Fowler', false),
    ('978-0-596-51774-8', 'Java Concurrency in Practice', 'Brian Goetz', false),
    ('978-1-4842-2553-7', 'Pro Spring Boot 2', 'Felipe Gutierrez', false),
    ('978-1-61729-254-5', 'Spring Microservices in Action', 'John Carnell', false),
    ('978-1-59327-584-6', 'The Pragmatic Programmer', 'Andrew Hunt', false),
    ('978-1-59327-756-7', 'Grokking Algorithms', 'Aditya Bhargava', false)