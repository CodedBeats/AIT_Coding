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
    const [noChocsDisplay, setNoChocsDisplay] = useState(false);
    const [filterValues, setFilterValues] = useState({
        rating: null,
        price: null,
        weight: null,
    });
    
    const { data: chocolatesData, isPending, error } = useFetch(
        "http://localhost/chocolatevista_api/chocolate/getAllChocolates.php",
        "POST",
        filterValues
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
        if (chocolatesData) { 
            // clear and display if no chocolates
            if (!chocolatesData.success) {
                setNoChocsDisplay(true);
                
                setChocolatesLength(0);
                setChocolates([]);
            }
            else {
                setNoChocsDisplay(false);
    
                // read chocolate data
                const fetchedChocolates = chocolatesData.chocsData.map(chocData => {
                    const [chocID, name, imgUrl, rating, numRatings] = chocData;
                    return { chocID, name, imgUrl, rating, numRatings };
                });
                // update the chocolates array with fetchedChocolates
                setChocolates(fetchedChocolates); 

                // read amount of chocolates found
                setChocolatesLength(Object.keys(chocolates).length);
            }
        }
    }, [chocolatesData, filterValues]);

    
    return (
        <>
        <div>
            <p>{chocolatesLength} Chocolates Found</p>
            <div>
                <Filters onFilterChange={handleFilterChange} />
                <div className="filters-preview">
                    <p>Value: {filterValues.rating}</p>
                    <p>Value: {filterValues.price}</p>
                    <p>Value: {filterValues.weight}</p>
                </div>
            </div>
            {noChocsDisplay 
                ? <div>No Chocolates Found</div>
                : <div className="all-chocolates-container">
                    {chocolates.map((chocolate, index) => (
                        <div key={index}>
                            <ChocCard chocID={chocolate} choc={chocolate} static={false} />
                        </div>
                    ))}
                </div>
            }
        </div>
        </>
    )
}

export default Chocolates;
