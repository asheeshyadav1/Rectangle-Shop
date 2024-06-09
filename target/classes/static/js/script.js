function editRectangle() {
    var name = prompt("Enter new name");
    var color = prompt("Enter new color");
    var width = prompt("Enter new width");
    var height = prompt("Enter new height");

    document.getElementById("name").textContent = name;
    document.getElementById("color").textContent = color;
    document.getElementById("width").textContent = width;
    document.getElementById("height").textContent = height;
}