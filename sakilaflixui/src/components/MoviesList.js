import React, { Component } from 'react'
import { Table } from 'react-bootstrap';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import {
	showHideInventory,
	selectedMovie
} from '../actions';

class MoviesList extends React.Component{
	constructor(props, context) {
	    super(props, context);
	    this.handleClick = this.handleClick.bind(this);
	}

	handleClick(e){
		let selectedMovieId = e.currentTarget.getAttribute('data-movieid');
		const {movies} = this.props;
		let selectedMovie = movies.find(function(e){
			return e.fid == selectedMovieId;
		});
		
		this.props.movieSelected(selectedMovieId,selectedMovie);
	}

	render(){
		const {movies} = this.props;
		return(
			<Table striped bordered condensed hover>
			  <thead>
			    <tr>
			      <th>Title</th>
			      <th>Description</th>
			      <th>Rating</th>
			      <th>Price</th>
			    </tr>
			  </thead>
			  <tbody>
			  	{
			  		movies.map((movie,idx) =>
			  			<tr key={movie.fid} data-movieid={movie.fid} onClick={this.handleClick}>
					      <td>{movie.title}</td>
					      <td>{movie.description}</td>
					      <td>{movie.rating}</td>
					      <td>${movie.price}</td>			  			
			  			</tr>)
			  	}
			  </tbody>
			</Table>
		)
	}
}

const mapStateToProps = function(state){
	return {}
}

const mapDispatchToProps = (dispatch, ownProps) => ({
  movieSelected: (movieId,selectedMovieRec) => {
  	dispatch(selectedMovie(selectedMovieRec))
    dispatch(showHideInventory(movieId))
  }
})

export default connect(
	mapStateToProps,
	mapDispatchToProps
)(MoviesList);