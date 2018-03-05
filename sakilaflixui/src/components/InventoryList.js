import React, { Component } from 'react';
import { Table } from 'react-bootstrap';

class InventoryList extends React.Component{
	constructor(props, context) {
		super(props, context);
	}

	render(){
		let {movieInventory} = this.props;

		return (
			<Table striped bordered condensed hover>
			  <thead>
			    <tr>
			      <th>Store</th>
			      <th>Rental Duration</th>
			      <th>Last Update</th>
			    </tr>
			  </thead>
			  <tbody>
			  	{
					movieInventory.map((rec,idx) =>
						<tr key={rec.inventoryId} data-inventoryid={rec.inventoryId}>
					      <td>{rec.storeId}</td>
					      <td>{rec.rentalDuration} (days)</td>
					      <td>{rec.lastUpdate}</td>
						</tr>
					)
				}
			  </tbody>
			</Table>
		)
	}
}

export default InventoryList