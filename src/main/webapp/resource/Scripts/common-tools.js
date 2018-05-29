function formatFileSize(bytes) {
    if (typeof bytes !== 'number') {
        return '';
    }
    if (bytes >= 1000000000) {
        return (bytes / 1000000000).toFixed(2) + ' GB';
    }
    if (bytes >= 1000000) {
        return (bytes / 1000000).toFixed(2) + ' MB';
    }
    return (bytes / 1000).toFixed(2) + ' KB';
}

String.prototype.trim = function () {
    return this.replace(/(^\s*)|(\s*$)/g, "");
}

if (!String.prototype.format) {
    String.prototype.format = function () {
        var args = arguments;
        return this.replace(/{(\d+)}/g, function (match, number) {
            return typeof args[number] != 'undefined' ? args[number] : match;
        });
    };
}

Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt
                = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

function elapsedDays(d) {
    var day = d.substring(0, 10).split('-');
    var publishDate = new Date(parseInt(day[0]), parseInt(day[1]) - 1, parseInt(day[2]));
    var diffDays = parseInt(((new Date()) - publishDate) / (1000 * 60 * 60 * 24));
    return diffDays;
}

function openModuleDialogue(width, height, url) {
    var lPos = (screen.width) ? (screen.width - width) / 2 : 0;
    var tPos = (screen.height) > height ? (screen.height - height) / 3 : 0;
    window.open(url, "_blank", "width=" + width + ",height=" + height + ",top=" + tPos + ",left=" + lPos + ",toolbar=no,scrollBars=yes,menubar=no,resizable=no");
}

function openWindow(width, height, url) {
    var lPos = (screen.width) ? (screen.width - width) / 2 : 0;
    var tPos = (screen.height) > height ? (screen.height - height) / 3 : 0;
    window.open(url, "_blank", "width=" + width + ",height=" + height + ",top=" + tPos + ",left=" + lPos + ",toolbar=no,scrollBars=yes,menubar=no,resizable=yes");
}

function setHash(value) {
    window.location.hash = value;
}

// 点击树形菜单标题
$(".treehead").click(function () {
    var visible = $(this).parent().find('.tree').is(':visible');
    if (visible) {
        $(this).parent().find('.tree').hide();
        $(this).find('.TreeExpandFlag').removeClass('TreeTitleExpanded').addClass('TreeTitleCollapsed');
    } else {
        $(this).parent().find('.tree').show();
        $(this).find('.TreeExpandFlag').removeClass('TreeTitleCollapsed').addClass('TreeTitleExpanded');
    }
});
