-- TIEP3 Tietokantojan perusteet
-- Harjoitustyö: Liikuntakeskuksen tietokanta, kysely 2b
-- Eveliina Toivanen (eveliina.toivanen@tuni.fi)

-- Haetaan lyhimmälle ryhmäliikuntatunnille sen nimi, kesto ja tunnin kategorian nimi.
SELECT rlnimi, kesto, knimi
FROM rltunti, kategoria
WHERE kesto = (SELECT MIN(kesto)
               FROM rltunti)
	AND rltunti.ktunnus = kategoria.ktunnus
ORDER BY rlnimi;