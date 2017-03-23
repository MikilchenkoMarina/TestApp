$(document).ready(function myFunction() {

    $("#show-window").click(function myFunction() {
        var text
        var imgLink
        var myAlert
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
                debugger
                text = obj.innerText
                imgLink = $(obj).find("img")[0].currentSrc
                checkForm(obj.innerText, $(obj).find("img")[0].currentSrc)

            }, timeout);

            timeout += tick;

        });


        function checkForm(text, imgLink) {
            myAlert = window.open('', 'alert', "width = 450, height = 450, top = 100, left = 100")
            var wC = '<html><head>'
            wC += '<link href="/resources/css/reminder-window.css" rel="stylesheet">'
            wC += '</head>'
            wC += '<body onBlur="self.focus();">'

            wC += '<div></div><h3> You wanted to remember this : </br></p><div></div>'
            wC += '<h2>' + text + '</h2>'
            wC += '<img src=' + imgLink + '>'

            wC += '</body></html>'
            myAlert.document.open()
            myAlert.document.write(wC)
        }
    });
});









