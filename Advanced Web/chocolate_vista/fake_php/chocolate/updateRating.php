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

if ($data && isset($data->rating) && isset($data->chocID)) {
    // get input rating
    $newRating = $data->rating;
    $chocID = $data->chocID;

    // sql query
    $sql = "UPDATE chocolate SET rating = '".$newRating."' WHERE ChocolateID = '".$chocID."';";
    $sql .= "UPDATE chocolate SET numRatings = numRatings + 1 WHERE ChocolateID = '".$chocID."'";

    // Execute the multi-query
    if (mysqli_multi_query($conn, $sql)) {
        $response['success'] = true;
        $response['message'] = "Rating updated successfully";
    }
    else {
        $response['success'] = false;
        $response['message'] = "Couldn't update rating: ". mysqli_error($conn);
    }
}
else {
    $response['success'] = false;
    $response['message'] = "No rating input or chocID provided";
}

echo json_encode($response);
?>