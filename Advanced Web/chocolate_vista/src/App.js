// dependencies
import { Routes , Route } from "react-router-dom"

// home
import Landing from "./components/landing/Landing";

// auth
import RegisterForm from "./components/auth/Register";
import LoginForm from "./components/auth/Login";

// nav
import NavbarComponent from "./components/nav/Navbar";

// data
import UserProvider from './UserProvider';


const App = () => (
    <div className="App">
        <UserProvider>
            <NavbarComponent />
            <Routes>

                {/* home */}
                <Route path="/" element={<Landing />} />
                <Route exact path="/*" element={<Landing />} /> 

                {/* auth*/}
                <Route path="/register" element={<RegisterForm />} />
                <Route path="/login" element={<LoginForm />} />
            </Routes>
        </UserProvider>
    </div>
);

export default App;
