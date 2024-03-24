// dependencies
import { Link, useLocation } from "react-router-dom";

// components
import UserInfo from "./UserInfo";

// style
import "./css/profile.css";


let Profile = () => {
    

    return (
        <div className="profile-container">
            <div className="user-info-container">
                <UserInfo />
            </div>
            <div className="favorites-container"></div>
            <div className="reviews-container"></div>
        </div>
    )
}

export default Profile;
