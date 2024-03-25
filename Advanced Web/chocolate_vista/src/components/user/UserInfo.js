// dependencies
import { useContext } from "react";
import { Link, useLocation } from "react-router-dom";
import Image from 'react-bootstrap/Image';
import Button from 'react-bootstrap/Button';

// components
import UserContext from '../../UserContext';

// style
import "./css/user-info.css";


let UserInfo = () => {

    const {userData: user, setUserData} = useContext(UserContext);

    
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
                <Button variant="outline-warning">Update Details</Button>
            </div>
        </div>
    )
}

export default UserInfo;
