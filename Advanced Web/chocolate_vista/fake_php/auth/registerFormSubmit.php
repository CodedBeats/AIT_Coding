<?php
require_once('../serverConnection.php');

// === DON'T TOUCH ===
header('Access-Control-Allow-Origin: http://localhost:3000');
// fancy shit
if ($_SERVER['REQUEST_METHOD'] == 'OPTIONS') {
    // Allow from any origin
    if (isset($_SERVER['HTTP_ORIGIN'])) {
        header("Access-Control-Allow-Origin: *");
        header('Access-Control-Allow-Credentials: true');
        header('Access-Control-Max-Age: 86400');    // cache for 1 day
    }
    // Access-Control headers are received during OPTIONS requests
    if (isset($_SERVER['HTTP_ACCESS_CONTROL_REQUEST_METHOD']))
        header("Access-Control-Allow-Methods: POST, OPTIONS");         

    if (isset($_SERVER['HTTP_ACCESS_CONTROL_REQUEST_HEADERS']))
        header("Access-Control-Allow-Headers: {$_SERVER['HTTP_ACCESS_CONTROL_REQUEST_HEADERS']}");

    exit(0);
}
// === DON'T TOUCH ===


// Get the JSON data sent from the frontend
$data = json_decode(file_get_contents('php://input'));
$response = array();

// Extract the form data
$imgUrl = $data->imgUrl;
$email = $data->email;
$username = $data->username;
$password = $data->password;
$hashedPassword = password_hash($password, PASSWORD_DEFAULT);

// Perform database operation (insertion, etc.)
$sql = "INSERT INTO user (imgUrl, email, username, password) VALUES ('$imgUrl', '$email', '$username', '$hashedPassword')";
if ($conn->query($sql) === TRUE) {
    $response["success"] = true;
    $response["message"] = "User registered successfully";
    $response['userData'] = [$imgUrl, $email, $username];
} else {
    $response["success"] = false;
    $response["message"] = "Error: " . $conn->error;
}

// Send JSON response back to React app
header('Content-Type: application/json');
echo json_encode($response);
?>