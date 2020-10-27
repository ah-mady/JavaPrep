/* Exercise 1 
Find the titles of all movies directed by Steven Spielberg.
*/

SELECT title FROM movie WHERE director LIKE '%Spielberg%';

/* Exercise 2 
Find all years that have a movie that received a rating of 4 or 5, and sort them in increasing order.
*/
SELECT DISTINCT year
FROM movies.rating
INNER JOIN movies.movie
	ON movies.rating.mID = movies.movie.mID
WHERE stars >= 4
ORDER BY year ASC;

/* Exercise 3
Find the titles of all movies that have no ratings.
*/

SELECT title
FROM movies.movie
LEFT JOIN movies.rating
	ON movies.rating.mID = movies.movie.mID
WHERE rID IS NULL;

/* Exercise 4
Some reviewers didn’t provide a date with their rating. Find the names of all reviewers who have ratings with a NULL value for the date.
*/
SELECT name
FROM movies.reviewer
LEFT JOIN movies.rating
	ON movies.rating.rID = movies.reviewer.rID
WHERE ratingDate IS NULL;

/* Exercise 5
Write a query to return the ratings data in a more readable format: reviewer name, movie title, stars, and ratingDate. Also, sort the data, first by reviewer name, then by movie title, and lastly by number of stars.
*/

SELECT name, title, stars, ratingDate
FROM movie
INNER JOIN rating
	ON movie.mID = rating.mID
INNER JOIN reviewer
	ON reviewer.rID = rating.rID
ORDER BY reviewer.name ASC,
movie.title ASC,
rating.stars ASC;

/* Exercise 6
For all cases where the same reviewer rated the same movie twice and gave it a higher rating the second time, return the reviewer’s name and the title of the movie.
*/

SELECT name, title
FROM movie
INNER JOIN rating   
	ON movie.mID = rating.mID 
INNER JOIN reviewer  
	ON reviewer.rID = rating.rID
INNER JOIN rating AS secondRating 
	ON movie.mID = secondRating.mID AND
	reviewer.rID = secondRating.rID
WHERE secondRating.stars > rating.stars
	AND secondRating.ratingDate > rating.ratingDate;


/* Exercise 7
For each movie that has at least one rating, find the highest number of stars that movie received. Return the movie title and number of stars. Sort by movie title.
*/

SELECT title, MAX(stars)
FROM movie
INNER JOIN rating
    ON movie.mID = rating.mID
GROUP BY movie.title
ORDER BY title;


/* Exercise 8
For each movie, return the title and the ‘rating spread’, that is, the difference between highest and lowest ratings given to that movie. Sort by rating spread from highest to lowest, then by movie title.
*/

SELECT title, MAX(stars) - MIN(stars) as rating_spread
FROM movie
INNER JOIN rating
    ON movie.mID = rating.mID
GROUP BY movie.title
ORDER BY rating_spread DESC,
	title ASC;

/* execise 9
NOT MY SOLUTION
*/

SELECT AVG (eachAVG) 
FROM 
	(SELECT title, AVG (stars) as eachAVG
	FROM movie
	INNER JOIN rating
		ON movie.mID = rating.mID
		where year > 1980 
	GROUP BY movie.title) AS grandAVG ;
    
    SELECT AVG (eachAVG) 
FROM 
	(SELECT title, AVG (stars) as eachAVG
	FROM movie
	INNER JOIN rating
		ON movie.mID = rating.mID
		where year < 1980 
	GROUP BY movie.title) AS grandAVG ;
    
SELECT ((SELECT AVG (eachAVG) 
	FROM 
		(SELECT title, AVG (stars) as eachAVG
		FROM movie
		INNER JOIN rating
			ON movie.mID = rating.mID
			where year < 1980 
		GROUP BY movie.title) AS grandAVG)
        
		-
        
		(SELECT AVG (eachAVG) 
	FROM 
		(SELECT title, AVG (stars) as eachAVG
		FROM movie
		INNER JOIN rating
			ON movie.mID = rating.mID
			where year > 1980 
		GROUP BY movie.title) AS grandAVG)) AS result ;