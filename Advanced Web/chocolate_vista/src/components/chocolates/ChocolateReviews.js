// dependencies
import { useState, useEffect, useContext } from "react";
import Button from 'react-bootstrap/Button';
import Image from 'react-bootstrap/Image';
import Form from 'react-bootstrap/Form';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faArrowUp, faArrowDown } from '@fortawesome/free-solid-svg-icons';


// components
import UserContext from '../../UserContext';
import ReviewCard from "../common/ReviewCard";

// style


const ChocolateReviews = (props) => {
    const {userData: user} = useContext(UserContext);
    const [reviews, setReviews] = useState([]);
    const [noReviewsDisplay, setNoReviewsDisplay] = useState(false);
    const [creatingReview, setCreatingReview] = useState(false);
    const [isOpen, setIsOpen] = useState(false);
    const [inputText, setInputText] = useState("");
    const [reviewAdded, setReviewAdded] = useState(false);
    const [reviewRemoved, setReviewRemoved] = useState(false);
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

                if (jsonData.success) {
                    // read reviews data
                    const fetchedReviews = jsonData.reviewsData.map(reviewData => {
                        const [reviewID, text, imgUrl, username] = reviewData;
                        return { reviewID, text, imgUrl, username };
                    });
                    // update the reviews array with fetchedReviews
                    setReviews(fetchedReviews);
                    setNoReviewsDisplay(false);
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
        
    }, [props.chocID, reviewAdded, reviewRemoved]);


    const toggleCreateReview = () => {
        setIsOpen(prevState => !prevState);
        setCreatingReview(prevState => !prevState);
    }

    const handleInputTextChange = (e) => {
        setInputText(e.target.value);
    };

    const handleReviewSubmit = () => {
        fetch("http://localhost/chocolatevista_api/review/addReview.php", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    userID: user.userID,
                    chocID: props.chocID,
                    reviewText: inputText
                }),
            })
            .then((response) => response.json())
            .then((data) => {
                console.log(data.message);
                
                setIsOpen(prevState => !prevState);
                setCreatingReview(prevState => !prevState);
                setReviewAdded(prevState => !prevState);
                
            })
            .catch((error) => {
                console.error("Error:", error);
            });
    }

    const handleDelete = (reviewID) => {
        fetch("http://localhost/chocolatevista_api/review/deleteReview.php", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    reviewID: reviewID
                }),
            })
            .then((response) => response.json())
            .then((data) => {
                console.log(data.message);

                setReviewRemoved(prevState => !prevState);
                
            })
            .catch((error) => {
                console.error("Error:", error);
            });
    }


    return (
        <div>
            { user.isLoggedIn &&
                <div className="create-review-container">
                    <Button variant="primary" onClick={toggleCreateReview}>Create Review {isOpen ? <FontAwesomeIcon icon={faArrowUp} /> : <FontAwesomeIcon icon={faArrowDown} />}</Button>
                    {/* only show on create click */}
                    {creatingReview && 
                        <div className="review-card-container">
                            <div className="review-user-img-container">
                                <Image src={user.imgUrl} alt="Logo" className="review-user-img" rounded />
                            </div>
                            <div className="review-title">{user.username}</div>
                            <div className="review-text">
                            <Form.Group controlId="exampleForm.ControlTextarea1">
                            <Form.Control 
                                as="textarea" 
                                rows={3} 
                                value={inputText} 
                                onChange={handleInputTextChange} 
                            />
                            </Form.Group>
                            </div>
                            <Button variant="success" onClick={handleReviewSubmit}>Submit</Button>
                        </div>
                    }
                </div>
            }
            <div className="review-cards-container">
            {!noReviewsDisplay ? (
                reviews.map((review, index) => (
                    <div key={index}>
                        <ReviewCard review={review} onClick={(value) => handleDelete(value)} />
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
