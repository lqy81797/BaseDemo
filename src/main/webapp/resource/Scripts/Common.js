function fnOpenWindowEx(strUrl, nWidth, nHeight) {
    var xMax = 0;
    var yMax = 0;
    xMax = screen.width;
    yMax = screen.height;

    var xOffset = (xMax - nWidth) / 2;
    var yOffset = (yMax - nHeight) / 2;

    window.open(strUrl, "", "height=" + nHeight.toString() + ", width=" + nWidth.toString() + ", top=" + yOffset + ", left=" + xOffset + ", toolbar=no, menubar=no, scrollbars=1, resizable=yes,location=no, status=no");
    return false;
}
