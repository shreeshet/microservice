import { createStore, applyMiddleware} from 'redux';
import thunk from 'redux-thunk';
import reducers from '../reducers';

const initState = {
  loggedInUser:'',
  searchText:'',
  movies:[],
  selectedMovie:'',
  selectedMovieInventory:[]
}

const store = createStore(
	reducers,
	initState,
	applyMiddleware(thunk));

export default store;