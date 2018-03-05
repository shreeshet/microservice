import {SUBMIT_SEARCH,
	SEARCH_FETCHING,
	SEARCH_RECIEVED} from '../actions';

const movies = (state=[],action) => {
	switch (action.type) {
		case 'SEARCH_RECIEVED':
			return action.movies;
		default:
			return state;
	}
}
export default movies;