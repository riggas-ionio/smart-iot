# DDI196 Έξυπνες Τεχνολογίες και εφαρμογές

Σε αυτό το repository μπορείτε να βρείτε χρήσιμο υλικό για το μάθημα DDI196 Έξυπνες Τεχνολογίες και εφαρμογές.

---

## Lab #1
* Γνωριμία με [Arduino](https://youtu.be/IV49AxTpOmw), [Breadboard](https://youtu.be/IjUNCm3haNg) σύνδεσης ηλεκτρονικών & [Tinkercad](https://youtu.be/tRz5ybWVbyQ).  
* Γνωρίστε [εναλλακτικές εκδόσεις](https://www.arduino.cc/en/main/products) του Arduino.

***Task (στο TinkerCad):***

* Δημιουργήστε student account TinkerCad link: https://www.tinkercad.com/joinclass/9MWXM6XCW (Join with email / username ή με το Microsoft account σας).
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
