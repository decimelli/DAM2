import React, {Component} from 'react';
import {Button, Table} from "react-bootstrap";

class Services extends Component {
    constructor(props) {
        super(props);
        this.state = {
            posted_services: []
        }
    }

    componentDidMount() {
        fetch("http://localhost:10010/api/v1")
            .then(res => res.json())
            .then(data => {
                this.setState({
                    posted_services: data
                })
            })
    }

    render() {
        return (
            <div>
                <h1>Services</h1>
                <p>API <a href={process.env.REACT_APP_LISTENER_API}>{process.env.REACT_APP_LISTENER_API}</a></p>
                <Table responsive="sm">
                    <thead>
                    <tr>
                        <th/>
                        <th>Service Name</th>
                        <th>Version</th>
                        <th>Host</th>
                        <th>Status</th>
                        <th>Date Posted</th>
                    </tr>
                    </thead>
                    <tbody>{
                        this.state.posted_services.map(service => {
                            return (
                                <tr>
                                    <td><Button variant="success">Start</Button></td>
                                    <td>{service.name}</td>
                                    <td>{service.version}</td>
                                    <td>{service.deploymentHost}:{service.executionPostPort}</td>
                                    <td>{service.status}</td>
                                    <td>{service.postDate}</td>
                                </tr>
                            )
                        })
                    }</tbody>
                </Table>
            </div>
        );
    }
}

export default Services;
