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

if ($data && isset($data->chocolateID) && isset($data->userID)) {
    $chocolateID = $data->chocolateID;
    $userID = $data->userID;

    // prepare and bind statement
    $stmt = $conn->prepare("INSERT INTO favourite (ChocolateID, UserID) VALUES (?, ?)");
    $stmt->bind_param("ii", $chocolateID, $userID);

    // execute the statement
    if ($stmt->execute() === TRUE) {
        $response['success'] = true;
        $response['message'] = "Record inserted successfully";
    } else {
        $response['success'] = false;
        $response['message'] = "Error inserting record: " . $conn->error;
    }

    // close statement
    $stmt->close();
} else {
    $response['success'] = false;
    $response['message'] = "chocolateID and userID not provided";
}

echo json_encode($response);
?>
