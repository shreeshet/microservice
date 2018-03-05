import { combineReducers } from 'redux';
import movies from './movies';
import {searchText,selectedMovie} from './searchText';
import showHideInventory from './showMovieInventory';
import loginUser from './loginUser';

const rootReducer = combineReducers({
	loggedInUser:loginUser,
	searchText:searchText,
	movies:movies,
	selectedMovie:selectedMovie,
	selectedMovieInventory:showHideInventory
})

export default rootReducer;