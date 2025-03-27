$(document).ready(function() {
    // Initialize tooltips
    $('[data-bs-toggle="tooltip"]').tooltip();
    
    // Confirm before delete
    $('.btn-danger').on('click', function(e) {
        if (!confirm('Are you sure you want to delete this item?')) {
            e.preventDefault();
        }
    });
    
    // Set today's date as default for date fields
    $('input[type="date"]').each(function() {
        if (!$(this).val()) {
            const today = new Date().toISOString().split('T')[0];
            $(this).val(today);
        }
    });
});