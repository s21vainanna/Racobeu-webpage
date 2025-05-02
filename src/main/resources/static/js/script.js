function changeLang(lang) {
	window.location.replace('/?lang=' + lang);
}

function changeId(id) {
	const urlParams = new URLSearchParams(window.location.search);
	if (urlParams.has('id')) {
		urlParams.set('id', id);
		window.location.replace(window.location.pathname + '?' + urlParams.toString());
	} else if (window.location.search.length > 0) {
		window.location.replace(window.location.pathname + window.location.search + '&id=' + id);
	} else {
		window.location.replace(window.location.pathname + '?id=' + id);
	}
}
