// 请在html页面结束的地方加载此脚本。
// 如果生成表格定义的<table>是页面加载完之后再动态生成的，请使用脚本语法

/////////////////////////////////////////////////////
//
// ligerGrid
//
/////////////////////////////////////////////////////

var gridOptions = [
{ 'name': 'statusName', 'isString': 1 },
{ 'name': 'width', 'isString': 1 },
{ 'name': 'height', 'isString': 1 },
{ 'name': 'mouseoverRowCssClass', 'isString': 1 },
{ 'name': 'pageParmName', 'isString': 1 },
{ 'name': 'pagesizeParmName', 'isString': 1 },
{ 'name': 'method', 'isString': 1 },
{ 'name': 'root', 'isString': 1 },
{ 'name': 'dataType', 'isString': 1 },
{ 'name': 'dataAction', 'isString': 1 },
{ 'name': 'sortnameParmName', 'isString': 1 },
{ 'name': 'sortorderParmName', 'isString': 1 },
{ 'name': 'record', 'isString': 1 },
{ 'name': 'dateFormat', 'isString': 1 },
{ 'name': 'groupColumnDisplay', 'isString': 1 },
{ 'name': 'pageSizeOptions', 'isString': 0 },
{ 'name': 'parms', 'isString': 0 },
{ 'name': 'heightDiff', 'isString': 0 },
{ 'name': 'editorTopDiff', 'isString': 0 },
{ 'name': 'page', 'isString': 0 },
{ 'name': 'minColToggle', 'isString': 0 },
{ 'name': 'pageSize', 'isString': 0 },
{ 'name': 'rownumbersColWidth', 'isString': 0 },
{ 'name': 'checkboxColWidth', 'isString': 0 },
{ 'name': 'rowHeight', 'isString': 0 },
{ 'name': 'headerRowHeight', 'isString': 0 },
{ 'name': 'detailColWidth', 'isString': 0 },
{ 'name': 'minColumnWidth', 'isString': 0 },
{ 'name': 'detailHeight', 'isString': 0 },
{ 'name': 'url', 'isString': 1 },
{ 'name': 'showTableToggleBtn', 'isString': 0 },
{ 'name': 'switchPageSizeApplyComboBox', 'isString': 0 },
{ 'name': 'checkbox', 'isString': 0 },
{ 'name': 'enabledEdit', 'isString': 0 },
{ 'name': 'allowUnSelectRow', 'isString': 0 },
{ 'name': 'delayLoad', 'isString': 0 },
{ 'name': 'selectRowButtonOnly', 'isString': 0 },
{ 'name': 'whenRClickToSelect', 'isString': 0 },
{ 'name': 'detailToEdit', 'isString': 0 },
{ 'name': 'frozenDetail', 'isString': 0 },
{ 'name': 'rownumbers', 'isString': 0 },
{ 'name': 'colDraggable', 'isString': 0 },
{ 'name': 'rowDraggable', 'isString': 0 },
{ 'name': 'autoFilter', 'isString': 0 },
{ 'name': 'title', 'isString': 0 },
{ 'name': 'columnWidth', 'isString': 0 },
{ 'name': 'data', 'isString': 0 },
{ 'name': 'cssClass', 'isString': 0 },
{ 'name': 'rowAttrRender', 'isString': 0 },
{ 'name': 'groupColumnName', 'isString': 0 },
{ 'name': 'groupRender', 'isString': 0 },
{ 'name': 'totalRender', 'isString': 0 },
{ 'name': 'where', 'isString': 0 },
{ 'name': 'contentType', 'isString': 0 },
{ 'name': 'onEndEdit', 'isString': 0 },
{ 'name': 'tree', 'isString': 0 },
{ 'name': 'isChecked', 'isString': 0 },
{ 'name': 'isSelected', 'isString': 0 },
{ 'name': 'detail', 'isString': 0 },
{ 'name': 'isShowDetailToggle', 'isString': 0 },
{ 'name': 'rowDraggingRender', 'isString': 0 },
{ 'name': 'onRowDragDrop', 'isString': 0 },
{ 'name': 'toolbar', 'isString': 0 },
{ 'name': 'headerImg', 'isString': 0 },
{ 'name': 'resizable', 'isString': 0 },
{ 'name': 'usePager', 'isString': 0 },
{ 'name': 'allowAdjustColWidth', 'isString': 0 },
{ 'name': 'allowHideColumn', 'isString': 0 },
{ 'name': 'isScroll', 'isString': 0 },
{ 'name': 'inWindow', 'isString': 0 },
{ 'name': 'async', 'isString': 0 },
{ 'name': 'fixedCellHeight', 'isString': 0 },
{ 'name': 'alternatingRow', 'isString': 0 },
{ 'name': 'enabledSort', 'isString': 0 },
{ 'name': 'clickToEdit', 'isString': 0 },
{ 'name': 'frozen', 'isString': 0 },
{ 'name': 'frozenCheckbox', 'isString': 0 },
{ 'name': 'frozenRownumbers', 'isString': 0 },
{ 'name': 'autoCheckChildren', 'isString': 0 },
{ 'name': 'toolbarShowInLeft', 'isString': 0 },
{ 'name': 'unSetValidateAttr', 'isString': 0 },
{ 'name': 'onDragCol', 'isString': 0 },
{ 'name': 'onToggleCol', 'isString': 0 },
{ 'name': 'onChangeSort', 'isString': 0 },
{ 'name': 'onSuccess', 'isString': 0 },
{ 'name': 'onDblClickRow', 'isString': 0 },
{ 'name': 'onSelectRow', 'isString': 0 },
{ 'name': 'onUnSelectRow', 'isString': 0 },
{ 'name': 'onBeforeCheckRow', 'isString': 0 },
{ 'name': 'onCheckRow', 'isString': 0 },
{ 'name': 'onBeforeCheckAllRow', 'isString': 0 },
{ 'name': 'onCheckAllRow', 'isString': 0 },
{ 'name': 'onBeforeShowData', 'isString': 0 },
{ 'name': 'onAfterShowData', 'isString': 0 },
{ 'name': 'onError', 'isString': 0 },
{ 'name': 'onSubmit', 'isString': 0 },
{ 'name': 'onReload', 'isString': 0 },
{ 'name': 'onToFirst', 'isString': 0 },
{ 'name': 'onToPrev', 'isString': 0 },
{ 'name': 'onToNext', 'isString': 0 },
{ 'name': 'onToLast', 'isString': 0 },
{ 'name': 'onAfterAddRow', 'isString': 0 },
{ 'name': 'onBeforeEdit', 'isString': 0 },
{ 'name': 'onBeforeSubmitEdit', 'isString': 0 },
{ 'name': 'onAfterEdit', 'isString': 0 },
{ 'name': 'onLoading', 'isString': 0 },
{ 'name': 'onLoaded', 'isString': 0 },
{ 'name': 'onContextmenu', 'isString': 0 },
{ 'name': 'onBeforeCancelEdit', 'isString': 0 },
{ 'name': 'onAfterSubmitEdit', 'isString': 0 },
{ 'name': 'onRowDragDrop', 'isString': 0 },
{ 'name': 'onGroupExtend', 'isString': 0 },
{ 'name': 'onGroupCollapse', 'isString': 0 },
{ 'name': 'onTreeExpand', 'isString': 0 },
{ 'name': 'onTreeCollapse', 'isString': 0 },
{ 'name': 'onTreeExpanded', 'isString': 0 },
{ 'name': 'onTreeCollapsed', 'isString': 0 },
{ 'name': 'onLoadData', 'isString': 0 }
];

