package demo.streams;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KGroupedStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.Serialized;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.Initializer;
import org.apache.kafka.streams.kstream.Aggregator;
import org.apache.kafka.common.serialization.Serdes;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PublishBack{
    public PublishBack(String topic){
        System.out.println("\n\nAggregating "+topic+"\n");

        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "stream-aggregate--"+RandomStringUtils.randomAlphanumeric(6));
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:19092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        final StreamsBuilder builder = new StreamsBuilder();

        KStream<String, String> source = builder.stream(topic);

        KStream<String, Integer> stream =
            source
            .peek((k, v) -> {
                System.out.println(props.get(StreamsConfig.APPLICATION_ID_CONFIG) + "  Received: Key = " + k + " Value = " + v);
            })
            .map((k, v) -> {
                ObjectMapper mapper = new ObjectMapper();
                try {
                    Map<String, Object> map = mapper.readValue(v, Map.class);
                    return new KeyValue<String, Integer>((String)map.get("sensor_id"), (Integer)map.get("value"));
                } catch (IOException ioe){System.out.println(ioe);}
                return new KeyValue<String, Integer>(null, null);
            })
            .filter((k, v) -> k!=null && v != null )
            .peek((k, v) -> {
                System.out.println(props.get(StreamsConfig.APPLICATION_ID_CONFIG) + "  ReMapped: Key = " + k + " Value = " + v);
            });

        stream.to(topic+"_remapped", Produced.with(Serdes.String(), Serdes.Integer()) );

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
