  $(function () {
      var albums = $("div.img").length
      $("small.totalAlbums").replaceWith("<small>" + albums + "</small>");
  });
  $(".img").each(function () {
      var i = 0;
      var artistName = jQuery(this).find(".artistName")[i].text;
      artistName = artistName.replace(/ /g, "+");
      var artistLink = "http://last.fm/music/" + artistName;
      jQuery(this).find(".artistName").attr("href", artistLink);

      var albumName = jQuery(this).find(".albumName")[i].text;
      albumName = albumName.replace(/ /g, "+");
      var albumLink = artistLink + "/" + albumName;
      jQuery(this).find(".albumName").attr("href", albumLink);
      jQuery(this).children("a").attr("href", albumLink);

      var apiKey = "3a8d6a8d0cb4132cacd967e9b9bae016";
      var apiLink = "http://ws.audioscrobbler.com/2.0/"
      var jsonLink = apiLink + "?method=album.getinfo&api_key=" + apiKey +
          "&artist=" + artistName + "&album=" + albumName + "&format=json";

      var $imgLink = jQuery(this).find(".albumImg");
      $.getJSON(jsonLink, function (data) {
          var albumString = data.album.image[4]["#text"];
          $imgLink.attr("src", albumString);
      })
      i++;
  })