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

if ($data && isset($data->search)) {
    // get input search string
    $searchQuery = $data->search;

    // sql query
    $sql = "SELECT * FROM chocolate WHERE `name` LIKE '%$searchQuery%'";
    
    $results = $conn->query($sql);
    $chocsArr = array();

    if (mysqli_num_rows($results) > 0 && $searchQuery !== "") {
        $response['success'] = true;
        $response['message'] = "Searched Chocolates found";

        while($row = mysqli_fetch_assoc($results)) {
            // set just required fields
            $chocID = $row["ChocolateID"];
            $name = $row["Name"];

            $choc = array();
            array_push($choc,$chocID,$name);
            array_push($chocsArr,$choc);
        }

        $response['chocsData'] = $chocsArr;
    }
    else {
        $response['success'] = false;
        $response['message'] = "No chocolates found matching the search query";
    }
}
else {
    $response['success'] = false;
    $response['message'] = "no search query";
}

echo json_encode($response);
?>