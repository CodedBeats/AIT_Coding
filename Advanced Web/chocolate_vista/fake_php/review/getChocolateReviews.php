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


// Initialize response array
$response = array();

// Check if data is received
$data = json_decode(file_get_contents('php://input'));
if ($data) {
    // Check if chocID is provided
    if (isset($data->chocID)) {
        $chocID = $data->chocID;

        // Prepare and execute review query
        $reviewSql = "SELECT * FROM review WHERE ChocolateID = ?";
        $reviewStmt = $conn->prepare($reviewSql);
        $reviewStmt->bind_param("i", $chocID);
        $reviewStmt->execute();
        $reviewResults = $reviewStmt->get_result();

        // Fetch reviews
        if ($reviewResults->num_rows > 0) {
            $reviewsArr = array();
            while ($row = $reviewResults->fetch_assoc()) {
                $text = $row["Text"];
                $userID = $row["UserID"];

                // Prepare and execute user query
                $userSql = "SELECT ImgUrl, Username FROM user WHERE UserID = ?";
                $userStmt = $conn->prepare($userSql);
                $userStmt->bind_param("i", $userID);
                $userStmt->execute();
                $userResults = $userStmt->get_result();

                // Fetch user details
                if ($userResults->num_rows > 0) {
                    $userRow = $userResults->fetch_assoc();
                    $imgUrl = $userRow["ImgUrl"];
                    $username = $userRow["Username"];

                    // Construct review array
                    $review = array();
                    // append all arrays together
                    array_push($review,$text,$imgUrl,$username);
                    array_push($reviewsArr,$review);
                }
            }
            $response['success'] = true;
            $response['message'] = "Reviews found";
            $response['reviewsData'] = $reviewsArr;
        } else {
            $response['success'] = false;
            $response['message'] = "No reviews found for chocID: $chocID";
        }
    } else {
        $response['success'] = false;
        $response['message'] = "chocID not provided";
    }
} else {
    $response['success'] = false;
    $response['message'] = "No data received";
}

// Close database connection
$conn->close();

// Encode response as JSON and output
echo json_encode($response);