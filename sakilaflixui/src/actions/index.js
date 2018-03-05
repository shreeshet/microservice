import dataServices from '../services/DataServices';

export const SUBMIT_SEARCH = 'SUBMIT_SEARCH';
export const SEARCH_FETCHING = 'SEARCH_FETCHING';
export const SEARCH_RECIEVED = 'SEARCH_RECIEVED';
export const SHOW_INVENTORY = 'SHOW_INVENTORY';
export const HIDE_INVENTORY = 'HIDE_INVENTORY';
export const MOVIE_SELECTED = 'MOVIE_SELECTED';
export const LOGIN_USER = 'LOGIN_USER';



export function searchFetching(searchText){
	return {
		type:'SEARCH_FETCHING',
		searchText
	}
}

export function searchRecieved(searchResults){
	return {
		type:'SEARCH_RECIEVED',
		movies:searchResults
	}
}

export function showHideInventory(movieId){
	return function(dispatch){
		if(movieId){
			dataServices.getMovieInventory(movieId)
			.then(
				(res)=> res.json(),
				(err)=> console.log(err)
			).then(
				json => dispatch({
					type: SHOW_INVENTORY,
					data: json
				})
			);
		}else{
			dispatch({
				type: HIDE_INVENTORY,
				data: []
			})
		}
	}
}


export function submitSearch(searchText){
	return function(dispatch){
		dispatch(searchFetching(searchText));
		
		dataServices.getMovies(searchText)
		.then(
			(res)=> res.json(),
			(err)=> console.log(err)
		).then(
			json => dispatch(searchRecieved(json))
		);

			// dataServices.getMovies('america')
			// .then(
			// 	response => response.json(),
			// 	err => console.log(err)
			// ).then(
			// 	json => dispatch(searchRecieved(json))
			// )
	}
}

export function selectedMovie(movieDetail){
	return {
		type:'MOVIE_SELECTED',
		data: movieDetail
	}
}

export function loginUser(user){
	return {
		type:'LOGIN_USER',
		data: user
	}
}


