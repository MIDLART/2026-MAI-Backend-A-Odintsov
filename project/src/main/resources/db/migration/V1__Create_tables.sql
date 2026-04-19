CREATE TABLE users (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL
);

CREATE TABLE books (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title TEXT NOT NULL UNIQUE
);

CREATE TABLE book_details (
     book_id BIGINT PRIMARY KEY,
     isbn VARCHAR(13) UNIQUE,
     publish_year INTEGER,
     page_count INTEGER,
     language TEXT,
     description TEXT,

     FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE
);

CREATE TABLE authors (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE author_books (
    author_id BIGINT,
    book_id BIGINT,

    PRIMARY KEY (author_id, book_id),
    FOREIGN KEY (author_id) REFERENCES authors(id) ON DELETE CASCADE,
    FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE
);

CREATE TABLE favorite_books (
    user_id BIGINT,
    book_id BIGINT,

    PRIMARY KEY (user_id, book_id),
    FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE INDEX idx_author_books_author_id ON author_books(author_id);
CREATE INDEX idx_author_books_book_id ON author_books(book_id);

CREATE INDEX idx_favorite_books_user_id ON favorite_books(user_id);
CREATE INDEX idx_favorite_books_book_id ON favorite_books(book_id);

CREATE INDEX idx_book_details_isbn ON book_details(isbn);
