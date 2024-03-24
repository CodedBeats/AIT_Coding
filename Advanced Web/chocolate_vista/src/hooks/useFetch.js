import {useEffect, useState} from "react"

let useFetch = (url, requestMethod, inputData) => {
    const [data, setData] = useState(null);
    const [isPending, setIsPending] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            setIsPending(true);
            setError(null);

            try {
                const response = await fetch(url, {
                    method: requestMethod,
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: inputData ? JSON.stringify(inputData) : null,
                });

                if (!response.ok) {
                    throw new Error('Failed to fetch data');
                }

                const jsonData = await response.json();
                setData(jsonData);
            } catch (error) {
                setError(error.message);
            }

            setIsPending(false);
        };

        fetchData();
    }, [url, requestMethod, inputData]);

    return { data, isPending, error}
}

export default useFetch;