$(document).ready(function myFunction() {
    var text
    var imgLink
    $(".show-mindow").click(function myFunction() {

        var timeout = 5000;
        $('.selectDelay').each(function (k, objSel) {
            if (objSel.selectedIndex != -1) {
                timeout = parseInt(objSel.options[objSel.selectedIndex].value);
            }
        });


        var tick = timeout
        $('.snippet').each(function (k, obj) {
            console.log(obj)
            setTimeout(function () {

                text = obj.innerText
                imgLink = $(obj).find("img")[0].currentSrc
                checkForm(obj.innerText, $(obj).find("img")[0].currentSrc)

            }, timeout);
            timeout += tick;

        });
    });
});

var myAlert
function checkForm(text, imgLink) {
    myAlert = window.open('', 'alert', "width = 400, height = 400, top = 200, left = 200")
    var wC = '<html><head></head><body onBlur="self.focus();">'
    wC += "This is reminder text " + text + " DEAR"
    debugger
    wC += '<img src=' + imgLink + ' width="300" height=auto >'
    wC += '</body></html>'
    myAlert.document.open()
    myAlert.document.write(wC)
}