var gridColumnOptions = [
{ 'name': 'align', 'isString': 1 },
{ 'name': 'type', 'isString': 1 },
{ 'name': 'id', 'isString': 0 },
{ 'name': 'name', 'isString': 0 },
{ 'name': 'totalSummary', 'isString': 0 },
{ 'name': 'display', 'isString': 0 },
{ 'name': 'headerRender', 'isString': 0 },
{ 'name': 'isAllowHide', 'isString': 0 },
{ 'name': 'isSort', 'isString': 0 },
{ 'name': 'columns', 'isString': 0 },
{ 'name': 'width', 'isString': 0 },
{ 'name': 'minWidth', 'isString': 0 },
{ 'name': 'format', 'isString': 0 },
{ 'name': 'hide', 'isString': 0 },
{ 'name': 'editor', 'isString': 0 },
{ 'name': 'render', 'isString': 0 },
{ 'name': 'textField', 'isString': 0 }
];

$('table[data-ui=ligerGrid]').each(function () {
    var $table = $(this);
    var props = {};

    if ($table.data('initobj') != null) {
        props = eval($table.data('initobj'));
    }

    $.each(gridOptions, function (i, t) {
        var data = $table.data(t.name.toLowerCase());
        if (data != null) {
            if (t.isString == 1)
                props[t.name] = data;
            else
                props[t.name] = eval(data);
        }
    });
    if ($table.data('jsdata') != null) {
        props['data'] = eval($table.data('jsdata'));
    }

    var columns = [];
    $table.find('th').each(function () {
        $col = $(this);
        var col = {};

        $.each(gridColumnOptions, function (i, t) {
            var data = $col.data(t.name.toLowerCase());
            if (data != null) {
                if(t.isString == 1)
                    col[t.name] = data;
                else
                    col[t.name] = eval(data);
            }
        });

        col['display'] = $col.text();
        if ($col.data('column-id') != null)
            col['name'] = $col.data('column-id');
        else if ($col.data('field-id') != null)
            col['name'] = $col.data('field-id');

        columns.push(col);
    });
    props.columns = columns;

    // error process
    var store = props.onSuccess;
    props.onSuccess = function (d,c) {
        if (d && d.__ajaxError && d.__ajaxError == 'yes') {
            alert(d.message +'\nurl: ' + d.url);
        } else if (store != null && typeof (store) == 'function') {
            store(d,c);
        }
    };

    var $tableId = $table.attr('id');
    if ($tableId == null) $tableId = 'grid_' + Math.floor(Math.random() * 1000000000);

    $table.hide();
    window[$tableId] = $table.parent().append('<div id="xxx"></div>').ligerGrid(props);
});


