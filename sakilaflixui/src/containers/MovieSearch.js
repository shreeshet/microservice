import { connect } from 'react-redux'
import MoviesList from '../components/MoviesList'

const filterMovies = (movies, searchText) => {
  // if(searchText && searchText !== ''){
  // 	return movies.filter((movieRec) => {
  //   	let currTitle = movieRec.title.toUpperCase();
  //   	return currTitle.indexOf(searchText.toUpperCase()) != -1;
  // 	});	
  // }else{
  	return movies;
  // }
  
}

const mapStateToProps = (state) => ({
	movies: filterMovies(state.movies, state.searchText)
})

const MovieSearch = connect(
  mapStateToProps
)(MoviesList)

export default MovieSearch