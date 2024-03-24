// dependencies
import { useState, useEffect } from 'react';
import { Link } from "react-router-dom";
import Card from 'react-bootstrap/Card';

// components
import ImageCarousel from "../common/ImageCarousel";

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
        if (chocolatesData && chocolatesData.chocsData) { // Check if chocolatesData and chocolatesData.chocsData are not null/undefined
            const fetchedChocolates = chocolatesData.chocsData.map(chocData => {
                const [name, imgUrl, rating] = chocData;
                return { name, imgUrl, rating };
            });
            setChocolates(fetchedChocolates); // Use setChocolates to update the chocolates state with the fetched chocolates
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
                {/* useFetch to load random here */}
                <div className="random-chocolates">
                    {chocolates.map((chocolate, index) => (
                        <div key={index}>
                            <Card style={{ width: '18rem' }}>
                                <Card.Body>
                                    <Card.Img variant="top" src={chocolate.imgUrl} alt={chocolate.name} className="choc-img" />
                                    <Link to="/chocolates/chocolate1">
                                        <Card.Title>{chocolate.name}</Card.Title>
                                    </Link>
                                    <Card.Subtitle className="mb-2 text-muted">Favorited: no</Card.Subtitle>
                                    <Card.Text>Stars: {chocolate.rating}</Card.Text>
                                    <Card.Text>Reviews: 1</Card.Text>
                                </Card.Body>
                            </Card>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
}

export default Landing;
