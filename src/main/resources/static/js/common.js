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

        // File name display (application.html)
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

        // Transition initialization (management-xxx.html)
        $('.project.detail').transition();
        $('.mid.attached.segment').attr('class', 'bottom attached ui segment');

        // Transition (management-xxx.html)
        $('.detail.button').click(function () {
            if ($(this).parent().parent().parent().next().attr('class') === 'ui attached segment')
                $(this).parent().parent().parent().next().attr('class', 'bottom attached ui segment');
            else
                $(this).parent().parent().parent().next().attr('class', 'ui attached segment');
            $(this).parent().parent().parent().next().next().transition('fade down');
            $(this).parent().parent().parent().next().next().next().transition('fade down');
        });
    })
;
