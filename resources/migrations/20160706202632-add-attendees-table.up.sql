CREATE TYPE language AS ENUM ('en', 'de', 'en/de');
CREATE TYPE status AS ENUM ('waitinglist', 'accepted', 'timedout', 'declined');

CREATE TABLE attendees
(id SERIAL PRIMARY KEY,
 first_name VARCHAR(50),
 last_name VARCHAR(50),
 email VARCHAR(50),
 gender VARCHAR(50),
 language language,
 food_requirements TEXT,
 assistance_required TEXT,
 anything_else TEXT,
 programming_experience TEXT,
 how_did_you_hear_about_cb TEXT,
 pictures_ok BOOLEAN,
 eighteen_or_older BOOLEAN,
 taken_part_before BOOLEAN,
 clojure_experience BOOLEAN,
 status status DEFAULT 'waitinglist',
 created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
 updated_at TIMESTAMP);
