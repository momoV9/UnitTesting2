Splitwise is een applicatie waarmee je in een vriendengroep de gezamenlijke rekening kan bijhouden.

Als er iets betaald moet worden dan gebeurt dat door 1 persoon.
Alle andere personen krijgen dan een gelijk deel van dat bedrag als schuld.
De bedoeling is dat je kan zien wat er moet gebeuren om de rekening te vereffenen.

Er werd hiervoor reeds een klasse **SplitWise** voorzien in het package be.thomasmore.splitwise.

---
Je maakt een object van die klasse _SplitWise_ met een **array van strings**, dat zijn de namen van de vrienden in de groep.

Die constructor werd reeds voorzien; de code ervan moet je wel zelf nog voorzien.
Je mag ervan uitgaan dat de namen die in die array aanwezig zijn altijd correct zijn - je moet er dus GEEN rekening mee houden dat de array namen bevat die leeg zijn of rare karacters bevatten, of dat dezelfde naam meerdere keren voorkomt.

---
In deze klasse werden ook reeds 2 methodes voorzien:  **billFor** en **pay**.

* functie **billFor**
  * heeft 1 parameter:
    * name: de naam van de persoon voor wie je de rekening wil zien.
    * De name is altijd correct - je moet er dus GEEN rekening mee houden dat name leeg kan zijn of rare karacters kan bevatten.
  * Het resultaat van de functie billFor is de rekening (positief of negatief) voor die persoon. Voorlopig retourneert de methode 0 (omdat de code anders niet zou compileren): het spreekt dat je dit zal moeten aanpassen.
  * Als de naam niet voorkomt in de vriendengroep dan is het resultaat ook altijd 0

* functie **pay**.
  * heeft 2 parameters:
    * name: naam van de persoon die betaalt (een String)
      * De name is altijd correct - je moet er dus GEEN rekening mee houden dat name leeg kan zijn of rare karacters kan bevatten.
      * Als deze naam nog niet in de vriendengroep zit dan voeg je hem toe en hij behoort deze persoon vanaf dan tot de vriendengroep. Deze persoon doet dus VANAF NU mee met alle betalingen.
    * amount: het betaalde bedrag
      * is altijd een geldig geheel getal;
      * als dit negatief is moet er niets gebeuren.

Aan de header van de constructor en die twee methodes **mag je niets wijzigen**. Je mag ook geen ander constructor toevoegen aan de klasse.
Wat je wél mag toevoegen aan de klasse SplitWise:
- attributen;
- code aan constructor en de reeds aanwezige methodes;
- desgewenst extra private methodes.

---
Hoe gebruik je een object van de klasse SplitWise?
* **Bijvoorbeeld:**
  * de 4 vrienden Jan, Jos, Mieke, Tamara gaan samen een dagje op stap en ze willen de kosten zo eerlijk mogelijk verdelen. Je maakt dus een nieuw object van SplitWise met als parameter een array van 4 strings:
    * dus SplitWise sw = new SplitWise(new String[]{"Jan", "Jos", "Mieke", "Tamara"}).
  * In de beginsituatie is het resultaat van billFor voor iedereen 0.
  * Ze drinken samen een koffie en Jan betaalt dit, het totale bedrag hiervoor is 40 Euro -> dus 10 Euro per persoon.
    * dus:  sw.pay("Jan", 40)
    * De rekening voor Jan is nu een positief bedrag, namelijk 40 Euro - 10 Euro (zijn eigen koffie) = 30 Euro
      * dus: sw.billFor("Jan") --> resultaat is 30
    * De rekening voor Jos, Mieke en Tamara is een negatief bedrag, namelijk -10 Euro
      * dus: sw.billFor("Jos") --> resultaat is -10 etc.
    * Dit wil zeggen: om de rekening te vereffenen moet Jan 30 Eur krijgen en Jos, Mieke en Tamara moeten elk 10 Eur
      betalen.

* **Bijvoorbeeld:**
  * DAARNA koopt Mieke een zakje koekjes om samen op te eten, dit kost 10 Euro -> dus 2.5 Euro per persoon.
    * dus: sw.pay("Mieke", 10)
    * De rekening voor Jan is: 30 - 2.5 (zijn aandeel koekjes) = 27.5 Euro.
    * De rekening voor Mieke is -10 + 10 (wat ze betaalt voor de koekjes) - 2.5 Euro (haar aandeel koekjes) = -2.5 Euro.
    * De rekening voor Jos en Tamara is -10 - 2.5 (hun aandeel koekjes) = -12.5 Euro.
    * Dit wil zeggen: om de rekening te vereffenen moet Jan 27.5 krijgen, Mieke moet 2.5 Eur betalen en Jos en Tamara
      moeten elk 12.5 Eur betalen.

* **Bijvoorbeeld:**
  * DAARNA komen de vrienden toevallig Pieter tegen, die aansluit voor de rest van de dag. Pieter betaalt een rondje en wordt automatisch toegevoegd aan de groep.
    * dus: sw.pay("Pieter", 10) -> dus 2 Eur per persoon
    * De rekening voor Jan is: 27.5 - 2 (zijn aandeel in rondje) = 25.5 Euro.
    * De rekening voor Mieke is -2.5 - 2 (haar aandeel) = -4.5 Euro.
    * De rekening voor Jos en Tamara is -12.5 - 2 (hun aandeel) = -14.5 Euro.
    * De rekening voor Pieter is 10 (wat hij betaalt) - 2 (zijn aandeel) = 8 Euro.
    * Dit wil zeggen: om de rekening te vereffenen moet Jan 25.5 krijgen, Mieke moet 4.5 Eur betalen, Jos en Tamara
      moeten elk 14.5 Eur betalen, Pieter moet 8 Euro krijgen.

---

**Let op:**
Denk goed na over de test cases. Bovenstaande voorbeeldjes zijn enkel om uit te leggen wat de bedoeling is.
Laat de tests je helpen om na te denken over het probleem.
Je mag zeker op voorhand een algoritme in je hoofd hebben waar je naartoe werkt.
Maar werk dat algoritme in kleine stapjes uit, en commit na elke stap.

**Let op:**
Voor deze opdracht is het toegelaten om meerdere asserts in 1 test te zetten
Dus: een test beschrijft een bepaald scenario, en je mag in dezelfde test asserten wat het resultaat is voor iedereen in deze vriendengroep.

**Let op:**
Een getal is niet altijd mooi deelbaar.
Bvb: 10/3 = 3.3333333 (oneindig veel 3-tjes).
Daarom mag je nooit asserten of een float of double exact gelijk is aan een getal.  
Gebruik deze assert-functie: assertEquals(double expected, double actual, double delta).
Voor delta mag je het getal 0.001 meegeven. Dat wil zeggen dat het verschil niet groter mag zijn dan 0.001.
Dit wil zeggen:
assertEquals(3.333, 10.0/3, 0.001) --> OK
assertEquals(3.334, 10.0/3, 0.001) --> OK
assertEquals(3.33, 10.0/3, 0.001) --> ERROR

**Let op: speciale gevallen**
* Als voor pay een negatief bedrag meegegeven wordt dan gebeurt er niks.
* De namen zijn altijd correct - je moet er dus GEEN rekening mee houden dat namen leeg kunnen zijn of rare karacters kunnen bevatten, of dat dezelfde naam meerdere keren voorkomt.
* Bij andere eventuele foute input mogen er geen exceptions gegooid worden. 
