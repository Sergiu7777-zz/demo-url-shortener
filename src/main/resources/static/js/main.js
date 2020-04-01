function copyLink() {
    var copyText = document.getElementById("js-url-input");
    var range = document.createRange();
    range.selectNode(copyText);
    window.getSelection().removeAllRanges();
    window.getSelection().addRange(range);
    document.execCommand("copy");
    window.getSelection().removeAllRanges();

    var tooltip = document.getElementById("myTooltip");
    tooltip.innerHTML = "Copied!";
}

function outFunction() {
    var tooltip = document.getElementById("myTooltip");
    tooltip.innerHTML = "Copy to clipboard";
}

function resetAllFields() {
    document.getElementById("js-url-input").innerHTML = "";
}

function toggleButton(ref,bttnID){
    document.getElementById(bttnID).disabled= ((ref.value === ref.defaultValue));
}