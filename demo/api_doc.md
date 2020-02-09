<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>api_doc</title>
  <link rel="stylesheet" href="https://stackedit.io/style.css" />
</head>

<body class="stackedit">
  <div class="stackedit__html"><h1 id="flo-playlist-api">Flo Playlist API</h1>
<h2 id="contents">Contents</h2>
<ol>
<li><a href="#1-playlist-%EC%83%9D%EC%84%B1-api">Playlist 생성 API</a></li>
<li><a href="#2-playlist-%EB%85%B8%EB%9E%98-%EC%95%A8%EB%B2%94-%EC%B6%94%EA%B0%80-api">Playlist 노래, 앨범 추가 API</a></li>
<li><a href="#3-playlist-%EB%AA%A9%EB%A1%9D-api">Playlist 목록 API</a></li>
<li><a href="#4-playlist-%EC%82%AD%EC%A0%9C-api">Playlist 삭제 API</a></li>
</ol>
<h3 id="playlist-생성-api">1. Playlist 생성 API</h3>
<pre><code>POST /playlists
</code></pre>
<ul>
<li>해당 사용자의 playlist를 생성할 수 있습니다.</li>
<li>한 사용자는 여러 개의 playlist를 가질 수 있습니다.</li>
<li>playlist 이름을 지정할 수 있습니다.</li>
</ul>
<h4 id="parameter">Parameter</h4>

<table>
<thead>
<tr>
<th>Parameter</th>
<th>Type</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr>
<td>title</td>
<td>string</td>
<td>(필수) 생성 할 playlist 이름</td>
</tr>
</tbody>
</table><h4 id="response-code">Response Code</h4>
<pre><code>200
</code></pre>
<h3 id="playlist-노래-앨범-추가-api">2. Playlist 노래, 앨범 추가 API</h3>
<pre><code>POST /playlists/{playlist_id}
</code></pre>
<ul>
<li>노래를 playlist에 추가할 수 있습니다.</li>
<li>특정 앨범에 포함된 모든 노래를 playlist에 추가할 수 있습니다.</li>
</ul>
<h4 id="path-parameter">Path Parameter</h4>

<table>
<thead>
<tr>
<th>Parameter</th>
<th>Type</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr>
<td>playlist_id</td>
<td>integer</td>
<td>(필수) 노래 혹은 특정 앨범에 포함된 모든 노래를 추가 할 playlist 아이디</td>
</tr>
</tbody>
</table><h4 id="parameter-1">Parameter</h4>

<table>
<thead>
<tr>
<th>Parameter</th>
<th>Type</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr>
<td>song_ids</td>
<td>array</td>
<td>추가 할 노래 아이디들</td>
</tr>
<tr>
<td>album_ids</td>
<td>array</td>
<td>추가 할 앨범 아이디들</td>
</tr>
</tbody>
</table><pre><code>{
    "song_ids": [ 1, 2 ],
    "album_ids": []
}
</code></pre>
<h4 id="response-code-1">Response Code</h4>
<pre><code>200
</code></pre>
<h3 id="playlist-목록-api">3. Playlist 목록 API</h3>
<ul>
<li>특정 사용자의 playlist 목록을 조회할 수 있습니다.</li>
<li>pagination은 하지 않습니다.</li>
</ul>
<pre><code>GET /playlists
</code></pre>
<h4 id="response-body">Response Body</h4>
<pre><code>{
	"playlists": [
		{
			"playlist_id": 13,
			"title": "추억",
			"thumbnail_url": "http://xxxxx.xxx/xxxxxx",
			"created_date": "20200209222809"
		},
		{
			"playlist_id": 12,
			"title": "7080",
			"thumbnail_url": "http://xxxxx.xxx/xxxxxx",
			"created_date": "20200209222805"
		},
		{
			"playlist_id": 11,
			"title": "운동",
			"thumbnail_url": "http://xxxxx.xxx/xxxxxx",
			"created_date": "20200209222759"
		}
	]
}
</code></pre>
<h3 id="playlist-삭제-api">4. Playlist 삭제 API</h3>
<ul>
<li>사용자의 특정 playlist 1개를 삭제합니다.</li>
</ul>
<pre><code>DELETE /playlists/{playlist_id}
</code></pre>
<h4 id="response-code-2">Response Code</h4>
<pre><code>200
</code></pre>
</div>
</body>

</html>
