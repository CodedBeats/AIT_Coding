// dependencies
import { useState, useContext } from "react";
import { Form, Button } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import { toast } from 'react-toastify';

// components
import UserContext from '../../UserContext';


let RegisterForm = () => {
    const navigate = useNavigate();
    const {setUserData} = useContext(UserContext);
    const notifySuccessfulRegister = () => toast.success("Account Created Successfully", {
        position: "top-right",
        autoClose: 2000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: false,
    });

    const [formData, setFormData] = useState({
        imgUrl: "",
        email: "",
        username: "",
        password: "",
    });
    const [errors, setErrors] = useState({
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
        // clear error message when user starts typing
        setErrors(prevState => ({
            ...prevState,
            [name]: ""
        }));

        // set random avatar img
        const randomAvatar = `/imgs/user/${Math.floor(Math.random() * 12) + 1}.png`;
        setFormData(prevState => ({
            ...prevState,
            imgUrl: randomAvatar
        }));
    };


    // login user
    const getUserData = () => {
        fetch("http://localhost/chocolatevista_api/user/getUserByEmail.php", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(formData),
        })
        .then((response) => response.json())
        .then((data) => {
            if (data.success) {
                console.log(data.userData);

                // set user data for context (login user)
                setUserData({
                    userID: data.userData[0],
                    imgUrl: data.userData[1],
                    email: data.userData[2],
                    username: data.userData[3],
                    isLoggedIn: true,
                });

                // navigate home
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

        let formValid = true;
        const newErrors = {};

        // check if form fields are empty
        if (formData.email === "") {
            newErrors.email = "Please fill out this field";
            formValid = false;
        }
        if (formData.username === "") {
            newErrors.username = "Please fill out this field";
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

        fetch("http://localhost/chocolatevista_api/auth/registerFormSubmit.php", {
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

                // get user data for context
                getUserData();

                // toast alert successful register
                notifySuccessfulRegister();
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

            <Form.Group controlId="username">
                <Form.Label>Username</Form.Label>
                <Form.Control
                    type="text"
                    name="username"
                    value={formData.username}
                    onChange={handleChange}
                    placeholder="Enter your username"
                />
                {errors.username && <Form.Text className="text-danger">{errors.username}</Form.Text>}
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
            REGISTER
        </Button>

        <div>
            Already have an account? 
            <Link to="/login">
                <Button variant="outline-success">Login</Button>
            </Link>
        </div>
        </>
    );
}

export default RegisterForm;
