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

if ($data && isset($data->email)) {
    $email = $data->email;
    $username = isset($data->username) ? $data->username : null;
    $password = isset($data->password) ? $data->password : null;
    
    $updateFields = array();

    if ($username !== null) {
        $updateFields[] = "`username` = '" . $username . "'";
    }
    if ($password !== null) {
        $hashedPassword = password_hash($password, PASSWORD_DEFAULT);
        $updateFields[] = "`password` = '" . $hashedPassword . "'";
    }

    if (!empty($updateFields)) {
        $sql = "UPDATE `user` SET " . implode(', ', $updateFields) . " WHERE `email` = '" . $email . "'";

        if (mysqli_query($conn, $sql)) {
            $response['success'] = true;
            $response['message'] = "Details updated successfully";
        } else {
            $response['success'] = false;
            $response['message'] = "Couldn't update";
        }
    } else {
        $response['success'] = false;
        $response['message'] = "No fields to update provided";
    }
} else {
    $response['success'] = false;
    $response['message'] = "Data and/or email not provided";
}

echo json_encode($response);
?>