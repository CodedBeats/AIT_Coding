import { useState } from "react";
import UserContext from "./UserContext";

function UserProvider({ children }) {
    const [userData, setUserData] = useState({
        userID: "",
        email: "",
        username: "",
        isLoggedIn: false,
    });

    const setUser = (userData) => {
        setUserData(userData);
    };

    return (
        <UserContext.Provider value={{ userData, setUser }}>
            {children}
        </UserContext.Provider>
    );
}

export default UserProvider;
