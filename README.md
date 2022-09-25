# Primo-progetto-Ingegneria-del-software
Primo progetto corso Ingegneria del software, voto 29/30. Il secondo e ultimo progetto non era di programmazione. Insieme formavano l'esame, passato con 29/30, data 16/09/2021. 
#richiesta da soddisfare:
Supponete di essere in ambiente Java Micro Edition, precisamente CLDC1.1
( https://docs.oracle.com/javame/config/cldc/ref-impl/cldc1.1/jsr139/index.html )
Supponete di voler utilizzare in questo ambiente una libreria di classi (myLib) nata in ambiente J2SE 1.4.2
(http://geas.dei.unipd.it/jdk1.4.2/docs/api/ 
https://www2.cs.duke.edu/csed/java/jdk1.4.2/docs/api/index.html).
In particolare, la libreria contiene classi che fanno uso dell’interfaccia List e, di conseguenza, Collection, 
Iterator e ListIterator del Java2 Collections Framework versione 1.4.2.
Sviluppate un adapter per l’interfaccia List, si suggerisce (ma non e’ obbligatorio) di utilizzare la classe
Vector di CLDC 1.1 come adaptee. 
Il comportamento del vostro adapter e dei suoi metodi deve essere esattamente quello descritto dalla 
documentazione di J2SE 1.4.2. Si ponga particolare attenzione al concetto di “backing” presente nella 
documentazione relativa al metodo subList. Si ponga anche particolare attenzione al fatto che l’oggetto che 
si ottiene con il metodo subList implementa a sua volta l’interfaccia List e deve quindi fornire il metodo 
subList esattamente come l’oggetto di partenza (recursive sublisting).
Potete lavorare in J2SE nella versione corrente, MA e’ obbligatorio utilizzare solo i metodi e le funzionalita’ 
disponibili in J2ME CLDC 1.1.
Per evitare collisioni con le interfacce della versione corrente di Java (in particolare Collection, List, Iterator 
e ListIterator) dovete definire localmente al package del vostro adapter (package che dovete chiamare 
myAdapter senza ulteriori livelli di nidificazione) le interfacce HCollection, HList, HIterator ed HListIterator 
con tutti i metodi delle interfacce Collection, List, Iterator e ListIterator della versione 1.4.2.
La vostra classe adapter deve chiamarsi ListAdapter, deve appartenere al package myAdapter e deve
implementare le interfacce HList e HCollection.
Il comportamento dei vostri adapters e dei loro metodi deve essere esattamente quello descritto dalla 
documentazione di J2SE 1.4.2 e devono essere implementate tutte le optional operations.
Devono essere compliant con la documentazione della versione 1.4.2 anche gli iteratori e devono essere 
implementate anche tutte le optional operations degli iteratori stessi. La o le classi che implementano gli 
iteratori devono far parte del package myAdapter e deve/devono implementare le interfacce HIterator e 
HListIterator.
Dovete consegnare tutti i sorgenti, non un progetto di un qualche ambiente integrato. I sorgenti devono 
essere contenuti in una cartella che sia la radice del CLASSPATH necessario alla compilazione.
Dovete utilizzare la metodologia Test Driven Development, e, quindi, definire ed Implementare le test suite 
Junit per le classi sviluppate. Le classi di test devono essere contenute in un package myTest (senza ulteriori 
livelli di nidificazione). Il package deve contenere una classe TestRunner che possa essere invocata da linea 
di comando, eseguire tutti i test da voi definiti, fornire almeno il risultato dei test ed il numero complessivo 
di test eseguiti.
Documentate la/le vostra test suite utilizzando il template “SAFe” descritto nella tabella 1 di questo 
documento. (ulteriore documentazione relativa a SAFe e’ disponibile qui https://jazz.net/help-
dev/clm/index.jsp?re=1&topic=/com.ibm.rational.test.qm.doc/topics/r_testsuite_template_ref.html&scop
e=null)
Documentate ogni test case secondo il template “Homework” descritto nella tabella 2 di questo 
documento.
E’ possibile fornire la documentazione in formato pdf o in formato html (da javadoc), in entrambi i casi le 
diverse voci per i diversi test devono essere facilmente leggibili e distinguibili dalle altre.
La documentazione deve essere contenuta in una cartella doc separata dai sorgenti.
Utilizzate il framework JUnit. E’ caldeggiato l’utilizzo della versione usata a lezione. Dovete comunque 
dichiarare nella documentazione la versione utilizzata, le componenti del framework utilizzate e le 
eventuali librerie di matcher utilizzate. Se utilizzerete librerie matcher, esse devono essere fornite nella 
consegna in formato jar, in una cartella dedicata denominata Matcher. Se utilizzerete una versione di JUnit 
diversa da quella utilizzata a lezione dovete fornire tutti i jar necessari in una cartella denominata junit.
Fornite la documentazione di tutte le classi (utilizzate il tool javadoc) con almeno la descrizione delle classi 
stesse e la documentazione di base (paragrafi parameters, returns, throws) dei metodi. Non vi e’ impedito 
l’uso di annotazioni avanzate, ma non e’ obbligatorio.
