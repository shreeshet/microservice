import React, { Component } from 'react';
import { Table } from 'react-bootstrap';
import { connect } from 'react-redux';

class UserBanner extends React.Component{
	constructor(props, context) {
		super(props, context);
	}

	render(){
		let {user} = this.props;
		return (
			<div>Welcome {user.firstName}</div>	
		)
	}
}

const mapStateToProps = function(state){
  return {
    user: state.loggedInUser
  }
}

export default connect(
	mapStateToProps
)(UserBanner);