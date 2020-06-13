import React from 'react';
import './App.css';
import {BrowserRouter, Link, Route, Switch} from 'react-router-dom';
import Version from "./components/Version";
import {Container, Nav, Navbar} from "react-bootstrap";
import Services from "./components/Services";
import Runs from "./components/Runs";

function App() {
    return (
        <BrowserRouter>
            <Navbar bg="dark" variant="dark">
                <Container>
                    <Navbar.Brand href="/">
                        <img alt="" src="./logo.svg" height="27"
                             className="d-inline-block align-top"/>{' '}
                        DAM2
                    </Navbar.Brand>
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="mr-auto">
                            <Nav.Link as={Link} to="/services">Services</Nav.Link>
                            <Nav.Link as={Link} to="/runs">Runs</Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                    <Navbar.Collapse className="justify-content-end">
                        <Navbar.Text><Version/></Navbar.Text>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
            <main>
                <Container>
                    <Switch>
                        <Route path="/" component={Services} exact/>
                        <Route path="/services" component={Services}/>
                        <Route path="/runs" component={Runs}/>
                    </Switch>
                </Container>
            </main>
        </BrowserRouter>
    );
}

export default App;
