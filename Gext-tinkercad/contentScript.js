var LOG_PREFIX = "[TinkerCad WireTap] ";
console.log(LOG_PREFIX, 'Wire tapping TinkerCad?... SUCCESS.');

$( document ).ready(function() {

    var log = function(){
        var args = Array.prototype.slice.call(arguments);
        args.unshift(LOG_PREFIX);
        console.log.apply(console, args);
    }

    // Credit: https://stackoverflow.com/a/2117523
    function uuidv4() {
        return ([1e7]+-1e3+-4e3+-8e3+-1e11).replace(/[018]/g, c =>
            (c ^ crypto.getRandomValues(new Uint8Array(1))[0] & 15 >> c / 4).toString(16)
        );
    }

    var timeout = null;

    function doTap(){
        var myUUID = null;
        log('Looking for serial monitor element..');
        var serial_monitor = $('body').find('div.code_panel__serial__content__text.js-code_panel__serial__text.js-code_editor__serial-monitor__content');
        if ( serial_monitor.length==0 ) {
            log('Look for iframe Thing');
            serial_monitor = $('body').find('iframe').contents().find('#main > div > div > div.editor.js-root_container > div.js-tpl-target__code_panel > div > div.code_panel__serial.js-code_panel__serial > div.code_panel__serial__content.js-code_panel__serial__content > div.code_panel__serial__top > div.code_panel__serial__content__text.js-code_panel__serial__text.js-code_editor__serial-monitor__content');
        }
        else {
            log('My Thing - Found in body');
        }

        log("Serial monitor textarea:", serial_monitor);
        if (serial_monitor.length>0){
            var refresh_delay ="0";
            var post_endpoint = null;
            var containsOnlyDigits = /^[0-9]+$/;
            do {
                refresh_delay = prompt("Serial monitor sampling interval (msec, >=500): ");
            } while(!containsOnlyDigits.test(refresh_delay) || refresh_delay<500);
            post_endpoint = prompt("POST endpoint: ");

            myUUID = uuidv4();
            log(myUUID, 'Serial monitor sampling period: '+refresh_delay+'msec');
            chrome.storage.local.set({"TCWTuuid": myUUID}, function() {
                log(myUUID, 'TCWTuuid is set to ' + myUUID);
            });

            var canMonitor = true;
            clearTimeout(timeout);
            var h = function(ev){
                chrome.storage.local.get("TCWTuuid", ({ TCWTuuid }) => {
                  if ( TCWTuuid==myUUID && canMonitor ){
                      var text = serial_monitor.text();
                      if (text.length>0){
                          var lines = text.split("\n");
                          // console.log('Serial changed: '+ text.split("\n").length);
                          if ( lines.length>1 ){
                              var latest_value = lines[lines.length-2];
                              log(myUUID, 'Last serial monitor value: '+latest_value);
                              canMonitor = false;
                              if ( post_endpoint && post_endpoint.length>0) {
                                  try {
                                    log("POST ", post_endpoint, latest_value);
                                    var post_data = JSON.stringify({'source': window.location.href, 'value':latest_value});
                                    $.ajax({
                                        type: "POST",
                                        contentType: 'application/json',
                                        url: post_endpoint,
                                        dataType: 'json',
                                        data: post_data
                                    })
                                    .done(function(){ log(myUUID, 'POST success.', post_data); })
                                    .fail(function(xhr, status, error) { log(myUUID, 'POST fail: ', status, error, xhr); });
                                  }
                                    catch(err) {
                                    log( err.message );
                                  }
                              }
                              log(myUUID, 'Sampling serial monitor again in ', refresh_delay);
                              timeout = setTimeout(function(){ canMonitor = true; }, refresh_delay);
                          }
                      }
                  }
                });
            };
            serial_monitor.bind('DOMSubtreeModified', h);
        }
        else {
            setTimeout(doTap, 5000); // 5sec after load, check Start/Stop Simulation button
        }
    }
    doTap();
});
