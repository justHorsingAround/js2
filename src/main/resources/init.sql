
DROP TABLE IF EXISTS poems;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    email TEXT UNIQUE NOT NULL,
    nickname TEXT NOT NULL,
    password TEXT NOT NULL,
	CONSTRAINT email_not_empty CHECK (email <> ''),
	CONSTRAINT password_not_empty CHECK (password <> ''),
	CONSTRAINT nickname_not_empty CHECK (nickname <> '')
);

CREATE TABLE poems (
    id SERIAL PRIMARY KEY,
    poet_id INTEGER,
    title TEXT NOT NULL,
    poem TEXT,
    release_date DATE NOT NULL,
    FOREIGN KEY (poet_id) REFERENCES users(id),
    CONSTRAINT title_not_empty CHECK (title <> '')
);

INSERT INTO users (email, nickname, password) VALUES
	('poe', 'poe', 'poe'),
	('a', 'a', 'a'),
	('b', 'b', 'b');

INSERT INTO poems (poet_id, title, poem, release_date) VALUES
    (1, 'The Bells', 'The bells! — ah, the bells!\n How fairy-like a melody there floats\n From their throats. — \n From their merry little throats — \n From the silver, tinkling throats\n Of the bells, bells, bells —\n Of the bells!\n', '1845-01-29'),
    (1, 'Random', 'If T is a complete enumeration type, provides a member typedef type that names the underlying type of T. Otherwise, the behavior is undefined.', '2008-03-04'),
    (2, 'The End', 'The noexcept operator performs a compile-time check that returns true if an expression is declared to not throw any exceptions.', '2011-12-20');

