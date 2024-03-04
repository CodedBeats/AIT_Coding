<?php
    require_once('serverConnection.php');

    // Allow requests from any origin
    header("Access-Control-Allow-Origin: *");

    // Allow certain methods
    header("Access-Control-Allow-Methods: POST");

    // Allow certain headers
    header("Access-Control-Allow-Headers: Origin, Content-Type, Accept");



    // Get the JSON data sent from the React app
    $data = json_decode(file_get_contents('php://input'));
    
    // Extract the form data
    $email = $data->email;
    $username = $data->username;
    $password = $data->password;
    
    // Perform database operation (insertion, etc.)
    $sql = "INSERT INTO userstest (email, username, password) VALUES ('$email', '$username', '$password')";
    if ($conn->query($sql) === TRUE) {
        $response = array("success" => true, "message" => "User registered successfully");
    } else {
        $response = array("success" => false, "message" => "Error: " . $conn->error);
    }
    
    // Send JSON response back to React app
    header('Content-Type: application/json');
    echo json_encode($response);
?>