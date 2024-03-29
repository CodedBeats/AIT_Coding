// dependencies
import { useState, useEffect } from "react";
import Button from 'react-bootstrap/Button';

// components
import ReviewCard from "../common/ReviewCard";

// style


const ChocolateReviews = (props) => {
    const [reviews, setReviews] = useState([]);
    const [noReviewsDisplay, setNoReviewsDisplay] = useState(false);
    const [isPending, setIsPending] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            setIsPending(true);
            setError(null);

            try {
                const response = await fetch(
                    "http://localhost/chocolatevista_api/review/getChocolateReviews.php",
                    {
                        method: "POST",
                        headers: {
                            "Content-Type": "application/json",
                        },
                        body: JSON.stringify({ chocID: props.chocID })
                    }
                );

                if (!response.ok) {
                    throw new Error('Failed to fetch data');
                }

                const jsonData = await response.json();

                if (response.success) {
                    // read reviews data
                    const fetchedReviews = jsonData.reviewsData.map(reviewData => {
                        const [text, imgUrl, username] = reviewData;
                        return { text, imgUrl, username };
                    });
                    // update the reviews array with fetchedReviews
                    setReviews(fetchedReviews);
                }
                else {
                    setNoReviewsDisplay(true);
                }
                
            } catch (error) {
                setError(error.message);
            }

            setIsPending(false);
        };

        fetchData();
        
    }, [props.chocID]);
    


    return (
        <div>
            <div className="create-review-container">
                <Button variant="success">Create Review +</Button>
            </div>
            <div className="review-cards-container">
            {!noReviewsDisplay ? (
                reviews.map((review, index) => (
                    <div key={index}>
                        <ReviewCard review={review} />
                    </div>
                ))
            ) : (
                <div>
                    This chocolate currently has no reviews
                </div>
            )}
            </div>
        </div>
    );
};

export default ChocolateReviews;
