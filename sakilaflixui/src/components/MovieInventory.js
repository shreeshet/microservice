import React, { Component } from 'react'
import { Modal,Table } from 'react-bootstrap';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import InventoryList from './InventoryList';
import {
	showHideInventory
} from '../actions';

class MovieInventory extends React.Component{
	constructor(props, context) {
		super(props, context);
		this.handleClose = this.handleClose.bind(this);
	}

	handleClose(){
		this.props.handleClose();
	}

	render(){
		const {show,movieInventory,selectedMovie} = this.props;
		
		return (
			<Modal show={show} onHide={this.handleClose}>
        		<Modal.Header closeButton>
          			<Modal.Title>Inventory for {selectedMovie.title}, ${selectedMovie.price}</Modal.Title>
    			</Modal.Header>
    			<Modal.Body>
					<InventoryList movieInventory={movieInventory}/>
    			</Modal.Body>
			</Modal>
		)
	}
}

const mapStateToProps = function(state){
	return {
		selectedMovie: state.selectedMovie,
		show: (state.selectedMovieInventory && state.selectedMovieInventory.length !== 0) ? true:false,
		movieInventory : state.selectedMovieInventory
	}
}

const mapDispatchToProps = (dispatch, ownProps) => ({
  handleClose: () => {
    dispatch(showHideInventory())
  }
})

export default connect(
	mapStateToProps,
	mapDispatchToProps
)(MovieInventory);