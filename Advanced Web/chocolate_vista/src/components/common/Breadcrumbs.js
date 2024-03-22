// dependencies
import { Link, useLocation } from "react-router-dom";

// style
import "./css/breadcrumbs.css";


let Breadcrumbs = () => {
    const location = useLocation();

    let currentLink = "";
    const homeCrumb = (
        <div className="crumb" key="home">
            <Link to="/">Home</Link>
        </div>
    );

    // first letter of path should be capitalized in breadcrumb display
    let capitalizeFirstLetter = (string) => {
        return string.charAt(0).toUpperCase() + string.slice(1);
    }

    // split path into individual paths (exclude blank) and create links
    const crumbs = location.pathname.split("/")
        .filter(crumb => crumb !== "")
        .map(crumb => {
            currentLink += `/${crumb}`

            return (
                <div className="crumb" key={crumb}>/ 
                    <Link to={currentLink}>{capitalizeFirstLetter(crumb)}</Link>
                </div>
            )
        });

    
    return (
        <div className="breadcrumbs">
            {homeCrumb}{crumbs}
        </div>
    )
}

export default Breadcrumbs;
