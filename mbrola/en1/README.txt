EEEEEE    N     N      1
E         NN    N    1 1
E         N N   N   1  1
E         N  N  N      1
EEEE      N   N N      1
E         N    NN      1
E         N     N      1
E         N     N      1
EEEEEEE   N     N   1111111 release 980910

Faculte Polytechnique de Mons (FPMs)
Copyright (c) 1997
All Rights Reserved.

(The  original  ROGER diphone database belongs to :
Centre for Speech Technology Research
University of Edinburgh, UK
Copyright (c) 1996,1997
All Rights Reserved.)

------------------------------------------------------------
Table of Contents
------------------------------------------------------------

1.0 License and disclaimer
2.0 A brief description of the EN1 database
3.0 Distribution
4.0 Installation, and tests
5.0 Acknowledgments

------------------------------------------------------------
1.0 License and disclaimer (FPMs)
------------------------------------------------------------

This  mbrola  database  is  being  provided  to  "You",  the
licensee,  by  the Faculte Polytechnique de  Mons  -  mbrola
team,  the  "Author  of  the  Mbrola  Database",  under  the
following license.

By  obtaining, using and/or copying this database, you agree
that  you have read, understood, and will comply with  these
terms and conditions :

Terms and conditions on the use of EN1
--------------------------------------

Permission  is granted to use the MBROLA en1 encoding of the
Roger database  for synthesizing speech  with and only  with 
the Mbrola  program made  available  from the MBROLA project 
www homepage :

   https://github.com/numediart/MBROLA/

following the terms and conditions on the use of the  Mbrola
program.

Terms and conditions for the distribution of EN1
------------------------------------------------

The  distribution of this database is submitted to the  same
terms and  conditions as the ones  imposed  by University of
Edinburgh on the use and distribution of the ROGER  database
in an encoded form:

"Permission  to use, copy, modify, distribute this  database
for  any  purpose is hereby granted without fee, subject  to
the following conditions:
  1. Redistributions  retain  the  above  copyright  notice,
     this list of conditions and the following disclaimer.
  2. Redistributions in an encoded form must  reproduce  the
     above  copyright  notice, this list of  conditions  and
     the  following  disclaimer in the documentation  and/or
     other materials provided with the redistribution.
  3. Neither  the  name of the University nor the  names  of
     contributors  to this work may be used  to  endorse  or
     promote  products  derived from this  software  without
     specific prior written permission."

In  addition, the distribution of this database is submitted
to  the  same  terms and conditions as the ones  imposed  by
Faculte  Polytechnique de Mons on the  distribution  of  the
Mbrola  program,  in  so far as they do not  contradict  the
terms and conditions quoted above.

This  database  may  therefore  be  copied  and  distributed
freely,  provided that this notice is copied and distributed
with it.

Disclaimer
----------

THIS  MBROLA  DATABASE  CARRIES NO  WARRANTY,  EXPRESSED  OR
IMPLIED.   THE  USER  ASSUMES ALL RISKS, KNOWN  OR  UNKNOWN,
DIRECT OR INDIRECT, WHICH INVOLVE THIS DATABASE IN ANY  WAY.
IN  PARTICULAR, THE AUTHOR OF THE MBROLA DATABASE  DOES  NOT
TAKE  ANY  COMMITMENT  IN VIEW OF ANY POSSIBLE  THIRD  PARTY
RIGHTS.

Additionally :

THE  UNIVERSITY  OF EDINBURGH AND THE CONTRIBUTORS  TO  THIS
WORK  DISCLAIM ALL WARRANTIES WITH REGARD TO THIS  SOFTWARE,
INCLUDING  ALL  IMPLIED  WARRANTIES OF  MERCHANTABILITY  AND
FITNESS,  IN NO EVENT SHALL THE UNIVERSITY OF EDINBURGH  NOR
THE  CONTRIBUTORS  BE  LIABLE FOR ANY SPECIAL,  INDIRECT  OR
CONSEQUENTIAL  DAMAGES OR ANY DAMAGES  WHATSOEVER  RESULTING
FROM  LOSS OF USE, DATA OR PROFITS, WHETHER IN AN ACTION  OF
CONTRACT,  NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING  OUT
OF  OR  IN  CONNECTION WITH THE USE OR PERFORMANCE  OF  THIS
WORK.

------------------------------------------------------------
2.0 A brief description of EN1
------------------------------------------------------------

EN1 release  is  a British English  diphone  database
provided in the context of the MBROLA project :

   https://github.com/numediart/MBROLA/

