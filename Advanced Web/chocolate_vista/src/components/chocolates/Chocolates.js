// dependencies
import { useState, useEffect } from 'react';

// components
import ChocCard from '../common/ChocCard';
import Filters from './Filters';

// hooks
import useFetch from '../../hooks/useFetch';

// style
import "./css/chocolates.css";


let Chocolates = () => {
    // choc obj and arr of chocs
    const [chocolates, setChocolates] = useState([]);
    const [chocolatesLength, setChocolatesLength] = useState(0);
    const [filterValues, setFilterValues] = useState({
        filter1: "",
        filter2: "",
        filter3: ""
    });
    
    const { data: chocolatesData, isPending, error } = useFetch(
        "http://localhost/chocolatevista_api/chocolate/getAllChocolates.php",
        "POST"
    );

    const handleFilterChange = (filterName, value) => {
        setFilterValues(prevState => ({
            ...prevState,
            [filterName]: value
        }));
    };


    // Fetch random chocolates on load
    useEffect(() => {
        // Check if chocolatesData and chocolatesData.chocsData are not null/undefined
        if (chocolatesData && chocolatesData.chocsData) { 
            setChocolatesLength(Object.keys(chocolatesData).length);
            const fetchedChocolates = chocolatesData.chocsData.map(chocData => {
                const [name, imgUrl, rating] = chocData;
                return { name, imgUrl, rating };
            });
            // update the chocolates state with the fetched chocolates
            setChocolates(fetchedChocolates); 
        }
    }, [chocolatesData]);

    
    return (
        <>
        <div>
            <p>{chocolatesLength} Chocolates Found</p>
            <div>
                <Filters onFilterChange={handleFilterChange} />
                <div className="filters-preview">
                    <p>Value: {filterValues.filter1}</p>
                    <p>Value: {filterValues.filter2}</p>
                    <p>Value: {filterValues.filter3}</p>
                </div>
            </div>
            <div className="all-chocolates-container">
                {chocolates.map((chocolate, index) => (
                    <div key={index}>
                        <ChocCard choc={chocolate} />
                    </div>
                ))}
            </div>
        </div>
        </>
    )
}

export default Chocolates;
