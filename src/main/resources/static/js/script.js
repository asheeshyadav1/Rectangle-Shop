/*
 * AUTHOR: Asheesh Yadav
 * DESCRIPTION: This is a JavaScript file that calculates the perimeter and area of a rectangle
 *              it is used and called in the specUser.html file when showing all attributes of a user's rectangle
 *              it gets the width and height from the table and calculates the perimeter and area
 * DATE: 6/14/2024
 *
 */

//when the window loads, the perimeter and area of the rectangle is calculated
window.onload = function() {

    // need to reparse the numbers back to integers since we parsed them in as strings
    var width = parseInt(document.getElementById('width').innerText);
    var height = parseInt(document.getElementById('height').innerText);

    // Calculate perimeter and area
    var perimeter = 2 * (width + height);
    var area = width * height;

    // Display perimeter and area in the table used the id associated with the td elements
    document.getElementById('perimeter').innerText = perimeter;
    document.getElementById('area').innerText = area;
}