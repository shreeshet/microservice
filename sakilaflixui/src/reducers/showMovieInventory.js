import {SHOW_INVENTORY,HIDE_INVENTORY} from '../actions';
	
const showHideInventory = (state='',action) => {
	switch (action.type) {
		case SHOW_INVENTORY:
			return action.data;
		case HIDE_INVENTORY:
			return action.data;			
		default:
			return state;		
	}
}
export default showHideInventory;