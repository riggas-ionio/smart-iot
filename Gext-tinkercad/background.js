chrome.browserAction.onClicked.addListener(function (tab) {
    if (tab.url.indexOf("https://www.tinkercad.com/things/") != -1) {
        chrome.tabs.executeScript(tab.id, { "file": "lib/jquery-3.5.1.min.js" }, function() {
            chrome.tabs.executeScript(tab.id, { "file": "contentScript.js" });
        });
    }
});
