package movieListAnswer;

import java.util.ArrayList;
import java.util.Collections;

import movieListQuestion.MovieListException;

public class MovieList {
	
	private final String RATING[][] = {
			{ 
				"No rating",
				"*",
				"**",
				"***",
				"****",
				"*****"
			},
			{ 
				"No rating",
				"Two thumbs down",
				"One thumb down",
				"No comment",
				"One thumb up",
				"Two thumbs up",
			}
	};
	private final int
		RATING_BY_STAR = 0,
		RATING_BY_THUMB = 1;
	

	private ArrayList<String> movies;
	private ArrayList<String> assocRating;
	private int ratingType;
	
	private int getRatingIndex(int rating) {
		if (ratingType == RATING_BY_STAR) {
			return rating;
		} else {
			return rating + 3;
		}
	}

	public MovieList() {
		movies = new ArrayList<String>();
		assocRating = new ArrayList<String>();
		this.ratingType = RATING_BY_STAR;
	}

	public MovieList(int ratingType) {
		movies = new ArrayList<String>();
		assocRating = new ArrayList<String>();
		this.ratingType = ratingType;
	}

	public void addMovie(String movieName) throws MovieListException {
		String strNoRatingForNewMovie = RATING[ratingType][0];
		if (movies.indexOf(movieName) < 0 ) {
			movies.add(movieName);
			assocRating.add(movies.size()-1, strNoRatingForNewMovie);
		} else {
			throw new MovieListException();
		}
	}

	public String getRating(String movieName) throws MovieListException {
		int ratingIndex = movies.indexOf(movieName);
		try {
			return assocRating.get(ratingIndex);
		} catch (Exception e) {
			throw new MovieListException(e.toString());
		}
	}

	public void setRating(String movieName, int newRating) throws MovieListException {
		final int MIN_RATING = 1, MAX_RATING = 5;
		int rating = getRatingIndex(newRating);
		if (rating >= MIN_RATING && rating <= MAX_RATING) {
			try {
				int ratingIndex = movies.indexOf(movieName);
				assocRating.set(ratingIndex, RATING[ratingType][rating]);
			} catch (Exception e) {
				throw new MovieListException();
			}
		} else {
			throw new MovieListException();
		}
	}

	public String getList() {
		ArrayList<String> sortedMovies = new ArrayList<String>(movies);
		String concatenateList = new String();
		Collections.sort(sortedMovies);
		
		for (String movie : sortedMovies) {
			concatenateList += movie + "\n";
		}
		return concatenateList;
	}
	
	public String getOscarList() {
		Mock mock = new Mock();
		ArrayList<String> sortedMovies = new ArrayList<String>(movies);
		String concatenateList = new String();
		Collections.sort(sortedMovies);
		
		for (String movie : sortedMovies) {
			if (mock.getMock().contains(movie)) {
				concatenateList += "Oscar winner: ";
			}
			concatenateList += movie + "\n";
		}
		return concatenateList;
	}

}
