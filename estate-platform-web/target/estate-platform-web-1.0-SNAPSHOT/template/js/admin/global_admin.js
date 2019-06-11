$(document).ready(function () {
    bindEventCheckAllCheckbox();
    autoCheckCheckboxAll();
    enableOrDisableDeleteAll();
});

function bindEventCheckAllCheckbox() {
    $('#checkAll').change(function () {
        if ((this).checked) {
            $(this).closest('table').find('tbody').find('input[type=checkbox]').prop('checked', true);
        } else {
            $(this).closest('table').find('tbody').find('input[type=checkbox]').prop('checked', false);
            $('#btnDelete').prop('disabled', true);
        }
    })
}

function autoCheckCheckboxAll() {
    var totalCheckboxChild = $('#checkAll').closest('table').find('tbody').find('input[type=checkbox]').length;
    $('#checkAll').closest('table').find('tbody').find('input[type=checkbox]').each(function () {
        $(this).on('change', function () {
            var totalCheckboxChecked = $('#checkAll').closest('table').find('tbody').find('input[type=checkbox]:checked').length;
            if (totalCheckboxChecked == totalCheckboxChild) {
                $('#checkAll').prop('checked', true);
            } else if (totalCheckboxChecked < totalCheckboxChild) {
                $('#checkAll').prop('checked', false);
            }
        })
    })
}

function enableOrDisableDeleteAll() {
    $('input[type=checkbox]').click(function () {
        if ($('input[type=checkbox]:checked').length > 0) {
            $('#btnDelete').prop('disabled', false);
        } else {
            $('#btnDelete').prop('disabled', true);
        }
    });
}






