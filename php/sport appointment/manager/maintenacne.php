<!DOCTYPE html>
<html>
<head>
    <title>File Maintenance</title>
</head>
<body>

<h2>File Maintenance</h2>

<?php
$upload_dir = dirname(dirname(__DIR__)) . "/sport appointment/";

// File upload
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_FILES["file"])) {
    $file = $_FILES["file"];
    $file_name = basename($file["name"]);
    $target_file = $upload_dir . $file_name;
    if (move_uploaded_file($file["tmp_name"], $target_file)) {
        echo "File $file_name uploaded successfully.";
    } else {
        echo "Error uploading file.";
    }
}

// File list
echo "<h3>File List:</h3>";
$files = array_diff(scandir($upload_dir), array('..', '.'));
echo "<ul>";
foreach ($files as $file) {
    echo "<li>$file <form method='post'><input type='hidden' name='delete_file' value='$file'><button type='submit' name='submit_delete'>Delete</button></form></li>";
}
echo "</ul>";

// File deletion
if (isset($_POST['submit_delete']) && isset($_POST['delete_file'])) {
    $file_to_delete = $_POST['delete_file'];
    $file_path = $upload_dir . $file_to_delete;
    if (file_exists($file_path)) {
        if (unlink($file_path)) {
            echo "File $file_to_delete deleted successfully.";
            // Redirect to refresh the page and update the file list
            header("Location: ".$_SERVER['PHP_SELF']);
            exit;
        } else {
            echo "Error deleting file.";
        }
    } else {
        echo "File $file_to_delete does not exist.";
    }
}
?>

<!-- File upload form -->
<form method="post" enctype="multipart/form-data">
    <h3>Upload File:</h3>
    <input type="file" name="file">
    <input type="submit" value="Upload">
</form>

</body>
</html>
