-- TIEP3 Tietokantojan perusteet
-- Harjoitustyö: Liikuntakeskuksen tietokanta, kysely 2c
-- Eveliina Toivanen (eveliina.toivanen@tuni.fi)

-- Haetaan lyhimmälle Kehonhuolto-ketagorian tunnille nimi, kesto ja kategorian nimi.
SELECT rlnimi, kesto, knimi
FROM rltunti, kategoria
WHERE kesto = (SELECT MIN(kesto)
               FROM rltunti
			   WHERE rltunti.ktunnus = kategoria.ktunnus
	               AND kategoria.knimi = 'Kehonhuolto')
ORDER BY rlnimi;