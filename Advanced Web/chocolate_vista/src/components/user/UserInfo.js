// dependencies
import { useState, useContext } from "react";
import { Link, useNavigate } from "react-router-dom";
import Image from 'react-bootstrap/Image';
import Button from 'react-bootstrap/Button';

// components
import UserContext from '../../UserContext';
import UpdateUserInfo from './UpdateUserInfo';
import CustomToast from "../common/CustomToast";

// style
import "./css/user-info.css";


let UserInfo = () => {
    const navigate = useNavigate();
    const {userData: user, setUserData} = useContext(UserContext);
    const [modalShow, setModalShow] = useState(false);

    const handleDelete = () => {
        // Prompt the user with a confirmation dialog
        const isConfirmed = window.confirm("Are you sure you want to delete your account? This action cannot be undone.");

        // If the user confirms, proceed with the deletion
        if (isConfirmed) {
            fetch("http://localhost/chocolatevista_api/auth/deleteUser.php", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({ userID: user.userID })
            })
            .then(response => response.json())
            .then(data => {
                console.log(data.message);

                // essentially logout
                setUserData({
                    userID: "",
                    imgUrl: "",
                    email: "",
                    username: "",
                    isLoggedIn: false,
                });
                // clear user data from local storage
                localStorage.removeItem("userData");
                navigate("/");

                // notify user successfully deleted account
                CustomToast("Account Deleted Successfully");
            })
            .catch(error => {
                console.error("Error:", error);
            });
    }
    }

    
    return (
        <div className="user-info">
            <div className="user-img-container">
                <Image src={user.imgUrl} alt="Logo" className="user-img" rounded />
            </div>
            <div className="email-container">
                <p>email</p>
                <p>{user.email}</p>
            </div>
            <div className="username-container">
                <p>username</p>
                <p>{user.username}</p>
            </div>
            <div className="password-container">
                <p>password</p>
                <p>*******</p>
            </div>
            <div className="update-container">
                <Button variant="outline-warning" onClick={() => setModalShow(true)}>Update Details</Button>
            </div>
            <UpdateUserInfo
                show={modalShow}
                onHide={() => setModalShow(false)}
                email={user.email}
            />
            <div className="delete-container">
                <button onClick={handleDelete}>Delete Account</button>
            </div>
        </div>
    )
}

export default UserInfo;
