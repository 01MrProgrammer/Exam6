<?php
// Load the XML file
$xmlFile = "Movie.xml";
$dom = new DOMDocument();
$dom->load($xmlFile);

// Get all <MovieInfo> elements
$movies = $dom->getElementsByTagName("MovieInfo");

// Iterate through each <MovieInfo> element
foreach ($movies as $movie) {
    // Get MovieTitle and ActorName
    $title = $movie->getElementsByTagName("MovieTitle")->item(0)->nodeValue;
    $actor = $movie->getElementsByTagName("ActorName")->item(0)->nodeValue;
    
    // Print MovieTitle and ActorName
    echo "Movie Title: $title, Actor Name: $actor <br>";
}
?> 
