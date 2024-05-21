SELECT name FROM people
INNER JOIN movies ON movies.id = stars.movie_id
INNER JOIN stars ON stars.person_id = people.id
WHERE movies.year = 2004
ORDER BY people.birth;
