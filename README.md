# Base Spaziale Internazionale
## _Applicazione ipotetica per Base Spaziale Internazionale, gestione flotta e moduli_

### _Assunzioni_
- il vettore permette di portare in orbita terrestre uno o più moduli per poi integrarli nella base spaziale
- le postazioni del modulo di tipo dormitorio, una volta integrati, andranno ad aggiungersi ai letti già disponibili sulla base spaziale
- i moduli di tipo STORAGE servono a immagazzinare cibo, acqua e immondizie
### _Composizione Base Spaziale Internazionale_
attualmente la base spaziale è così composta
- un modulo per l'acqua
- un modulo per il cibo
- un modulo per le immondizie
- un modulo per esperimenti di biologia
- un modulo per esperimenti di fisica
### _Vincoli di missione_
- i membri dell'equipaggio di un vettore non devono superare il numero di posti a dormire sulla base spaziale
- il 50% dei moduli sul vettore non devono appartenere all'agenzia spaziale del vettore stesso
- il 70% dell'equipaggio non deve appartenere all'agenzia spaziale del vettore con cui si raggiunge la base
- deve esserci almeno una donna nell'equipaggio nel vettore
### _Gestione magazzino_
- in caso la quantità di acqua per ogni astronauta sia inferiore a 1000 litri deve essere comunicato
- in caso di quantità di cibo per ogni atronauta sia inferiore a 800 kg deve essere comunicato
- in caso si raggiunga la quantità di 500kg di immondizia allora può essere rilasciata nello spazio perchè verrà distrutta a contatto con l'atmosfer terrestre
### _Salute degli astronauti_
Viene costantemente monitorato lo stato di salute dei membri dell'equipaggio.
In particolare deve essere inviata un alert relativo ai parametri vitali dell'astronauta se

- si ha una pressione al di fuori del range per più di un giorno (in base alla seguente tabella)

| ETA'     | SESSO | RANGE PRESSIONE |
|----------|-------|-----------------|
| [20, 30] | F     | [60, 140]       |
| [31, 40] | F     | [70, 130]       |
| [41, 50] | F     | [85, 125]       |
| [51, 60] | F     | [87, 135]       |
| [20, 30] | M     | [70, 130]       |
| [31, 40] | M     | [75, 125]       |
| [41, 50] | M     | [85, 120]       |
| [51, 60] | M     | [87, 130]       |

- si ha una frequenza cardiaca al di fuori del range per più di 15 minuti (in base alla seguente tabella)

| ETA'     | SESSO | RANGE FREQUENZA CARDIACA |
|----------|-------|--------------------------|
| [20, 30] | F     | [45, 75]                 |
| [31, 40] | F     | [50, 80]                 |
| [41, 50] | F     | [55, 85]                 |
| [51, 60] | F     | [65, 90]                 |
| [20, 30] | M     | [50, 70]                 |
| [31, 40] | M     | [55, 75]                 |
| [41, 50] | M     | [60, 80]                 |
| [51, 60] | M     | [65, 85]                 |

- inoltre bisogna sempre mandare un eccezione di tipo HealthException nel caso ci sia una frequenza maggiore o uguale ai 180 battiti al minuto

