// dependencies
import { Link } from "react-router-dom";
import Card from 'react-bootstrap/Card';

// style
import "./css/choc-img.css";
import "./css/carousel.css";


let ChocCard = (props) => {
    return (
        <Card style={{ width: '18rem' }}>
            <Card.Body>
                <Link to="/chocolates/chocolate1">
                    <Card.Img variant="top" src={props.choc.imgUrl} alt={props.choc.name} className="choc-img" />
                    <Card.Title>{props.choc.name}</Card.Title>
                </Link>
                <Card.Subtitle className="mb-2 text-muted">Favorited: no</Card.Subtitle>
                <Card.Text>Stars: {props.choc.rating}</Card.Text>
                <Card.Text>Reviews: 1</Card.Text>
            </Card.Body>
        </Card>
    );
}

export default ChocCard;
