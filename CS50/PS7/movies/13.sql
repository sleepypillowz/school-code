SELECT DISTINCT people.name FROM people
INNER JOIN stars ON stars.person_id = people.id
INNER JOIN movies ON movies.id = stars.movie_id
WHERE movies.id IN (
    SELECT movie_id FROM stars
    INNER JOIN people ON stars.person_id = people.id
    WHERE people.name = 'Kevin Bacon'
)
AND people.name != 'Kevin Bacon';
