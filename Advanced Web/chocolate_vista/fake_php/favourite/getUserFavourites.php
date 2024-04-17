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

        // prepare and execute favourite query
        $favouriteSql = "SELECT * FROM favourite WHERE UserID = ?";
        $favouriteStmt = $conn->prepare($favouriteSql);
        $favouriteStmt->bind_param("i", $userID);
        $favouriteStmt->execute();
        $favouriteResults = $favouriteStmt->get_result();

        // Fetch reviews
        if ($favouriteResults->num_rows > 0) {
            $favouritesArr = array();
            while ($row = $favouriteResults->fetch_assoc()) {
                $favouriteID = $row["FavouriteID"];
                $chocID = $row["ChocolateID"];

                // Prepare and execute chocolate query
                $chocolateSql = "SELECT Name, ImgUrl, Rating, NumRatings FROM chocolate WHERE ChocolateID = ?";
                $chocolateStmt = $conn->prepare($chocolateSql);
                $chocolateStmt->bind_param("i", $chocID);
                $chocolateStmt->execute();
                $chocolateResults = $chocolateStmt->get_result();

                // Fetch chocolate details
                if ($chocolateResults->num_rows > 0) {
                    $chocolateRow = $chocolateResults->fetch_assoc();
                    $name = $chocolateRow["Name"];
                    $imgUrl = $chocolateRow["ImgUrl"];
                    $rating = $chocolateRow["Rating"];
                    $numRatings = $chocolateRow["NumRatings"];

                    // Construct review array
                    $favourite = array();
                    // append all arrays together
                    array_push($favourite,$chocID,$name,$imgUrl,$rating,$numRatings);
                    array_push($favouritesArr,$favourite);
                }
            }
            $response['success'] = true;
            $response['message'] = "Favourites found";
            $response['chocolatesData'] = $favouritesArr;
        } else {
            $response['success'] = false;
            $response['message'] = "No favourites found for userID: $userID";
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