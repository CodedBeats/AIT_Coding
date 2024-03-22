// dependencies
import { Link } from "react-router-dom";

// components
import ImageCarousel from "../common/ImageCarousel";

// style
import "./css/landing.css";
import "../common/css/carousel.css";


let Landing = () => {

    const carouselImage = ["/imgs/choc1.jpg", "/imgs/choc2.jpg"];

    return (
        <div className="landing-page">
            <div className="carousel-section-container">
                <ImageCarousel images={carouselImage} imageClass="landing-carousel-image" />
            </div>
                <Link to="/chocolates">
                    <h4>All Boxed Chocolates</h4>
                </Link>
        </div>
    );
}

export default Landing;
