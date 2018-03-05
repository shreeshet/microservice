import React, { Component } from 'react';
import { Button } from 'react-bootstrap';
import { withRouter } from 'react-router';
import { connect } from 'react-redux';
import dataServices from '../services/DataServices';
import { FormControl } from 'react-bootstrap';
import {
	loginUser
} from '../actions';

class Login extends Component{
	constructor(props, context) {
		super(props,context);
		this.handleChange = this.handleChange.bind(this);
		this.handleClick = this.handleClick.bind(this);

		this.state = {
    		userName: this.props.userName || ''
  		}
	}

	handleClick(e){
		this.props.handleClick(this.state.userName);
	}

	handleChange(e) {
		this.setState({ userName: e.target.value });
	}

	render(){
		const {user} = this.props;

		return(
			<div>
			<FormControl
            	type="text"
            	value={this.props.userName}
            	placeholder="Enter User Name"
            	onChange={this.handleChange}
          	/>
			<Button bsStyle="primary" onClick={this.handleClick}>Login</Button>
			</div>
		)
	}
}

const mapStateToProps = function(state){
	return {
		user:state.loggedInUser
	}
}

const mapDispatchToProps = (dispatch, ownProps) => ({
  handleClick: (userName) => {
    const {history} = ownProps;
    dataServices.authenticateUser(userName)
    .then(
		(res)=> res.json(),
		(err)=> console.log(err)
	).then(
		json => {
			dispatch(loginUser(json));
			history.push('/home');
		}
	);
  }
})

export default withRouter(connect(
	mapStateToProps,
	mapDispatchToProps
)(Login));
