window.onload = function() {
    // Get width and height from the table and convert them to numbers
    var width = parseInt(document.getElementById('width').innerText);
    var height = parseInt(document.getElementById('height').innerText);

    // Calculate perimeter and area
    var perimeter = 2 * (width + height);
    var area = width * height;

    // Display perimeter and area in the table
    document.getElementById('perimeter').innerText = perimeter;
    document.getElementById('area').innerText = area;
}