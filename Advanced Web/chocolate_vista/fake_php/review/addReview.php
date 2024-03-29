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

if ($data && isset($data->userID) && isset($data->chocID) && isset($data->reviewText)) {
    // get input user and review data
    $userID = $data->userID;
    $chocID = $data->chocID;
    $reviewText = $data->reviewText;

    // sql query
    $sql = "INSERT INTO review (UserID, ChocolateID, `Text`) VALUES ('".$userID."', '".$chocID."', '".$reviewText."')";

    // Execute the query
    if ($conn->query($sql) === TRUE) {
        $response['success'] = true;
        $response['message'] = "created review successfully";
    }
    else {
        $response['success'] = false;
        $response['message'] = "Couldn't create review: ". mysqli_error($conn);
    }
}
else {
    $response['success'] = false;
    $response['message'] = "No data provided";
}

echo json_encode($response);
?>