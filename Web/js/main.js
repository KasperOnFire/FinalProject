$(function () {
    $(".typer").typed({
        strings: ["cd", "vinyl", "movie", "game", "anything"],
        typeSpeed: 50,
        showCursor: 1,
        startDelay: 500,
        backDelay: 1000
    });
});

$(function () {
    var albums = $("div.img").length
    $("small.totalAlbums").replaceWith("<small>" + albums + "</small>");
});

$(".img").each(function () {
    var i = 0;
    var artistName = jQuery(this).find(".artistName")[i].text;
    jQuery(this).find(".artistTitle").text(artistName);
    artistName = artistName.replace(/ /g, "+");
    var artistLink = "http://last.fm/music/" + artistName;
    jQuery(this).find(".artistName").attr("href", artistLink);

    var albumName = jQuery(this).find(".albumName")[i].text;
    jQuery(this).find(".albumTitle").text(albumName);
    albumName = albumName.replace(/ /g, "+");
    var albumLink = artistLink + "/" + albumName;
    jQuery(this).find(".albumName").attr("href", albumLink);
    jQuery(this).children("a").attr("href", albumLink);

    var apiKey = "3a8d6a8d0cb4132cacd967e9b9bae016";
    var apiLink = "http://ws.audioscrobbler.com/2.0/"
    var jsonLink = apiLink + "?method=album.getinfo&api_key=" + apiKey +
        "&artist=" + artistName + "&album=" + albumName + "&autocorrect[1]&format=json";

    var $imgLink = jQuery(this).find(".albumImg");
    if (albumName != "placeholder" && artistName != "placeholder") {
        $.getJSON(jsonLink, function (data) {
            var albumString = data.album.image[4]["#text"];
            if (albumString.length != 0) {
                $imgLink.attr("src", albumString);
            }
            var tracks = data.album.tracks.track;
            var tracknumber = 1;
            /*$.each(tracks, function () {
                var json = JSON.parse(tracks);
                var trackname = json.parse("name");
                console.log(trackname);
                var trackduration = tracks[i]["duration"];
                $(".trackTable").append("<tr><td>" + tracknumber + "</td><td>" + trackname + "</td><td>" + trackduration + "</td></tr>")
                tracknumber++;
            })*/
        })
    }


    $.getJSON(jsonLink, function (data) {

    })
    i++;
})

$(".tracklist").click(function () {


})





var modal = document.getElementById('myModal');
var btn = document.getElementsByClassName("tracklist")[0];
var span = document.getElementsByClassName("close")[0];
btn.onclick = function () {
    modal.style.display = "block";
}
span.onclick = function () {
    modal.style.display = "none";
}
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}


var colors = ['#F44336', '#E91E63', '#9C27B0', '#673AB7', '#3F51B5', '#2196F3', '#03A9F4', '#00BCD4', '#009688', '#4CAF50', '#8BC34A', '#FF9800', '#FF5722'];
var randNumb = Math.floor(Math.random() * colors.length);
var newColor = colors[randNumb];
$(function () {
    $(".changecolor").css("color", newColor);
})