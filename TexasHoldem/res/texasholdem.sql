DROP SEQUENCE hand_seq;
DROP SEQUENCE player_in_game_seq;
DROP SEQUENCE cards_in_game_seq;
DROP SEQUENCE game_seq;
DROP SEQUENCE poker_user_seq;
DROP TABLE hand;
DROP TABLE player_in_game;
DROP TABLE cards_in_game;
DROP TABLE game;
DROP TABLE poker_user;

CREATE SEQUENCE poker_user_seq;
CREATE TABLE poker_user (
    poker_user_id INT NOT NULL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    password VARCHAR(100) NOT NULL,
    credits INT NOT NULL,
    is_deleted NUMBER(1),
    CONSTRAINT poker_user_ck CHECK (is_deleted IN (0, 1))
);

CREATE SEQUENCE game_seq;
CREATE TABLE game (
	game_id INT NOT NULL PRIMARY KEY,
	date_of_game DATE NOT NULL,
	pot INT NOT NULL
);

CREATE SEQUENCE cards_in_game_seq;
CREATE TABLE cards_in_game (
    cards_id INT NOT NULL PRIMARY KEY,
    game_id INT NOT NULL,
    flop1 NVARCHAR2(3),
    flop2 NVARCHAR2(3),
    flop3 NVARCHAR2(3),
    turn NVARCHAR2(3),
    river NVARCHAR2(3),
    CONSTRAINT cards_in_game_fk FOREIGN KEY (game_id) REFERENCES game(game_id)
);

CREATE SEQUENCE player_in_game_seq;
CREATE TABLE player_in_game (
	best_combination NVARCHAR2 (30),
    poker_user_id INT NOT NULL,
    game_id INT NOT NULL,
    CONSTRAINT player_in_game_fk1 FOREIGN KEY (poker_user_id) REFERENCES poker_user(poker_user_id),
    CONSTRAINT player_in_game_fk2 FOREIGN KEY (game_id) REFERENCES game(game_id),
	CONSTRAINT player_in_game_pk PRIMARY KEY (game_id, poker_user_id)
);

CREATE SEQUENCE hand_seq;
CREATE TABLE hand (
    hand_id INT NOT NULL PRIMARY KEY,
    poker_user_id INT NOT NULL,
    game_id INT NOT NULL,
    card1 NVARCHAR2(3),
    card2 NVARCHAR2(3),
    is_won NUMBER(1),
    CONSTRAINT hand_ck CHECK (is_won IN (0, 1)),
    CONSTRAINT hand_fk1 FOREIGN KEY (poker_user_id) REFERENCES poker_user(poker_user_id),
    CONSTRAINT hand_fk2 FOREIGN KEY (game_id) REFERENCES game(game_id)
);

