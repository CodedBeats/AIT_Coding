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

if (isset($data->id)) {
    $id = $data->id;

    $sql = "SELECT * FROM chocolate WHERE ChocolateID = '".$id."'";
    $results = $conn->query($sql);

    if (mysqli_num_rows($results) > 0) {
        $row = mysqli_fetch_array($results);
        $chocID = $row["ChocolateID"];
        $name = $row["Name"];
        $description = $row["Description"];
        $imgUrl = $row["ImgUrl"];
        $price = $row["Price"];
        $rating = $row["Rating"];
        $numRatings = $row["NumRatings"];
        $ingredients = $row["Ingredients"];
        $flavors = $row["Flavors"];
        $weight = $row["Weight"];
        $packaging = $row["Packaging"];
        $allergenInformation = $row["AllergenInformation"];
        $expirationTime = $row["ExpirationTime"];
        $origin = $row["Origin"];
        $certifications = $row["Certifications"];


        $response['success'] = true;
        $response['message'] = "Chocolate found";
        $response['chocData'] = [
            $chocID, 
            $name, 
            $description,
            $imgUrl, 
            $price,
            $rating,
            $numRatings,
            $ingredients,
            $flavors,
            $weight,
            $packaging,
            $allergenInformation,
            $expirationTime,
            $origin,
            $certifications
        ];
    }
    else {
        $response['success'] = false;
        $response['message'] = "Chocolate not found";
    }
} else {
    $response['success'] = false;
    $response['message'] = "ID not provided";
}


echo json_encode($response);
?>