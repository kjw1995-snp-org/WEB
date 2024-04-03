const token = localStorage.getItem('jwt');

$(document).ajaxSend(function(event, jqxhr,settings) {
    jqxhr.setRequestHeader('jwt',token);
});

$('.logout-btn').on('click', function(e) {
    localStorage.removeItem('jwt');
});





