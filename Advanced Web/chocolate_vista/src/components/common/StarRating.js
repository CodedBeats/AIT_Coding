// dependencies
import { useState, useEffect } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faStar as solidStar } from "@fortawesome/free-solid-svg-icons";
import { faStar as regularStar } from "@fortawesome/free-regular-svg-icons";
import { Button } from "react-bootstrap";

// style
import "./css/star-rating.css";

const StarRating = (props) => {
    const [rating, setRating] = useState(0);
    const [hoverRating, setHoverRating] = useState(0);

    const handleClick = (value) => {
        console.log(rating);

        // Calculate the new rating
        let newRating = ((rating * props.numRatings) + value) / (props.numRatings + 1);
        newRating = Math.min(newRating, 5); // Cap the rating at 5

        // Update the rating state
        setRating(newRating);
        console.log(newRating);

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
        setRating(props.rating);
    }, [props.rating]);


    return (
        <div>
            {props.static ? (
                [1, 2, 3, 4, 5].map((value) => (
                    <Button
                        key={value}
                        variant="link"
                        className="star-btn"
                    >
                        <FontAwesomeIcon
                            icon={
                                value <= rating
                                    ? solidStar
                                    : regularStar
                            }
                            className={`star-icon ${
                                value <= rating ? "filled" : ""
                            }`}
                        />
                    </Button>
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
                                value <= (hoverRating || rating)
                                    ? solidStar
                                    : regularStar
                            }
                            className={`star-icon ${
                                value <= (hoverRating || rating) ? "filled" : ""
                            }`}
                        />
                    </Button>
                ))
            )}
        </div>
    );
};

export default StarRating;
