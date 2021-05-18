package demo.streams;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to Kafka Streams demo.\n\n" );

        java.util.Scanner sc = new java.util.Scanner(System.in);
        int ch = -1;
        String topic ;
        System.out.println("Run Kafka Streams app:");
        System.out.println("\t1. Peek stream");
        System.out.println("\t2. Modify stream");
        System.out.println("\t3. Filter stream");
        System.out.println("\t4. ReMap stream");
        System.out.println("\t5. Write back to another stream");
        System.out.println("\t6. Aggregate");

        System.out.println("\t0. Exit");
        System.out.print("Choose app [type menu number]: ");
        ch = sc.nextInt();

        // System.out.println("Running "+ch);
        switch(ch){
            case 1:
                sc.nextLine();
                System.out.print("Peek topic [type topic name]?... ");
                topic = sc.nextLine();
                new Peek( topic );
                break;
            case 2:
                sc.nextLine();
                System.out.print("Modify topic values [type topic name]?... ");
                topic = sc.nextLine();
                new Modify( topic );
                break;
            case 3:
                sc.nextLine();
                System.out.print("Filter topic values [type topic name]?... ");
                topic = sc.nextLine();
                System.out.print("Filter sensor values [type sensor id]?... ");
                String sensor_id = sc.nextLine();
                new Filter( topic, sensor_id );
                break;
            case 4:
                sc.nextLine();
                System.out.print("Modify topic values [type topic name]?... ");
                topic = sc.nextLine();
                new ReMap( topic );
                break;
            case 5:
                sc.nextLine();
                System.out.print("Write back per sensor values of topic [type topic name]?... ");
                topic = sc.nextLine();
                new PublishBack( topic );
                break;
            case 6:
                sc.nextLine();
                System.out.print("Aggregate per server values of topic [type topic name]?... ");
                topic = sc.nextLine();
                new Aggregate( topic );
                break;
            case 0:
                System.out.print("\nGoodbye!\n\n");
                break;
        }
    }
}
