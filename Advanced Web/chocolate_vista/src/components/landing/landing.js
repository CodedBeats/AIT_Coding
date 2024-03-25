// dependencies
import { useState, useEffect } from 'react';
import { Link } from "react-router-dom";

// components
import ImageCarousel from "../common/ImageCarousel";
import ChocCard from '../common/ChocCard';

// hooks
import useFetch from '../../hooks/useFetch';

// style
import "./css/landing.css";
import "../common/css/carousel.css";


let Landing = () => {
    // choc obj and arr of chocs
    const [chocolates, setChocolates] = useState([]);
    
    const { data: chocolatesData, isPending, error } = useFetch(
        "http://localhost/chocolatevista_api/chocolate/getRandom.php",
        "POST"
    );

    // imgs for carousel
    const carouselImage = [
        "/imgs/choc1.jpg", 
        "/imgs/choc2.jpg",
    ];


    // Fetch random chocolates on load
    useEffect(() => {
        // Check if chocolatesData and chocolatesData.chocsData are not null/undefined
        if (chocolatesData && chocolatesData.chocsData) { 
            const fetchedChocolates = chocolatesData.chocsData.map(chocData => {
                const [chocID, name, imgUrl, rating] = chocData;
                return { chocID, name, imgUrl, rating };
            });
            // update the chocolates state with the fetched chocolates
            setChocolates(fetchedChocolates); 
        }
    }, [chocolatesData]);


    return (
        <div className="landing-page">
            <div className="carousel-section-container">
                <ImageCarousel images={carouselImage} imageClass="landing-carousel-image" />
                <Link to="/chocolates">
                    <h4>All Boxed Chocolates</h4>
                </Link>
            </div>

            <div className="random-chocolates-container">
                <div className="random-chocolates-title">Some Boxed Chocolates You Might Like</div>
                <div className="random-chocolates">
                    {chocolates.map((chocolate, index) => (
                        <div key={index}>
                            <ChocCard chocID={chocolate} choc={chocolate} />
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
}

export default Landing;
