var title_str = "theta_deg | theta_rad | sin(theta_rad) | cos(theta_rad) | tan(theta_rad)";
console.log(title_str);
for (var theta_deg = 0; theta_deg <= 360; theta_deg += 30) {
    var result_str = "";
    var theta_rad = theta_deg * 3.141592 / 180;
    result_str += ("" + theta_deg).padStart(9) + " | ";
    result_str += ("" + theta_rad.toPrecision(3)).padStart(9, " ") + " | ";
    result_str += ("" + Math.sin(theta_rad).toPrecision(3)).padStart(14, " ") + " | ";
    result_str += ("" + Math.cos(theta_rad).toPrecision(3)).padStart(14, " ") + " | ";
    result_str += ("" + Math.tan(theta_rad).toPrecision(3)).padStart(14, " ");
    console.log(result_str);
}