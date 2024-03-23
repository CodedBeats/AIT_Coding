// dependencies
import { useState, useEffect } from 'react';
import { Link } from "react-router-dom";

// components
import ImageCarousel from "../common/ImageCarousel";

// style
import "./css/landing.css";
import "../common/css/carousel.css";


let Landing = () => {
    // arr of choc objs
    const [chocolates, setChocolates] = useState([]);

    // imgs for carousel
    const carouselImage = [
        "/imgs/choc1.jpg", 
        "/imgs/choc2.jpg",
    ];

    // Hard-coded chocolate object
    const initialChocolate = {
        img: '/imgs/choc3.png',
        title: 'Truffles',
        favorited: true,
        stars: 4,
        reviews: 10
    };

    // Function to populate chocolates state
    const fetchRandomChocolates = () => {
        // custom useFetch hook - getRandomChocolates API call


        // temp hard-coded
        setChocolates(Array(5).fill(initialChocolate));
    };

    // get random chocolates on load
    useEffect(() => {
        fetchRandomChocolates();
    }, []);



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
                    <img src={chocolate.img} alt={chocolate.title} className="choc-img" />
                    <h2>{chocolate.title}</h2>
                    <p>Favorited: {chocolate.favorited.toString()}</p>
                    <p>Stars: {chocolate.stars}</p>
                    <p>Reviews: {chocolate.reviews}</p>
                    </div>
                ))}
                </div>
            </div>
        </div>
    );
}

export default Landing;
