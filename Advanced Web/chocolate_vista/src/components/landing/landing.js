// dependencies

import { Link } from "react-router-dom";

// components


let Landing = () => {
    return (
        <div className="landing-page">
            <Link to="/chocolates">
                <h4>All Boxed Chocolates</h4>
            </Link>
            
        </div>
    );
}

export default Landing;