It  provides a British English male voice (known as "RogerÆs
voice")  to  be used with the MBROLA program.  It  has  been
built  from  the original Roger diphones made  available  by
CSTR, University of Edinburgh, as part of their generic text-
to-speech system FESTIVAL :

   http://www.cstr.ed.ac.uk/projects/festival.html

Input  files use the SAMPA phonetic notation, as adopted  in
other  MBROLA  databases. Below is a  list  of  the  English
speech  sounds it accounts for, with examples. We also  give
the  correspondence with the MRPA phonetic notation used  in
the  original distribution of RogerÆs voice in the  FESTIVAL
TTS system.

                   MRPA    SAMPA   Example
                     p       p       put
                     b       b       but
                     t       t       ten
                     d       d       den
                     k       k       can
                     m       m       man
                     n       n       not
                     l       l      like
                     r       r       run
                     f       f      full
                     v       v      very
                     s       s      some
                     z       z      zeal
                     h       h       hat
                     w       w      went
                     g       g      game
                    ch      tS      chain
                    jh      dZ      Jane
                    ng       N      long
                    th       T      thin
                    dh       D      then
                    sh       S      ship
                    zh       Z     measure
                     y       j       yes
                    ii      i:      bean
                    aa      A:      barn
                    oo      O:      born
                    uu      u:      boon
                    @@      3:      burn
                     i       I       pit
                     e       e       pet
                     a       {       pat
                    uh       V      putt
                     o       Q       pot
                     u       U      good
                     @       @      about
                    ei      eI       bay
                    ai      aI       buy
                    oi      OI       boy
                    ou      @U       no
                    au      aU       now
                    I@      I@      peer
                    e@      e@      pair
                    u@      U@      poor

MRPA also actually defines two allophones of [l] : a "light"
one  [l],  as  in  "list",  and a "dark"  one  [ll],  as  in
"festival". We have used the character found in the  IPA-SAM
Truetype font [5].

                    ll      5       bolt

Additionally, the notation for silence is the  one  used  in
previous mbrola databases : _ (MRPA uses #).

However,  in  order to maintain a strict compatibility  with
the  MRPA  notation, and to allow any other notation  to  be
used as well, we have included in the distribution of en1  a
configuration  file which performs automatic MRPA  to  SAMPA
phoneme  mapping  (as  accepted  by  the  latest  version of
mbrola; see below).

Notice  finally that there is no support for SAMPA's glottal
stop  (?,  as in "network" [ne?w3:k]) nor for the  voiceless
velar fricative (x, as in "loch" [lQx]).

Limitations:
-----------
In  the FESTIVAL distribution of Roger's voice, not all 2116
diphones (i.e. 46x46) are available.

For reasons of compactness, some diphones (like e-dZ and  e-
d,  for instance) have been mapped into a single unit.  This
should  not  have  a  major  influence  on  the  quality  of
synthetic speech.

Notice  also that not all diphones are possible  in  English
(like  f-ng,  for  instance). However,  in  order  to  avoid
problems   when   trying  to  synthesize   such   impossible
combinations,  we  have  systematically  mapped   impossible
diphones to 3:-@ (as done by FESTIVAL itself).

------------------------------------------------------------
3.0 Distribution
------------------------------------------------------------

This distribution of mbrola contains the following files :

   en1         : the database itself
   en1mrpa     : a configuration file, which can follow en1
                 on the command line, and enables automatic
                 phoneme  mapping  for use  with  the  MRPA 
                 notation.
   readme.txt  : this file

and several example .PHO files :

   mbrola.pho  : a small introduction to mbrola
   mbrolamr.pho: same thing, MRPA notation
   euler.pho   : a famous  quotation by  Swiss mathematician
                 Leonhard Euler
   eulerfr.pho : same thing in French with an English accent
   tobe.pho    : mbrola metaphysics

Additional  languages and voices, as well as  other  example
command  files, are or will be available in the  context  of
the  MBROLA  project.  Please  consult  the  MBROLA  project
homepage :

   https://github.com/numediart/MBROLA/

Registered  users  will automatically  be  notified  of  the
availability  of  new databases. To freely register,  simply
send  an  email  to  mbrola-interest-request@tcts.fpms.ac.be
with the word 'subscribe' in the message title.

------------------------------------------------------------
4.0 Installation and Tests
------------------------------------------------------------

If  you  have not copied the MBROLA software yet, or if  you
have  an  older  version, please consult the MBROLA  project
homepage and get it.

Copy en1.zip into the mbrola directory and unzip it :
     
   unzip en1.zip (or pkunzip on PC/DOS)
   (don't forget to delete the .zip file when this is done)

Try
     
   mbrola en1 euler.pho euler.wav

to  create  a  sound file. In this example  the  audio  file
follows  the  RIFF  Wav  format.  But,  depending   on   the
extension, euler.au, euler.aif, or euler.raw, you can obtain
other  file  formats. Listen to it with your favorite  sound
editor, and try other command files (*.pho) to have a better
idea  of  the quality of speech you can synthesize with  the
MBROLA technique.

On  Unix  systems you can pipe the audio ouput to the  sound
player. On a HP, for instance, do:

   mbrola en1 euler.pho - | splayer -srate 16000 -l16

Also refer to the readme.txt file provided with the mbrola
software for using it.

You   can   also  very  easily  use  the  MRPA  input   file
eulermrp.pho :

   mbrola en1 en1mrpa eulermrp.pho euler.wav

------------------------------------------------------------
5.0 Acknowledgments
------------------------------------------------------------

We  would  like  to  thank  Alan Black,  Paul Taylor,  Roger
Burroughes, Alistair Conkie, and Sue Fitt for the remarkable
contribution  they have made  to  free speech  synthesis  by 
making the original Roger diphone database freely  available 
without any restriction of use.

It  should  be  noted  in  that  respect  that  mbrola-based
synthesis using en1 is fully supported by the Festival text-
to-speech system developed at CSTR and available at :

   http://www.cstr.ed.ac.uk/projects/festival.html

(Other possible uses of the mbrola speech synthesizer  within
complete TTS systems are listed at :

   https://github.com/numediart/MBROLA/)

------------------------------------------------------------

The MBROLA team                                   Sep 1998

Faculte Polytechnique de Mons
31 Bvd Dolez
B-7000 Mons
Belgium

Tel.: +32.65.374133
Fax.: +32.65.374129

e-mail: mbrola@tcts.fpms.ac.be, for general information,
questions on the installation of software and databases.
