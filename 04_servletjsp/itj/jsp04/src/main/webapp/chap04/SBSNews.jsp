<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">

$(function() {

	$('#b1').click(function() {
		$('#d1').empty()
		$.ajax({
			url: "https://api.rss2json.com/v1/api.json?rss_url=https%3A%2F%2Fnews.sbs.co.kr%2Fnews%2FSectionRssFeed.do%3FsectionId%3D09%26plink%3DRSSREADER",
			success: function(doc) {
				list = doc.items
                for(let i = 0; i < list.length; i++) {
                    title = list[i].title
                    pubDate = list[i].pubDate
                    link = list[i].link
                    author = list[i].author
                    img = list[i].thumbnail
                    tag = "<img src=" + img + " width=100 height=100>"
                    console.log(title + ", " + pubDate + ", " + link + ", " + author + ", " + img)
                    $('#d1').append(tag + "<a href=" + link + ">" + title + "</a><br>")
                }
            },
            error: function(e) {
                alert('프락시 서버 실패.@@@@@@@@')
			}
		})
	})



	$('#b2').click(function() {
        $('#d1').empty()
        $.ajax({
            url : "https://api.rss2json.com/v1/api.json?rss_url=https%3A%2F%2Fnews.sbs.co.kr%2Fnews%2FSectionRssFeed.do%3FsectionId%3D02%26plink%3DRSSREADER",
            success : function(doc) {
                let list = doc.items;
                for(let i = 0; i < list.length; i++) {
                    title = list[i].title
                    pubDate = list[i].pubDate
                    link = list[i].link
                    author = list[i].author
                    img = list[i].thumbnail
                    tag = "<img src=" + img + " width=100 height=100>"
                    console.log(title + ", " + pubDate + ", " + link + ", " + author + ", " + img)
                    $('#d1').append(tag + "<a href=" + link + ">" + title + "</a><br>")
                }
            },
            error : function(e) {
                alert(e)
            }
        })
    })



	$('#b3').click(function() {
        $('#d1').empty()
        $.ajax({
            url : "https://api.rss2json.com/v1/api.json?rss_url=https%3A%2F%2Fnews.sbs.co.kr%2Fnews%2FSectionRssFeed.do%3FsectionId%3D03%26plink%3DRSSREADER",
            success : function(doc) {
                let list = doc.items;
                for(let i = 0; i < list.length; i++) {
                    title = list[i].title
                    pubDate = list[i].pubDate
                    link = list[i].link
                    author = list[i].author
                    img = list[i].thumbnail
                    tag = "<img src=" + img + " width=100 height=100>"
                    console.log(title + ", " + pubDate + ", " + link + ", " + author + ", " + img)
                    $('#d1').append(tag + "<a href=" + link + ">" + title + "</a><br>")
                }
            },
            error : function(e) {
                alert(e)
            }
        })
    })

})

</script>
<style>
input {
	background: yellow;
	color: red;
}
</style>

</head>


<body>
	<button id="b1" class="mt-2 p-2 bg-primary text-white rounded">SBS XML(스포츠)받아오자.</button>
	<button id="b2" class="mt-2 p-2 bg-primary text-white rounded">SBS XML(경제)받아오자.</button>
	<button id="b3" class="mt-2 p-2 bg-primary text-white rounded">SBS XML(사회)받아오자.</button>

	<hr>
	<div id="d1" style="width: 800px; height: 1000px;">
	</div>
</body>

</html>