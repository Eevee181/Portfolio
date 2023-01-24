-- TIEP3 Tietokantojan perusteet
-- Harjoitustyö: Liikuntakeskuksen tietokanta, kysely 2a
-- Eveliina Toivanen (eveliina.toivanen@tuni.fi)

-- Haetaan lyhimmälle ryhmäliikuntatunnille sen nimi ja kesto.
SELECT rlnimi, kesto
FROM rltunti
WHERE kesto = (SELECT MIN(kesto)
               FROM rltunti)
ORDER BY rlnimi;