// dependencies
import { BrowserRouter as Router, Routes , Route } from "react-router-dom"

// landing
import Landing from "./components/landing/landing";

// auth
import RegisterForm from "./components/auth/register/Register";


const App = () => (
    <Router>
            <Routes>
                {/* landing */}
                <Route path="/" element={<Landing />} />

                {/* auth*/}
                <Route path="/register" element={<RegisterForm />} />
            </Routes>
        </Router>
);

export default App;
