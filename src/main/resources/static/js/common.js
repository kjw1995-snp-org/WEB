const token = localStorage.getItem('jwt');

$(document).ajaxSend(function(event, jqxhr,settings) {
    jqxhr.setRequestHeader('jwt',token);
});

$('.logout-btn').on('click', function(e) {
    localStorage.removeItem('jwt');
});

$('a').on('click',function(event) {
    event.preventDefault();
    const url = $(this).attr('href');

    $.ajax({
        method: 'GET',
        url: url,
        headers: {
            jwt : token
        },
        success: function(data) {
            location.href = url;
        },
        error: function(xhr, status, error) {
            alert(error.message);
        }
    });

});





