import React, { Component } from 'react';
import {Map, InfoWindow, Marker, GoogleApiWrapper} from 'google-maps-react';
import { connect } from 'react-redux';

export class MapContainer extends Component {
  constructor(props, context) {
    super(props, context);
  }

  render() {
    return (
      <Map google={this.props.google} zoom={14}>

      </Map>
    )
  }
}

const mapStateToProps = function(state){
  return {
    google: state.google
  }
}


export default connect(
  mapStateToProps
)(GoogleApiWrapper({
  apiKey: 'AIzaSyAyesbQMyKVVbBgKVi2g6VX7mop2z96jBo'
})(MapContainer))

