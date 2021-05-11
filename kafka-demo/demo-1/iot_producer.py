from confluent_kafka import Producer
import random
import json
import signal
import sys
import time

if ( len(sys.argv) <6 ):
    print("Usage: python3 iot_producer.py <broker url:port> <topic> <sensor_id> <sensor_min> <sensor_max>")
    exit()


def signal_handler(sig, frame):
    print('Goodbye, thank you for running me!')
    sys.exit(0)
signal.signal(signal.SIGINT, signal_handler)
print('Press Ctrl+C to exit')

p = Producer({'bootstrap.servers': sys.argv[1]})

def delivery_report(err, msg):
    """ Called once for each message produced to indicate delivery result.
        Triggered by poll() or flush(). """
    if err is not None:
        print('Message delivery failed: {}'.format(err))
    else:
        print('Message delivered to {} [{}]'.format(msg.topic(), msg.partition()))

while True:
    # Asynchronously produce a message, the delivery report callback
    # will be triggered from poll() above, or flush() below, when the message has
    # been successfully delivered or failed permanently.
    msg = {'sensor_id':sys.argv[3], 'value':random.randint(int(sys.argv[4]), int(sys.argv[5]))}
    print('MSG= ', json.dumps(msg))
    p.produce(sys.argv[2], json.dumps(msg).encode('utf-8'), callback=delivery_report)
    # Trigger any available delivery report callbacks from previous produce() calls
    p.poll(0)
    # Random delay..
    for t in range(1,random.randint(3, 10)):
        print('.', end =' ', flush=True)
        time.sleep(1)

# Wait for any outstanding messages to be delivered and delivery report
# callbacks to be triggered.
p.flush()
