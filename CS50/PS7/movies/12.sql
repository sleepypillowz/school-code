SELECT title FROM movies AS m
WHERE m.id IN (
    SELECT movie_id FROM stars
    WHERE person_id IN (
        SELECT id FROM people
        WHERE name = 'Bradley Cooper'
    )
)
AND m.id IN (
    SELECT movie_id FROM stars
    WHERE person_id IN (
        SELECT id FROM people
        WHERE name = 'Jennifer Lawrence'
    )
);
