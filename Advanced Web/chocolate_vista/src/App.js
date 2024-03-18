// dependencies
import { BrowserRouter as Router, Routes , Route } from "react-router-dom"

// home
import Landing from "./components/landing/Landing";

// auth
import RegisterForm from "./components/auth/Register";
import LoginForm from "./components/auth/Login";


const App = () => (
    <Router>
        <Routes>
            {/* home */}
            <Route path="/" element={<Landing />} />

            {/* auth*/}
            <Route path="/register" element={<RegisterForm />} />
            <Route path="/login" element={<LoginForm />} />
        </Routes>
    </Router>
);

export default App;
