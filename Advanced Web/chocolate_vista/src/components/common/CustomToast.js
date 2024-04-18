import { toast } from 'react-toastify';

let CustomToast = (message) => {
    const notifyToast = () => toast.success(message, {
        position: "top-right",
        autoClose: 2000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: false,
    });
    notifyToast();
}

export default CustomToast;