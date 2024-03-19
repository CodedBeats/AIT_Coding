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




// Get the JSON data sent from the frontend
$data = json_decode(file_get_contents('php://input'), true);
$response = array();

if (isset($data['email']) && isset($data['password'])) {
    $email = $data["email"];
    $password = $data["password"];

    $sql = "SELECT * FROM userstest WHERE email = '".$email."'";
    $results = $conn->query($sql);

    if (mysqli_num_rows($results) > 0) {
        $row = mysqli_fetch_array($results);
        $hash = $row["Password"];
        $username = $row["Username"];
        $_SESSION["username"] = $username;

        if (password_verify($password, $hash)) {
            // password match
            $response['success'] = true;
            $response['message'] = "Login successful";
        }
        else {
            $response['success'] = false;
            $response['message'] = "Invalid Password";
        }
    }
    else {
        $response['success'] = false;
        $response['message'] = "Email not found";
    }
} else {
    $response['success'] = false;
    $response['message'] = "Email and/or password not provided.";
}


echo json_encode($response);
?>