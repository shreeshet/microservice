import {LOGIN_USER} from '../actions';

const loginUser = (state='',action) => {
	switch (action.type) {
		case 'LOGIN_USER':
			return action.data;
		default:
			return state;
	}
}
export default loginUser;