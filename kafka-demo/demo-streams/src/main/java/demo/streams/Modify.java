package demo.streams;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.common.serialization.Serdes;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.lang3.RandomStringUtils;

public class Modify{
    public Modify(String topic){
        System.out.println("\n\nModifying "+topic+"\n");

        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "stream-modify-"+RandomStringUtils.randomAlphanumeric(6));
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:19092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        final StreamsBuilder builder = new StreamsBuilder();

        KStream<String, String> source = builder.stream(topic);

        source
            .peek((k, v) -> {
                System.out.println(props.get(StreamsConfig.APPLICATION_ID_CONFIG) + "  Received: Key = " + k + " Value = " + v);
            })
            .flatMapValues(v -> Arrays.asList(v.toUpperCase()) )
            .peek((k, v) -> {
                System.out.println(props.get(StreamsConfig.APPLICATION_ID_CONFIG) + "  Modified: Key = " + k + " Value = " + v);
            });

        final Topology topology = builder.build();
        System.out.println("Topology: \n"+topology.describe());

        final KafkaStreams streams = new KafkaStreams(topology, props);
        final CountDownLatch latch = new CountDownLatch(1);
        // attach shutdown handler to catch control-c
        Runtime.getRuntime().addShutdownHook(new Thread("streams-shutdown-hook") {
            @Override
            public void run() {
                System.out.println("Shutting down kafka consumer: "+ props.get(StreamsConfig.APPLICATION_ID_CONFIG));
                streams.close();
                latch.countDown();
            }
        });

        try {
            System.out.println("Start kafka consumer: "+ props.get(StreamsConfig.APPLICATION_ID_CONFIG));
            streams.start();
            latch.await();
        } catch (Throwable e) {
            System.err.println(e);
        }
    }
}
