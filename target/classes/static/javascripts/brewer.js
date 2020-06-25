$(function() {
	var decimal = $('.js-decimal');
	decimal.maskMoney({
		 thousands: '.', //Define o separador de milhar como ponto
		    decimal: ',' //Define o separador de decimal como vírgula
	});
	
	var plain = $('.js-plain');
	plain.maskMoney({ precision: 0 });
});