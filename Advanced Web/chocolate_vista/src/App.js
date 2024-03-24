// dependencies
import { Routes , Route } from "react-router-dom"

// landing
import Landing from "./components/landing/Landing";

// chocolates
import Chocolates from "./components/chocolates/Chocolates";
import Chocolate from "./components/chocolates/Chocolate";

// auth
import RegisterForm from "./components/auth/Register";
import LoginForm from "./components/auth/Login";

// about
import About from "./components/about/About";

// nav
import NavbarComponent from "./components/nav/Navbar";

// common
import Breadcrumbs from "./components/common/Breadcrumbs";

// data
import UserProvider from './UserProvider';


const App = () => (
    <div className="App">
        <UserProvider>
            <NavbarComponent />
            <Breadcrumbs />
            <Routes>

                {/* home */}
                <Route path="/" element={<Landing />} />
                <Route path="/*" element={<Landing />} /> 

                {/* chocolates */}
                <Route exact path="/chocolates" element={<Chocolates />} /> 
                <Route path="/chocolates/chocolate1" element={<Chocolate />} /> 

                {/* auth*/}
                <Route exact path="/register" element={<RegisterForm />} />
                <Route exact path="/login" element={<LoginForm />} />

                {/* about */}
                <Route exact path="/about" element={<About />} />
            </Routes>
        </UserProvider>
    </div>
);

export default App;
