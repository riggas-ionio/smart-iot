   var mqtt;
   var reconnectTimeout = 2000;
   var host="192.168.1.163"; //change this
   var host="82.165.158.236";
   //var host="steve-laptop"; //change this
   var host="test.mosquitto.org";
   var port=1833
   //var port=9001;
   //var port=8881;

   function onConnect() {
 // Once a connection has been made, make a subscription and send a message.

   console.log("Connected ");
   //mqtt.subscribe("sensor1");
   message = new Paho.MQTT.Message("Hello World");
   message.destinationName = "sensor1";
   mqtt.send(message);
 }
 function MQTTconnect() {
   console.log("connecting to "+ host +" "+ port);
       var x=Math.floor(Math.random() * 10000);
   var cname="orderform-"+x;
   mqtt = new Paho.MQTT.Client(host,port,cname);
   //document.write("connecting to "+ host);
   var options = {

       timeout: 3,
       onSuccess: onConnect,

    };

   mqtt.connect(options); //connect
   }
