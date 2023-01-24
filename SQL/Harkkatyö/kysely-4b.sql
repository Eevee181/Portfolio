-- TIEP3 Tietokantojan perusteet
-- Harjoitustyö: Liikuntakeskuksen tietokanta, kysely 4b
-- Eveliina Toivanen (eveliina.toivanen@tuni.fi)

-- Haetaan jokaiselle kategorialle nimi, kategoriaan kuuluvien tuntien lukumäärä, kategoriaan 
-- kuuluvien pidettävien tuntien lukumäärä ja kategoriaan kuuluvien pidettävien tuntien ohjaajien
-- lukumäärä.

SELECT knimi, COUNT(DISTINCT rlnimi) AS rltuntilkm, COUNT(ljtunti.rltunnus) AS ljtuntilkm,
    COUNT(DISTINCT ljtunti.otunnus) AS ohjaajalkm
FROM kategoria INNER JOIN rltunti ON kategoria.ktunnus = rltunti.ktunnus
    LEFT OUTER JOIN ljtunti ON ljtunti.rltunnus = rltunti.rltunnus
GROUP BY knimi
ORDER BY knimi;