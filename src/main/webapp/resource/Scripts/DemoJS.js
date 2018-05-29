$(function () {
    textAdaptive();

    $(".topImage").colorbox({
        //transition: "none",
        width: "85%",
        height: "85%",
        scrolling: false,
        opacity: 0.5,
        close: "×"
    });
    function textAdaptive() {
        var textarea = document.getElementById("txtHtml");
        if (textarea) {
            var aa = textarea.scrollHeight;//IE8需要先获取一次才可以
            $("#txtHtml").height(textarea.scrollHeight);
        }
    }
});

