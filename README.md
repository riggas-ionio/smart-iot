# DDI196 Έξυπνες Τεχνολογίες και εφαρμογές

Σε αυτό το repository μπορείτε να βρείτε χρήσιμο υλικό για το μάθημα DDI196 Έξυπνες Τεχνολογίες και εφαρμογές.

---

## Lab #1
* Γνωριμία με [Arduino](https://youtu.be/IV49AxTpOmw), [Breadboard](https://youtu.be/IjUNCm3haNg) σύνδεσης ηλεκτρονικών & [Tinkercad](https://youtu.be/tRz5ybWVbyQ).  
* Γνωρίστε [εναλλακτικές εκδόσεις](https://www.arduino.cc/en/main/products) του Arduino.

***Task (στο TinkerCad):***

* Δημιουργήστε student account TinkerCad link: https://www.tinkercad.com/joinclass/5WTNW9UDV (Join with email / username).
* Δημιουργήστε ένα κύκλωμα Arduino - αντίστασης - led και το σχετικό πρόγραμμα το οποίο ανάβει και σβύνει το led κάθε 1 sec.
* Δημιουργήστε ένα κύκλωμα Arduino - αντίστασης - led και το σχετικό πρόγραμμα το οποίο ανάβει και σβύνει το led κάθε 1, μετά κάθε 2, μετά κάθε 3, κ.ο.κ. μέχρι 5 sec και στη συνέχεια ο χρόνος να μειώνεται σε κάθε επανάληψη.

## Lab #2
* Γνωριμία με συνδεσμολογία [κουμπιού εισόδου και χρήση αντιστάσεων pull-up/down](https://youtu.be/riLNkdNt4gg).
* Εναλλακτική συνδεσμολογία με [αξιοποίηση εσωτερικής pull-up αντίστασης](https://docs.arduino.cc/tutorials/generic/digital-input-pullup).
* Λίγο περισσότερα για τα [ψηφιακά pins](https://www.arduino.cc/en/Tutorial/Foundations/DigitalPins) του Arduino.
* Λίγο περισσότερα για τος [pull-up/down αντιστάσεις](https://www.seeedstudio.com/blog/2020/02/21/pull-up-resistor-vs-pull-down-differences-arduino-guide/).

***Task (στο TinkerCad):***

* Δημιουργήστε ένα φανάρι οχημάτων & πεζών, με το τελευταίο να ελέγχεται από κουμπί.

## Lab #3
* Γνωρίμία [αξιοποίησης ποτενσιόμετρου](https://youtu.be/_pft_oqDJUA) για αναλογική είσοδο.   
Οι αναλογικές είσοδοι του Arduino (`A0`-`A5`) δέχονται ως είσοδο μία τάση, τυπικά `0`-`5V`, και μέσω ενός [analog to digital converter](https://learn.sparkfun.com/tutorials/analog-to-digital-conversion/all) την αντιστοιχούν σε μια 10 bit τιμή, δλδ μεταξύ `0` και <code>2^<sup>10</sup>-1</code> (δλδ 1023). Η ανάγνωση από την αναλογική είσοδο διαρκεί ~100μsec.  
Διαβάζουμε από μια αναλογική είσοδο με χρήση της [`analogRead()`](https://www.arduino.cc/reference/en/language/functions/analog-io/analogread/).  
Πολύ συχνά, η εφαρμογή που θέλουμε να σχεδιάσουμε απαιτεί να αντιστοιχήσουμε το εύρος τιμών που διαβάζουμε από την `analogRead()` σε ένα άλλο, πχ το `0`-`1023` σε `1`-`10`. Μια χρήσιμη διαθέσιμη συνάρτηση είναι η [`map()`](https://www.arduino.cc/reference/en/language/functions/math/map/).
* _There has never been an unexpectedly short debugging period in the history of computers._ <sub>Steven Levy</sub>  
Ένα πολύ χρήσιμο εργαλείο του Arduino το οποίο μπορεί να βοηθήσει και στην εκσφαλμάτωση του κώδικα (ή των συνδέσεων του υλικού σας) είναι το [Serial Monitor](https://docs.arduino.cc/software/ide-v2/tutorials/ide-v2-serial-monitor). Μπορείτε να αξιοποιήσετε ένα virtual [Serial Monitor στο Tinkercad](https://www.instructables.com/Arduino-Serial-Monitor-in-Tinkercad/).  

***Task (στο TinkerCad):***

* Δημιουργήστε ένα κύκλωμα με ένα Arduino και ένα ποτενσιόμετρο (όπως αυτή στο [roboticsbackend.com](https://roboticsbackend.com/wp-content/uploads/2021/09/arduino_potentiometer_circuit.png)) και δημιουργήστε τον ανάλογο κώδικα στο Arduino ώστε να _διαβάζετε_ την τιμή που δίνει το ποτενσιόμετρο και να εκτυπώνει στο Serial Monitor την τιμή εισόδου και σε τι voltage αυτή αναλογεί.
* Χρησιμοποιήστε ένα (virtual) [πολύμετρο](https://www.tutocad.com/tinkercad/how-to-use-multimeter-in-tinkercad/) για να επιβεβαιώσετε την ορθότητα της μέτρησής σας.
* Η τιμή αναλογικής εισόδου από το (virtual) ποτενσιόμετρο είναι σταθερή;  
Στον πραγματικό κόσμο πολύ συχνά χρειάζεται κάποια [σταθεροποίηση ή φιλτράρισμα](https://www.norwegiancreations.com/2015/10/tutorial-potentiometers-with-arduino-and-filtering/).
* Δημιουργήστε ένα νέο κύκλωμα το οποίο να περιλαμβάνει ένα Arduino, ένα ποτενσιόμετρο και τρία led (πράσσινο, κίτρινο κόκκινο). Δημιουργήστε κώδικα ο οποίος ανάλογα με την τιμή αναλογικής εισόδου από το πολύμετρο ανάβει ένα από τα led ώστε να προσομοιώνει ένα κύκλωμα ελέγχου και οπτικής ανάδρασης προς το χρήστη.

## Lab #4
* Γνωριμία με τον [Paralax Ping Ultrasonic Distance Sensor](https://docs.arduino.cc/built-in-examples/sensors/Ping) ένα **ψηφιακό** αισθητήρα μέρτησης απόστασης.  
Ο αισθητήρας Paralax Ping είναι ψηφιακός, άρα εκτός της τροφοδοσίας και γείωσης σύνδέεται σε ένα ψηφιακό pin του Arduino.  
Ανιχνεύει την απόσταση του πλησιέστερου αντικειμένου μπροστά από τον αισθητήρα (από 3 cm έως 400 cm). Λειτουργεί στέλνοντας μια ριπή υπερήχων και ακούγοντας την ηχώ όταν αυτή ανακλάται από ένα αντικείμενο. Για την αξιοποίησή του η πλακέτα Arduino στέλνει έναν σύντομο παλμό στον αισθητήρα για να ενεργοποιήσει την ανίχνευση και στη συνέχεια _ακούει_ για έναν παλμό στον ίδιο ακροδέκτη χρησιμοποιώντας τη συνάρτηση [pulseIn()](https://www.arduino.cc/en/Reference/PulseIn). Η διάρκεια αυτού του δεύτερου παλμού είναι ίση με το χρόνο που χρειάζεται ο υπέρηχος για να ταξιδέψει στο αντικείμενο και να επιστρέψει στον αισθητήρα. Χρησιμοποιώντας την ταχύτητα του ήχου, ο χρόνος αυτός μπορεί να μετατραπεί σε απόσταση. Σύμφωνα με το datasheet του αισθητήρα:
    ```
    // The speed of sound is 340 m/s or 29 microseconds per centimeter.
    // The ping travels out and back, so to find the distance of the object we
    // take half of the distance travelled.
    distance_in_cm = microseconds / 29 / 2

    ```

***Task (στο TinkerCad):***

* Δημιουργήστε ένα κεύκλωμα με ένα Arduino και ένα Paralax Ping αισθητήρα απόστασης (όπως αυτό στο [docs.arduino.cc](https://docs.arduino.cc/static/63725f847ef17bddd93d409ce6fb2218/a6d36/circuit.png)) και δημιουργήστε ανάλογο κώδικα στο Arduino ώστε να διαβαζετε την τιμή του αισθητήρα και να εκτυπώνετε την απόσταση που αντιστοιχεί σε μέτρα με δύο δεκαδικά ψηφία.
* Στη συνέχεια, υλοποιήστε την πρώτη υποχρεωτική εργασία που έχει αναρτηθεί στο opencourses.

## Lab #5
* Γνωριμία με τον [PIR Motion Sensor](https://learn.adafruit.com/pir-passive-infrared-proximity-motion-sensor) ένα **ψηφιακό** αισθητήρα κίνησης.  
Ο αισθητήρας PIR Motion Sensor είναι ψηφιακός, άρα εκτός της τροφοδοσίας και γείωσης σύνδέεται σε ένα ψηφιακό pin του Arduino.  
Οι αισθητήρες PIR επιτρέπουν να αντιλαμβάνεστε την κίνηση και χρησιμοποιούνται σχεδόν πάντα για να ανιχνεύσουν αν ένας άνθρωπος έχει μετακινηθεί εντός ή εκτός της εμβέλειας των αισθητήρων.
Όταν ο αισθητήρας βρίσκεται σε αδράνεια απλά ανιχνεύει την περιβαλλοντική ποσότητα υπέρυθρης ακτινοβολίας που εκπέμπεται από το δωμάτιο, τους τοίχους ή το εξωτερικό χώρο. Όταν ένα θερμό σώμα, όπως ένας άνθρωπος ή ένα ζώο, περνάει από μπροστά του, ο αισθητήρας παράγει μια μεταβολή η οποία ανιχνεύεται.  
Η σύνδεσή του σε ένα Arduino γίνεται με τα pins [5V, GRD και ένα ψηφιακό pin _ως είσοδο_](https://cdn-learn.adafruit.com/assets/assets/000/000/543/large1024/proximity_pirardbb.gif?1447976079).   
Ο προγραμματισμός απλά απαιτεί την ανάγνωση της τιμής του αντίστοιχου pin με χρήση της [digitalRead()](https://www.arduino.cc/reference/en/language/functions/digital-io/digitalread/) και έλεγχο αν η τιμή του είναι `LOW` ή `HIGH`.
* Γνωριμία με το [Servo motor](https://docs.arduino.cc/learn/electronics/servo-motors).  
Ο σερβοκινητήρας είναι μια μικρή συσκευή που διαθέτει έναν άξονα εξόδου. Αυτός ο άξονας μπορεί να τοποθετηθεί σε συγκεκριμένες γωνιακές θέσεις στέλνοντας στον σερβοκινητήρα ένα κωδικοποιημένο σήμα. Όσο το κωδικοποιημένο σήμα υπάρχει στη γραμμή εισόδου, ο σερβοκινητήρας διατηρεί τη γωνιακή θέση του άξονα. Εάν το κωδικοποιημένο σήμα αλλάξει, η γωνιακή θέση του άξονα αλλάζει.  
Η σύνδεσή του σε ένα Arduino γίνεται με τα pins [5V, GRD και ένα ψηφιακό pin _ως έξοδο_](https://docs.arduino.cc/static/943895f1f578104f7af98741d69a7c97/4ef49/servo-sweep-circuit.png).   
Ο προγραμματισμός γίνεται με χρήση της βιβλιοθήκης `Servo.h` και της εντολής [_servo_.write(angle)](https://www.arduino.cc/en/Reference/ServoWrite) η οποία περιστρέφει τον άξονα του σερβοκινητήρα σε μια γωνία.

***Task (στο TinkerCad):***

Σκοπός είναι να προσομοιώσουμε ένα κύκλωμα ελέγχου πρόσβασης σε ένα χώρο με χρήση ενός αισθητήρα κίνησης και μιας μπάρας:

* Φορτώστε το έτοιμο κύκλωμα Arduino+LCD το οποίο παρέχει το TinkerCad.
* Συνδέστε στο Arduino ένα PIR Motion Sensor κα ένα Servo motor.
* Προγραμματίστε το Arduino ώστε κάθε φορά που _περνά_ μπροστά από τον αισθητήρα PIR ένα άτομο:  
    a. H οθόνη LCD να προβάλει κατάλληλο μήνυμα που δείχνει πόσοι άνθρωποι έχουν περάσει μπροστά από τον αισθητήρα.  
    b. Ο σερβοκινητήρας να ανοίγει την πρόσβαση του ατόμου για 5 sec.

---
## Lab #6

#### Α' μέρος: Αποκτήστε πρόσβαση στο cloud ide GoormIDE_

* Κάνετε (δωρεάν) εγγραφή στο https://ide-run.goorm.io/
* Δημιουργήστε ένα container (σας παρέχει έως πέντε) βασισμένο σε **python**. Ας είναι private, δεν έχει σημασία πού φιλοξενείται, αφήστε όλα τα άλλα default.
* Ξεκινήστε την εκτέλεση του container και εντός αυτού σε ένα terminal εκτελέστε:  
    ```
    git clone https://github.com/riggas-ionio/smart-iot.git
    cd smart-iot/post-server/
    python3 -m venv venv
    source venv/bin/activate
    pip install -r requirements.txt
    python3 main.py
    ```

    * Όταν θέλετε να ξαναξεκινήσετε το endpoint αρκούν τα:
    ```
    cd smart-iot/post-server/
    source venv/bin/activate
    python3 main.py
    ```
    Αν προσθέσετε άλλα dependencies στο requirements.txt, τρέξτε και το `pip install -r requirements.txt`.


* Η τελευταία εντολή ξεκινά το main.py (***μελετήστε το, στο φάκελο post-server***) το οποίο εκτελεί ένα python flask server, θα δείτε ένα output σαν:  

    ```
    * Serving Flask app "main" (lazy loading)
    * Environment: production
      WARNING: This is a development server. Do not use it in a production deployment.
      Use a production WSGI server instead.
    * Debug mode: on
    * Running on http://0.0.0.0:80/ (Press CTRL+C to quit)
    * Restarting with stat
    * Debugger is active!
    * Debugger PIN: xxx-xxx-xxx
    ```

* Για να δείτε σε ποιο public url είναι διαθέσιμο το endpoint αυτό, μεταβείτε στο menu του GoormIDE `PROJECT > Running URL and Port`.  
![GoormIDE - url and port](_img/GoormIDE-url-port.blur.png)  
    * Το endpoint σας είναι διαθέσιμο στο (url που βλέπετε)+`/post`, πχ https://py-server-hzwpn.run-eu-central1.goorm.io/post

#### Β' μέρος:  Google Chrome extension for TinkerCad_

**Η χρήση Google Chrome είναι απαραίτητη, <ins>ίσως</ins> δουλεύει και σε Linux Chromium - δώστε feedback στα issues**

* Αφού κάνετε clone το τρέχον repo στο pc σας ακολουθήστε τις οδηγίες για Chrome Extension development [εδώ](https://developer.chrome.com/docs/extensions/mv2/getstarted/) ώστε να ενεργοποιήσετε αυτό το extension στο σύστημά σας, ή απλά ακολουθήστε τη σύνοψη:

    * Open the Extension Management page by navigating to `chrome://extensions`.
    * Enable Developer Mode by clicking the toggle switch next to **Developer mode**.
    * Click the **LOAD UNPACKED** button and select the extension directory.  
        * Προσοχή, επιλέγετε το φάκελο `Gext-tinkercad` όχι όλο το _smart-iot_!
    ![Google Chrome - Load unpacked/development extension](https://developer-chrome-com.imgix.net/image/BrQidfK9jaQyIHwdw91aVpkPiib2/iYdLKFsJ1KSVGLhbLRvS.png?auto=format&w=650)


* Το extension είναι πλέον διαθέσιμο στο σύστημα σας και μπορείτε να το ενεργοποιήσετε από το εικονίδιο των extensions δίπλα στο address bar.
    * _Κάντε το pin ώστε να το βρίσκετε γρήγορα. :-)_
    * Δεν παρέχει κάποιο UI, μπορείτε να παρακολουθήσετε τη λειτουργία του extension από το `View > Developer > Developer Tools > Console`. Το extension κάνει log με πρόθεμα **[TinkerCad WireTap]**.


* Το extension έχει πρόσβαση (permission) σε όλα τα url τύπου **https://www.tinkercad.com/things/**xxxxxxxxx, πχ https://www.tinkercad.com/things/ijmonNCOLBA, είτε είναι δικό σας είτε άλλου χρήστη!

    * Η βασική του λειτουργία είναι ότι _παρακολουθεί_ ό,τι γράφει το Arduino στο serial monitor κατά τη διάρκεια του simulation.  
    ![TinkerCad serial monitor](_img/TinkerCad-serial-monitor.png)

    * Έχει τη δυνατότητα κάθε x msec να διαβάζει την τελευταία γραμμή του serial monitor και αυτή την τιμή (που μπορεί να είναι μια αριθμητική τιμή από ένα αισθητήρα ή ένα string που περιλαμβάνει τιμές πολλών αισθητήρων):
        * να την εμφανίζει στο Console του Chrome
        * να την κάνει HTTP POST σε ένα endpoint που δηλώνει ο χρήστης

**Χρήση Google Chrome extension for TinkerCad_**

* Δημιουργείτε το κύκλωμα σας στο TinkerCad και γράφετε τον κώδικα που το ελέγχει
    * Φροντίστε ό,τι τιμές θέλετε να μεταβιβάζονται από το TinkerCad στην cloud υπηρεσία που θα επιλέξετε να γίνονται από το Arduino print στο serial monitor.  

* Ξεκινάτε το simulation.

* **Click** στο εικονίδιο του extension. Με το click θα σας ζητηθούν μέσω javascript prompt:

    * Η **περίοδος δειγματοληψίας**, πόσο συχνά δηλαδή το extension θα διαβάζει το serial monitor.  
    ![Google Chrome TinkerCad extension - sampling period](_img/Gext-tinkercad-sampling.png)

    * Το **https endpoint**  στο οποίο θα στέλνονται τα δεδομένα. (Μπορεί να είναι κενό - οπότε στο Console θα εμφανίζεται ένα http post error, αλλά κατά τα άλλα το extension θα δουλεύει)  
    ![Google Chrome TinkerCad extension - sampling period](_img/Gext-tinkercad-endpoint.png)

* Επιθυμητό είναι να δείτε στο Chrome Console (κάντε filter πχ με τον όρο _Tap_ για να βλέπετε μόνο το output του extension):  
![Google Chrome TinkerCad extension - console](_img/Gext-tinkercad-console.png)  

<small>_Disclaimer:_ το extension παρέχεται για να σας βοηθήσει να συνδυάσετε το simulated Arduino με άλλα cloud services. Για οποιαδήποτε δυσλειτουργία, bug (_it's not a bug, it's a feature_), επιθυμητή αλλαγή.. μη ρωτήσετε, _hack your way to it!_  
Pull requests are welcome :-)</small>

**_Αξιοποίηση ενός (οποιουδήποτε) http post endpoint_**

Μπορείτε να αξιοποιήσετε ο,τι endpoint μπορεί να κάνει consume ένα json το οποίο έχει τη μορφή:  
`{'source': 'https://www.tinkercad.com/things/ijmonNCOLBA', 'value': '449\r'}`  
Το `source` δηλώνει από ποιο tinkercad thing προέρχονται τα δεδομένα, το `value` είναι η τιμή που έχει διαβαστεί από το serial monitor.

Για να ξεκινήσετε, και καθώς το api που θέλετε να αξιοποιήσετε ίσως θέλει κάποιο άλλο format δεδομένων, σας παρέχεται ένα sample http post endpoint γραμμένο σε python το οποίο μπορείτε να αξιοποιήσετε/τροποποιήσετε όπως θέλετε.

---

## Lab #7
* Γνωριμία με τα [Photocells](https://learn.adafruit.com/photocells), τους μικρούς αναλογικούς αισθητήρες μέτρησης έντασης φωτός.  
* Γνωριμία με τον [TMP36](https://learn.adafruit.com/tmp36-temperature-sensor), ένα απλό αναλογικούς αισθητήρα μέτρησης θερμοκρασίας.  

***Task (στο TinkerCad):***

* Δημιουργήστε ένα κύκλωμα Arduino - photocell - TMP36 και το σχετικό πρόγραμμα έτσι ώστε κάθε 1 sec να γράφετε στο serial monitor την ένταση του φωτός και την τρέχουσα θερμοκρασία σε μορφή json string.
* Αξιοποιήστε το chrome extension και το http endpoint του περασμένου εργαστηρίου για να στείλετε τα δεδομένα που συλλέγει το Arduino στο GoormIDE.
* Στο GoormIDE στήστε μια βάση (πχ MySQL), δημιουργήστε εντός της ένα πίνακα και αποθηκεύστε τα δεδομένα που φτάνουν από το Arduino σε μορφή:  

    | Timestamp | Luminocity | Temperature|
    |-----------|-----------:|-----------:|  
    | 2020-01-01 13:10:10 |   560 |    23 |

---

## Lab #8

Είναι πιο εύκολο να δημιουργήσετε ένα νέο container στο GoormIDE, όπως είχαμε κάνει κάνει σε προηγούμενο εργαστήριο, βασισμένο σε **python** και στο οποίο, _στα Additional modules_, να ☑ τσεκάρετε την εγκατάσταση `MySQL` και `mysql-ctl`.
![GoormIDE - mysql](_img/GoormIDE-mysql.png)  

Μετά τη δημιουργία του νέου container, κάνετε πάλι `git clone` το repo του μαθήματος.

* H MySQL (ο server της) ξεκινά από το τερματικό με την εντολή: `mysql-ctl start`.
* Δημιoυργήστε μια βάση και ένα table εντός του οποίου θα αποθηκεύονται οι μετρήσεις που φτάνουν στο GoormIDE. Ένα `sql script` σαν αυτό αρκεί:

    ```
    CREATE DATABASE iot_db;
    USE iot_db;
    CREATE TABLE iot_readings
    (
        tstamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
        temperature    FLOAT(6,2),
        luminocity     INT
    );
    INSERT INTO iot_readings(temperature, luminocity) VALUES (23.5, 267);
    SELECT * FROM iot_readings;
    ```
    _Αν τρέξετε αυτό τον κώδικα σε ένα mysql server (στο οποίο έχετε κατάλληλα δικαιώματα) θα δείτε ως output:_
    ```
    +---------------------+-------------+------------+
    | tstamp              | temperature | luminocity |
    +---------------------+-------------+------------+
    | 2022-04-14 19:56:10 |       23.50 |        267 |
    +---------------------+-------------+------------+
    ```

* Τώρα χρειάζεται να επέμβετε στο `main.py` που τρέχει το Flask server, και συγκεκριμένα την `def post()` ώστε τα δεδομένα που φτάνουν σε μορφή json object να τα εισάγετε στη βάση που μόλις δημιουργήσατε.
    * Μελετήστε το αποτέλεσμα του print στη γραμμή 20 του `main.py`:
    ```
    {'source': 'https://www.tinkercad.com/things/ijmonNCOLBA-photocell-voltage-divider/editel', 'value': '{"lum":3}'}
    ```
    N.B.: Αν δοκιμάστε να κάνετε `json.loads` αυτό το string θα λάβετε ένα μήνυμα λάθους *json.decoder.JSONDecodeError: **Expecting property name enclosed in double quotes**: line ... column ... (char ...)*
    Θα πρέπει να  αντικαταστήσετε σε αυτό το string τα ' με ", αλλά αφού πρώτα αντικαταστήσετε τα " εντός του value με \\".
    * _Όταν πάψετε να έχετε JSONDecodeErrors θα μπορείτε πλέον να πάρετε την τιμή εντός του value διαβάζοντας το αντίστοιχο key, πχ `json_obj["value"]`, προσέξτε όμως και αυτό με τη σειρά του είναι string που πρέπει να γίνει json.loads!_

#### Β' μέρος:  Οπτικοποίηση με Graphana

* Επόμενο βήμα, η [εγκατασταση Graphana στο GoormIDE container](https://grafana.com/docs/grafana/latest/installation/debian/).
* Δημιουργήστε ένα Datasource το οποίο να συνδέεται με τη MySQL που έχετε εγκαταστήσει νωρίτερα.
* Δημιουργήστε ένα panel στο οποίο να απεικονίσετε τα δύο timeseries που έχετε δημιουργήσει

    ![Graphana](./_img/Graphana.gif)


---

## Lab #9

Πέραν της οπτικοποίησης μπορούμε να αναπτύξουμε και μια _λογική_ η οποία αναλόγως της τιμής ενός αισθητήρα θα _ζητά_ από το περιβάλλον κάποια υπηρεσία. Πχ όταν η τιμή της φωτεινότητας είναι χαμηλή θα ζητά περισσότερο φως.  
Θέλουμε όμως ο _αισθητήρας_, η _λογική_ και ο _ενεργοποιητής_ της απόκρισης του περιβάλλοντος να είναι _χαλαρά συνδεδεμένα_ μεταξύ τους μέσω μια υπηρεσίας μηνυμάτων (γιατί;).  
Γνωρίστε το [MQTT](https://mqtt.org/) (ή δείτε [εδώ](https://www.hivemq.com/mqtt/mqtt-protocol/) και [εδώ](http://www.steves-internet-guide.com/mqtt/)).

***Task (στο GoormIDE):***

Σκοπός είναι να εγκαταστήσετε ένα mqtt broker, δλδ μια υπηρεσία διαχείρισης μηνυμάτων mqtt, στον container όπου τρέχει το http post endpoint σας.

* Ένας κατάλληλος mqtt broker για ubuntu είναι ο `mosquitto`.
* Εκεί σε ένα ξεχωριστό topic για κάθε κύκλωμα TinkerCad που έχετε να καταχωρείτε την τελευταία τιμή (ή σύνολο  τιμών, πχ σε json) που λάβατε από το TinkerCad. Θα πρέπει να επέμβετε στο `main.py` αρχείο ώστε όποτε λαμβάνετε ένα `POST` να κάνετε `mqtt publish` το `value` σε ένα κατάλληλο `mqtt topic`.
* Αξιοποιήστε τη βιβλιοθήκη [`paho-mqtt`](https://pypi.org/project/paho-mqtt/)
* Δημιουργήστε ένα (standalone) πρόγραμμα σε python, το οποίο επίσης να αξιοποιεί τη βιβλιοθήκη `paho-mqtt` το οποίο να κάνει consume ένα mqtt topic και οποτεδήποτε εντοπίζει ακραίες τιμές (ορίστε τες όπως κρίνετε, ανάλογα με το τι δεδομένα παρακολουθείτε) να στέλνει ένα μήνυμα σε ένα δεύτερο mqtt topic (πχ με prefix το όνομα του topic που καταναλώνει και suffix `/alert`)
* Αν χρειαστείτε να παρακολουθείτε μέσω terminal τα μηνύματα στα topics του mqtt broker, εγκαταστήστε σε Ubuntu το `mosquitto-clients` και χρησιμοποιήστε το `mosquitto_sub`.
