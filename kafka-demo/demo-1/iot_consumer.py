from confluent_kafka import Consumer
import random
import json
import signal
import sys
import time

if ( len(sys.argv) <3 ):
    print("Usage: python3 iot_consumer.py <broker url:port> <topic> ")
    exit()


def signal_handler(sig, frame):
    print('Goodbye, thank you for running me!')
    sys.exit(0)
signal.signal(signal.SIGINT, signal_handler)
print('Press Ctrl+C to exit')


c = Consumer({
    'bootstrap.servers': sys.argv[1],
    'group.id': 'demogroup',
    'auto.offset.reset': 'earliest'
})

c.subscribe([sys.argv[2]])

while True:
    msg = c.poll(1.0)

    if msg is None:
        continue
    if msg.error():
        print("Consumer error: {}".format(msg.error()))
        continue
    print('Received message: {}'.format(msg.value().decode('utf-8')))

c.close()
