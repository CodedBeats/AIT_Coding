// dependencies
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faHeart as solidHeart } from '@fortawesome/free-solid-svg-icons';
import { faHeart as regularHeart } from '@fortawesome/free-regular-svg-icons';

let FavouriteIcon = (props) => {
    const icon = props.isFavorited ? solidHeart : regularHeart;
    const color = "red";

    return (
        <>
        { props.static ? (
            <FontAwesomeIcon icon={icon} style={{ color }} />
        ) : (
            <div>
                
            </div>
        )}
        </>
    );
}

export default FavouriteIcon;