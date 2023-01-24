-- TIEP3 Tietokantojan perusteet
-- Harjoitustyö: Liikuntakeskuksen tietokanta, kyselyt
-- Eveliina Toivanen (eveliina.toivanen@tuni.fi)

-- 1. Haetaan Kehonhuolto-kategoriaan kuuluvien ryhmäliikuntatuntien lukujärjestystunneista 
-- tietoa. 

-- TOIMII
-- a) Haetaan jokaiselle Kehonhuoltoon kuuluvalle tunnille viikonpäivä, alkamisaika, tunnin nimi ja
-- sen kesto.
SELECT viikonpaiva, alkamisaika, rlnimi, kesto
FROM ljtunti, rltunti, kategoria
WHERE knimi = 'Kehonhuolto'
    AND kategoria.ktunnus = rltunti.ktunnus
    AND ljtunti.rltunnus = rltunti.rltunnus
ORDER BY rltunti.rltunnus, viikonpaiva, alkamisaika, rlnimi;
-- TOIMII

-- TOIMII
-- b) Haetaan jokaiselle Kehonhuolto-tunnille viikonpäivä, alkamisaika, nimi, kesto ja salin nimi,
-- jotka päättyvät ennen klo. 10.00 tai alkavat kello 18.00 jälkeen.
SELECT viikonpaiva, alkamisaika, rlnimi, kesto, snimi
FROM ljtunti 
    INNER JOIN rltunti ON ljtunti.rltunnus = rltunti.rltunnus
    INNER JOIN kategoria ON rltunti.ktunnus = kategoria.ktunnus
    INNER JOIN sali ON ljtunti.stunnus = sali.stunnus
WHERE (paattymisaika < '10:00:00' OR alkamisaika > '18:00:00')
	AND kategoria.ktunnus = rltunti.ktunnus
    AND knimi = 'Kehonhuolto'
ORDER BY viikonpaiva, alkamisaika, rlnimi;
-- TOIMII


-- 2. Lyhimmälle ryhmäliikuntatunnille haetaan tietoja

--TOIMII
-- a) Haetaan lyhimmälle ryhmäliikuntatunnille sen nimi ja kesto.
SELECT rlnimi, kesto
FROM rltunti
WHERE kesto = (SELECT MIN(kesto)
               FROM rltunti)
ORDER BY rlnimi;
-- TOIMII

-- TOIMII
-- b) Haetaan lyhimmälle ryhmäliikuntatunnille sen nimi, kesto ja tunnin kategorian nimi.
SELECT rlnimi, kesto, knimi
FROM rltunti, kategoria
WHERE kesto = (SELECT MIN(kesto)
               FROM rltunti)
	AND rltunti.ktunnus = kategoria.ktunnus
ORDER BY rlnimi;
-- TOIMII

-- TOIMII
-- c) Haetaan lyhimmälle Kehonhuolto-kategorian tunnille nimi, kesto ja kategorian nimi.
SELECT rlnimi, kesto, knimi
FROM rltunti, kategoria
WHERE kesto = (SELECT MIN(kesto)
               FROM rltunti
			   WHERE rltunti.ktunnus = kategoria.ktunnus
	               AND kategoria.knimi = 'Kehonhuolto')
ORDER BY rlnimi;
-- TOIMII

-- TOIMII
-- 3. Haetaan tunnus ja nimi jokaiselle ohjaajalle, jotka voivat ohjata vain spinning-kategorian
-- tunteja.
SELECT ohjaaja.otunnus AS ohjtunnus, onimi AS ohjnimi
FROM voi_ohjata INNER JOIN ohjaaja ON ohjaaja.otunnus = voi_ohjata.otunnus
    INNER JOIN rltunti ON voi_ohjata.rltunnus = rltunti.rltunnus
    INNER JOIN kategoria ON kategoria.ktunnus = rltunti.ktunnus
WHERE knimi = 'Spinning'
EXCEPT
SELECT voi_ohjata.otunnus, onimi
FROM voi_ohjata INNER JOIN ohjaaja ON ohjaaja.otunnus = voi_ohjata.otunnus
    INNER JOIN rltunti ON voi_ohjata.rltunnus = rltunti.rltunnus
    INNER JOIN kategoria ON kategoria.ktunnus = rltunti.ktunnus
WHERE knimi != 'Spinning'
ORDER BY ohjtunnus;
-- TOIMII

-- 4. Haetaan tietoja kategorioille.

-- TOIMII
-- a) Haetaan jokaiselle kategorialle nimi, kategoriaan kuuluvien tuntien lukumäärä, minimikesto ja 
-- maksimikesto.
SELECT knimi, COUNT(rltunti.ktunnus) AS lkm, MIN(kesto) AS minkesto, MAX(kesto) AS maxkesto
FROM kategoria, rltunti
WHERE kategoria.ktunnus = rltunti.ktunnus
GROUP BY knimi
ORDER BY knimi;
-- TOIMII

-- TOIMII
-- b) Haetaan jokaiselle kategorialle nimi, kategoriaan kuuluvien tuntien lukumäärä, kategoriaan 
-- kuuluvien pidettävien tuntien lukumäärä ja kategoriaan kuuluvien pidettävien tuntien ohjaajien
-- lukumäärä.
SELECT knimi, COUNT(DISTINCT rlnimi) AS rltuntilkm, COUNT(ljtunti.rltunnus) AS ljtuntilkm,
    COUNT(DISTINCT ljtunti.otunnus) AS ohjaajalkm
FROM kategoria INNER JOIN rltunti ON kategoria.ktunnus = rltunti.ktunnus
    LEFT OUTER JOIN ljtunti ON ljtunti.rltunnus = rltunti.rltunnus
GROUP BY knimi
ORDER BY knimi;
-- TOIMII

-- TOIMII
-- 5. Haetaan tunnukset ja nimet ohjaajille, jotka ohjaavat kaikkien niiden ryhmäliikuntatuntien
-- lukujärjestystunteja, joita he voivat ohjata.
SELECT ohjaaja.otunnus, onimi
FROM ohjaaja
WHERE NOT EXISTS (SELECT rltunnus
                  FROM voi_ohjata
				  WHERE ohjaaja.otunnus = voi_ohjata.otunnus
				  EXCEPT
				  SELECT rltunnus
				  FROM ljtunti
				  WHERE ohjaaja.otunnus = ljtunti.otunnus)
ORDER BY otunnus;
-- TOIMII