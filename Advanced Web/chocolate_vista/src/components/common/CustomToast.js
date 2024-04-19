import { toast } from 'react-toastify';

let CustomToast = (message, type) => {
    if (type === "success") {
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
    else if (type === "warning") {
        const notifyToast = () => toast.warn(message, {
            position: "top-right",
            autoClose: 2000,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: true,
            draggable: false,
        });
        notifyToast();
    }
}

export default CustomToast;