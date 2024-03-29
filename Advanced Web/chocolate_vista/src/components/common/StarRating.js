// dependencies
import { useState, useEffect } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faStar as solidStar } from "@fortawesome/free-solid-svg-icons";
import { faStar as regularStar } from "@fortawesome/free-regular-svg-icons";
import { Button } from "react-bootstrap";

// style
import "./css/star-rating.css";

const StarRating = (props) => {
    const [ratingAvg, setRatingAvg] = useState(0);
    const [hoverRating, setHoverRating] = useState(0);
    const [hasRated, setHasRated] = useState(false);

    const handleClick = (value) => {
        console.log("clicked");
        const newRating = (parseInt(props.rating)) + (parseInt(value));
        console.log(`numRatigs:${props.numRatings}, rating:${props.rating}, ratingAvg:${ratingAvg}, newRating:${newRating}`)

        setHasRated(true);

        // update choc's rating
        fetch("http://localhost/chocolatevista_api/chocolate/updateRating.php", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    rating: newRating,
                    chocID: props.id
                }),
            })
            .then((response) => response.json())
            .then((data) => {
                console.log(data.message);
            })
            .catch((error) => {
                console.error("Error:", error);
            });
    };

    const handleMouseEnter = (value) => {
        setHoverRating(value);
    };

    const handleMouseLeave = () => {
        setHoverRating(0);
    };


    // set rating on load
    useEffect(() => {
        setRatingAvg((props.rating) / props.numRatings);
        // console.log(props.rating,props.numRatings)
    }, [ratingAvg, props.rating, props.numRatings]);


    return (
        <div className="stars-box">
            {props.static || hasRated ? (
                [1, 2, 3, 4, 5].map((value) => (
                    <div className="star-btn">
                        <FontAwesomeIcon
                            icon={
                                value <= ratingAvg
                                    ? solidStar
                                    : regularStar
                            }
                            className={`star-icon ${
                                value <= ratingAvg ? "filled" : ""
                            }`}
                        />
                    </div>
                ))
            ) : (
                [1, 2, 3, 4, 5].map((value) => (
                    <Button
                        key={value}
                        onClick={() => handleClick(value)}
                        onMouseEnter={() => handleMouseEnter(value)}
                        onMouseLeave={handleMouseLeave}
                        variant="link"
                        className="star-btn"
                    >
                        <FontAwesomeIcon
                            icon={
                                value <= (hoverRating || ratingAvg)
                                    ? solidStar
                                    : regularStar
                            }
                            className={`star-icon ${
                                value <= (hoverRating || ratingAvg) ? "filled" : ""
                            }`}
                        />
                    </Button>
                ))
            )}
        </div>
    );
};

export default StarRating;
