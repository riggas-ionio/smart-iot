import paho.mqtt.client as mqtt
from confluent_kafka import Producer
import signal
import sys
import time

if ( len(sys.argv) <6 ):
    print("Usage: python3 mqtt_to_kafka.py <mqtt broker url> <mqtt broker port> <mqtt topic> <kafka broker url:port> <kafka topic> ")
    exit()

mqtt_client = mqtt.Client("MQTT2KafkaBridge")
mqtt_client.connect(sys.argv[1], int(sys.argv[2]))

kafka_producer = Producer({'bootstrap.servers': sys.argv[4]})

def signal_handler(sig, frame):
    print('Goodbye, thank you for running me!')
    mqtt_client.loop_stop()
    kafka_producer.flush()
    sys.exit(0)
signal.signal(signal.SIGINT, signal_handler)
print('Press Ctrl+C to exit')

def delivery_report(err, msg):
    """ Called once for each message produced to indicate delivery result.
        Triggered by poll() or flush(). """
    if err is not None:
        print('Message delivery failed: {}'.format(err))
    else:
        print('Message delivered to {} [{}]'.format(msg.topic(), msg.partition()))

def on_message(client, userdata, message):
    msg = message.payload
    msg = msg.decode("utf-8")
    print("Got MQTT message: ", msg)
    kafka_producer.produce(sys.argv[5], msg.encode('utf-8'), callback=delivery_report)
    print("Pubished to Kafka topic '"+sys.argv[5]+"' " + msg )
    kafka_producer.poll(0)


mqtt_client.loop_start()
mqtt_client.subscribe(sys.argv[3])
mqtt_client.on_message = on_message

while True:
    time.sleep(1)
