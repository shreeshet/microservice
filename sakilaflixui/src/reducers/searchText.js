import {SUBMIT_SEARCH,
	SEARCH_FETCHING,
	SEARCH_RECIEVED,
	MOVIE_SELECTED} from '../actions';
	
const searchText = (state='',action) => {
	switch (action.type) {
		case SEARCH_FETCHING:
			return state;
		default:
			return state;		
	}
}

const selectedMovie = (state='',action) => {
	switch (action.type) {
		case MOVIE_SELECTED:
			return action.data;
		default:
			return state;		
	}
}
export {searchText,selectedMovie};