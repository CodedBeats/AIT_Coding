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


// get input
$data = json_decode(file_get_contents('php://input'));

// Receive filter vals
$numRatingsFilter = isset($data->numRatingsFilter) ? intval($data->numRatingsFilter) : null;
$price = isset($data->price) ? floatval($data->price) : null;
$weight = isset($data->weight) ? floatval($data->weight) : null;


// Prepare SQL query (1=1 condition always evaluates to true, starting point for dynamically building SQL queries)
$sql = "SELECT * FROM chocolate WHERE 1=1";

// Add filters to query dynamically
if ($numRatingsFilter !== null) {
    $sql .= " AND NumRatings > $numRatingsFilter";
}

if ($price !== null) {
    $sql .= " AND Price < $price";
}

if ($weight !== null) {
    $sql .= " AND Weight > $weight";
}

$results = $conn->query($sql);

$chocsArr = array();
$response = array();

if (mysqli_num_rows($results) > 0) {
    $response['success'] = true;
    $response['message'] = "Chocolates found";

    while($row = mysqli_fetch_assoc($results)) {
        // set just required fields
        $chocID = $row["ChocolateID"];
        $name = $row["Name"];
        $imgUrl = $row["ImgUrl"];
        $rating = $row["Rating"];
        $numRatings = $row["NumRatings"];

        $choc = array();
        array_push($choc,$chocID,$name,$imgUrl,$rating,$numRatings);
        array_push($chocsArr,$choc);
    }

    $response['chocsData'] = $chocsArr;
}
else {
    $response['success'] = false;
    $response['message'] = "No chocolates found matching the criteria";
}

echo json_encode($response);
?>