// dependencies
import { Container, Row, Col, Button, Card } from "react-bootstrap";
import { Link } from "react-router-dom"

let Landing = () => {
    return (
        <div className="landing-page">
            <Container>
                <Row>
                    <Col>
                        <h1>Welcome to Our Website</h1>
                        <p>
                            This is a simple landing page with some random fancy
                            Bootstrap components. Feel free to explore!
                        </p>
                        <Button variant="primary">Get Started</Button>
                    </Col>
                </Row>
                <Row className="mt-5">
                    <Col>
                        <Card style={{ width: "18rem" }}>
                            <Card.Img
                                variant="top"
                                src="https://via.placeholder.com/286x180"
                            />
                            <Card.Body>
                                <Card.Title>Card Title</Card.Title>
                                <Card.Text>
                                    Some quick example text to build on the card
                                    title and make up the bulk of the card's
                                    content.
                                </Card.Text>
                                <Button variant="primary">Go somewhere</Button>
                            </Card.Body>
                        </Card>
                    </Col>
                    <Col>
                        <Card style={{ width: "18rem" }}>
                            <Card.Img
                                variant="top"
                                src="https://via.placeholder.com/286x180"
                            />
                            <Card.Body>
                                <Card.Title>Card Title</Card.Title>
                                <Card.Text>
                                    Some quick example text to build on the card
                                    title and make up the bulk of the card's
                                    content.
                                </Card.Text>
                                <Button variant="primary">Go somewhere</Button>
                            </Card.Body>
                        </Card>
                    </Col>
                    <Col>
                        <Card style={{ width: "18rem" }}>
                            <Card.Img
                                variant="top"
                                src="https://via.placeholder.com/286x180"
                            />
                            <Card.Body>
                                <Card.Title>Card Title</Card.Title>
                                <Card.Text>
                                    Some quick example text to build on the card
                                    title and make up the bulk of the card's
                                    content.
                                </Card.Text>
                                <Button variant="primary">Go somewhere</Button>
                            </Card.Body>
                        </Card>
                    </Col>
                </Row>

                <Link to="/Register">
                    <Button variant="primary">Register</Button>
                </Link>

            </Container>
        </div>
    );
}

export default Landing;
