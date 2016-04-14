package movieListQuestion;


import org.junit.Test;

import movieListAnswer.MovieList;

import org.junit.Before;
import static org.junit.Assert.*;


/* The following tests are for the basic functionality of
 * the movie list class
 * 
 * You should uncomment them one at a time and follow the
 * "red, green, refactor" strategy to get each one working
 * 
 * NB: You will not be able to run this file as a JUnit test
 * until you have uncommented Test 1, because Eclipse won't
 * recognise MovieListTest as a JUnit "runner" until it
 * contains at least one "@Test" method
 */

public class MovieListTest2 {

	/* Test 0: Declaring MovieList objects
	 */
	MovieList movies;
	

	/* Test 1: Constructing a MovieList object
	 */
	@Before @Test public void setUpMovieList() {
		movies = new MovieList();
	}
	
	/* Test 2: Adding a new movie to the list
	 */
	@Test public void addAMovie() throws MovieListException {
		movies.addMovie("Star Wars");
		assertEquals("Adding movie failed",
				"No rating", movies.getRating("Star Wars"));
	}
	
	/* Test 3: Associating a rating with a movie
	 */
	@Test public void addARating() throws MovieListException {
		movies.addMovie("Goldfinger");
		movies.setRating("Goldfinger", 4);
		assertEquals("Couldn't add a rating",
				"****", movies.getRating("Goldfinger"));
	}
	
	/* Test 4: Getting a printable list of movies
	 */
	@Test public void listAlphabetically() throws MovieListException {
		String orderedListing =
				"Casablanca\n" +
				"Maltese Bippy, The\n" +
				"Star Wars\n";
		movies.addMovie("Star Wars");
		movies.addMovie("Casablanca");
		movies.addMovie("Maltese Bippy, The");
		assertEquals("Listing not alphabetical",
				orderedListing, movies.getList());
	}
	
	/* Test 5: Can't get a rating for an unrated movie
	 */
	@Test(expected = MovieListException.class)
	public void nonexistentRating() throws MovieListException {
		movies.getRating("The Ghost in the Invisible Bikini");
	}
	
	/* Test 6: Can't add the same movie twice
	 */
	@Test(expected = MovieListException.class)
	public void duplicateMovie() throws MovieListException {
		movies.addMovie("Earth Versus the Flying Saucers");
		movies.addMovie("Earth Versus the Flying Saucers");
	}
	
	/* Test 7: Even a bomb gets a single star
	 */
	@Test(expected = MovieListException.class)
	public void ratingTooLow() throws MovieListException {
		movies.addMovie("Plan Nine From Outer Space");
		movies.setRating("Plan Nine From Outer Space", 0);
	}
	
	/* Test 8: No movie gets more than five stars
	 */
	@Test(expected = MovieListException.class)
	public void ratingTooHigh() throws MovieListException {
		movies.addMovie("Citizen Kane");
		movies.setRating("Citizen Kane", 6);
	}
	
	/* Test 9: Can't rate an unknown movie
	 */
	@Test(expected = MovieListException.class)
	public void ratingUnknownMovie() throws MovieListException {
		movies.setRating("Them!", 4);
	}
	
}