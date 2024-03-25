// dependencies
import { useState, useEffect } from "react";
import Dropdown from 'react-bootstrap/Dropdown';

// components
import ChocCard from "../common/ChocCard";

// hooks
import useFetch from "../../hooks/useFetch";

// style
import "./css/filters.css";

let Filters = ({ onFilterChange }) => {

    const handleInputChange = (value, filterName) => {
        onFilterChange(filterName, value);
    };

    return (
        <div className="filters">
            <Dropdown>
                <Dropdown.Toggle variant="success" id="dropdown-basic">
                Dropdown Button1
                </Dropdown.Toggle>

                <Dropdown.Menu>
                <Dropdown.Item onClick={() => handleInputChange("Action1", "filter1")}>Action1</Dropdown.Item>
                <Dropdown.Item onClick={() => handleInputChange("Action2", "filter1")}>Action2</Dropdown.Item>
                <Dropdown.Item onClick={() => handleInputChange("Action3", "filter1")}>Action3</Dropdown.Item>
                </Dropdown.Menu>
            </Dropdown>

            <Dropdown>
                <Dropdown.Toggle variant="success" id="dropdown-basic">
                Dropdown Button2
                </Dropdown.Toggle>

                <Dropdown.Menu>
                <Dropdown.Item onClick={() => handleInputChange("Action1", "filter2")}>Action1</Dropdown.Item>
                <Dropdown.Item onClick={() => handleInputChange("Action2", "filter2")}>Action2</Dropdown.Item>
                <Dropdown.Item onClick={() => handleInputChange("Action3", "filter2")}>Action3</Dropdown.Item>
                </Dropdown.Menu>
            </Dropdown>

            <Dropdown>
                <Dropdown.Toggle variant="success" id="dropdown-basic">
                Dropdown Button3
                </Dropdown.Toggle>

                <Dropdown.Menu>
                <Dropdown.Item onClick={() => handleInputChange("Action1", "filter3")}>Action1</Dropdown.Item>
                <Dropdown.Item onClick={() => handleInputChange("Action2", "filter3")}>Action2</Dropdown.Item>
                <Dropdown.Item onClick={() => handleInputChange("Action3", "filter3")}>Action3</Dropdown.Item>
                </Dropdown.Menu>
            </Dropdown>
        </div>
    );
};

export default Filters;
