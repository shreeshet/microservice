import React, { Component } from 'react'
import { FormControl } from 'react-bootstrap';
import { connect } from 'react-redux';
import PropTypes from 'prop-types';
import {
	submitSearch
} from '../actions';

class SearchBox extends React.Component{
	

	constructor(props, context) {
	    super(props, context);
	    this.handleChange = this.handleChange.bind(this);
	    this.handleSubmit = this.handleSubmit.bind(this);
	    this.state = {
    		searchText: this.props.searchText || ''
  		}
  	}

	getValidationState() {
		const length = this.state.value.length;
		if (length > 10) return 'success';
		else if (length > 5) return 'warning';
		else if (length > 0) return 'error';
		return null;
	}

	handleChange(e) {
		this.setState({ searchText: e.target.value });
	}

	handleSubmit(e){
		const text = e.target.value.trim()
		if (e.which === 13) { //on enter submit
		  this.props.onSubmit(text)
		}
	}

	render(){
		return(
			<FormControl
            	type="text"
            	value={this.state.searchText}
            	placeholder="Enter text"
            	onChange={this.handleChange}
            	onKeyPress={this.handleSubmit}
          	/>
		);
	}
}

const mapStateToProps = function(state){
	return {
		searchText: state.searchText		
	}
}

const mapDispatchToProps = (dispatch, ownProps) => ({
  onSubmit: (text) => {
    dispatch(submitSearch(text))
  }
})

export default connect(
	mapStateToProps,
	mapDispatchToProps
)(SearchBox);