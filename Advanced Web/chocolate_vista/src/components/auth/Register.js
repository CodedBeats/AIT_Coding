// dependencies
import { useState, useContext } from "react";
import { Form, Button } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";

// components
import UserContext from '../../UserContext';


let RegisterForm = () => {
    const navigate = useNavigate();
    const {setUserData} = useContext(UserContext);

    const [formData, setFormData] = useState({
        email: "",
        username: "",
        password: "",
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData((prevState) => ({
            ...prevState,
            [name]: value,
        }));
    };


    const getUserData = () => {
        fetch("http://localhost/chocolatevista_api/getUserByEmail.php", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(formData),
        })
        .then((response) => response.json())
        .then((data) => {
            if (data.success) {
                // console.log(data.userData);

                // set user data for context
                setUserData({
                    userID: data.userData[0],
                    email: data.userData[1],
                    username: data.userData[2],
                    isLoggedIn: true,
                });

                // navigate to home (or maybe last page)
                navigate("/");
            } else {
                console.log(data.message);
            }
        })
        .catch((error) => {
            console.error("Error:", error);
        });
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        // console.log(formData); 

        fetch("http://localhost/chocolatevista_api/registerFormSubmit.php", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(formData),
        })
        .then((response) => response.json())
        .then((data) => {
            if (data.success) {
                console.log("Register successful");
                // console.log(data.userData);

                // get user data for context and route somewhere
                getUserData();
            } else {
                console.log(data.message);
            }
        })
        .catch((error) => {
            console.error("Error:", error);
        });
    };


    return (
        <>
        <Form>
            <Form.Group controlId="email">
                <Form.Label>Email address</Form.Label>
                <Form.Control
                    type="email"
                    name="email"
                    value={formData.email}
                    onChange={handleChange}
                    placeholder="Enter email"
                />
            </Form.Group>

            <Form.Group controlId="username">
                <Form.Label>Username</Form.Label>
                <Form.Control
                    type="text"
                    name="username"
                    value={formData.username}
                    onChange={handleChange}
                    placeholder="Enter your username"
                />
            </Form.Group>

            <Form.Group controlId="password">
                <Form.Label>Password</Form.Label>
                <Form.Control
                    type="password"
                    name="password"
                    value={formData.password}
                    onChange={handleChange}
                    placeholder="Password"
                />
            </Form.Group>
        </Form>

        <Button variant="primary" type="button" onClick={handleSubmit}>
            Submit
        </Button>

        <Link to="/login">
            <Button variant="outline-success">Login</Button>
        </Link>
        </>
    );
}

export default RegisterForm;