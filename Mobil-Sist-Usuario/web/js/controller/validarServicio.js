$(document).ready(function () {
    $('#nuevo-servicio-ajax-form').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            nb_cliente: {
                validators: {
                    notEmpty: {
                        message: 'El indicador es indispensable'
                    },
                    stringLength: {
                        min: 3,
                        max: 20,
                        message: 'El indicador debe ser mayor de 3 y menos de 20 caracteres de longitud'
                    }
                }
            },
            dir_origen: {
                validators: {
//                    regexp: {
//                        regexp: /^#/,
//                        message: 'El primer caracter debe ser #'
//                    },
                    notEmpty: {
                        message: 'La direcion de Origen es indispensable'
                    },
                    stringLength: {
                        min: 5,
                        message: 'La direcion de Origen debe contener minimo 10 caracteres'
                    }
                }
            }
        }
    });
});