//参数说明：num 要格式化的数字 n 保留小数位
function formatNum(num, n) {
    try {
        num = String(num.toFixed(n));
    } catch (e) {
        num = NaN;
    }
    var re = /(-?\d+)(\d{3})/;
    while (re.test(num)) {
        num = num.replace(re, "$1,$2");
    }
    return num;
}

$.ligerDefaults.Grid.formatters['currency'] = function (num, col) {
    if (num == null)
        return '';
    else
        return formatNum(num, 2);
};


/////////////////////////////////////////////////////
//
// ligerComboBox
//
/////////////////////////////////////////////////////

var comboBoxOptions = [
{ 'name': 'resize', 'isString': 0 },
{ 'name': 'isMultiSelect', 'isString': 0 },
{ 'name': 'isShowCheckBox', 'isString': 0 },
{ 'name': 'columns', 'isString': 0 },
{ 'name': 'selectBoxWidth', 'isString': 0 },
{ 'name': 'selectBoxHeight', 'isString': 0 },
{ 'name': 'onBeforeSelect', 'isString': 0 },
{ 'name': 'onSelected', 'isString': 0 },
{ 'name': 'initValue', 'isString': 0 },
{ 'name': 'initText', 'isString': 0 },
{ 'name': 'valueField', 'isString': 1 },
{ 'name': 'textField', 'isString': 1 },
{ 'name': 'valueFieldID', 'isString': 1 },
{ 'name': 'slide', 'isString': 0 },
{ 'name': 'split', 'isString': 1 },
{ 'name': 'data', 'isString': 0 },
{ 'name': 'tree', 'isString': 0 },
{ 'name': 'treeLeafOnly', 'isString': 0 },
{ 'name': 'condition', 'isString': 0 },
{ 'name': 'grid', 'isString': 0 },
{ 'name': 'onStartResize', 'isString': 0 },
{ 'name': 'onEndResize', 'isString': 0 },
{ 'name': 'hideOnLoseFocus', 'isString': 0 },
{ 'name': 'hideGridOnLoseFocus', 'isString': 0 },
{ 'name': 'url', 'isString': 1 },
{ 'name': 'emptyText', 'isString': 1 },
{ 'name': 'addRowButton', 'isString': 1 },
{ 'name': 'addRowButtonClick', 'isString': 0 },
{ 'name': 'triggerIcon', 'isString': 1 },
{ 'name': 'onSuccess', 'isString': 0 },
{ 'name': 'onError', 'isString': 0 },
{ 'name': 'onBeforeOpen', 'isString': 0 },
{ 'name': 'onButtonClick', 'isString': 0 },
{ 'name': 'render', 'isString': 0 },
{ 'name': 'absolute', 'isString': 0 },
{ 'name': 'cancelable', 'isString': 0 },
{ 'name': 'css', 'isString': 1 },
{ 'name': 'parms', 'isString': 1 },
{ 'name': 'renderItem', 'isString': 1 },
{ 'name': 'autocomplete', 'isString': 0 },
{ 'name': 'highLight', 'isString': 0 },
{ 'name': 'readonly', 'isString': 0 },
{ 'name': 'ajaxType', 'isString': 1 },
{ 'name': 'alwayShowInTop', 'isString': 0 },
{ 'name': 'valueFieldCssClass', 'isString': 1 }
];

$('input[data-ui=ligerComboBox]').each(function () {
    var $input = $(this);
    var props = {};

    if ($input.data('initobj') != null) {
        props = eval($input.data('initobj'));
    }

    $.each(comboBoxOptions, function (i, t) {
        var data = $input.data(t.name.toLowerCase());
        if (data != null) {
            if (t.isString == 1)
                props[t.name] = data;
            else
                props[t.name] = eval(data);
        }
    });
    if ($input.data('jsdata') != null) {
        props['data'] = eval($input.data('jsdata'));
    }

    var $inputId = $input.attr('id');
    if ($inputId == null) $inputId = 'combobox_' + Math.floor(Math.random() * 1000000000);
    window[$inputId] = $input.ligerComboBox(props);

});

$('div[data-ui=ligerTree]').each(function () {
    var $div = $(this);
    var props = {};

    if ($div.data('initobj') != null) {
        props = eval($div.data('initobj'));
    }
    var $divId = $div.attr('id');
    if ($divId == null) $divId = 'ligertree_' + Math.floor(Math.random() * 1000000000);
    window[$divId] = $div.ligerTree(props);
});