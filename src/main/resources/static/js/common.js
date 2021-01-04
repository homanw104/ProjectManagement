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

        // File upload button (application.html)
        $('#file-button').click(function () {
            $("#file").click();
        });

        // Show file name (application.html)
        $("#file").change(function () {
            let files = $("#file").get(0).files;
            $("#file-name").val(files[0].name);
        });

        // Dropdown UI (application.html)
        $('#tutors').dropdown({maxSelections:1});
        $('#teammates').dropdown({maxSelections:3});

        // Dropdown UI (profile-edit.html)
        $('#year').dropdown();
        $('#gender').dropdown();
    })
;
