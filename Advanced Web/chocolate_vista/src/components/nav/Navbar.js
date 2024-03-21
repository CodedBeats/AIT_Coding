// dependencies
import { useContext } from "react";
import { Navbar, Nav, Form, FormControl, Button } from "react-bootstrap";
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
            <Navbar.Brand href="/">
                <img
                    src="/imgs/choc1.jpg"
                    width="50"
                    height="50"
                    className="d-inline-block align-top"
                    alt="Logo"
                />{" "}
                Website Title
            </Navbar.Brand>
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
                    <Nav.Link href="#">Boxed Chocolates</Nav.Link>
                    <Nav.Link href="#">About</Nav.Link>
                </Nav>
                <Nav>
                    {userData.isLoggedIn ? (
                        <Nav>
                            <Link to="#">
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
