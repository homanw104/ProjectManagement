$(document)
    .ready(function() {

        // Fix main menu to page on passing
        $('.main.menu').visibility({
            type: 'fixed'
        });
        $('.overlay').visibility({
            type: 'fixed',
            offset: 80
        });

        // Lazy load images
        $('.image').visibility({
            type: 'image',
            transition: 'vertical flip in',
            duration: 500
        });

        // Show dropdown on hover
        $('.main.menu .ui.dropdown').dropdown({
            on: 'hover'
        });

        // File upload button
        $('#file-url-button').click(function () {
            $("#file-url").click();
        });

        // Show file name
        $("#file-url").change(function () {
            let files = $("#file-url").get(0).files;
            $("#file-name").val(files[0].name);
        });
    })
;
