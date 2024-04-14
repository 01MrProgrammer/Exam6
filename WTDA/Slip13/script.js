$(document).ready(function(){
    $('#username').keyup(function(){
        var name = $(this).val();
        if (name === '') {
            $('#response').text("Stranger, please tell me your name!");
        } else if (['Rohit', 'Virat', 'Dhoni', 'Ashwin', 'Harbhajan','Adarsh'].includes(name)) {
            $('#response').text("Hello, master!");
        } else {
            $('#response').text("I don't know you!");
        }
    });
});
