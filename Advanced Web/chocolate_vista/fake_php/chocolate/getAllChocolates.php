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

$sql = "SELECT * FROM chocolate";
$results = $conn->query($sql);

$chocsArr = array();
$response = array();

if (mysqli_num_rows($results) > 0) {
    $response['success'] = true;
    $response['message'] = "all chocolates found";

    while($row = mysqli_fetch_assoc($results)) {
        // set just required fields
        $name = $row["Name"];
        $imgUrl = $row["ImgUrl"];
        $rating = $row["Rating"];

        $choc = array();
        array_push($choc,$name,$imgUrl,$rating);
        array_push($chocsArr,$choc);
    }

    $response['chocsData'] = $chocsArr;
}
else {
    $response['success'] = false;
    $response['message'] = "couldn't find all chocolates";
}

echo json_encode($response);
?>