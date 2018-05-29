// by huangfucai, 2015-08-18

$.fn.loadForm = function (url, param, dataObj) {
    var $this = $(this);
    return $.get(url, param).done(function (data, a, xhr) {
        var ajaxStatus = xhr.getResponseHeader('AjaxStatus');
        if (ajaxStatus == "OK") {
            var dataPath = 'data.formData';
            console.log(data);
            if (dataObj != null)
                data.formData
            $this.formData(eval(dataPath));
        } else if (ajaxStatus == 'ERROR') {
            var err = $.parseJSON(xhr.responseText);
            alert(err.message);
        }
    });
}

$.fn.submitForm = function (url, data) {
    var $this = $(this);
    if ($this.data('submitting') == 'true') // 防止提交期间再次提交
        return;
    $this.data('submitting', 'true');

    if (url == null)
        url = $this.attr('action');
    if (data == null)
        data = $this.serialize();

    return $.post(url, data).done(function (data, a, xhr) {
        var ajaxStatus = xhr.getResponseHeader('AjaxStatus');
        if (ajaxStatus == "Ok") {
            $this.formData(data.formData);
        } else if (ajaxStatus == 'ERROR') {
            var err = $.parseJSON(xhr.responseText);
            alert(err.message);
        }
    }).always(function () {
        $this.data('submitting', '');
    });

}

// http://stackoverflow.com/questions/6992585/jquery-deserialize-form
$.fn.formData = function (values) {
    console.log(values);
    var form = $(this);
    var inputs = $(':input', form).get();
    var hasNewValues = typeof values == 'object';

    if (hasNewValues) {
        // change properties to upper case.
        var values2 = {};
        $.each(values[0], function (key, value) {
            key = "" +key;
            values2[key.toUpperCase()] = values[0][key];
        });
        values = values2;




        $.each(inputs, function () {
            var input = $(this);
            var value = values[this.name.toUpperCase()];
            if (value != null)
                if (values.hasOwnProperty(this.name.toUpperCase())) {
                    switch (this.type) {
                        case 'checkbox':
                            // for checkbox group
                            if (value != null) {
                                var vals = value.split(';');
                                if ($.inArray(input.val(), vals) >= 0) {
                                    input.prop('checked', true);
                                } else {
                                    input.prop('checked', false);
                                    //alert('uncheck')
                                }
                            }
                            break;
                        case 'radio':
                            if (value === null) {
                                input.prop('checked', false);
                            } else if (input.val() == value) {
                                input.prop("checked", true);
                            }
                            break;
                        default:
                            input.val(value);
                    }
                }
        });
        return form;
    } else {
        values = {};
        $.each(inputs, function () {
            var input = $(this);
            var value;
            switch (this.type) {
                case 'checkbox':
                case 'radio':
                    value = input.is(':checked') ? input.val() : null;
                    break;
                default:
                    value = $(this).val();
            }
            // if one name has multi value, treat as array.
            if (values[this.name] != null)
                values[this.name] += ';' + value;
            else
                values[this.name] = value;
        });
        return values;
    }
};