<?php
require_once('serverConnection.php');

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



// Main logic for the navbar
if ($_SERVER['REQUEST_METHOD'] === 'GET') {
    // Check if the user is logged in
    $isLoggedIn = isset($_SESSION['username']);

    // Prepare the response for the navbar
    $navbarInfo = array(
        'isLoggedIn' => $_SESSION['username']
    );

    // Return the navbar information as JSON
    echo json_encode($navbarInfo);

} else {
    // Return appropriate error response
    $response = array(
        'error' => 'Invalid request method'
    );
    http_response_code(400);
    echo json_encode($response);
}
?>