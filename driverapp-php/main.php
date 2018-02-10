<?php
    require_once __DIR__ . '/db_config.php';

    $json = file_get_contents("php://input");
    $obj = json_decode($json);

    $response = array();
    $response["email"] = $obj->email;
    $email = $obj->email;
    $response["password"] = $obj->password;
    $password = $obj->password;

    $con = mysqli_connect(DB_SERVER, DB_USER, DB_PASSWORD, DB_DATABASE)
    or die("could not connect to mysql from .php");

    $sql = "SELECT * FROM driver WHERE email = '$email' AND password = '$password'";

    if(empty($con)) {
        die("Connection failed: " . $con->mysql_error);
    } else {
        $result = mysqli_query($con, $sql) or die(mysqli_error($con));

        header("Content-type: application/json");
        if($result->num_rows > 0) {
            $response["success"] = 1;
            echo json_encode($response);
        } else {
            $response["success"] = 0;
            echo json_encode($response);
        }
    }

?>
