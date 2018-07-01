var DatatablesExtensionButtons = {
	init: function () {
		$("#liste_articles").DataTable({
			responsive: true,
			dom: "<'row'<'col-sm-6 text-left'f><'col-sm-6 text-right'B>>\n\t\t\t<'row'<'col-sm-12'tr>>\n\t\t\t<'row'<'col-sm-12 col-md-5'i><'col-sm-12 col-md-7 dataTables_pager'lp>>",
			buttons: [
				{
					extend: 'print',
					exportOptions: {
				   		columns: [ 0, 1, 2, 3 ]
					}
				},
				{
					extend: 'copyHtml5',
					exportOptions: {
						columns: [ 0, 1, 2, 3 ]
					}
				},
				{
					extend: 'csvHtml5',
					exportOptions: {
						columns: [ 0, 1, 2, 3 ]
					}
				},
				{
					extend: 'excelHtml5',
					exportOptions: {
						columns: [ 0, 1, 2, 3 ]
					}
				},
				{
					extend: 'pdfHtml5',
					exportOptions: {
						columns: [ 0, 1, 2, 3 ]
					}
				},
			],
			"lengthMenu": [[10, 15, 20, -1], [10, 15, 20, "tous"]]
		}), $("#export_print").on("click", function (e) {
			e.preventDefault(), t.button(0).trigger()
		}), $("#export_copy").on("click", function (e) {
			e.preventDefault(), t.button(1).trigger()
		}), $("#export_excel").on("click", function (e) {
			e.preventDefault(), t.button(2).trigger()
		}), $("#export_csv").on("click", function (e) {
			e.preventDefault(), t.button(3).trigger()
		}), $("#export_pdf").on("click", function (e) {
			e.preventDefault(), t.button(4).trigger()
		}),
		
		$("#liste_commandes").DataTable({
			responsive: true,
			dom: "<'row'<'col-sm-6 text-left'f><'col-sm-6 text-right'B>>\n\t\t\t<'row'<'col-sm-12'tr>>\n\t\t\t<'row'<'col-sm-12 col-md-5'i><'col-sm-12 col-md-7 dataTables_pager'lp>>",
			buttons: [
				{
					extend: 'print',
					exportOptions: {
				   		columns: [ 0, 1, 2, 3, 4, 5 ]
					}
				},
				{
					extend: 'copyHtml5',
					exportOptions: {
						columns: [ 0, 1, 2, 3, 4, 5 ]
					}
				},
				{
					extend: 'csvHtml5',
					exportOptions: {
						columns: [ 0, 1, 2, 3, 4, 5 ]
					}
				},
				{
					extend: 'excelHtml5',
					exportOptions: {
						columns: [ 0, 1, 2, 3, 4, 5 ]
					}
				},
				{
					extend: 'pdfHtml5',
					exportOptions: {
						columns: [ 0, 1, 2, 3, 4, 5 ]
					}
				},
			],
			"lengthMenu": [[10, 15, 20, -1], [10, 15, 20, "tous"]]
		}), $("#export_print").on("click", function (e) {
			e.preventDefault(), t.button(0).trigger()
		}), $("#export_copy").on("click", function (e) {
			e.preventDefault(), t.button(1).trigger()
		}), $("#export_excel").on("click", function (e) {
			e.preventDefault(), t.button(2).trigger()
		}), $("#export_csv").on("click", function (e) {
			e.preventDefault(), t.button(3).trigger()
		}), $("#export_pdf").on("click", function (e) {
			e.preventDefault(), t.button(4).trigger()
		})
	}
};
jQuery(document).ready(function () {
	DatatablesExtensionButtons.init()
});