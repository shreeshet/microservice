import React from 'react'
import SearchBox from './searchbox';
import MovieSearch from '../containers/MovieSearch';
import MovieInventory from './MovieInventory';
import InventoryList from './InventoryList';
import MapContainer from './MapContainer';
import UserBanner from './UserBanner';
import { PageHeader,Button,Grid,Row,Col } from 'react-bootstrap';
import { connect } from 'react-redux';
import {Redirect} from 'react-router-dom';

class App extends React.Component{

	constructor(props, context) {
		super(props, context);
	}

	render(){
		const {loggedInUser} = this.props;
		if(loggedInUser && loggedInUser!== '' 
			&& loggedInUser.firstName
			&& loggedInUser.active){
			return (
				<div>
					<PageHeader>
						SakilaFlix <small>your one stop movie shop</small>
						<UserBanner/>
					</PageHeader>
					<SearchBox/>
					<MovieSearch/>
					<MovieInventory/>
	  			</div>
			)			
		}else{
			return <Redirect to="/"/>
		}

		
	}
}

const mapStateToProps = function(state){
	return {
		loggedInUser: state.loggedInUser
	}
}

export default connect(
	mapStateToProps
)(App)