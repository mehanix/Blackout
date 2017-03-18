BLACKOUT v1.0b ----------- Patch notes

1.0b ----------

*Mod contra timp -- adaugat:
**Mai multe marimi de puzzleuri
**fixat "numere magice" - partial
**trecut de la o camera la cealalta
**calculat cea mai mare distanta dintre player si iesire
**adaugat ochelari pt vedere/pastila care creste viteza (iteme)
**fixat sistem de display - cand marimea puzzleului e mai mica decat 
**dimensiunile ecranului il centreaza pe mijloc

*Mod puzzle -- adaugat:
**implementat sistem nestemate - trebuie colectate 4 ca sa se deschida iesirea
**gasit dimensiune ok pentru mapa - 24/20
**simplificat mult cod si adus la restul standardelor
**(scos generarea pozitiei random la player care era diferita de cum se genereaza restul numerelor)
**(yay pentru metode)

BUGS --------

TAM:
- ochelarii de vedere strica FOV(doar pe time attack, pe puzzle merg perfect)
- nici macar nu apar la generare si nu inteleg de ce

PM:
- FOV e mai mic decat harta propriu zisa si nu imi genereaza gaura in centru 
- probabil rescriu tot sistemul de fov .......

*
1.3a ----------

*Added patch note file
*Improved modularity on menu buttons - yay for inheritance!
*Fixed language system
*Added background/buttons(to be changed)/language-selectors resources

1.2a ----------
*Fixed vision system
*Changed textures
*Fixed player animations
*Fixed collision issues - was because of the animations
*Added menu buttons
*Added menu animations - pretty wonky

1.1a ----------
*Fixed maze generation
*Fixed wall textures
!collision issues! To be fixed

1.0a ----------
*Added maze generator that works

TO BE ADDED:

*Scoreboard system -- probably won't work(requires online access), might replace with About/Credits page


*Tutorial
**Add tutorial picture


*Time attack mode:

**Countdown timer
**Score calculation based on formula
****Panning camera? (doar daca imi mai ramane timp)


*Puzzle Mode:
**Timer that counts up
**Emerald HUD

****Panning camera?

*General
**Random texture colors
**Music
**Game logo
**Credits?
**Actually making the menu send you to the gamemodes
**Button hover and click textures
**Text displayed when hovering on buttons that explains what the buttons do
**Make code more modular and readable
**Add documentation