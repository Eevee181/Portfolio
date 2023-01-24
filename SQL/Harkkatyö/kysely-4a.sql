-- TIEP3 Tietokantojan perusteet
-- Harjoitustyö: Liikuntakeskuksen tietokanta, kysely 4a
-- Eveliina Toivanen (eveliina.toivanen@tuni.fi)

-- Haetaan jokaiselle kategorialle nimi, kategoriaan kuuluvien tuntien lukumäärä, minimikesto ja 
-- maksimikesto.
SELECT knimi, COUNT(rltunti.ktunnus) AS lkm, MIN(kesto) AS minkesto, MAX(kesto) AS maxkesto
FROM kategoria, rltunti
WHERE kategoria.ktunnus = rltunti.ktunnus
GROUP BY knimi
ORDER BY knimi;