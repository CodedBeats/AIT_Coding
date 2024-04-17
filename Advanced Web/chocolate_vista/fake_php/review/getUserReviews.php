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
    // Check if userID is provided
    if (isset($data->userID)) {
        $userID = $data->userID;

        // Prepare and execute review query
        $reviewSql = "SELECT * FROM review WHERE UserID = ?";
        $reviewStmt = $conn->prepare($reviewSql);
        $reviewStmt->bind_param("i", $userID);
        $reviewStmt->execute();
        $reviewResults = $reviewStmt->get_result();

        // Fetch reviews
        if ($reviewResults->num_rows > 0) {
            $reviewsArr = array();
            while ($row = $reviewResults->fetch_assoc()) {
                $reviewID = $row["ReviewID"];
                $chocID = $row["ChocolateID"];
                $text = $row["Text"];

                // Prepare and execute chocolate query
                $chocolateSql = "SELECT Name, ImgUrl FROM chocolate WHERE ChocolateID = ?";
                $chocolateStmt = $conn->prepare($chocolateSql);
                $chocolateStmt->bind_param("i", $chocID);
                $chocolateStmt->execute();
                $chocolateResults = $chocolateStmt->get_result();

                // Fetch chocolate details
                if ($chocolateResults->num_rows > 0) {
                    $chocolateRow = $chocolateResults->fetch_assoc();
                    $name = $chocolateRow["Name"];
                    $imgUrl = $chocolateRow["ImgUrl"];

                    // Construct review array
                    $review = array();
                    // append all arrays together
                    array_push($review,$reviewID,$chocID,$text,$name,$imgUrl);
                    array_push($reviewsArr,$review);
                }
            }
            $response['success'] = true;
            $response['message'] = "Reviews found";
            $response['reviewsData'] = $reviewsArr;
        } else {
            $response['success'] = false;
            $response['message'] = "No reviews found for userID: $userID";
        }
    } else {
        $response['success'] = false;
        $response['message'] = "userID not provided";
    }
} else {
    $response['success'] = false;
    $response['message'] = "No data received";
}

// Close database connection
$conn->close();

// Encode response as JSON and output
echo json_encode($response);
?>