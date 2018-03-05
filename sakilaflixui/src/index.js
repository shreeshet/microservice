import React from 'react';
import ReactDOM from 'react-dom';
import {Provider} from "react-redux";
import bootstrapStyles from './assets/styles/bootstrap_3.3.7.css';
import Login from './components/Login';
import App from './components/App';
import store from './store';
import {BrowserRouter as Router, Route,Switch} from 'react-router-dom';


const rootEl = document.getElementById('root');

ReactDOM.render(
  <Provider store={store}>
    <div className="container-fluid">
        <Router>
            <Switch>
                <Route path="/home" component={App} />
                <Route path="/" component={Login}/>
            </Switch>
        </Router>
    </div>
  </Provider>,
rootEl);
