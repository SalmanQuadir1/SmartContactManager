function preback() {
	window.history.forward();
}
setTimeout("preback()", 0);
window.onunload = function(){
	 var form = $('form'); 
    // let the browser natively reset defaults
    form[0].reset();
};