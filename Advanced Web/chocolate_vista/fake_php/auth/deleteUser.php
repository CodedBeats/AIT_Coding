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

if ($data && isset($data->userID)) {
    $userID = $data->userID;

    // prepare and execute deletion from the 'favourite' table
    $sql_favourite = "DELETE FROM favourite WHERE UserID = ?";
    $stmt_favourite = $conn->prepare($sql_favourite);
    $stmt_favourite->bind_param("s", $userID);
    $stmt_favourite->execute();
    $rows_affected_favourite = $stmt_favourite->affected_rows;

    // prepare and execute deletion from the 'review' table
    $sql_review = "DELETE FROM review WHERE UserID = ?";
    $stmt_review = $conn->prepare($sql_review);
    $stmt_review->bind_param("s", $userID);
    $stmt_review->execute();
    $rows_affected_review = $stmt_review->affected_rows;

    // prepare and execute deletion from the 'user' table
    $sql_user = "DELETE FROM user WHERE UserID = ?";
    $stmt_user = $conn->prepare($sql_user);
    $stmt_user->bind_param("s", $userID);
    $stmt_user->execute();
    $rows_affected_user = $stmt_user->affected_rows;

    // check if any rows were affected in any of the tables
    if (($rows_affected_favourite !== -1 || $rows_affected_review !== -1 || $rows_affected_user !== -1) &&
        ($rows_affected_favourite > 0 || $rows_affected_review > 0 || $rows_affected_user > 0)) {
        $response['success'] = true;
        $response['message'] = "User data deleted successfully from favourite, review, and user tables";
    } else {
        $response['success'] = false;
        $response['message'] = "Couldn't delete user";
    }
} else {
    // invalid or missing data
    $response['success'] = false;
    $response['message'] = "Invalid data provided";
}

echo json_encode($response);
?>