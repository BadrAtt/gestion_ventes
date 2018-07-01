function printData() {
	var part1 = "<!DOCTYPE html><html lang=\"en\" ><!-- begin::Head --><head><meta charset=\"utf-8\" ></meta><title>Gestion Ventes | Facture</title><meta name=\"description\" content=\"Latest updates and statistic charts\"></meta><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/><meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\"></meta><script src=\"https://ajax.googleapis.com/ajax/libs/webfont/1.6.16/webfont.js\"></script><script>WebFont.load({google: {\"families\":[\"Poppins:300,400,500,600,700\",\"Roboto:300,400,500,600,700\"]},active: function() {sessionStorage.fonts = true;}});</script><link href=\"assets/vendors/base/vendors.bundle.css\" rel=\"stylesheet\" type=\"text/css\" /><link href=\"assets/demo/demo12/base/style.bundle.css\" rel=\"stylesheet\" type=\"text/css\" /><link rel=\"shortcut icon\" href=\"../../assets/demo/default/media/img/logo/favicon.ico\" /></head><body  class=\"m-page--fluid m--skin- m-content--skin-light2 m-header--fixed m-header--fixed-mobile m-aside-left--enabled m-aside-left--skin-dark m-aside-left--offcanvas m-footer--push m-aside--offcanvas-default\">";
	var divToPrint = $("#facture").clone();
	divToPrint.css('display','block');
	newWin = window.open("");
	newWin.document.write(part1);
	newWin.document.write($('<div>').append(divToPrint).html());
	setTimeout(function(){ newWin.print();}, 2000);
}