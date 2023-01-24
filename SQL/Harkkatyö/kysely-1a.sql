-- TIEP3 Tietokantojan perusteet
-- Harjoitustyö: Liikuntakeskuksen tietokanta, kysely 1a
-- Eveliina Toivanen (eveliina.toivanen@tuni.fi)

-- Haetaan jokaiselle Kehonhuoltoon kuuluvalle tunnille viikonpäivä, alkamisaika, tunnin nimi ja
-- sen kesto.
SELECT viikonpaiva, alkamisaika, rlnimi, kesto
FROM ljtunti, rltunti, kategoria
WHERE knimi = 'Kehonhuolto'
    AND kategoria.ktunnus = rltunti.ktunnus
    AND ljtunti.rltunnus = rltunti.rltunnus
ORDER BY viikonpaiva, alkamisaika, rlnimi;