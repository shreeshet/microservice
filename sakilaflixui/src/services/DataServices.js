import "whatwg-fetch";

class DataServices {
	static getMovies(searchText){
		let url = '/movieservice/movie/title/' + searchText; 
		return fetch(url, {
            method: 'GET',
            credentials: 'same-origin'
        });
	}

	static getMovieInventory(movieId){
		let url = '/inventoryservice/inventory/' + movieId;
		return fetch(url, {
            method: 'GET',
            credentials: 'same-origin'
        });
	}

	static authenticateUser(userName){
		let url = '/customer/first_name/' + userName;
		return fetch(url, {
            method: 'GET',
            credentials: 'same-origin'
    });
	}
}

export default DataServices;