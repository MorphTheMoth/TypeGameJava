######   #####     #
#       #     #   ##
#       #        # #
#####    #####     #
#             #    #
#       #     #    #
######   #####   #####
 
release 3

--------------------------------------------------------------
Table of Contents
--------------------------------------------------------------

1.0 A brief description of the ES1 database
2.0 Distribution
3.0 Installation, and tests
4.0 Acknowledgments

--------------------------------------------------------------
1.0 A brief description of ES1
--------------------------------------------------------------
ES1 2.069 equalized release is a Spanish diphone database provided in
the context of the MBROLA project (see
https://github.com/numediart/MBROLA/).

It provides a Spanish male voice to be used with the MBROLA program.

Input files use the SAMPA (SAM Phonetic Alphabet) notation as
recommended by the EEC-SAM Project, but with some minor changes,as 
indicated. The following is derived from SAMPA for Spanish (J.C.Wells,
UCL,London).

SAMPA	EXAMPLE		TRANSCRIPTION
p	padre		"paDre
b	vino		"bino
t	tomo		"tomo
d	donde		"donde
k	casa		"kasa
g	gata		"gata

tS	mucho		"mutSo
jj	hielo		"jjelo
w	huele		"wele	(NOT sampa definition)

f	fácil		"faTil
T	cinco		"Tinko
s	sala		"sala
x	mujer		mu"xer

m	mismo		"mismo
n	nunca		"nunka
J	año		"aJo

l	lejos		"lexos
L	caballo		ka"baLo	
r	puro		"puro
rr	torre		"torre

i	pico		"piko
e	pero		"pero
a	valle		"baLe
o	toro		"toro
u	duro		"duro

_		silence	

Limitations:
-----------
A matrix provided suffers from some limitations that we hope to
eliminate in future versions. In particular the diphthongs are
not adequately treated in the current version of the database, nor
are the /b/ /B/, /d/ /D/, /g/ /G/ pairs.
The following are the original Sampa definitions left out.
j		rei		rrej
		pie		pje
w		deuda		"dewDa
		muy		mwi
B		cabra		"kaBra		(= /b/)
D		nada		"naDa		(= /d/)
G		luego		"lweGo	(= /g/)

--------------------------------------------------------------
2.0 Distribution
--------------------------------------------------------------

This distribution of mbrola contains the following files : 

   es1      : the database itself
   es1.txt  : This file
   license.txt : must read before using the database
    
and a TEST directory containing .PHO files. Some of the .PHO
files are automatically generates, some copy natural prosody.

Additional languages and voices, as well as other example command
files, are or will be available in the context of the MBROLA 
project. Please consult the MBROLA project homepage :
   https://github.com/numediart/MBROLA/

Registered users will automatically be notified of the availability 
of new databases. To freely register, simply send an email to 
mbrola-interest-request@tcts.fpms.ac.be with the word 'subscribe'
in the message title.

--------------------------------------------------------------
3.0 Installation and Tests
--------------------------------------------------------------

If you have not copied the MBROLA software yet, please consult
the MBROLA project homepage and get it.

Copy es1.zip into the mbrola directory and unzip it : 

   unzip es1.zip (or pkunzip on PC/DOS)
   (don't forget to delete the .zip file when this is done)

Try 

   mbrola es1 TEST/carlos1.pho test.wav

to create a sound file. In this example the audio file follows 
the RIFF Wav format. But depending on the extension test.au, test.aif, 
or test.raw you can obtain other file formats. Listen to it with your 
favorite sound editor, and try other command files (*.pho) to have 
a better idea of the quality of speech you can synthesize with the 
MBROLA technique.

On Unix systems you can pipe the audio ouput to the sound player as
on a HP : mbrola es1 test.pho - | splayer -srate 16000 -l16

Also refer to the readme.txt file provided with the mbrola 
software for using it.

--------------------------------------------------------------
4.0 Acknowledgements
--------------------------------------------------------------

We could like to thank Carlos for the use of his voice, and the members
of the Grup de Fonetica, Universitat Autonoma de Barcelona for their
help and encouragement in making this database. And Vincent Pagel and
Thierry Dutoit for their work in preparing the database.

--------------------------------------------------------------

Alistair Conkie (alistair@liceu.uab.es)
Lourdes Aguilar (lourdes@liceu.uab.es)
Rafael Marin (rafa@liceu.uab.es)

e-mail: alistair@liceu.uab.es, for questions concerning the 
database es1.

e-mail: mbrola@tcts.fpms.ac.be, for general information, 
questions on the installation of software and databases.
