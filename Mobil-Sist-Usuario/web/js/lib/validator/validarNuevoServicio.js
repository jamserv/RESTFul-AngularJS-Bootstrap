$(document).ready(function () {
    $('#loginForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            username: {
                validators: {
                    regexp: {
                        regexp: /^#/,
                        message: 'El primer caracter debe ser #'
                    },
                    notEmpty: {
                        message: 'El cuerpo del mensaje es indispensable'
                    },
                    stringLength: {
                        min: 10,
                        message: 'El cuerpo del mensaje debe contener minimo 10 caracteres'
                    }
                }
            }
        }
    });
});

