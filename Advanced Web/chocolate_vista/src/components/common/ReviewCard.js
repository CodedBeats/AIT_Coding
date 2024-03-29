// dependencies
import Image from 'react-bootstrap/Image';

// style
import "./css/review-card.css";

let ReviewCard = (props) => {
    return (
        <div className="review-card-container">
            <div className="review-user-img-container">
                <Image src={props.review.imgUrl} alt="Logo" className="review-user-img" rounded />
            </div>
            <div className="review-title">{props.review.username}</div>
            <div className="review-text">{props.review.text}</div>
        </div>
    );
}

export default ReviewCard;
