<?php
// Load the XML file into a SimpleXML object
$xml = simplexml_load_file('book.xml');

// Display attributes and elements
echo "<h2>Attributes:</h2>";
foreach ($xml->attributes() as $key => $value) {
    echo "$key: $value <br>";
}

echo "<h2>Elements:</h2>";
foreach ($xml->children() as $child) {
    echo "<h3>{$child->getName()}</h3>";
    echo "<ul>";
    foreach ($child->children() as $element) {
        echo "<li>{$element->getName()}: {$element}</li>";
    }
    echo "</ul>";
}
?>
