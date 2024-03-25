// dependencies
import Dropdown from 'react-bootstrap/Dropdown';

// style
import "./css/filters.css";

let Filters = ({ onFilterChange }) => {

    const handleInputChange = (filterName, value) => {
        onFilterChange(filterName, value);
    };

    return (
        <div className="filters">
            <Dropdown>
                <Dropdown.Toggle variant="success" id="dropdown-basic">
                Rating
                </Dropdown.Toggle>

                <Dropdown.Menu>
                <Dropdown.Item onClick={() => handleInputChange("rating", 0)}>&gt;=0</Dropdown.Item>
                <Dropdown.Item onClick={() => handleInputChange("rating", 1)}>&gt;=1</Dropdown.Item>
                <Dropdown.Item onClick={() => handleInputChange("rating", 2)}>&gt;=2</Dropdown.Item>
                <Dropdown.Item onClick={() => handleInputChange("rating", 3)}>&gt;=3</Dropdown.Item>
                <Dropdown.Item onClick={() => handleInputChange("rating", 4)}>&gt;=4</Dropdown.Item>
                <Dropdown.Item onClick={() => handleInputChange("rating", 5)}>&gt;=5</Dropdown.Item>
                </Dropdown.Menu>
            </Dropdown>

            <Dropdown>
                <Dropdown.Toggle variant="success" id="dropdown-basic">
                Price
                </Dropdown.Toggle>

                <Dropdown.Menu>
                <Dropdown.Item onClick={() => handleInputChange("price", 6)}>&lt;6</Dropdown.Item>
                <Dropdown.Item onClick={() => handleInputChange("price", 4)}>&lt;4</Dropdown.Item>
                <Dropdown.Item onClick={() => handleInputChange("price", 2)}>&lt;2</Dropdown.Item>
                </Dropdown.Menu>
            </Dropdown>

            <Dropdown>
                <Dropdown.Toggle variant="success" id="dropdown-basic">
                Weight
                </Dropdown.Toggle>

                <Dropdown.Menu>
                <Dropdown.Item onClick={() => handleInputChange("weight", 2)}>&gt;=2</Dropdown.Item>
                <Dropdown.Item onClick={() => handleInputChange("weight", 4)}>&gt;=4</Dropdown.Item>
                <Dropdown.Item onClick={() => handleInputChange("weight", 6)}>&gt;=6</Dropdown.Item>
                <Dropdown.Item onClick={() => handleInputChange("weight", 8)}>&gt;=8</Dropdown.Item>
                </Dropdown.Menu>
            </Dropdown>
        </div>
    );
};

export default Filters;
