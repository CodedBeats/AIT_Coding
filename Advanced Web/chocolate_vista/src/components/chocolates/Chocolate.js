import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import useFetch from '../../hooks/useFetch';

let Chocolate = () => {
    const { id: currentId } = useParams();
    const [chocolate, setChocolate] = useState({
        chocID: "",
        name: "",
        description: "",
        imgUrl: "",
        price: "",
        rating: "",
        numRatings: "",
        ingredients: "",
        flavors: "",
        weight: "",
        packaging: "",
        allergenInformation: "",
        expirationTime: "",
        origin: "",
        certifications: ""
    });
    const [isPending, setIsPending] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            setIsPending(true);
            setError(null);

            try {
                const response = await fetch(
                    "http://localhost/chocolatevista_api/chocolate/getChocolate.php",
                    {
                        method: "POST",
                        headers: {
                            "Content-Type": "application/json",
                        },
                        body: JSON.stringify({ id: currentId })
                    }
                );

                if (!response.ok) {
                    throw new Error('Failed to fetch data');
                }

                const jsonData = await response.json();

                const [
                    chocID,
                    name,
                    description,
                    imgUrl,
                    price,
                    rating,
                    numRatings,
                    ingredients,
                    flavors,
                    weight,
                    packaging,
                    allergenInformation,
                    expirationTime,
                    origin,
                    certifications
                ] = jsonData.chocData;

                setChocolate({
                    chocID,
                    name,
                    description,
                    imgUrl,
                    price,
                    rating,
                    numRatings,
                    ingredients,
                    flavors,
                    weight,
                    packaging,
                    allergenInformation,
                    expirationTime,
                    origin,
                    certifications
                });
            } catch (error) {
                setError(error.message);
            }

            setIsPending(false);
        };

        if (currentId) {
            fetchData();
        }

    }, [currentId]);

    return (
        <div>
            {/* Render chocolate details using the chocolate state */}
            <p>{chocolate.name}</p>
            <p>id: {chocolate.chocID}</p>
            <p>{chocolate.description}</p>
        </div>
    );
}

export default Chocolate;
