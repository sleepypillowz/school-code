SELECT title FROM movies AS m
INNER JOIN stars ON stars.movie_id = m.id
INNER JOIN people ON people.id = stars.person_id
INNER JOIN ratings ON ratings.movie_id = m.id
WHERE people.name = 'Chadwick Boseman'
ORDER BY rating DESC
LIMIT 5;
