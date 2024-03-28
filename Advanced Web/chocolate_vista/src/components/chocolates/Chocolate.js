// dependencies
import { useParams } from 'react-router-dom';

let Chocolate = () => {
    const { id, name } = useParams();
    
    
    return (
        <>
        <h2>{name}</h2>
        <p>ID: {id}</p>
        </>
    )
}

export default Chocolate;
