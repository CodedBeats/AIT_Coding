// dependencies
import { useState, useContext } from "react";
import { Link, useNavigate } from "react-router-dom";
import { Form, Button } from "react-bootstrap";

// components
import UserContext from '../../UserContext';
import CustomToast from "../common/CustomToast";


let LoginForm = () => {
    const navigate = useNavigate();
    const {setUserData} = useContext(UserContext);

    const [formData, setFormData] = useState({
        email: "",
        password: "",
    });
    const [errors, setErrors] = useState({
        email: "",
        password: "",
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData((prevState) => ({
            ...prevState,
            [name]: value,
        }));
        // clear error message when user starts typing
        setErrors(prevState => ({
            ...prevState,
            [name]: ""
        }));
    };


    const handleSubmit = (e) => {
        e.preventDefault();

        let formValid = true;
        const newErrors = {};

        // check if form fields are empty
        if (formData.email === "") {
            newErrors.email = "Please fill out this field";
            formValid = false;
        }
        if (formData.password === "") {
            newErrors.password = "Please fill out this field";
            formValid = false;
        }

        // if any field is empty, set errors and return
        if (!formValid) {
            setErrors(newErrors);
            return;
        }

        fetch("http://localhost/chocolatevista_api/auth/loginFormSubmit.php", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(formData),
        })
        .then((response) => response.json())
        .then((data) => {
            if (data.success) {
                console.log("Login successful");
                // console.log(data.userData);

                // set user data for context
                setUserData({
                    userID: data.userData[0],
                    imgUrl: data.userData[1],
                    email: data.userData[2],
                    username: data.userData[3],
                    isLoggedIn: true,
                });

                // navigate to home (or maybe last page)
                navigate("/");

                // toast alert successful login
                CustomToast("Login Successful",);
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
                {errors.email && <Form.Text className="text-danger">{errors.email}</Form.Text>}
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
                {errors.password && <Form.Text className="text-danger">{errors.password}</Form.Text>}
            </Form.Group>
        </Form>

        <Button variant="primary" type="button" onClick={handleSubmit}>
            LOGIN
        </Button>

        <div>
            Don't have an account? 
            <Link to="/register">
                <Button variant="outline-success">Register</Button>
            </Link>
        </div>
        </>
    );
}

export default LoginForm;
