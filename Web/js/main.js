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
      $.getJSON(jsonLink, function (data) {
          var albumString = data.album.image[4]["#text"];
          $imgLink.attr("src", albumString);
      })



      $.getJSON(jsonLink, function (data) {
          var tracks = data.album.tracks;
          tracks.each(function () {
              $(this).find("tbody")
                  .append($("<tr>")
                      .append($("<td>")
                          .append($("<p>")
                              .text(tracks)
                          )
                      )
                  )
          })
      })

      i++;
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