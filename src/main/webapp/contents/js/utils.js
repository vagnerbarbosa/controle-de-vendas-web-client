var i = setInterval(function () {
    clearInterval(i);
    document.getElementById("preloader").style.display = "none";
    document.getElementById("all").style.display = "inline";
}, 2000);

$('#myModal').on('shown.bs.modal', function () {
    $('#myInput').focus();
});