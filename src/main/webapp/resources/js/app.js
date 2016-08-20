$(function() {
	$('.js-toggle').bind('click', function(event) {
		$('.js-sidebar, .js-content').toggleClass('is-toggled');
		event.preventDefault();
	});
});

function maiusculo(z) {
	v = z.value.toUpperCase();
	z.value = v;
}

function minusculo(z) {
	v = z.value.toLowerCase();
	z.value = v;
}