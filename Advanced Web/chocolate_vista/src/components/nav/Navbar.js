// dependencies
import { useContext } from "react";
import { Navbar, Nav, Form, FormControl, Button } from "react-bootstrap";
import Image from 'react-bootstrap/Image';
import { Link } from "react-router-dom"

// components
import UserContext from '../../UserContext';


const NavbarComponent = () => {

    const {userData, setUserData} = useContext(UserContext);

    const handleLogout = () => {
        setUserData({
            userID: "",
            email: "",
            username: "",
            isLoggedIn: false,
        });
    }

    return (
        <Navbar bg="light" expand="lg">
            <Link to="/">
                <Image 
                    src="/imgs/logo.png"
                    width="50"
                    height="50"
                    alt="Logo"
                    rounded 
                />
                ChocolateVista
            </Link>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="mr-auto">
                    <Form inline>
                        <FormControl
                            type="text"
                            placeholder="Search"
                            className="mr-sm-2"
                        />
                    </Form>
                    <Link to="/chocolates">
                        <div>Boxed Chocolates</div>
                    </Link>
                    <Link to="/about">
                        <div>About</div>
                    </Link>
                </Nav>
                <Nav>
                    {userData.isLoggedIn ? (
                        <Nav>
                            <Link to="/profile">
                                <Button variant="outline-success">Profile</Button>
                            </Link>
                            <Button variant="danger" onClick={handleLogout}>Logout</Button>
                        </Nav>
                    ) : (
                        <Link to="/register">
                            <Button variant="outline-success">Register</Button>
                        </Link>
                    )}
                </Nav>
            </Navbar.Collapse>
        </Navbar>
    );
};

export default NavbarComponent;
