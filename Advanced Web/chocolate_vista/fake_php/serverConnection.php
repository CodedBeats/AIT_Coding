<?php
    $conn = new mysqli("localhost", "root", "", "ChocolateVista");

    if (mysqli_connect_error()) {
        echo mysqli_connect_error();
        exit();
    }
    else {
        // echo "Success!";
    }
?>